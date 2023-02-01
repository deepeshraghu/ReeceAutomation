package Steps;

import Base.BaseStep;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class product_search_retail extends BaseStep {

    @When("I click on the {string} product id in the search results")
    public void userClickOnProduct(String product_code){
        findElement("//p[contains(text(),'"+product_code+"')]//preceding-sibling::a", BaseStep.Pather.xPath).click();
    }

    @Then("I should not see the ADD button on the product details page")
    public void userVerifyAddToCartCTA(){
        Assert.assertNotEquals(findElement("//a[text()='Shop in ']",Pather.xPath).getText(),"ADD");
    }
}
