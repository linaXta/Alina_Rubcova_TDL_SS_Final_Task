package pages;

import pages.objects.Button;

public class AddsPage {
    public Button addsCloseButton = new Button("Close", "xpath=//div[@aria-label='Close ad']");

    public void closeAdd(){
        addsCloseButton.click();
    }

    public boolean isInitialized(){
        return addsCloseButton.isButtonPresent();
    }
}
