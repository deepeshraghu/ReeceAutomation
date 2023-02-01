package Steps;

import Base.BaseStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.Color;

public class product_search_qty_validation extends BaseStep {

    @When("^I change the value of the quantity field of the first product to \"([^\"]*)\" and enter$")
    public void userEnterProductQuantity(String quantity) throws InterruptedException {
        Thread.sleep(2000);
        findElement("//div[@data-search-result-position-index='1']//input",Pather.xPath).sendKeys(quantity);
        findElement("//div[@data-search-result-position-index='1']//input",Pather.xPath).sendKeys(Keys.RETURN);
    }

    @Then("I should see an error message of {string} below the field")
    public void userVerifyErrorMessage(String error){
        Assert.assertEquals(findElement("//div[@class='product-tile__qty-error show-error']",Pather.xPath).getText(),error);
    }

    @And("Add button is not clickable")
    public void userVerifyFieldColor() {
        String actualColor = Color.fromString(findElement("//div[@data-search-result-position-index='1']//span[@class='add-to-cart-component__action-btn-text']", Pather.xPath).getCssValue("color")).asHex();
        Assert.assertEquals(actualColor,"#101010");
    }

}
