package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.objects.Button;
import pages.objects.TextField;
import common.TestBase;

public class DialogBoxesPage {
    private TestBase testBase = new TestBase();
    public Button createUserButton = new Button("Create new user", "id=create-user");
    public Button createAnUserButton = new Button("Accept to create new user", "xpath=/html/body/div[3]/div[3]/div/button[1]");
    public  Button messageBoxButton = new Button("Mesage Box", "xpath=//*[@id='Message Box']");
    public Button okButton = new Button("Ok", "xpath=/html/body/div[2]/div[3]/div/button");
    public Button formTabButton = new Button("FORM", "xpath=//*[@id='Form']");

    public TextField name = new TextField("Name", "id=name", "Initial Name Value");
    public TextField email = new TextField("Email", "id=email", "Initial Email Value");
    public TextField password = new TextField("Password", "id=password", "Initial Password Value");

    public TextField nameValidate = new TextField("Created name","","xpath=/html/body/div[1]/table/tbody/tr[2]/td[1]");
    public TextField emailValidate = new TextField("Created email","","xpath=/html/body/div[1]/table/tbody/tr[2]/td[2]");
    public TextField passwordValidate = new TextField("Created password","","xpath=/html/body/div[1]/table/tbody/tr[2]/td[3]");

//    public void clickCreateUserButton() {
//        WebElement button = new WebDriverWait(driver, 10)
//                .until(ExpectedConditions.visibilityOfElementLocated(By.id("create-user")));
//        button.click();
//        System.out.println("Button 'Create new user' was clicked");//   }

    public boolean isInitialized() {
        return createUserButton.isButtonPresent();
    }

    public void createNewUser(String name, String email, String password) {
        this.name.clearField();
        this.name.enterTextValue(name);

        this.email.clearField();
        this.email.enterTextValue(email);

        this.password.clearField();
        this.password.enterTextValue(password);
    }

    public boolean isNewEntryVisible(String name, String email, String password) {
        String xpath = "//table[@id='asynchronous']//tr[contains(., '" + name + "') and contains(., '" + email + "') and contains(., '" + password + "')]";
        WebElement newEntry = testBase.getDriver().findElement(By.xpath(xpath));
        return newEntry.isDisplayed();
    }


    public boolean isMessageBoxVisible() {
        try {
            return getMessageBox().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private WebElement getMessageBox() {
        return testBase.getDriver().findElement(By.id("your-message-box-id"));
    }
}

