package pages;

import pages.objects.Button;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProgressBarPage {
    public Button randomProgressBarrButton = new Button("Random ProgressBar", "xpath=//*[@id='Random Progress Bar']");
    public Button randomColorButton = new Button( "Random color", "xpath=//*[@id='colorButton']");
    public Button randomValueButton = new Button("Random Value - Determinate", "xpath=//*[@id='numButton']");

    public boolean isInitialized()
    {
        return randomProgressBarrButton.isButtonPresent();
    }

    public String extractRgbValueFromStyle(String style) {
        String rgbPattern = "background: rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)";
        Pattern pattern = Pattern.compile(rgbPattern);
        Matcher matcher = pattern.matcher(style);

        if (matcher.find()) {
            return "rgb(" + matcher.group(1) + ", " + matcher.group(2) + ", " + matcher.group(3) + ")";
        }
        return "RGB value not found";
    }

}
