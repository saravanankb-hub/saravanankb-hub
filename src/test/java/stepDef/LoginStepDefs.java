package stepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static pages.LoginPage.*;

public class LoginStepDefs {

    @When("user successfully enters the login details")
    public void userSuccessfullyEntersTheLoginDetails() {
        enter_userName();
        enter_password();
        click_login();
    }

    @Then("user should be able to view the product details")
    public void userShouldBeAbleToViewTheProductDetails() throws IOException {
        view_mainPage();
    }
}