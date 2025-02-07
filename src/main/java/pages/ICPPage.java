package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;
import utils.Assertions;
import utils.SeleniumUtils;
import utils.SeleniumWait;

import java.time.Duration;
import java.util.logging.Logger;
import java.util.concurrent.TimeUnit;

public class ICPPage {
    // Locators for login page
    @FindBy(how = How.ID, using = "nce-input")
    WebElement USERNAME_TB;
    @FindBy(how = How.ID, using = "icp-input-password")
    WebElement PASSWORD_TB;
    @FindBy(how = How.ID, using = "nce-login-btn")
    WebElement LOGIN_BTN;

    // Locators for Use Case 1 (Passenger Forecasting Page)
    @FindBy(how = How.XPATH, using = "//span[text()='Passenger Forecasting']")
    WebElement PASSENGER_FORECASTING_LINK;
    @FindBy(how = How.XPATH, using = "//span[text()='Aircraft Activity']")
    WebElement AIRCRAFT_ACTIVITY_LBL;
    @FindBy(how = How.XPATH, using = "//span[@class='ant-select-selection-item']")
    WebElement EMIRATES_CODE_DD;
    @FindBy(how = How.XPATH, using = "//div[@class='ant-picker-input']")
    WebElement CALENDAR_BTN;
    @FindBy(how = How.XPATH, using = "//h4[contains(text(),'Passenger Forecasting for Shift Optimisation')]")
    WebElement PASSENGER_FORECASTING_LBL;
    public static final By CALENDER_BTN = By.xpath("//div[@class='ant-picker-input']");
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Passengers Volume:')]")
    WebElement FORECAST_DATA_CHART_LBL;
    @FindBy(how = How.XPATH, using = "//span[text()='Aircraft Activity']//following::h4/span")
    WebElement AIRCRAFT_ACTIVITY_LBL1;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Passengers Traffic')]//following::h4/span")
    WebElement EXPECTED_PASSENGERS_TRAFFIC_LBL;
    @FindBy(how = How.XPATH, using = "//span[text()='Staffed Gate Passengers']//following::h4/span")
    WebElement STAFFED_GATE_PASSENGERS_LBL;
    @FindBy(how = How.XPATH, using = "//span[text()='E-Gate Passengers']//following::h4/span")
    WebElement E_GATE_PASSENGERS_LBL;
    @FindBy(how = How.XPATH, using = "//span[text()='Staffed Gate - Arrival']//following::h4/span")
    WebElement STAFFED_GATE_ARRIVAL_LBL;
    @FindBy(how = How.XPATH, using = "//span[text()='Staffed Gate - Departure']//following::h4/span")
    WebElement STAFFED_GATE_DEPARTURE_LBL;
    @FindBy(how = How.XPATH, using = "//span[text()='% of Passengers in Transit']//following::h4/span")
    WebElement PASSENGERS_IN_TRANSIT_LBL;
    @FindBy(how = How.XPATH, using = "//h5[text()='Staffed Gate - Arrival']//following::strong[text()='Shift 1']")
    WebElement ARRIVAL_SHIFT1_LBL;
    @FindBy(how = How.XPATH, using = "//h5[text()='Staffed Gate - Arrival']//following::strong[text()='Shift 2']")
    WebElement ARRIVAL_SHIFT2_LBL;
    @FindBy(how = How.XPATH, using = "//h5[text()='Staffed Gate - Arrival']//following::strong[text()='Shift 3']")
    WebElement ARRIVAL_SHIFT3_LBL;
    @FindBy(how = How.XPATH, using = "//h5[text()='Staffed Gate - Departure']//following::strong[text()='Shift 1']")
    WebElement DEPARTURE_SHIFT1_LBL;
    @FindBy(how = How.XPATH, using = "//h5[text()='Staffed Gate - Departure']//following::strong[text()='Shift 2']")
    WebElement DEPARTURE_SHIFT2_LBL;
    @FindBy(how = How.XPATH, using = "//h5[text()='Staffed Gate - Departure']//following::strong[text()='Shift 3']")
    WebElement DEPARTURE_SHIFT3_LBL;
    @FindBy(how = How.XPATH, using = "//h5[text()='Staffed Gate - Arrival']//following::strong[text()='Shift 1']//following::div[contains(@style,'background-image')]")
    WebElement ARRIVAL_SHIFT1_CHART_IMG;
    @FindBy(how = How.XPATH, using = "//h5[text()='Staffed Gate - Arrival']//following::strong[text()='Shift 2']//following::div[contains(@style,'background-image')]")
    WebElement ARRIVAL_SHIFT2_CHART_IMG;
    @FindBy(how = How.XPATH, using = "//h5[text()='Staffed Gate - Arrival']//following::strong[text()='Shift 3']//following::div[contains(@style,'background-image')]")
    WebElement ARRIVAL_SHIFT3_CHART_IMG;
    @FindBy(how = How.XPATH, using = "//h5[text()='Staffed Gate - Departure']//following::strong[text()='Shift 1']//following::div[contains(@style,'background-image')]")
    WebElement DEPARTURE_SHIFT1_CHART_IMG;
    @FindBy(how = How.XPATH, using = "//h5[text()='Staffed Gate - Departure']//following::strong[text()='Shift 2']//following::div[contains(@style,'background-image')]")
    WebElement DEPARTURE_SHIFT2_CHART_IMG;
    @FindBy(how = How.XPATH, using = "//h5[text()='Staffed Gate - Departure']//following::strong[text()='Shift 3']//following::div[contains(@style,'background-image')]")
    WebElement DEPARTURE_SHIFT3_CHART_IMG;
    @FindBy(how = How.XPATH, using = "//strong[contains(text(),'Forecast Analysis')]//following::div[contains(@id,'highcharts')]")
    WebElement FORECAST_ANALYSIS_CHART;
    @FindBy(how = How.XPATH, using = "//strong[text()='Staffed Gate - Arrival']//following::th[contains(text(),'Time')]")
    WebElement STAFFED_GATE_ARRIVAL_TIME_LBL;
    @FindBy(how = How.XPATH, using = "//strong[text()='Staffed Gate - Arrival']//following::th[contains(text(),'Manual Gate Passengers Volume')]")
    WebElement STAFFED_GATE_ARRIVAL_MANUAL_GATE_PASSENGERS_LBL;
    @FindBy(how = How.XPATH, using = "//strong[text()='Staffed Gate - Arrival']//following::th[contains(text(),'Status')]")
    WebElement STAFFED_GATE_ARRIVAL_STATUS_LBL;
    @FindBy(how = How.XPATH, using = "//strong[text()='Staffed Gate - Arrival']//following::th[contains(text(),'Officers Required')]")
    WebElement STAFFED_GATE_ARRIVAL_OFFICERS_REQUIRED_TH;
    @FindBy(how = How.XPATH, using = "//strong[text()='Staffed Gate - Departure']//following::th[contains(text(),'Time')]")
    WebElement STAFFED_GATE_DEPARTURE_TIME_LBL;
    @FindBy(how = How.XPATH, using = "//strong[text()='Staffed Gate - Departure']//following::th[contains(text(),'Manual Gate Passengers Volume')]")
    WebElement STAFFED_GATE_DEPARTURE_MANUAL_GATE_PASSENGERS_LBL;
    @FindBy(how = How.XPATH, using = "//strong[text()='Staffed Gate - Departure']//following::th[contains(text(),'Status')]")
    WebElement STAFFED_GATE_DEPARTURE_STATUS_LBL;
    @FindBy(how = How.XPATH, using = "//strong[text()='Staffed Gate - Departure']//following::th[contains(text(),'Officers Required')]")
    WebElement STAFFED_GATE_DEPARTURE_OFFICERS_REQUIRED_LBL;

