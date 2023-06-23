package starter.user;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class HomePage extends PageObject {
    private By Dashboard(){
        return By.xpath("//*[@id=\"root\"]");
    }
    @Step
    public void validateOnHomePage(){
         $(Dashboard()).isDisplayed();
    }
}
