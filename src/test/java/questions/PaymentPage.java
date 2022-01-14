package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import ui.HomePageElements;

import static ui.PaymentPageElements.SENDPAYMENT_BUTTON;

public class PaymentPage implements Question<Boolean> {

    @Subject("the payment page is visible")


    @Override
    public Boolean answeredBy(Actor actor) {
        return SENDPAYMENT_BUTTON.resolveFor(actor).isVisible();
    }

    public static PaymentPage isVisible() {
        return new PaymentPage();
    }

}
