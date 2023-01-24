package Steps;

import Base.BaseStep;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class product_search_qty_validation extends BaseStep {

    @When("I change the value of the quantity field of the first product to {string} and enter")
    public void userEnterProductQuantity(String quantity){
        findElement("//input[@class='product-tile__qty-field product-tile__qty-field--js error']",Pather.xPath).clear();
        findElement("//input[@class='product-tile__qty-field product-tile__qty-field--js error']",Pather.xPath).sendKeys(quantity);
    }

    @Then("I should see an error message of {string} below the field")
    public void userVerifyErrorMessage(String error){
        Assert.assertEquals(findElement("//div[@class='product-tile__qty-error show-error']",Pather.xPath).getText(),error);
    }

}
