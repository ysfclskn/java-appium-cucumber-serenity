package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import questions.HomePage;
import questions.LoginPage;
import tasks.LoginToEriBank;
import ui.HomePageElements;
import ui.LoginPageElements;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class LogoutSteps {

    @Managed(driver = "Appium")
    public WebDriver herMobileDevice;

    String actorName="ysfclskn";
    Actor actor = Actor.named(actorName);

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("User logged in")
    public void userLoggedIn() {
        actor.can(BrowseTheWeb.with(herMobileDevice));
        actor.attemptsTo(LoginToEriBank.login("company","company"));
    }

    @When("User should see logout button")
    public void userShouldSeeLogoutButton() {
        actor.should(
                seeThat(HomePage.isVisible())
        );
    }

    @Then("User logout")
    public void userLogout() {
        actor.attemptsTo(
                Click.on(HomePageElements.LOGOUT_BUTTON)
        );

        actor.should(
                seeThat(LoginPage.isVisible())
        );
    }
}
