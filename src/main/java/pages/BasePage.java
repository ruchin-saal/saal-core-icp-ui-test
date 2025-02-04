package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//*[local-name()='svg' and @id='MENU_OPEN']")
    static WebElement hamburgerMenuIcn;

    @FindBy(how = How.ID, using = "APP_LOGO")
    static WebElement applicationLogo;

    @FindBy(how = How.ID, using = "LANGUAGE_SWITCH")
    static WebElement languageSwitchIcn;


    @FindBy(how = How.ID, using = "USER_AVATAR_DROPDOWN")
    static WebElement userInfoLbl;

    @FindBy(how = How.ID, using = "USER_LOGOUT")
    static WebElement logoutBtn;
}
