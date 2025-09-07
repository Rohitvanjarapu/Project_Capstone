package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.LoginPage;
import pages.SortingPage;
import utils.DriverFactory;

import java.util.List;
import java.util.stream.Collectors;

public class SortingTest {
    WebDriver driver;
    LoginPage loginPage;
    SortingPage sortingPage;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.initDriver("chrome");
        loginPage = new LoginPage(driver);
        sortingPage = new SortingPage(driver);

        // login
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
    }

    @Test
    public void testSortAZ() {
        System.out.println("🔹 Running testSortAZ...");
        sortingPage.selectSortOption("Name (A to Z)");

        List<String> names = sortingPage.getProductNames();
        System.out.println("Names after A→Z sort: " + names);

        List<String> sorted = names.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(names, sorted, "❌ Products are not sorted A to Z");
        System.out.println("✅ testSortAZ PASSED");
    }

    @Test
    public void testSortZA() {
        System.out.println("🔹 Running testSortZA...");
        sortingPage.selectSortOption("Name (Z to A)");

        List<String> names = sortingPage.getProductNames();
        System.out.println("Names after Z→A sort: " + names);

        List<String> sorted = names.stream().sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList());
        Assert.assertEquals(names, sorted, "❌ Products are not sorted Z to A");
        System.out.println("✅ testSortZA PASSED");
    }

    @Test
    public void testSortLowToHigh() {
        System.out.println("🔹 Running testSortLowToHigh...");
        sortingPage.selectSortOption("Price (low to high)");

        List<Double> prices = sortingPage.getProductPrices();
        System.out.println("Prices after Low→High sort: " + prices);

        List<Double> sorted = prices.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(prices, sorted, "❌ Products are not sorted Low to High");
        System.out.println("✅ testSortLowToHigh PASSED");
    }

    @Test
    public void testSortHighToLow() {
        System.out.println("🔹 Running testSortHighToLow...");
        sortingPage.selectSortOption("Price (high to low)");

        List<Double> prices = sortingPage.getProductPrices();
        System.out.println("Prices after High→Low sort: " + prices);

        List<Double> sorted = prices.stream().sorted((a, b) -> Double.compare(b, a)).collect(Collectors.toList());
        Assert.assertEquals(prices, sorted, "❌ Products are not sorted High to Low");
        System.out.println("✅ testSortHighToLow PASSED");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        DriverFactory.quitDriver();
    }
}