    // Locators for Use Case 2 (Name Origin Explorer Page)
    @FindBy(how = How.XPATH, using = "//span[text()='Name Origin Explorer']")
    WebElement NAME_ORIGIN_EXPLORER_LINK;
    @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter Full Name']")
    WebElement FULLNAME_TB;
    @FindBy(how = How.XPATH, using = "//input[@id='rc_select_3']")
    WebElement RESIDENCY_DD;
    @FindBy(how = How.XPATH, using = "//span[text()='Predict Origin']")
    WebElement PREDICT_ORIGIN_BTN;
    @FindBy(how = How.XPATH, using = "//h1[contains(text(),'Origin of Names Exploration')]")
    WebElement NAME_ORIGIN_LBL;
    @FindBy(how = How.XPATH, using = "//h5[text()='Region']")
    WebElement REGION_LBL;
    @FindBy(how = How.XPATH, using = "//h5[text()='Country']")
    WebElement COUNTRY_LBL;
    @FindBy(how = How.XPATH, using = "//h5[text()='Alternative Country']")
    WebElement ALTERNATIVE_COUNTRY_LBL;
    @FindBy(how = How.XPATH, using = "//h5[text()='Other Top Countries Of Origin']")
    WebElement OTHER_TOP_COUNTRIES_OF_ORIGIN_LBL;
    @FindBy(how = How.XPATH, using = "//h5[text()='Other Top Region Of Origin']")
    WebElement OTHER_TOP_REGION_OF_ORIGIN_LBL;

