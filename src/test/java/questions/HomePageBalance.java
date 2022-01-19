package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import ui.HomePageElements;

public class HomePageBalance implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return HomePageElements.TOTALBALANCE_TEXT.resolveFor(actor).getAttribute("content-desc");
    }

    public static HomePageBalance totalBalanceText(){
        return new HomePageBalance();
    }
}