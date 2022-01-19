package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import ui.LoginPageElements;

public class LoginPage implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return LoginPageElements.LOGIN_BTN.resolveFor(actor).isVisible();
    }

    public static LoginPage isVisible() {
        return new LoginPage();
    }
}
