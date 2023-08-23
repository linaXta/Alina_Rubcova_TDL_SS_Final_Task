package pages;

import pages.objects.Button;
import pages.objects.TextField;

import java.io.File;
import java.lang.reflect.Field;

public class DialogBoxesPage {
    public Button createUserButton = new Button("Create new user", "id=create-user");

    public TextField name = new TextField("Name", "id=name", "");
    public TextField email = new TextField("Email", "id=email", "");
    public TextField password = new TextField("Password", "id=password", "");
    public boolean isInitialized()
    {
        return createUserButton.isButtonPresent();
    }


    public void createNewUser(String name, String email, String password){
        this.name.clearField();
        this.email.clearField();
        this.password.clearField();
        this.name = name;
        this.email = email;
        this.password = password;

    }

}
