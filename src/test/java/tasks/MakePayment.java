package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.HomePageElements;
import ui.PaymentPageElements;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class MakePayment implements Task {

    private String name="";
    private String phone="";
    private String amount="";
    private String client="";

    public MakePayment (String name,String phone,String amount,String client){
        this.name = name;
        this.phone = phone;
        this.amount = amount;
        this.client = client;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            //Type Name to Name Text Field
            Click.on(PaymentPageElements.NAME_TEXTFIELD),
            SendKeys.of(this.name).into(PaymentPageElements.NAME_TEXTFIELD),
            //Type Phone to Phone Text Field
            Click.on(PaymentPageElements.PHONE_TEXTFIELD),
            SendKeys.of(this.phone).into(PaymentPageElements.PHONE_TEXTFIELD),
            //Scroll amount bar
            Click.on(PaymentPageElements.AMOUNT_BAR),
            SendKeys.of(this.amount.toString()).into(PaymentPageElements.AMOUNT_BAR),
            //Select Country
            Click.on(PaymentPageElements.COUNTRY_BUTTON),
            //Send Payment
            Click.on(PaymentPageElements.SENDPAYMENT_BUTTON),
            //Approve the payment
            WaitUntil.the(PaymentPageElements.POPUPOK_BUTTON, WebElementStateMatchers.isClickable()),
            Click.on(PaymentPageElements.POPUPOK_BUTTON)
        );
    }

    public static MakePayment makePayment(String name,String phone,String amount,String client){
        return instrumented(MakePayment.class, name,phone,amount,client);
    }
}