    // Locators for Use Dashboard 1 (Expats Residency Page)
    @FindBy(how = How.XPATH, using = "//span[text()='Expats Residency']")
    WebElement EXPATS_RESIDENCY_LINK;
    @FindBy(how = How.XPATH, using = "//span[text()='All Nationalities']")
    WebElement ALL_NATIONALITIES_LBL;
    @FindBy(how = How.XPATH, using = "//button/span[text()='Apply All']")
    WebElement APPLY_ALL_BTN;
    @FindBy(how = How.XPATH, using = "//input[@id='rc_select_1']")
    WebElement EMIRATES_DB1_DD;
    @FindBy(how = How.XPATH, using = "//input[@id='rc_select_2']")
    WebElement NATIONALITY_DB1_DD;
    @FindBy(how = How.XPATH, using = "//h4[contains(text(),'Expats Residency')]")
    WebElement EXPATS_RESIDENCY_LBL;

    // Locators for Use Dashboard 2 (Active Residency Page)
    @FindBy(how = How.XPATH, using = "//span[text()='Active Residency']")
    WebElement ACTIVE_RESIDENCY_LINK;
    @FindBy(how = How.XPATH, using = "//span[text()='Total Active Residents']")
    WebElement TOTAL_ACTIVE_RESIDENTS_LBL;
    @FindBy(how = How.XPATH, using = "//span[text()='Other Filters']")
    WebElement OTHER_FILTER_BTN;
    @FindBy(how = How.XPATH, using = "//input[@id='rc_select_1']")
    WebElement NATIONALITY_DB2_DD;
    @FindBy(how = How.XPATH, using = "//input[@id='rc_select_2']")
    WebElement EMIRATES_DB2_DD;
    @FindBy(how = How.XPATH, using = "//input[@id='rc_select_3']")
    WebElement RESIDENCY_TYPE_DB2_DD;
    @FindBy(how = How.XPATH, using = "//h4[contains(text(),'Active Residency')]")
    WebElement ACTIVE_RESIDENCY_LBL;

