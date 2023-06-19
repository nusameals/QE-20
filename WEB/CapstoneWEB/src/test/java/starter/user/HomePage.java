package starter.user;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class HomePage extends PageObject {
    private By title(){
        return By.xpath("//div[@class='v-toolbar__title']");
    }
    @Step
    public void validateOnHomePage(){
        $(title()).isDisplayed();
    }
}
