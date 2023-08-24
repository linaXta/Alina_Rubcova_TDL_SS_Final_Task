package pages;

import pages.objects.Button;
import pages.objects.TextField;

public class DialogBoxesPage {
    public Button createUserButton = new Button("Create new user", "id=create-user");
    public  Button messageBoxButton = new Button("Mesage Box", "xpath=//*[@id='Message Box']");

    public TextField name = new TextField("Name", "id=name", "Initial Name Value");
    public TextField email = new TextField("Email", "id=email", "Initial Email Value");
    public TextField password = new TextField("Password", "id=password", "Initial Password Value");

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
}

