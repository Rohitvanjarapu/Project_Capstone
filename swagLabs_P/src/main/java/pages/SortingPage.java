package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.stream.Collectors;

public class SortingPage {
    WebDriver driver;

    By sortDropdown = By.className("product_sort_container");
    By productNames = By.className("inventory_item_name");
    By productPrices = By.className("inventory_item_price");

    public SortingPage(WebDriver driver) {
        this.driver = driver;
    }

    // ✅ Use Select for dropdown
    public void selectSortOption(String option) {
        WebElement dropdown = driver.findElement(sortDropdown);
        Select select = new Select(dropdown);
        select.selectByVisibleText(option);
    }

    public List<String> getProductNames() {
        List<WebElement> items = driver.findElements(productNames);
        return items.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<Double> getProductPrices() {
        List<WebElement> prices = driver.findElements(productPrices);
        return prices.stream()
                .map(e -> Double.parseDouble(e.getText().replace("$", "")))
                .collect(Collectors.toList());
    }
}
