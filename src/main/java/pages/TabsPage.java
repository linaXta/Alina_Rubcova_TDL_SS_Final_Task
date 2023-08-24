package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.objects.Button;

import javax.swing.*;

public class TabsPage {
    private WebDriver driver;
    public Button section2Button = new Button("Section 2", "xpath=//h3[text()='Section 2']");

    public String getSection2Text() {
        WebElement section2Element = driver.findElement(By.xpath("//h3[text()='Section 2']/following-sibling::p"));
        return section2Element.getText();
    }
}
