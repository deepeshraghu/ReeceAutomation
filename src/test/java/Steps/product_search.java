package Steps;

import Base.BaseStep;
import Runner.Runner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import java.util.Optional;

import static org.junit.Assert.assertFalse;


public class product_search extends BaseStep {
    

    public product_search() {
        super();
    }

    @Given("^I am on the home page$")
    public void userlaunchSite() {
        geturl();
    }

    @And("I search for product {string} as retail user")
    public void userSearchProduct(String product_name) {
        findElement("//input[@id='search-input']",Pather.xPath).clear();
        findElement("//input[@id='search-input']",Pather.xPath).sendKeys(product_name);
        findElement("//button[text()='Search']",Pather.xPath).click();
    }

    @Then("I should not see price details")
    public void verifyPriceDetails() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Text is :"+findElement("//div[@data-search-result-position-index='1']//a[@class='postcode-link']",Pather.xPath).getText());
        Assert.assertTrue(findElement("//div[@data-search-result-position-index='1']//a[@class='postcode-link']",Pather.xPath).getText().contains("postcode"));
    }

    @When("^I set the postcode to \"([^\"]*)\"$")
    public void userSetPostalCode(String code) throws InterruptedException {
        Thread.sleep(2000);
        findElement("//div[contains(text(),'Your location:')]",Pather.xPath).click();
        findElement("//input[@class='popup-postcode__input']",Pather.xPath).sendKeys(code);
        findElement("//button[@class='popup-postcode__button']",Pather.xPath).click();
        Thread.sleep(3000);
    }

    @Then("I should see description of product contains {string}")
    public void userVerifyProductDescription(String product_name) {
        Assert.assertTrue(findElement("//div[@data-search-result-position-index='1']//a[@class='product-tile__detail-name']",Pather.xPath).getText().contains(product_name));

    }

    @And("^I should see list of product codes$")
    public void userVerifyProductCode() {
        Assert.assertTrue(findElement("//div[@data-search-result-position-index='1']//p[@class='product-tile__detail-code']",Pather.xPath).getText().contains("Product Code"));
    }

    @And("^I should see list of CMP gst inc prices$")
    public void userVerifySMPPrice() throws InterruptedException {
        Assert.assertTrue(findElement("//div[@data-search-result-position-index='1']//div[@class='product-tile__price product-tile__price--cmp']//span[@class='product-tile__price-suffx']",Pather.xPath).getText().contains("inc.gst"));
    }

    @And("^I should see gst inc note$")
    public void userVerifyGSTINC() {
        Assert.assertTrue(findElement("//div[@data-search-result-position-index='1']//div[@class='product-tile__price product-tile__price--cmp']//span[@class='product-tile__price-suffx']",Pather.xPath).getText().contains("inc"));
    }

    @Then("I should see that the ADD button is \"([^\"]*)\"$")
    public void userVerifyAddToCartButton(Boolean value) throws InterruptedException {
        WebElement element = findElement("//div[@data-search-result-position-index='1']//span[@class='add-to-cart-component__action-btn-text']//parent::button", Pather.xPath);
        if (value) {Thread.sleep(3000);
            Assert.assertTrue(element.isEnabled());
        }
        else {
            Thread.sleep(3000);
            assertFalse(element.isEnabled());
        }
    }

    @And("^I should see the add to Wishlist button$")
    public void userVerifyWhiteListButton() {
        Assert.assertTrue(findElement("//div[@data-search-result-position-index='1']//span[@class='product-tile__wishlist-text']",Pather.xPath).isDisplayed());
    }

    @When ("I click on ADD button")
    public void userClickOnAddCartCTA() throws InterruptedException {
        Thread.sleep(5000);
        findElement("//div[@data-search-result-position-index='1']//add-to-cart[@class='add-to-cart-component']",Pather.xPath).click();
    }

    @When  ("I click the shop in max button for a product as a retail user")
    public void userClickOnShopInMaxCTA(){
        findElement("//span[text()='Shop in maX']",Pather.xPath).click();

    }

    @And ("I should see that the button name is {string}")
    public void userVerifyShopInMaxCTA(String value){
        Assert.assertTrue(findElement("//span[text()='"+value+"']",Pather.xPath).isDisplayed());
    }
    @When("^I click Add to wishlist button$")
    public void userWhiteListProduct() {
        findElement("//div[@data-search-result-position-index='1']//span[@class='product-tile__wishlist-text']",Pather.xPath).click();
    }

    @Then("the count for wishlist item is added by 1")
    public void userVerifyWhiteListCount() {
        Assert.assertEquals(findElement("//div[@id='retail-wishlist-count-holder']",Pather.xPath).getText(),"1");
    }

    @Then("the count for the My Cart is added by 1")
    public void userVerifyMyCartCount() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals(findElement("//div[@id='cart-count-holder']",Pather.xPath).getText(),"1");
    }

    @When("I navigate to {string}")
    public void userNavigateToLink(String value) throws InterruptedException {

        String[] words=value.split("[,]", 0);
        for(int i=0;i<words.length;i++){
            System.out.println(i);
            if(i!=1) {
                findElement("//a[text()='" + words[i] + "']", Pather.xPath).click();
            }
            else{
                findElement("//li[@class='page-nav-level-1__li--type-1 active']/a[text()='"+words[i]+"']", Pather.xPath).click();
            }
        }
        Thread.sleep(5000);
    }

    @Then("I should see that the selected view is {string} view")
    public void userVerifyView(String type) throws InterruptedException {
        Thread.sleep(3000);
        if (type.contains("grid")) {
            String actualColor = Color.fromString(findElement("//button[@id='v-btn--grid']", Pather.xPath).getCssValue("color")).asHex();
            Assert.assertEquals(actualColor,"#003767");
        }
        else {
            String actualColor = Color.fromString(findElement("//button[@id='v-btn--list']", Pather.xPath).getCssValue("color")).asHex();
           Assert.assertEquals(actualColor,"#003767");
        }
    }

    @When("I click on {string} on sort view options")
    public void userClickOnMostReleventLink(String value) throws InterruptedException {
        Thread.sleep(3000);
        String beforeValue = findElement("//div[@data-search-result-position-index='1']//p[@class='product-tile__detail-code']",Pather.xPath).getText();
        findElement("//ul[@class='view-menu__root view-menu__root--lv-0']/descendant::a[contains(text(),'Sort by')]",Pather.xPath).click();
        findElement("//div[@data-mobile-sub-menu-type='SORT_BY']/descendant::span[contains(text(),'"+value+"')]",Pather.xPath).click();
        String afterValue = findElement("//div[@data-search-result-position-index='1']//p[@class='product-tile__detail-code']",Pather.xPath).getText();
       Assert.assertNotEquals(beforeValue,afterValue);
    }

    @When("I clicks on {string} category")
    public void userClickOnSeperateCategory(String value) {
        findElement("//span[text()='Categories']//following::span[contains(text(),'"+value+"')]", Pather.xPath).click();
        Assert.assertTrue(findElement("//ul[@class='breadcrumbs plp-breadcrumbs']",Pather.xPath).getText().contains("Set"));
    }

    @When("I click on {string} category")
    public void userClickOnCategories(String value) throws InterruptedException {
        findElement("//span[text()='Categories']//following::span[contains(text(),'"+value+"')]", Pather.xPath).click();
        Thread.sleep(2000);
        Assert.assertTrue(findElement("//ul[@class='breadcrumbs plp-breadcrumbs']",Pather.xPath).getText().contains(value));
    }

    @When ("I click on Brand {string}")
    public void userClickOnBrandMilli(String value) throws InterruptedException {
        Thread.sleep(2000);
        findElement("//ul[@data-parent-filter='Brand']/descendant::span[contains(text(),'"+value+"')]", Pather.xPath).click();
        String description = findElement("//div[@data-search-result-position-index='1']//a[@class='product-tile__detail-name']",Pather.xPath).getText();
        Assert.assertTrue(description.contains(value));
    }

    @When ("I click on {int} on page list control")
    public void userClickOnCountDetails(int value){
        String[] arr_1 = findElement("//h1[@class='cat-banner__title']/following-sibling::span",Pather.xPath).getText().split(" ");
        String str1 = arr_1[0];
        double count = Double.parseDouble(str1);
        double result = count / value;
        findElement("//label[@for='page-"+value+"']", Pather.xPath).click();
        String[] arr_2 = findElement("//select[@class='product-listing__pagination-control--page']/option[1]",Pather.xPath).getText().split(" ");
        String pages = arr_2[arr_2.length-1];
        double epsilon = 0.000001d;
        Assert.assertEquals(Double.parseDouble(pages), Math.ceil(result),epsilon);
    }

    @And  ("I click on next icon on pagination")
    public void userClickOnNextPagination(){
        findElement("//a[@class='product-listing__pagination-control--next']", Pather.xPath).click();
    }

    @When ("I click on list view icon")
    public void userSelectListView(){
        findElement("//button[@id='v-btn--list']", Pather.xPath).click();
    }

    @And ("I click Clear link on {string} filter")
    public void userClearBrandFilter(String value){
        findElement("//ul[@class='view-menu__root--lv-1 product-listing-filters__base']/li[@data-filter-type='"+value+"']/span/a", Pather.xPath).click();
    }

    @When ("I click on {int} option on pagination dropdown")
    public void userClickOnPaginationDropDown(int number){
        String beforeValue = findElement("//div[@data-search-result-position-index='1']//p[@class='product-tile__detail-code']",Pather.xPath).getText();
        findElement("//select[@class='product-listing__pagination-control--page']/option[1]",Pather.xPath).click();
        findElement("//select[@class='product-listing__pagination-control--page']/option["+number+"]",Pather.xPath).click();
        String afterValue = findElement("//div[@data-search-result-position-index='1']//p[@class='product-tile__detail-code']",Pather.xPath).getText();
        Assert.assertNotEquals(beforeValue,afterValue);
    }

    @Then ("I should be redirected to the login page")
    public void userVerifyLogInPage(){
        Assert.assertTrue(findElement("//main[@class='_widget login']//h1[text()='Welcome']",Pather.xPath).getText().contains("Welcome"));
    }

    @When ("I login to with {string} and {string}")
    public void userLogInToReece(String username, String password){
        findElement("//main[@class='_widget login']//input[@id='username']",Pather.xPath).sendKeys(username);
        findElement("//main[@class='_widget login']//input[@id='password']",Pather.xPath).sendKeys(password);
        findElement("//main[@class='_widget login']//button[@type='submit']",Pather.xPath).click();
    }

    @Given ("I login to my account with {string} and {string}")
    public void userLogInToReeceAccount(String username, String password){
        geturl();
        findElement("//li[@class='header-top-right-nav__li']//a[text()='Login']",Pather.xPath).click();
        findElement("//main[@class='_widget login']//input[@id='username']",Pather.xPath).sendKeys(username);
        findElement("//main[@class='_widget login']//input[@id='password']",Pather.xPath).sendKeys(password);
        findElement("//main[@class='_widget login']//button[@type='submit']",Pather.xPath).click();
    }

    @Then ("I am forwarded to product details page of {string} product")
    public void userVerifyProductOnDescriptionPage(String product_code){
        Assert.assertTrue(findElement("//p[@class='pdp-main-block__product-code']",Pather.xPath).getText().contains(product_code));
    }

    @And ("I click Add to cart button on product details page")
    public void userClickOnAddToCart(){
        findElement("//span[text()='Add']",Pather.xPath).click();
    }

    @And  ("I logout")
    public void userClickOnLogOutCTA(){
        findElement("//li[@id='link-account-1-desktop']/a",Pather.xPath).click();
        findElement("//li[@id='link-account-1-desktop']/div/a[text()='Logout']",Pather.xPath).click();
    }

}
