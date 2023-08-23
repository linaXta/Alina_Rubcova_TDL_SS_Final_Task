package pages;

import pages.objects.Button;

public class HomePage {
    public Button dialogBoxButton = new Button("DialogBox", "xpath=//a[contains(text(), 'DialogBox')]");

    public boolean isInitialized()
    {
        return dialogBoxButton.isButtonPresent();
    }
}
