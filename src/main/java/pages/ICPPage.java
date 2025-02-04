package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;

import java.time.Duration;
import java.util.logging.Logger;
import java.util.concurrent.TimeUnit;

public class ICPPage {
    // Locators for login page
    public static final By USERNAME_TB = By.id("nce-input");
    public static final By PASSWORD_TB = By.id("icp-input-password");
    public static final By LOGIN_BTN = By.id("nce-login-btn");

    // Locators for Use Case 1 (Passenger Forecasting Page)
    public static final By PASSENGER_FORECASTING_LINK = By.xpath("//span[text()='Passenger Forecasting']");
    public static final By AIRCRAFT_ACTIVITY_LBL = By.xpath("//span[text()='Aircraft Activity']");
    public static final By EMIRATES_CODE_DD = By.xpath("//span[@class='ant-select-selection-item']");
    public static final By CALENDER_BTN = By.xpath("//div[@class='ant-picker-input']");

    // Locators for Use Case 2 (Name Origin Explorer Page)
    public static final By NAME_ORIGIN_EXPLORER_LINK = By.xpath("//span[text()='Name Origin Explorer']");
    public static final By FULLNAME_TB = By.xpath("//input[@placeholder='Enter Full Name']");
    public static final By RESIDENCY_DD = By.xpath("//input[@id='rc_select_3']");
    public static final By PREDICT_ORIGIN_BTN = By.xpath("//span[text()='Predict Origin']");

    // Locators for Use Dashboard 1 (Expats Residency Page)
    public static final By EXPATS_RESIDENCY_LINK = By.xpath("//span[text()='Expats Residency']");
    public static final By ALL_NATIONALITIES_LBL = By.xpath("//span[text()='All Nationalities']");
    public static final By APPLY_ALL_BTN = By.xpath("//button/span[text()='Apply All']");
    public static final By EMIRATES_DB1_DD = By.xpath("//input[@id='rc_select_1']");
    public static final By NATIONALITY_DB1_DD = By.xpath("//input[@id='rc_select_2']");

    // Locators for Use Dashboard 2 (Active Residency Page)
    public static final By ACTIVE_RESIDENCY_LINK = By.xpath("//span[text()='Active Residency']");
    public static final By TOTAL_ACTIVE_RESIDENTS_LBL = By.xpath("//span[text()='Total Active Residents']");
    public static final By OTHER_FILTER_BTN = By.xpath("//span[text()='Other Filters']");
    public static final By NATIONALITY_DB2_DD = By.xpath("//input[@id='rc_select_1']");
    public static final By EMIRATES_DB2_DD = By.xpath("//input[@id='rc_select_2']");
    public static final By RESIDENCY_TYPE_DB2_DD = By.xpath("//input[@id='rc_select_3']");

    // Locators for Use Dashboard 3 (Active General Page)
    public static final By ACTIVE_GENERAL_LINK = By.xpath("//span[text()='Active General']");
    public static final By NATIONALITY_DB3_DD = By.xpath("//input[@id='rc_select_1']");
    public static final By EMIRATES_DB3_DD = By.xpath("//input[@id='rc_select_2']");
    public static final By TOTAL_ACTIVE_GENERAL_POPULATION_LBL = By.xpath("//span[text()='Total Active General Population']");


    // WebDriver instance
    private static final Logger logger = Logger.getLogger(ICPPage.class.getName());

    WebDriver driver;

    public ICPPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void performLoginIntoICPApplication(String username, String password) {
        if (driver == null) {
            throw new RuntimeException("WebDriver not initialized");
        }

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Wait for the username field to be clickable
            logger.info("Waiting for the username field to be clickable.");
            WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(USERNAME_TB));

