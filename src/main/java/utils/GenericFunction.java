package utils;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.Color;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static utils.SeleniumWait.logger;

public class GenericFunction {

    /**************************************** Time Related Op ******************************************/
    public static HashMap<String, String> getCurrentDateAndTime() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        String dateAndTime = new SimpleDateFormat("yyyy/MM/dd h:mm a").format(new Date());
        hashMap.put("todayDate", dateAndTime.split(" ")[0].trim().split("/")[2].trim());
        hashMap.put("month", dateAndTime.split(" ")[0].trim().split("/")[1].trim());
        hashMap.put("year", dateAndTime.split(" ")[0].trim().split("/")[0].trim());
        hashMap.put("todayTime", dateAndTime.split(" ")[1].trim());
        hashMap.put("AM/PM", dateAndTime.split(" ")[2].trim());

        return hashMap;
    }

    public static String getDateBasedOnFormat(String format) {
        String dateAndTime = null;
        if (format != null) {
            DateFormat dateFormat = new SimpleDateFormat(format);
            Date date = new Date();
            dateAndTime = dateFormat.format(date);
        }

        return dateAndTime;
    }

    // ******************** Dynamic Data Generation By Faker API ***************************
    public static String firstName() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public static String firstName(String localType) {
        Faker faker = new Faker(new Locale(localType));
        return faker.name().firstName();
    }

    public static String lastName() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public static String emailAddress() {
        Faker faker = new Faker();
        return faker.internet().safeEmailAddress();
    }

    public static String emailAddressWithInternet() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static String signatureId() {
        Faker faker = new Faker();
        return "Sig" + faker.random().hex(9).toLowerCase();
    }

    public static String avatarUrl() {
        Faker faker = new Faker();
        return faker.internet().avatar();
    }

    public static String authorId() {
        String authorId;
        Faker faker = new Faker();
        authorId = "Author" + faker.idNumber().valid().replace("-", "");

        return authorId;
    }

    public static String authorName() {
        String authorName;
        Faker faker = new Faker();
        authorName = faker.book().author();

        return authorName;
    }

    public static String bookName() {
        String bookName;
        Faker faker = new Faker();
        bookName = "Aut" + getString(faker.book().title());
        bookName = bookName.length() > 22 ? bookName.substring(0, 20) : bookName;
        return bookName.replace(" ", "");
    }

    public static String resourceName() {
        String bookName;
        Faker faker = new Faker();
        bookName = "Resource" + getString(faker.book().title());
        return bookName.replace(" ", "");
    }

    public static String metaDataName() {
        Faker faker = new Faker();
        return "MetaData" + getString(faker.book().title());
    }

    public static String description() {
        Faker faker = new Faker();
        return faker.book().genre();
    }

    public static String publisher() {
        Faker faker = new Faker();
        return faker.book().publisher();
    }

    public static String edition() {
        String[] str = {"First Edition", "Second Edition", "Third Edition", "Fourth Edition",
                "Fifth Edition", "Sixth Edition", "Seventh Edition"};
        return str[generateRandomNumber(0, str.length)];
    }

    public static String removeSpecialCharacterFromString(String inputString) {
        String str = null;
        if (inputString != null) {
            str = inputString.chars()
                    .mapToObj(c -> Character.toString((char) c))
                    .filter(s -> s.matches("[a-zA-Z0-9 ]+"))
                    .collect(Collectors.joining());

            System.out.println("Original string: " + inputString);
            System.out.println("Result string: " + str);
        }

        return str;
    }

    public static String getString(String inputString) {
        String str = null;
        if (inputString != null) {
            str = inputString.chars()
                    .mapToObj(c -> Character.toString((char) c))
                    .filter(s -> s.matches("[a-zA-Z ]+"))
                    .collect(Collectors.joining());
        }

        return str;
    }

    public static int getPageCountFromStr(String inputString) {
        int number = 0;
        List<Integer> numbersList = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(inputString);
        while (matcher.find()) {
            numbersList.add(Integer.parseInt(matcher.group()));
        }

        if (numbersList.get(0) == numbersList.get(1))
            number = numbersList.get(0);
        else
            number = numbersList.get(1);

        return number;
    }

    public static String capitalizeFully(String string) {

        if (string == null || string.isEmpty())
            return null;

        return Arrays.stream(string.split("_")).map(str ->
                str.substring(0, 1).toUpperCase() + str.substring(1)
                        .toLowerCase()).collect(Collectors.joining(" "));
    }

    public static String capitalizeFully(String string, String splitBy) {

        if (string == null || string.isEmpty())
            return null;

        return Arrays.stream(string.split(splitBy)).map(str ->
                str.substring(0, 1).toUpperCase() + str.substring(1)
                        .toLowerCase()).collect(Collectors.joining(" "));
    }

    public static String removeAllDigitUsingStream(String str) {
        return Arrays.stream(str.split("\\s+"))
                .filter(s -> !s.matches("\\d+"))
                .collect(Collectors.joining(" "));
    }

    public static String removeAllDigitUsingChars(String str) {
        return str.chars()
                .filter(c -> !Character.isDigit(c))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString().replaceAll("  ", " ").trim();
    }

    public static String removeAllDigitUsingRegex(String str) {
        return str.replaceAll("\\d", "").replaceAll("  ", " ").trim();
    }

    public static String getRandomUUID() {
        return UUID.randomUUID().toString();
    }

    public static int generateRandomNumber(int maxSize) {
        int number = 0;
        Random random;
        random = new Random();
        if (maxSize > 0)
            number = random.nextInt(maxSize);

        return number;
    }

    public static int generateRandomNumber(int minSize, int maxSize) {
        Random random = new Random();
        return random.ints(minSize, maxSize)
                .findFirst()
                .getAsInt();
    }

    public static long generateRandomOf13Digit() {
        Random random = new Random();
        long randomNumber = random.nextLong() % 10000000000000L;
        if (randomNumber < 0) {
            randomNumber *= -1;
        }

        return randomNumber;
    }

    public static String generateRandomAlphaNumeric(int length) {
        Random random = new Random();
        String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        return random.ints(length, 0, alphabet.length())
                .mapToObj(alphabet::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    public static String generateRandomString(int length) {
        Random random = new Random();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        return random.ints(length, 0, alphabet.length())
                .mapToObj(alphabet::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    public static String currentTimeInUTCFormat() {
        LocalDateTime dateTime = LocalDateTime.now(ZoneOffset.UTC);
        // Create a DateTimeFormatter object for the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        return dateTime.format(formatter);
    }

//    public static void uploadFile(WebDriver driver, WebElement element, String fileName) {
//        if (fileName != null && SeleniumUtils.isElementDisplayed(driver, element)) {
//            LocalFileDetector localFileDetector = new LocalFileDetector();
//            ((RemoteWebDriver) driver).setFileDetector(localFileDetector);
//            File file = new File(GlobalVar.workingDirectory + fileName);
//            element.sendKeys(file.getAbsolutePath());
//        }
//    }

    public static boolean checkDigitInStr(String str) {
        return str.matches(".*\\d.*");
    }

    public static String getColorCode(WebDriver webDriver, WebElement webElement, String cssTypeValue) {
        Color color = Color.fromString(SeleniumUtils.getCssValue(webDriver, webElement, cssTypeValue));

        return color.asHex();
    }

    public static void getFileName() {
        File file = new File(GlobalVar.workingDirectory + GlobalVar.slash + "testData");

        String fileName = Arrays.stream(Objects.requireNonNull(file.listFiles())).filter(fil -> fil.getName().contains(".png")).findFirst().get().getName();
        System.out.println(fileName);
    }

    public static String getFileName(String folderName, String fileType) {
        String fileName;
        int randomNumber = generateRandomNumber(100, 1000);

        File file = new File(GlobalVar.workingDirectory + GlobalVar.slash + folderName);
        fileName = Arrays.stream(Objects.requireNonNull(file.listFiles())).filter(fi -> fi.getName().contains(fileType)).findFirst().get().getName();

        File olderFile = new File(GlobalVar.workingDirectory + GlobalVar.slash + folderName + GlobalVar.slash + fileName);

        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex != -1 && dotIndex < fileName.length() - 1)
            fileName = fileName.substring(dotIndex + 1);
        fileName = fileName + randomNumber + "." + fileType;

        File newFile = new File(GlobalVar.workingDirectory + GlobalVar.slash + folderName + GlobalVar.slash + fileName);

        if (olderFile.renameTo(newFile)) ;

        return fileName;
    }

    public static void removeFilesFromFolder(String folderName, String fileExtension) {
        File file = new File(GlobalVar.workingDirectory + GlobalVar.slash + folderName + GlobalVar.slash);
        if (file.exists()) {
            for (File f : Objects.requireNonNull(file.listFiles())) {
                if (f.getName().contains(fileExtension))
                    f.delete();
            }
        }
    }

    public static int convertStrToInt(String stringValue) {
        int intValue = 0;
        if (stringValue != null)
            intValue = Integer.parseInt(stringValue);

        return intValue;
    }

    public static void selectElementFromDD(WebDriver driver, String elementType, WebElement elementDD, List<WebElement> elementList) {
        SeleniumWait.pauseExecution(3);
        SeleniumUtils.scrollTillElementWithJS(driver, elementDD);
        elementDD.click();
        SeleniumWait.pauseExecution(2);
        for (WebElement element : elementList) {
            if (element.getText().equals(elementType)) {
                SeleniumWait.waitUntilVisibilityOfElement(driver, element);
                SeleniumUtils.clickElement(driver, element);
                break;
            }
        }
    }

    public static void selectElementFromDDJS(WebDriver driver, String elementType, WebElement elementDD, List<WebElement> elementList) {
        SeleniumWait.pauseExecution(1);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        elementDD.click();
        SeleniumWait.pauseExecution(3);
        for (WebElement element : elementList) {
            if (element.getText().equals(elementType)) {
                js.executeScript("arguments[0].click()", element);
                SeleniumUtils.clickElement(driver, element);
                break;
            }
        }
    }

    public static void checkElementExistence(WebDriver driver, List<WebElement> elementList, String elementType) {
        boolean isAvailable = false;
        for (WebElement element : elementList) {
            if (element.getText().equals(elementType)) {
                logger.info("Element " + elementType + " is found successfully");
                isAvailable = true;
                Assertions.assertTrue(true, "Element " + elementType + " is found in List");
                break;
            }
        }
        if (!isAvailable) {
            Assertions.assertTrue(false, "Element " + elementType + " is not found in List");
        }
    }

    public static boolean checkElementExistenceInList(WebDriver driver, List<WebElement> elementList, String elementType) {
        boolean isAvailable = false;
        for (WebElement element : elementList) {
            if (element.getText().equals(elementType)) {
                logger.info("Element " + elementType + " is found successfully");
                isAvailable = true;
                break;
            }
        }
        return isAvailable;
    }

    public static String getSelectQuery(String catlogName, String schemaName, String tableName, String columnName, String ColumnValue) {
        return "Select * From " + catlogName + "." + schemaName + "." + tableName + " " + "where " + columnName + "=" + ColumnValue;
    }

    public static String getSelectQueryWithLimit(String catlogName, String schemaName, String tableName, String limitValue) {
        return "Select * From " + catlogName + "." + schemaName + "." + tableName + " " +  "LIMIT " + limitValue;
    }

    public static String makeQuery(String queryType, String catlogName, String schemaName, String tableName) {
        String query = null;
        switch (queryType) {
            case "select":
                query = "select * from " + catlogName + "." + schemaName + "." + tableName;
                break;
            case "update":
                query = "";
                break;
            case "delete":
                query = "";
                break;
            default:
                throw new IllegalArgumentException("Please enter valid query type:" + queryType);
        }
        return query;
    }

    public static boolean checkValueInList(List<WebElement> elements, String value) {
        boolean isAvailable = false;
        for (WebElement element : elements) {
            if (!(element.getText().equalsIgnoreCase(value))) {
                System.out.println(element.getText());
                logger.info("Value " + value + " is wrong in the List");
                isAvailable = false;
                break;
            } else {
                isAvailable = true;
            }
        }
        return isAvailable;
    }

    public static void checkElementExistenceInTable(WebDriver driver, List<WebElement> elementList, String value) {
        boolean isAvailable = false;
        for (WebElement element : elementList) {
            if (element.getText().contains(value)) {
                logger.info("Element " + value + " is found successfully");
                isAvailable = true;
                break;
            }
        }
        if (!isAvailable) {
            Assertions.assertTrue(false, "Element " + value + " is not found in List");
        }
    }

    public static void checkElementExistenceOnPage(WebDriver driver, WebElement pageElement, String pageLbl) {
        SeleniumWait.waitForPageLoaded(driver);
        SeleniumWait.waitForElementToBeClickable(driver, pageElement,30);
//        SeleniumWait.pauseExecution(3);
        SeleniumUtils.scrollTillElementWithJS(driver, pageElement);
        SeleniumWait.waitUntilVisibilityOfElement(driver, pageElement);
        Assertions.assertTrue(SeleniumUtils.getText(driver, pageElement).equals
                (pageLbl));
    }

    public static void selectElementFromDDByValue(WebDriver driver, String elementType, WebElement elementDD) {
        SeleniumWait.pauseExecution(3);
        SeleniumUtils.scrollTillElementWithJS(driver, elementDD);
        elementDD.click();
        SeleniumWait.pauseExecution(2);
        SeleniumUtils.sendKeysAndEnterByActionsClass(driver, elementType);
        SeleniumWait.pauseExecution(2);
    }

    public static void clickAndCheckElementExistenceOnPage(WebDriver driver,WebElement clickElement,WebElement pageElement, String pageLbl) {
        SeleniumUtils.clickElement(driver,clickElement);
        SeleniumWait.waitForPageLoaded(driver);
        SeleniumWait.waitForElementToBeClickable(driver, pageElement,30);
        SeleniumWait.waitUntilVisibilityOfElement(driver, pageElement);
        Assertions.assertTrue(SeleniumUtils.getText(driver, pageElement).equals(pageLbl));
    }

    public static void checkElementPresenceOnPage(WebDriver driver, WebElement pageElement) {
        SeleniumWait.waitForPageLoaded(driver);
        SeleniumWait.waitUntilVisibilityOfElement(driver, pageElement);
        SeleniumUtils.scrollTillElementWithJS(driver, pageElement);
        Assertions.assertTrue(pageElement.isDisplayed());
    }
}