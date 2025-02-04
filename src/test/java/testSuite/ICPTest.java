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
        icpPage=new ICPPage(WebDriverSessionManager.getDriver());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        SeleniumUtils.terminateWindow(WebDriverSessionManager.getDriver(), Options.QUIT);
    }

    @Description("Visit UC1(Passenger Forecasting) Page")
    @Story("Visit UC1(Passenger Forecasting) Page")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description="Visit UC1(Passenger Forecasting) Page", groups = {"regression", "smoke", "sanity"})
    public void verifyPassengerForecastingPage(){
        logger.info("Verifying the Admin user logged-In successfully");
        icpPage.performLoginIntoICPApplication(getValueFromProperties("adminUserName"), getValueFromProperties("adminPassword"));
        logger.info("Verified the Admin user logged-In successfully & 'welcome message!!!");
        icpPage.selectPassengerForecastingPage();
    }

    @Test(description = "Visit UC1(Passenger Forecasting) Page and apply filters", groups = {"regression", "smoke", "sanity"})
    @Description("Visit UC1(Passenger Forecasting) Page and apply filters")
    @Story("Visit UC1(Passenger Forecasting) Page")
    @Severity(SeverityLevel.CRITICAL)
    public void test_case_2() {
        logger.info("Visit UC1(Passenger Forecasting) Page and apply filters");
        icpPage.performLoginIntoICPApplication(getValueFromProperties("adminUserName"), getValueFromProperties("adminPassword"));
        icpPage.selectPassengerForecastingPage();
        icpPage.selectEmiratesCode("AUH");
        icpPage.selectDate("1");
    }

    @Test(description = "Visit UC2(Name Origin Explorer) Page", groups = {"regression", "smoke", "sanity"})
    @Description("Visit UC2(Name Origin Explorer) Page")
    @Story("Visit UC2(Name Origin Explorer) Page")
    @Severity(SeverityLevel.CRITICAL)
    public void test_case_3() {
        logger.info("Visit UC2(Name Origin Explorer) Page");
        icpPage.performLoginIntoICPApplication(getValueFromProperties("adminUserName"), getValueFromProperties("adminPassword"));
        icpPage.selectNameOriginExplorerPage();
    }

    @Test(description = "Visit UC2(Name Origin Explorer) Page and apply filters", groups = {"regression", "smoke", "sanity"})
    @Description("Visit UC2(Name Origin Explorer) Page and apply filters")
    @Story("Visit UC2(Name Origin Explorer) Page and apply filters")
    @Severity(SeverityLevel.CRITICAL)
    public void test_case_4() {
        logger.info("Visit UC2(Name Origin Explorer) Page and apply filters");
        icpPage.performLoginIntoICPApplication(getValueFromProperties("adminUserName"), getValueFromProperties("adminPassword"));
        icpPage.selectNameOriginExplorerPage();
        icpPage.enterName("Ruchin Khare");
        icpPage.selectPredictOriginButton();
        logger.info("ZAP scan completed for UC2(Name Origin Explorer) Page");
    }

    @Test(description = "Visit Dashboard1(Expats Residency) Page", groups = {"regression", "smoke", "sanity"})
    @Description("Visit Dashboard1(Expats Residency) Page")
    @Story("Visit Dashboard1(Expats Residency) Page")
    @Severity(SeverityLevel.CRITICAL)
    public void test_case_5() {
        logger.info("Visit Dashboard1(Expats Residency) Page");
        icpPage.performLoginIntoICPApplication(getValueFromProperties("adminUserName"), getValueFromProperties("adminPassword"));
        icpPage.selectExpatsResidencyPage();
        logger.info("ZAP scan completed for Dashboard1(Expats Residency) Page");
    }

    @Test(description = "Visit Dashboard1(Expats Residency) Page and apply filters", groups = {"regression", "smoke", "sanity"})
    @Description("Visit Dashboard1(Expats Residency) Page and apply filters")
    @Story("Visit Dashboard1(Expats Residency) Page and apply filters")
    @Severity(SeverityLevel.CRITICAL)
    public void test_case_6() {
        logger.info("Visit Dashboard1(Expats Residency) Page and apply filters");
        icpPage.performLoginIntoICPApplication(getValueFromProperties("adminUserName"), getValueFromProperties("adminPassword"));
        icpPage.selectExpatsResidencyPage();
        icpPage.selectFiltersForDashboard1("Male", "Abu Dhabi", "India");
    }

    @Test(description = "Visit Dashboard2(Active Residency) Page", groups = {"regression", "smoke", "sanity"})
    @Description("Visit Dashboard2(Active Residency) Page")
    @Story("Visit Dashboard2(Active Residency) Page")
    @Severity(SeverityLevel.CRITICAL)
    public void test_case_7() {
        logger.info("Visit Dashboard2(Active Residency) Page");
        icpPage.performLoginIntoICPApplication(getValueFromProperties("adminUserName"), getValueFromProperties("adminPassword"));
        icpPage.selectActiveResidencyPage();

    }

    @Test(description = "Visit Dashboard2(Active Residency) Page and apply filters", groups = {"regression", "smoke", "sanity"})
    @Description("Visit Dashboard2(Active Residency) Page and apply filters")
    @Story("Visit Dashboard2(Active Residency) Page and apply filters")
    @Severity(SeverityLevel.CRITICAL)
    public void test_case_8() {
        logger.info("Visit Dashboard2(Active Residency) Page and apply filters");
        icpPage.performLoginIntoICPApplication(getValueFromProperties("adminUserName"), getValueFromProperties("adminPassword"));
        icpPage.selectActiveResidencyPage();
        icpPage.selectFiltersForDashboard2("Pakistan", "Abu Dhabi", "Work Residents", "0", "40", "Male");
    }

    @Test(description = "Visit Dashboard3(Active General) Page", groups = {"regression", "smoke", "sanity"})
    @Description("Visit Dashboard3(Active General) Page")
    @Story("Visit Dashboard3(Active General) Page")
    @Severity(SeverityLevel.CRITICAL)
    public void test_case_9() {
        logger.info("Visit Dashboard3(Active General) Page");
        icpPage.performLoginIntoICPApplication(getValueFromProperties("adminUserName"), getValueFromProperties("adminPassword"));
        icpPage.selectActiveGeneralPage();

    }

    @Test(description = "Visit Dashboard3(Active General) Page and apply filters", groups = {"regression", "smoke", "sanity"})
    @Description("Visit Dashboard3(Active General) Page and apply filters")
    @Story("Visit Dashboard3(Active General) Page and apply filters")
    @Severity(SeverityLevel.CRITICAL)
    public void test_case_10() {
        logger.info("Visit Dashboard3(Active General) Page and apply filters");
        icpPage.performLoginIntoICPApplication(getValueFromProperties("adminUserName"), getValueFromProperties("adminPassword"));
        icpPage.selectActiveGeneralPage();
        icpPage.selectFiltersForDashboard3("India", "Abu Dhabi", "0", "40", "Male");
    }
}

