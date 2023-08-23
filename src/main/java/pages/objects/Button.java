package pages.objects;

import org.openqa.selenium.WebElement;

public class Button extends BasePageObject {
    public Button(String name, String locator) {
        super(name, locator);
    }
    public void click(){
        WebElement button = getWebElement(getLocator());
        button.click();
        System.out.println("Button '" + getName() + "' was clicked");
    }

    public boolean isButtonPresent(){
        WebElement button = getWebElement(getLocator());
        return button.isDisplayed();
    }
}
