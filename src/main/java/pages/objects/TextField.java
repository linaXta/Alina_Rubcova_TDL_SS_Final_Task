package pages.objects;

import org.openqa.selenium.WebElement;

public class TextField extends BasePageObject {
    private String testValue;

    public TextField(String name, String locator, String testValue) {
        super(name, locator);
        this.testValue = testValue;
    }

    public void enterTextValue(String text) {
        WebElement textField = getWebElement(getLocator());
        textField.sendKeys(text);
        System.out.println("Entered '" + text + "' into field " + getName());
    }

    public void clearField() {
        WebElement textField = getWebElement(getLocator());
        textField.clear();
    }

    public String getValue() {
        WebElement textField = getWebElement(getLocator());
        return textField.getAttribute("value");
    }
}