    // Locators for Use Dashboard 3 (Active General Page)
    @FindBy(how = How.XPATH, using = "//span[text()='Active General']")
    WebElement ACTIVE_GENERAL_LINK;
    @FindBy(how = How.XPATH, using = "//input[@id='rc_select_1']")
    WebElement NATIONALITY_DB3_DD;
    @FindBy(how = How.XPATH, using = "//input[@id='rc_select_2']")
    WebElement EMIRATES_DB3_DD;
    @FindBy(how = How.XPATH, using = "//span[text()='Total Active General Population']")
    WebElement TOTAL_ACTIVE_GENERAL_POPULATION_LBL;
    @FindBy(how = How.XPATH, using = "//h4[contains(text(),'Active General Population')]")
    WebElement ACTIVE_GENERAL_POPULATION_LBL;

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
            SeleniumWait.waitUntilVisibilityOfElement(driver,PASSWORD_TB, 15);
            // Clear the fields and enter valid credentials
            logger.info("Clearing username and password fields.");
            usernameField.clear();
            PASSWORD_TB.clear();
            logger.info("Entering username.");
            usernameField.sendKeys(username);
            logger.info("Entering password.");
            PASSWORD_TB.sendKeys(password);

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

    public void validatePassengerForecastingHeading(String expectedText){
        validatePageHeading(PASSENGER_FORECASTING_LBL.getText(), expectedText);
    }

    public void validateNameOriginHeading(String expectedText){
        validatePageHeading(NAME_ORIGIN_LBL.getText(), expectedText);
    }

    public void validateExpatsResidencyHeading(String expectedText){
        validatePageHeading(EXPATS_RESIDENCY_LBL.getText(), expectedText);
    }

    public void validateActiveResidencyHeading(String expectedText){
        validatePageHeading(ACTIVE_RESIDENCY_LBL.getText(), expectedText);
    }

    public void validateActiveGeneralHeading(String expectedText){
        validatePageHeading(ACTIVE_GENERAL_POPULATION_LBL.getText(), expectedText);
    }

    public void validatePageHeading(String actualText,String expectedText){
        Assertions.assertTrue(actualText.equals(expectedText),
                "Actual Value: "+actualText+" Expected Value: "+expectedText);
    }

    public void validateExpectedPassengersVolumeElements(){
        SeleniumWait.waitUntilVisibilityOfElement(driver,AIRCRAFT_ACTIVITY_LBL, 20);
        Assertions.softAssertTrue(FORECAST_DATA_CHART_LBL.isDisplayed(),
                "Actual Value: '" + FORECAST_DATA_CHART_LBL.getText() + "' is appearing blank while looking for real data");
        Assertions.softAssertTrue(!AIRCRAFT_ACTIVITY_LBL.getText().equals("-"),
                "Actual Value: '" + AIRCRAFT_ACTIVITY_LBL.getText() + "' is appearing blank while looking for real data");
        Assertions.softAssertTrue(!EXPECTED_PASSENGERS_TRAFFIC_LBL.getText().equals("-"),
                "Actual Value: '" + EXPECTED_PASSENGERS_TRAFFIC_LBL.getText() + "' is appearing blank while looking for real data");
        Assertions.softAssertTrue(!STAFFED_GATE_PASSENGERS_LBL.getText().equals("-"),
                "Actual Value: '" + STAFFED_GATE_PASSENGERS_LBL.getText() + "' is appearing blank while looking for real data");
        Assertions.softAssertTrue(!E_GATE_PASSENGERS_LBL.getText().equals("-"),
                "Actual Value: '" + E_GATE_PASSENGERS_LBL.getText() + "' is appearing blank while looking for real data");
        Assertions.softAssertTrue(!STAFFED_GATE_ARRIVAL_LBL.getText().equals("-"),
                "Actual Value: '" + STAFFED_GATE_ARRIVAL_LBL.getText() + "' is appearing blank while looking for real data");
        Assertions.softAssertTrue(!STAFFED_GATE_DEPARTURE_LBL.getText().equals("-"),
                "Actual Value: '" + STAFFED_GATE_DEPARTURE_LBL.getText() + "' is appearing blank while looking for real data");
        Assertions.softAssertTrue(!PASSENGERS_IN_TRANSIT_LBL.getText().equals("-"),
                "Actual Value: '" + PASSENGERS_IN_TRANSIT_LBL.getText() + "' is appearing blank while looking for real data");
        Assertions.softAssertAll();
    }

