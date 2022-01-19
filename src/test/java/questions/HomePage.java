package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import ui.HomePageElements;

import static ui.HomePageElements.LOGOUT_BUTTON;

public class HomePage implements Question<Boolean> {

    @Subject("the home page is visible")


        @Override
        public Boolean answeredBy(Actor actor) {
            return LOGOUT_BUTTON.resolveFor(actor).isVisible();
        }

        public static HomePage isVisible() {
            return new HomePage();
        }

}
