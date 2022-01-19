package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaymentPageElements {


    public static Target PHONE_TEXTFIELD = Target.the("Phone Text Field")
            .located(By.id("phoneTextField"));
    public static Target NAME_TEXTFIELD = Target.the("Name Text Field")
            .located(By.id("nameTextField"));
    public static Target AMOUNT_BAR = Target.the("Amount Bar")
            .located(By.id("amount"));
    public static Target COUNTRY_BUTTON = Target.the("Country Button")
            .located(By.id("countryButton"));
    public static Target SENDPAYMENT_BUTTON = Target.the("Payment Button")
            .located(By.id("sendPaymentButton"));
    public static Target POPUPOK_BUTTON = Target.the("Accept payment button")
            .located(By.id("android:id/button1"));






}
