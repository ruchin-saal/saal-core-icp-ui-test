package testSuite;

import driver.BaseClass;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ICPPage;
import utils.Options;
import utils.SeleniumUtils;
import utils.WebDriverSessionManager;

@Epic("Audits Page")
@Feature("Audits Page Components")
public class ICPTest extends BaseClass {

    private static final Logger logger = LogManager.getLogger(ICPTest.class);
    ICPPage icpPage;


    @BeforeMethod(alwaysRun = true)
    public void initializeDriver() {
        logger.info("Initializing the web-driver instance based on the things from the config file");
        startDriver();
        openBrowserWithBaseURL(WebDriverSessionManager.getDriver());
        icpPage = new ICPPage(WebDriverSessionManager.getDriver());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        SeleniumUtils.terminateWindow(WebDriverSessionManager.getDriver(), Options.QUIT);
    }

    @Description("Visit UC1(Passenger Forecasting) Page and validate page is up and running")
    @Story("Visit UC1(Passenger Forecasting) Page")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Visit UC1(Passenger Forecasting) Page", groups = {"regression", "smoke", "sanity"})
    public void verifyPassengerForecastingPage() {
        logger.info("Verifying the Admin user logged-In successfully");
        icpPage.performLoginIntoICPApplication(getValueFromProperties("adminUserName"), getValueFromProperties("adminPassword"));
        logger.info("Verified the Admin user logged-In successfully & 'welcome message!!!");
        icpPage.selectPassengerForecastingPage();
        icpPage.validatePassengerForecastingHeading(getValueFromProperties("passengerForecastingHeading"));
    }

    @Test(description = "Visit UC1(Passenger Forecasting) Page and apply filters", groups = {"regression", "smoke", "sanity"})
    @Description("Visit UC1(Passenger Forecasting) Page and apply filters")
    @Story("Visit UC1(Passenger Forecasting) Page")
    @Severity(SeverityLevel.CRITICAL)
    public void applyFilterForPassengerForecastingPage() {
        logger.info("Visit UC1(Passenger Forecasting) Page and apply filters");
        icpPage.performLoginIntoICPApplication(getValueFromProperties("adminUserName"), getValueFromProperties("adminPassword"));
        icpPage.selectPassengerForecastingPage();
        icpPage.selectEmiratesCode(getValueFromProperties("emiratesCodeAUH"));
        icpPage.selectDate(getValueFromProperties("calenderDate"));
        icpPage.validateExpectedPassengersVolumeElements();
        icpPage.validateStaffGateArrivalDeparture();
        icpPage.validatePassengersForecastAnalysis();
        icpPage.validateStaffedGatePassengersCount();
    }

    @Test(description = "Visit UC2(Name Origin Explorer) page is up and running", groups = {"regression", "smoke", "sanity"})
    @Description("Visit UC2(Name Origin Explorer) Page")
    @Story("Visit UC2(Name Origin Explorer) Page")
    @Severity(SeverityLevel.CRITICAL)
    public void validateNameOriginPage() {
        logger.info("Visit UC2(Name Origin Explorer) Page");
        icpPage.performLoginIntoICPApplication(getValueFromProperties("adminUserName"), getValueFromProperties("adminPassword"));
        icpPage.selectNameOriginExplorerPage();
        icpPage.validateNameOriginHeading(getValueFromProperties("nameOriginHeading"));
    }

    @Test(description = "Visit UC2(Name Origin Explorer) Page and apply filters", groups = {"regression", "smoke", "sanity"})
    @Description("Visit UC2(Name Origin Explorer) Page and apply filters")
    @Story("Visit UC2(Name Origin Explorer) Page and apply filters")
    @Severity(SeverityLevel.CRITICAL)
    public void validateNameOriginAfterEnteringName() {
        logger.info("Visit UC2(Name Origin Explorer) Page and apply filters");
        icpPage.performLoginIntoICPApplication(getValueFromProperties("adminUserName"), getValueFromProperties("adminPassword"));
        icpPage.selectNameOriginExplorerPage();
        icpPage.enterName(getValueFromProperties("name"));
        icpPage.selectPredictOriginButton();
        icpPage.validateNameResultPage(getValueFromProperties("name"));
    }

    @Test(description = "Visit Dashboard1(Expats Residency)  page is up and running", groups = {"regression", "smoke", "sanity"})
    @Description("Visit Dashboard1(Expats Residency) Page")
    @Story("Visit Dashboard1(Expats Residency) Page")
    @Severity(SeverityLevel.CRITICAL)
    public void validateExpatsResidencyPage() {
        logger.info("Visit Dashboard1(Expats Residency) Page");
        icpPage.performLoginIntoICPApplication(getValueFromProperties("adminUserName"), getValueFromProperties("adminPassword"));
        icpPage.selectExpatsResidencyPage();
        icpPage.validateExpatsResidencyHeading(getValueFromProperties("expatsResidencyHeading"));
    }

    @Test(description = "Visit Dashboard1(Expats Residency) Page and apply filters", groups = {"regression", "smoke", "sanity"})
    @Description("Visit Dashboard1(Expats Residency) Page and apply filters")
    @Story("Visit Dashboard1(Expats Residency) Page and apply filters")
    @Severity(SeverityLevel.CRITICAL)
    public void validateExpatsResidencyPageWithFilter() {
        logger.info("Visit Dashboard1(Expats Residency) Page and apply filters");
        icpPage.performLoginIntoICPApplication(getValueFromProperties("adminUserName"), getValueFromProperties("adminPassword"));
        icpPage.selectExpatsResidencyPage();
        icpPage.selectFiltersForDashboard1(getValueFromProperties("dashboard1Gender"),
                getValueFromProperties("dashboard1Emirates"),
                getValueFromProperties("dashboard1Country"));
        icpPage.validateAppliedFilter(getValueFromProperties("dashboard1Gender"),
                getValueFromProperties("dashboard1Emirates"),
                getValueFromProperties("dashboard1Country"));
        icpPage.validateContinent();
        icpPage.validateCountryNameInCountryList(getValueFromProperties("dashboard1Country"));
        icpPage.validateVisaAndExpatriatesData();
        icpPage.validateNationalityByGender();
        icpPage.validateTotalExpatResidentsByEmirates(getValueFromProperties("dashboard1Emirates"));
        icpPage.validateTotalResidentsByYearChart();
    }

