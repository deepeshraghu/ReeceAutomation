package Steps;

import Base.BaseStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class product_search_page_show_correct_cart_actions extends BaseStep {

    @And("^I search for product \"([^\"]*)\"$")
    public void userSearchProduct(String product_name) {
        findElement("//input[@id='search-input']",Pather.xPath).clear();
        findElement("//input[@id='search-input']",Pather.xPath).sendKeys(product_name);
        findElement("//button[text()='Search']",Pather.xPath).click();
    }

    @Then("I get the product search with no results")
    public void userVerifyNoSearchFound(){
        System.out.println(findElement("//h4[@class='search-no-res-msg__header']",Pather.xPath).getText());
        Assert.assertTrue(findElement("//h4[@class='search-no-res-msg__header']",Pather.xPath).getText().contains("No results found"));
    }
}
