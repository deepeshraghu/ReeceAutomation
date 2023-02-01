package Steps.Product_Details_Page;

import Base.BaseStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class product_details_page_show_price extends BaseStep {

    @Then("I should see the CMP price")
    public void userVerifyCMPPrice(){
        Assert.assertTrue(findElement("//span[text()='inc. gst']",Pather.xPath).getText().contains("inc"));
    }
    @And("click on Add to cart button")
    public void userClickOnAddToCart() throws InterruptedException {
        Thread.sleep(2000);
        findElement("//span[text()='Add']",Pather.xPath).click();
    }
    @Then ("I should see the {string} product in the cart")
    public void userVerifyProductInCart(String product_Id) throws InterruptedException {
        findElement("//div[@id='cart-count-holder']",Pather.xPath).click();
        Thread.sleep(5000);
        Assert.assertTrue(findElement("//span[@class='product-code ng-binding']",Pather.xPath).getText().contains(product_Id));
    }

    @And ("I set the postcode to {string} on pdp page")
    public void userSetPostalCode(String code) throws InterruptedException{
        Thread.sleep(2000);
        findElement("//a[text()='Enter your postcode to see pricing']",Pather.xPath).click();
        findElement("//input[@name='customerpostcode']",Pather.xPath).sendKeys(code);
        findElement("//button[text()='Set As My Location']",Pather.xPath).click();
        Thread.sleep(3000);
    }

}
