package driver;

import database.MongoDB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import utils.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


public class BaseClass {

    private static final String browser = GlobalVar.browserName;
    protected static WebDriver webDriver;
    public LoadProperty loadProperty;

    private static final Logger logger = LogManager.getLogger(BaseClass.class);

    @BeforeSuite(alwaysRun = true)
    public void initialization() {
        loadProperty = new LoadProperty();
        setBaseURLAndEnvironment();
    }

    public void startDriver() {
        String gridUrl = System.getenv("SELENIUM_GRID_URL");
        String executionMode = System.getenv("executionMode");
        GlobalVar.executionMode = (executionMode != null) ? executionMode.toLowerCase() : "local";
        logger.info("Execution mode is -----> " + GlobalVar.executionMode);

        ChromeOptions chromeOptions = getChromeOptionManager();
        FirefoxOptions firefoxOptions = getFirefoxOptionManager();

        if (GlobalVar.executionMode.equals("local")) {
            if ("chrome".equalsIgnoreCase(browser)) {
                try{
                    chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
                }catch (Exception e){
                    //Catch block is used to bypass the code
                }
                webDriver = new ChromeDriver(chromeOptions);
            } else if ("firefox".equalsIgnoreCase(browser)) {
                webDriver = new FirefoxDriver(firefoxOptions);
            } else {
                throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        } else if (GlobalVar.executionMode.equals("server")) {
            try {
                logger.info("Using Selenium Grid at URL: {}", gridUrl);
                if (gridUrl == null || gridUrl.isEmpty()) {
                    throw new IllegalArgumentException("SELENIUM_GRID_URL environment variable is not set.");
                }
                if ("chrome".equalsIgnoreCase(browser)) {
                    webDriver = new RemoteWebDriver(new URL(gridUrl), chromeOptions);
                } else {
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
                }
            } catch (MalformedURLException e) {
                throw new RuntimeException("Invalid Selenium Grid URL: " + gridUrl, e);
            }
        } else {
            throw new IllegalArgumentException("Invalid execution mode: " + GlobalVar.executionMode);
        }
        logger.info("WebDriver Status Is -----> {}", webDriver);
        WebDriverSessionManager.setWebDriver(webDriver);
//        webDriver.manage().window().setPosition(new Point(0, 0));
//        webDriver.manage().window().setSize(new Dimension(1920, 1080));
        webDriver.manage().window().maximize();
        WebDriverSessionManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public ChromeOptions getChromeOptionManager() {
        logger.info("Initializing the chrome browser instance ....");
        ChromeOptions chromeOptions = new ChromeOptions();

        // Create a map for preferences
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2); // Block notifications
        prefs.put("credentials_enable_service", false); // Disable credentials service
        prefs.put("profile.password_manager_enabled", false); // Disable password manager
        prefs.put("autofill.credit_card_enabled", false); // Prevent "save credit-card" popup and autofill

        // Add arguments to ChromeOptions
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--force-device-scale-factor=0.8");
        chromeOptions.addArguments("--high-dpi-support=0.8");
        chromeOptions.addArguments("--ignore-ssl-errors=yes");
        chromeOptions.addArguments("--ignore-certificate-errors");

        // Uncomment for headless mode
        // chromeOptions.addArguments("--headless");
        // chromeOptions.addArguments("--disable-gpu");

        if (GlobalVar.executionMode.equalsIgnoreCase("server")) {
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-dev-shm-usage");
        }

        // Set experimental options
        chromeOptions.setExperimentalOption("prefs", prefs);

        return chromeOptions;
    }


    public static FirefoxOptions getFirefoxOptionManager() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("start-maximized");
        firefoxOptions.addArguments("disable-infobars");

        if (GlobalVar.executionMode.equalsIgnoreCase("server")) {
            firefoxOptions.addArguments("--no-sandbox");
            firefoxOptions.addArguments("--disable-dev-shm-usage");
            //chromeOptions.addArguments("--headless=new");
        }
        return firefoxOptions;
    }

    /**
     * Used to initialize the driver instance based on the parameters
     *
     * @param executionMode : testcase execution type either locally or remotely
     * @return WebDriver instance
     */
    public WebDriver initDriver(String executionMode) throws MalformedURLException {
        switch (executionMode) {
            case "local" -> webDriver = WebDriverSessionManager.getDriver();
            case "server" -> webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                    getChromeOptionManager());

            default -> throw new IllegalStateException("Unexpected value Of executionMode : " + executionMode);
        }
        WebDriverSessionManager.setWebDriver(webDriver);
        return webDriver;
    }

    public void setBaseURLAndEnvironment() {
        System.out.println("Setting up base URL and all--->> ");
        if (!(System.getenv("environment") == null))
            GlobalVar.currentEnvironment = System.getenv("environment").toLowerCase();

        else if (System.getProperty("env.PATH") != null)
            GlobalVar.currentEnvironment = System.getProperty("env.PATH").toLowerCase();

        else {
            logger.info("This is the default value if the environment variable value is not specified ----> " + GlobalVar.currentEnvironment);
        }
        GlobalVar.propertyPath = GlobalVar.workingDirectory + "/src/test/resources/config/" + GlobalVar.currentEnvironment + ".properties";
        GlobalVar.baseURL = loadProperty.getValueFromPropertyFile(GlobalVar.propertyPath, "BASE_URL");
        System.out.println("****************************************************");
        System.out.println(GlobalVar.baseURL + "======" + GlobalVar.currentEnvironment);
    }

    public String getValueFromProperties(String Key) {
        if (!(Key.isEmpty())) {
            return new LoadProperty().getValueFromPropertyFile(GlobalVar.propertyPath, Key);
        } else return "";
    }


    public void openBrowserWithBaseURL(WebDriver driver) {
        SeleniumUtils.openUrl(driver, new LoadProperty().getValueFromProperties("BASE_URL"));
        SeleniumWait.pauseExecution(5);
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initializeAndConnectMongoConfiguration() {
        MongoDB mongoDB = new MongoDB();
        GlobalVar.mongoHost = getValueFromProperties("Mongo_Host");
        GlobalVar.mongoPort = Integer.parseInt(getValueFromProperties("Mongo_Port"));
        GlobalVar.mongoUserName = getValueFromProperties("Mongo_UserName");
        GlobalVar.mongoUserPassword = getValueFromProperties("Mongo_Password");
        GlobalVar.mongoCourseDBName = getValueFromProperties("Mongo_DBName_Course");
        System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
        mongoDB.connectDataBase(GlobalVar.mongoCourseDBName);
    }
}