    public void validateStaffGateArrivalDeparture(){
        SeleniumWait.waitUntilVisibilityOfElement(driver,ARRIVAL_SHIFT1_LBL, 20);
        SeleniumUtils.scrollTillElementWithJS(driver, ARRIVAL_SHIFT1_LBL);
        Assertions.softAssertTrue(ARRIVAL_SHIFT1_LBL.isDisplayed(),
                "Actual Value: '" + ARRIVAL_SHIFT1_LBL.getText() + "' is appearing blank while looking for real data");
        Assertions.softAssertTrue(ARRIVAL_SHIFT2_LBL.isDisplayed(),
                "Actual Value: '" + ARRIVAL_SHIFT2_LBL.getText() + "' is appearing blank while looking for real data");
        Assertions.softAssertTrue(ARRIVAL_SHIFT3_LBL.isDisplayed(),
                "Actual Value: '" + ARRIVAL_SHIFT3_LBL.getText() + "' is appearing blank while looking for real data");
        Assertions.softAssertTrue(DEPARTURE_SHIFT1_LBL.isDisplayed(),
                "Actual Value: '" + DEPARTURE_SHIFT1_LBL.getText() + "' is appearing blank while looking for real data");
        Assertions.softAssertTrue(DEPARTURE_SHIFT2_LBL.isDisplayed(),
                "Actual Value: '" + DEPARTURE_SHIFT2_LBL.getText() + "' is appearing blank while looking for real data");
        Assertions.softAssertTrue(DEPARTURE_SHIFT3_LBL.isDisplayed(),
                "Actual Value: '" + DEPARTURE_SHIFT3_LBL.getText() + "' is appearing blank while looking for real data");
        Assertions.softAssertTrue(ARRIVAL_SHIFT1_CHART_IMG.isDisplayed(),
                "Actual Value: '" + ARRIVAL_SHIFT1_CHART_IMG.getAttribute("style") + "' is appearing blank while looking for real data");
        Assertions.softAssertTrue(ARRIVAL_SHIFT2_CHART_IMG.isDisplayed(),
                "Actual Value: '" + ARRIVAL_SHIFT2_CHART_IMG.getAttribute("style") + "' is appearing blank while looking for real data");
        Assertions.softAssertTrue(ARRIVAL_SHIFT3_CHART_IMG.isDisplayed(),
                "Actual Value: '" + ARRIVAL_SHIFT3_CHART_IMG.getAttribute("style") + "' is appearing blank while looking for real data");
        Assertions.softAssertTrue(DEPARTURE_SHIFT1_CHART_IMG.isDisplayed(),
                "Actual Value: '" + DEPARTURE_SHIFT1_CHART_IMG.getAttribute("style") + "' is appearing blank while looking for real data");
        Assertions.softAssertTrue(DEPARTURE_SHIFT2_CHART_IMG.isDisplayed(),
                "Actual Value: '" + DEPARTURE_SHIFT2_CHART_IMG.getAttribute("style") + "' is appearing blank while looking for real data");
        Assertions.softAssertTrue(DEPARTURE_SHIFT3_CHART_IMG.isDisplayed(),
                "Actual Value: '" + DEPARTURE_SHIFT3_CHART_IMG.getAttribute("style") + "' is appearing blank while looking for real data");
        Assertions.softAssertAll();
    }

    public void validatePassengersForecastAnalysis(){
        SeleniumWait.waitUntilVisibilityOfElement(driver,FORECAST_ANALYSIS_CHART, 20);
        SeleniumUtils.scrollTillElementWithJS(driver, FORECAST_ANALYSIS_CHART);
        Assertions.softAssertTrue(FORECAST_ANALYSIS_CHART.isDisplayed(),
                "Actual Value: '" + FORECAST_ANALYSIS_CHART.getText() + "' is appearing blank while looking for real data");
    }