            // Wait for the password field to be visible
            logger.info("Waiting for the password field to be visible.");
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_TB));

            // Clear the fields and enter valid credentials
            logger.info("Clearing username and password fields.");
            usernameField.clear();
            passwordField.clear();
            logger.info("Entering username.");
            usernameField.sendKeys(username);
            logger.info("Entering password.");
            passwordField.sendKeys(password);

            // Wait for the login button to be clickable and click it
            logger.info("Waiting for the login button to be clickable.");
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BTN));
            logger.info("Clicking the login button.");
            loginButton.click();
        } catch (TimeoutException e) {
            logger.severe("Login failed due to timeout: " + e.getMessage());
        }
    }


    public void selectNameOriginExplorerPage() {
        try {
            logger.info("Waiting for the Name Origin Explorer option visibility");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement nameOriginExplorerLink = wait.until(ExpectedConditions.elementToBeClickable(NAME_ORIGIN_EXPLORER_LINK));
            logger.info("Clicking the Name Origin Explorer link");
            nameOriginExplorerLink.click();

            wait.until(ExpectedConditions.elementToBeClickable(FULLNAME_TB));
            logger.info("Post click verification done");
        } catch (Exception e) {
            logger.info("Error while selecting Name Origin Explorer Page: " + e.getMessage());
        }
    }

    public void selectExpatsResidencyPage() {
        try {
            logger.info("Waiting for the Expats Residency option visibility");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement expatsResidencyLink = wait.until(ExpectedConditions.elementToBeClickable(EXPATS_RESIDENCY_LINK));
            logger.info("Clicking the Expats Residency link");
            expatsResidencyLink.click();

            wait.until(ExpectedConditions.elementToBeClickable(ALL_NATIONALITIES_LBL));
            logger.info("Post click verification done");
        } catch (Exception e) {
            logger.info("Error while selecting Expats Residency Page: " + e.getMessage());
        }
    }

    public void selectActiveResidencyPage() {
        try {
            logger.info("Waiting for the Active Residency option visibility");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement activeResidencyLink = wait.until(ExpectedConditions.elementToBeClickable(ACTIVE_RESIDENCY_LINK));
            logger.info("Clicking the Active Residency link");
            activeResidencyLink.click();

            wait.until(ExpectedConditions.elementToBeClickable(TOTAL_ACTIVE_RESIDENTS_LBL));
            logger.info("Post click verification done");
        } catch (Exception e) {
            logger.info("Error while selecting Active Residency Page: " + e.getMessage());
        }
    }

    public void selectActiveGeneralPage() {
        try {
            logger.info("Waiting for the Active General option visibility");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement activeGeneralLink = wait.until(ExpectedConditions.elementToBeClickable(ACTIVE_GENERAL_LINK));
            logger.info("Clicking the Active General link");
            activeGeneralLink.click();

            wait.until(ExpectedConditions.elementToBeClickable(TOTAL_ACTIVE_GENERAL_POPULATION_LBL));
            logger.info("Post click verification done");
        } catch (Exception e) {
            logger.info("Error while selecting Active General Page: " + e.getMessage());
        }
    }

    public void selectFiltersForDashboard1(String gender, String emirates, String nationality) {
        selectGender(gender);
        selectEmirates(emirates, By.xpath("//input[@id='rc_select_1']"));
        selectNationality(nationality, By.xpath("//input[@id='rc_select_2']"));
        selectApplyAllButton();
    }

    public void selectFiltersForDashboard2(String nationality, String emirates, String residencyType,
                                           String startingAgeRange, String endingAgeRange, String gender) {
        selectNationality(nationality, By.xpath("//input[@id='rc_select_1']"));
        selectEmirates(emirates, By.xpath("//input[@id='rc_select_2']"));
        selectResidency(residencyType, By.xpath("//input[@id='rc_select_3']"));
        selectOtherFilter(startingAgeRange, endingAgeRange, gender);
        selectApplyAllButton();
    }

    public void selectFiltersForDashboard3(String nationality, String emirates, String startingAgeRange,
                                           String endingAgeRange, String gender) {
        selectNationality(nationality, By.xpath("//input[@id='rc_select_1']"));
        selectEmirates(emirates, By.xpath("//input[@id='rc_select_2']"));
        selectOtherFilter(startingAgeRange, endingAgeRange, gender);
        selectApplyAllButton();
    }

    public void selectGender(String gender) {
        try {
            logger.info("Selecting gender: " + gender);
            String genderXpath = "//div[@class='ant-segmented-item-label']/span[text()='" + gender + "']";
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement genderElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(genderXpath)));
            genderElement.click();
            logger.info("Gender '" + gender + "' selected successfully");
        } catch (Exception e) {
            logger.info("Error selecting gender '" + gender + "': " + e.getMessage());
        }
    }


    public void selectPassengerForecastingPage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // Wait for Passenger Forecasting link and click
            logger.info("Waiting for the Passenger Forecasting option visibility.");
            WebElement passengerForecastingLink = wait.until(ExpectedConditions.elementToBeClickable(PASSENGER_FORECASTING_LINK));
            passengerForecastingLink.click();

            // Wait for Aircraft Activity label
            wait.until(ExpectedConditions.elementToBeClickable(AIRCRAFT_ACTIVITY_LBL));
            logger.info("Post click verification done.");
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception e) {
            logger.severe("Error while selecting Passenger Forecasting Page: " + e.getMessage());
        }
    }



    public void selectEmirates(String emirates, By emirateDD) {
        try {
            logger.info("Selecting emirates: " + emirates);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement emiratesElement = wait.until(ExpectedConditions.elementToBeClickable(emirateDD));
            emiratesElement.click();

            // Wait for input field visibility and enter the emirates code
            wait.until(ExpectedConditions.visibilityOf(emiratesElement));
            Actions actions = new Actions(driver);
            actions.sendKeys(emiratesElement, emirates).perform();
            actions.sendKeys(emiratesElement, "\n").perform();

            logger.info("Emirates '" + emirates + "' selected successfully.");
        } catch (Exception e) {
            logger.severe("Error selecting emirates '" + emirates + "': " + e.getMessage());
        }
    }

    public void selectNationality(String nationality, By nationalityDD) {
        try {
            logger.info("Selecting nationality: " + nationality);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement nationalityElement = wait.until(ExpectedConditions.elementToBeClickable(nationalityDD));
            nationalityElement.click();

            wait.until(ExpectedConditions.visibilityOf(nationalityElement));
            Actions actions = new Actions(driver);
            actions.sendKeys(nationalityElement, nationality).perform();
            actions.sendKeys(nationalityElement, "\n").perform();
            logger.info("Nationality '" + nationality + "' selected successfully.");
        } catch (Exception e) {
            logger.severe("Error selecting nationality '" + nationality + "': " + e.getMessage());
        }
    }

    public void selectApplyAllButton() {
        try {
            logger.info("Waiting for the Apply All button to be ready for click.");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement applyAllButton = wait.until(ExpectedConditions.elementToBeClickable(APPLY_ALL_BTN));
            applyAllButton.click();
            wait.until(ExpectedConditions.elementToBeClickable(ALL_NATIONALITIES_LBL));
            logger.info("Post click verification done.");
            TimeUnit.SECONDS.sleep(6);
        } catch (Exception e) {
            logger.severe("Error clicking Apply All button: " + e.getMessage());
        }
    }

    public void selectOtherFilter(String startingAgeRange, String endingAgeRange, String gender) {
        try {
            logger.info("Selecting Other Filter");

            // Click 'Other Filters' button
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement otherFiltersButton = wait.until(ExpectedConditions.elementToBeClickable(OTHER_FILTER_BTN));
            otherFiltersButton.click();

            // Select starting age range
            String startingAgeXpath = "//div[text()='" + startingAgeRange + "']";
            WebElement startingAgeElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(startingAgeXpath)));
            startingAgeElement.click();

            // Select ending age range
            String endingAgeXpath = "//div[text()='" + endingAgeRange + "']";
            WebElement endingAgeElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(endingAgeXpath)));
            endingAgeElement.click();

            // Select gender
            String genderXpath = "//span[@class='ant-radio']/following-sibling::span[text()='" + gender + "']";
            WebElement genderElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(genderXpath)));
            genderElement.click();

            logger.info("Other Filter selected successfully");
        } catch (Exception e) {
            logger.info("Error selecting Other Filter: " + e.getMessage());
        }
    }

    public void selectResidency(String residency, By residencyDd) {
        try {
            logger.info("Selecting residency: " + residency);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement residencyElement = wait.until(ExpectedConditions.elementToBeClickable(residencyDd));
            residencyElement.click();

            // Wait for the input field to be interactable and send keys
            wait.until(ExpectedConditions.visibilityOf(residencyElement));
            Actions actions = new Actions(driver);
            actions.sendKeys(residencyElement, residency).perform();
            actions.sendKeys(residencyElement, "\n").perform();

            logger.info("Residency '" + residency + "' selected successfully");
        } catch (Exception e) {
            logger.info("Error selecting residency '" + residency + "': " + e.getMessage());
        }
    }

    public void enterName(String fullName) {
        try {
            logger.info("Entering full name: " + fullName);

            // Wait for the input field to be clickable within 20 seconds
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement nameInputElement = wait.until(ExpectedConditions.elementToBeClickable(FULLNAME_TB));

            // Clear any existing text and enter the full name
            nameInputElement.clear();
            nameInputElement.sendKeys(fullName);

            logger.info("Full name '" + fullName + "' entered successfully");
        } catch (Exception e) {
            logger.info("Error entering full name '" + fullName + "': " + e.getMessage());
        }
    }

    public void selectPredictOriginButton() {
        try {
            logger.info("Waiting for the Predict Origin button to be ready for click");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement predictOriginButton = wait.until(ExpectedConditions.elementToBeClickable(PREDICT_ORIGIN_BTN));
            predictOriginButton.click();

            // Optional: wait for a few seconds
            Thread.sleep(5000);
        } catch (Exception e) {
            logger.info("Error clicking 'Predict Origin' button: " + e.getMessage());
        }
    }

    public void selectEmiratesCode(String emiratesCode) {
        try {
            logger.info("Waiting for the Emirates selection to be ready");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement emiratesCodeElement = wait.until(ExpectedConditions.elementToBeClickable(EMIRATES_CODE_DD));
            emiratesCodeElement.click();

            // Select the specific Emirates code
            String selectEmiratesOptionXpath = "//div[@class='ant-select-item-option-content'][text()='" + emiratesCode + "']";
            WebElement emiratesOptionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selectEmiratesOptionXpath)));
            emiratesOptionElement.click();

            logger.info("Emirates code selected successfully");
        } catch (Exception e) {
            logger.info("Error selecting Emirates code: " + e.getMessage());
        }
    }

    public void selectDate(String date) {
        try {
            logger.info("Waiting for the date picker to be ready");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement datePickerElement = wait.until(ExpectedConditions.elementToBeClickable(CALENDER_BTN));
            datePickerElement.click();

            // Select the specific date
            String dateOptionXpath = "//div[@class='ant-picker-cell-inner'][text()='" + date + "']";
            WebElement dateOptionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dateOptionXpath)));
            dateOptionElement.click();

            logger.info("Date '" + date + "' selected successfully");

            // Optionally wait for verification
            wait.until(ExpectedConditions.elementToBeClickable(AIRCRAFT_ACTIVITY_LBL));
            logger.info("Post click verification done");

            // Optional: wait for a few seconds
            Thread.sleep(5000);
        } catch (Exception e) {
            logger.info("Error selecting date '" + date + "': " + e.getMessage());
        }
    }

}
