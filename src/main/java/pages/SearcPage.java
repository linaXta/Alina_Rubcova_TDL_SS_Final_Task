package pages;

import pages.objects.TextField;

public class SearcPage {
    public TextField searchField = new TextField("Search", "xpath=//*[@id='search']", "testValue");

    public void searchForValue() {
        searchField.click();
        searchField.enterTextValue("and");
    }
}