    public void validateStaffedGatePassengersCount(){
        SeleniumWait.waitUntilVisibilityOfElement(driver,STAFFED_GATE_ARRIVAL_TIME_LBL, 20);
        SeleniumUtils.scrollTillElementWithJS(driver, STAFFED_GATE_ARRIVAL_TIME_LBL);
        Assertions.softAssertTrue(STAFFED_GATE_ARRIVAL_TIME_LBL.isDisplayed(),
                "Actual Value: '" + STAFFED_GATE_ARRIVAL_TIME_LBL.getText() + "' is appearing blank while looking for real data");
        Assertions.softAssertTrue(STAFFED_GATE_ARRIVAL_MANUAL_GATE_PASSENGERS_LBL.isDisplayed(),
                "Actual Value: '" + STAFFED_GATE_ARRIVAL_MANUAL_GATE_PASSENGERS_LBL.getText() + "' is appearing blank while looking for real data");
        Assertions.softAssertTrue(STAFFED_GATE_ARRIVAL_STATUS_LBL.isDisplayed(),
                "Actual Value: '" + STAFFED_GATE_ARRIVAL_STATUS_LBL.getText() + "' is appearing blank while looking for real data");
        Assertions.softAssertTrue(STAFFED_GATE_ARRIVAL_OFFICERS_REQUIRED_TH.isDisplayed(),
                "Actual Value: '" + STAFFED_GATE_ARRIVAL_OFFICERS_REQUIRED_TH.getText() + "' is appearing blank while looking for real data");
        Assertions.softAssertTrue(STAFFED_GATE_DEPARTURE_TIME_LBL.isDisplayed(),
                "Actual Value: '" + STAFFED_GATE_DEPARTURE_TIME_LBL.getText() + "' is appearing blank while looking for real data");
        Assertions.softAssertTrue(STAFFED_GATE_DEPARTURE_MANUAL_GATE_PASSENGERS_LBL.isDisplayed(),
                "Actual Value: '" + STAFFED_GATE_DEPARTURE_MANUAL_GATE_PASSENGERS_LBL.getText() + "' is appearing blank while looking for real data");
        Assertions.softAssertTrue(STAFFED_GATE_DEPARTURE_STATUS_LBL.isDisplayed(),
                "Actual Value: '" + STAFFED_GATE_DEPARTURE_STATUS_LBL.getText() + "' is appearing blank while looking for real data");
        Assertions.softAssertTrue(STAFFED_GATE_DEPARTURE_OFFICERS_REQUIRED_LBL.isDisplayed(),
                "Actual Value: '" + STAFFED_GATE_DEPARTURE_OFFICERS_REQUIRED_LBL.getText() + "' is appearing blank while looking for real data");
        Assertions.softAssertAll();
    }

    public void validateNameResultPage(String name) {
        String locatorValue="//strong[text()='"+name+" Originated From']";
        WebElement nameXpath=driver.findElement(By.xpath(locatorValue));
        SeleniumWait.waitUntilVisibilityOfElement(driver, nameXpath, 20);
        Assertions.softAssertTrue(REGION_LBL.isDisplayed(),
                "Actual Value: '" + REGION_LBL.getText() + "' is appearing blank while looking for real data");
        Assertions.softAssertTrue(COUNTRY_LBL.isDisplayed(),
                "Actual Value: '" + COUNTRY_LBL.getText() + "' is appearing blank while looking for real data");
        Assertions.softAssertTrue(ALTERNATIVE_COUNTRY_LBL.isDisplayed(),
                "Actual Value: '" + ALTERNATIVE_COUNTRY_LBL.getText() + "' is appearing blank while looking for real data");
        Assertions.softAssertTrue(OTHER_TOP_COUNTRIES_OF_ORIGIN_LBL.isDisplayed(),
                "Actual Value: '" + OTHER_TOP_COUNTRIES_OF_ORIGIN_LBL.getText() + "' is appearing blank while looking for real data");
        Assertions.softAssertTrue(OTHER_TOP_REGION_OF_ORIGIN_LBL.isDisplayed(),
                "Actual Value: '" + OTHER_TOP_REGION_OF_ORIGIN_LBL.getText() + "' is appearing blank while looking for real data");
        Assertions.softAssertAll();
    }
}
