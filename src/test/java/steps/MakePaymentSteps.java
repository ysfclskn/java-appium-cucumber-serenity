package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import questions.HomePage;
import questions.HomePageBalance;
import questions.PaymentPage;
import tasks.LoginToEriBank;
import tasks.MakePayment;
import ui.HomePageElements;
import ui.PaymentPageElements;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class MakePaymentSteps {
    public static int totalBalance = 100;
    public static int reducedBalance = 0;
    @Managed(driver = "Appium")
    public WebDriver herMobileDevice;

    String actorName="ysfclskn";
    Actor actor = Actor.named(actorName);

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }
    @Given("I login to app with username and password")
    public void iLoginToAppWithUsernameAndPassword() {
        actor.can(BrowseTheWeb.with(herMobileDevice));
        actor.attemptsTo(LoginToEriBank.login("company","company"));
    }


    @When("I go to Make Payment screen")
    public void iGoToMakePaymentScreen() {

        actor.attemptsTo(
                Click.on(HomePageElements.MAKEPAYMENT_BUTTON)
        );

        actor.should(
                seeThat(PaymentPage.isVisible())

        );

    }


    @And("User makes payment with {string} amount to this {string},{string} and {string}")
    public void userMakesPaymentWithAmountToThisAnd(String name, String phone, String amount, String client) {
            actor.attemptsTo(
                    MakePayment.makePayment(name,phone,amount,client)
            );
    }

    @Then("Then user should see reduced balance by {string}")
    public void thenUserShouldSeeReducedBalanceBy(String amount) {
        reducedBalance = totalBalance - (Integer.parseInt(amount));
        actor.should(
                seeThat(HomePageBalance.totalBalanceText(), Matchers.is("Your balance is:"+Integer.toString(reducedBalance)+".00$"))
        );

    }


}
