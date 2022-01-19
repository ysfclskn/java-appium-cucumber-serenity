package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePageElements {

    public static Target LOGOUT_BUTTON = Target.the("Logout Button")
            .located(By.id("logoutButton"));
    public static Target MAKEPAYMENT_BUTTON = Target.the("Make Payment Button")
            .located(By.id("makePaymentButton"));
    public static Target TOTALBALANCE_TEXT = Target.the("Amount Text")
            .located(By.className("android.view.View"));

}