    @Test(description = "Visit Dashboard2(Active Residency) page is up and running", groups = {"regression", "smoke", "sanity"})
    @Description("Visit Dashboard2(Active Residency) Page")
    @Story("Visit Dashboard2(Active Residency) Page")
    @Severity(SeverityLevel.CRITICAL)
    public void validateActiveGeneralPage() {
        logger.info("Visit Dashboard2(Active Residency) Page");
        icpPage.performLoginIntoICPApplication(getValueFromProperties("adminUserName"), getValueFromProperties("adminPassword"));
        icpPage.selectActiveResidencyPage();
        icpPage.validateActiveResidencyHeading(getValueFromProperties("activeResidencyHeading"));
    }

    @Test(description = "Visit Dashboard2(Active Residency) Page and apply filters", groups = {"regression", "smoke", "sanity"})
    @Description("Visit Dashboard2(Active Residency) Page and apply filters")
    @Story("Visit Dashboard2(Active Residency) Page and apply filters")
    @Severity(SeverityLevel.CRITICAL)
    public void validateActiveGeneralPageWithFilter() {
        logger.info("Visit Dashboard2(Active Residency) Page and apply filters");
        icpPage.performLoginIntoICPApplication(getValueFromProperties("adminUserName"), getValueFromProperties("adminPassword"));
        icpPage.selectActiveResidencyPage();
        icpPage.selectFiltersForDashboard2(getValueFromProperties("dashboard2Country"),
                getValueFromProperties("dashboard2Emirates"),
                getValueFromProperties("dashboard2WorkResidencyHeading"),
                getValueFromProperties("dashboard2StartingAge"),
                getValueFromProperties("dashboard2EndAge"),
                getValueFromProperties("dashboard2Gender"));
        String ageRange = getValueFromProperties("dashboard2StartingAge") + "-" + getValueFromProperties("dashboard2EndAge");
        icpPage.validateAppliedFilterForDashboard2(getValueFromProperties("dashboard2Country"),
                getValueFromProperties("dashboard2Emirates"),
                getValueFromProperties("dashboard2WorkResidencyHeading"),
                ageRange,
                getValueFromProperties("dashboard2Gender"));
        icpPage.validateDB2ResidentsByGender();
        icpPage.validateDB2ResidentsByResidencyType();
        icpPage.validateDB2ResidentsByAgeRange();
        icpPage.validateDB2ResidentsByEmirates();
        icpPage.validateContinentDashboard2();
        icpPage.validateCountryNameInCountryList(getValueFromProperties("dashboard2Country"));
        icpPage.validateDB2ResidentsByProfession();
        icpPage.validateDB2ResidentsBySponsor();
    }

    @Test(description = "Visit Dashboard3(Active General) page is up and running", groups = {"regression", "smoke", "sanity"})
    @Description("Visit Dashboard3(Active General) Page")
    @Story("Visit Dashboard3(Active General) Page")
    @Severity(SeverityLevel.CRITICAL)
    public void validateActiveGeneralHeading() {
        logger.info("Visit Dashboard3(Active General) Page");
        icpPage.performLoginIntoICPApplication(getValueFromProperties("adminUserName"), getValueFromProperties("adminPassword"));
        icpPage.selectActiveGeneralPage();
        icpPage.validateActiveGeneralHeading(getValueFromProperties("activeGeneralHeading"));
    }

    @Test(description = "Visit Dashboard3(Active General) Page and apply filters", groups = {"regression", "smoke", "sanity"})
    @Description("Visit Dashboard3(Active General) Page and apply filters")
    @Story("Visit Dashboard3(Active General) Page and apply filters")
    @Severity(SeverityLevel.CRITICAL)
    public void validateActiveGeneralHeadingWithFilter() {
        logger.info("Visit Dashboard3(Active General) Page and apply filters");
        icpPage.performLoginIntoICPApplication(getValueFromProperties("adminUserName"), getValueFromProperties("adminPassword"));
        icpPage.selectActiveGeneralPage();
        icpPage.selectFiltersForDashboard3(getValueFromProperties("dashboard3Country"),
                getValueFromProperties("dashboard3Emirates"),
                getValueFromProperties("dashboard3StartingAge"),
                getValueFromProperties("dashboard3EndAge"),
                getValueFromProperties("dashboard3Gender"));
        String ageRange = getValueFromProperties("dashboard3StartingAge") + "-" + getValueFromProperties("dashboard3EndAge");
        icpPage.validateAppliedFilterForDashboard3(getValueFromProperties("dashboard3Country"),
                getValueFromProperties("dashboard3Emirates"),
                ageRange,
                getValueFromProperties("dashboard3Gender"));
        icpPage.validateGeneralPopulationDashboard3();
        icpPage.validatePopulationByEmiratesDashboard3();
        icpPage.validateContinentDashboard3();
        icpPage.validateCountryNameInCountryList(getValueFromProperties("dashboard3Country"));
        icpPage.validatePopulationByGenderDashboard3();
        icpPage.validatePopulationByAgeRangeDashboard3();
    }
}