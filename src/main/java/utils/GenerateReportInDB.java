package utils;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GenerateReportInDB {
    public static void main(String[] args) {
        try {
            // Parse the XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            org.w3c.dom.Document xmlDocument = builder.parse("target/surefire-reports/testng-results.xml");

            // Extract suite name
            Element suiteElement = (Element) xmlDocument.getElementsByTagName("suite").item(0);
            String suiteName = suiteElement.getAttribute("name");
            System.out.println("Suite Name: " + suiteName);

            // Extract test results from the 'testng-results' element
            Element resultsElement = (Element) xmlDocument.getElementsByTagName("testng-results").item(0);

            String ignoredStr = resultsElement.getAttribute("ignored");
            String totalStr = resultsElement.getAttribute("total");
            String passedStr = resultsElement.getAttribute("passed");
            String failedStr = resultsElement.getAttribute("failed");
            String skippedStr = resultsElement.getAttribute("skipped");

            System.out.println("Attributes before parsing:");
            System.out.println("Ignored: " + ignoredStr);
            System.out.println("Total: " + totalStr);
            System.out.println("Passed: " + passedStr);
            System.out.println("Failed: " + failedStr);
            System.out.println("Skipped: " + skippedStr);

            int ignored = parseAttribute(ignoredStr);
            int total = parseAttribute(totalStr);
            int passed = parseAttribute(passedStr);
            int failed = parseAttribute(failedStr);
            int skipped = parseAttribute(skippedStr);

            // Calculate percentages
            double passPercentage = (total > 0) ? ((double) passed / total) * 100 : 0;
            double failPercentage = (total > 0) ? ((double) failed / total) * 100 : 0;
            double skipPercentage = (total > 0) ? ((double) skipped / total) * 100 : 0;

            // Extract executed test methods
            NodeList testMethodNodes = xmlDocument.getElementsByTagName("test-method");
            ArrayList<Map<String, String>> executedTests = new ArrayList<>();

            for (int i = 0; i < testMethodNodes.getLength(); i++) {
                Element testMethodElement = (Element) testMethodNodes.item(i);
                if (!Boolean.parseBoolean(testMethodElement.getAttribute("is-config"))) {
                    Map<String, String> testDetails = new HashMap<>();
                    testDetails.put("test_name", testMethodElement.getAttribute("name"));
                    testDetails.put("status", testMethodElement.getAttribute("status"));
                    testDetails.put("test_started_at", testMethodElement.getAttribute("started-at"));
                    testDetails.put("test_finished_at", testMethodElement.getAttribute("finished-at"));
                    executedTests.add(testDetails);
                }
            }

            // Create JSON document
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("project_name", suiteName);
            Map<String, Object> resultsMap = new HashMap<>();
            resultsMap.put("ignored", ignored);
            resultsMap.put("total", total);
            resultsMap.put("passed", passed);
            resultsMap.put("failed", failed);
            resultsMap.put("skipped", skipped);

            // Add calculated percentages to the results map
            resultsMap.put("pass_percentage", passPercentage);
            resultsMap.put("fail_percentage", failPercentage);
            resultsMap.put("skip_percentage", skipPercentage);

            jsonMap.put("testng_results", resultsMap);
            jsonMap.put("executed_test_methods", executedTests);

            // Add createdAt and updatedAt fields with the current timestamp
            Instant currentTimestamp = Instant.now();
            jsonMap.put("createdAt", currentTimestamp);
            jsonMap.put("updatedAt", currentTimestamp);

            // Insert JSON document into MongoDB
            String connectionString = "mongodb://alpha.saal.ai:30968/?retryWrites=true&loadBalanced=false&serverSelectionTimeoutMS=5000&connectTimeoutMS=10000";
            ConnectionString connString = new ConnectionString(connectionString);

            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(connString)
                    .build();

            try (MongoClient mongoClient = MongoClients.create(settings)) {
                MongoDatabase database = mongoClient.getDatabase("smart_qa");
                MongoCollection<Document> collection = database.getCollection("dailyExecutionReports");
                Document mongoDocument = new Document(jsonMap);
                collection.insertOne(mongoDocument);
            }
            System.out.println("Document inserted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Helper method to safely parse integer attributes
    private static int parseAttribute(String attribute) {
        if (attribute == null || attribute.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(attribute);
    }
}