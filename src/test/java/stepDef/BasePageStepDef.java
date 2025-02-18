package stepDef;

import io.cucumber.java.en.Given;

import static pages.LoginPage.click_hamburger_menu;
import static pages.LoginPage.click_signIn_Link;

public class BasePageStepDef {

    @Given("user navigates to login Page")
    public void userNavigatesToLoginPage() {
        click_hamburger_menu();
        click_signIn_Link();
    }
}