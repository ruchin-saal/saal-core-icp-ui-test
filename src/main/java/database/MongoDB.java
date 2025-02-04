package database;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import utils.GlobalVar;
import utils.LoadProperty;

public class MongoDB {
    static LoadProperty loadProperty = new LoadProperty();
    static com.mongodb.client.MongoClient mongoClient;
    static ConnectionString connectionString;
    static MongoDatabase database;


    public void connectDataBase(String DataBaseName) {
        mongoClient = null;
        String ConnectionString = "mongodb://" + GlobalVar.mongoUserName + ":" +
                GlobalVar.mongoUserPassword + "@" + GlobalVar.mongoHost + ":" +
                GlobalVar.mongoPort + "/" + DataBaseName + "?authSource=admin";
        connectionString = new ConnectionString(ConnectionString);
        mongoClient = MongoClients.create(connectionString);
        System.out.println("Connected to the database successfully");
    }

    public void getDatabase(String databaseName) {
        database = null;
        database = mongoClient.getDatabase(databaseName);
        System.out.println(databaseName + " database accessed successfully");
    }

    public void removeDocumentFromMonGoDB(String databaseName, String collectionName, String key, String value) {
        getDatabase(databaseName);
        try {
            MongoCollection<Document> collection = database.getCollection(collectionName);
            System.out.println("Collection " + collectionName + " selected successfully");
            collection.deleteOne(Filters.eq(key, value));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeCreatedAssessmentFromMongoDB(String assessmentLessonId) {
        getDatabase(GlobalVar.mongoCourseDBName);
        try {
            MongoCollection<Document> collection = database.getCollection("program-items");
            System.out.println("Collection program-items selected successfully");
            collection.deleteOne(Filters.eq("id", assessmentLessonId));
            System.out.println("Assessment Deleted successfully");
        } catch (Exception e) {
            System.out.println("Assessment Could not be deleted");
            e.printStackTrace();
        }
    }


}
