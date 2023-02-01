package Steps.Product_Details_Page;

import Base.BaseStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class product_details_page_show_price extends BaseStep {

    @Then("I should see the CMP price")
    public void userVerifyCMPPrice(){
        Assert.assertTrue(findElement("//span[text()='inc. gst']",Pather.xPath).getText().contains("inc.gst"));
    }
    @And("click on Add to cart button")
    public void userClickOnAddToCart(){
        findElement("//span[text()='Add']",Pather.xPath).click();
    }
    @Then ("I should see the {string} product in the cart")
    public void userVerifyProductInCart(String product_Id){

        findElement("//div[@id='cart-count-holder']",Pather.xPath).click();
        Assert.assertTrue(findElement("//span[@class='product-code ng-binding']",Pather.xPath).getText().contains(product_Id));
    }
}
