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
    public void userVerifyAddToCartCTA() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println(findElement("//div[text()='Trade account only']",Pather.xPath).getText());
        Assert.assertNotEquals(findElement("//div[text()='Trade account only']",Pather.xPath).getText(),"ADD");
    }

}
