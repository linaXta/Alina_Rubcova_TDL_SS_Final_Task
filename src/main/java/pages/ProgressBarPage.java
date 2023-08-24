package pages;

import pages.objects.Button;

public class ProgressBarPage {
    public Button randomProgressBarrButton = new Button("Random ProgressBar", "xpath=//*[@id='Random Progress Bar']");
    public Button randomColorButton = new Button( "Random color", "xpath=//*[@id='colorButton']");

    public boolean isInitialized()
    {
        return randomProgressBarrButton.isButtonPresent();
    }
}
