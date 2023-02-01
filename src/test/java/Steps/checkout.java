package Steps;

import Base.BaseStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

public class checkout extends BaseStep {


    @And("I click on my cart icon")
    public void userClickOnMyCartIcon() throws InterruptedException {
        Thread.sleep(5000);
        findElement("//a[@id='cart-icon']",Pather.xPath).click();
    }

    @And("I click on check out cta")
    public void userClickOnCheckOutCTA() throws InterruptedException {
        Thread.sleep(2000);
        findElement("//div[@class='inner-wrap text-right']/a[text()='Checkout']",Pather.xPath).click();
    }

    @Then("I click on check out as guest cta")
    public void userClickOnCheckOutAsGuestCTA() throws InterruptedException {
        Thread.sleep(2000);
        findElement("//a[@id='checkout-as-guest']",Pather.xPath).click();
    }

    @And("I fill billing details")
    public void userFillBillingDetails() throws InterruptedException {
//        Thread.sleep(3000);
        findElement("//input[@type='email']",Pather.xPath).sendKeys("testuser@reece.com");
//        Thread.sleep(1000);
        findElement("//input[@id='billing-name-input']",Pather.xPath).sendKeys("Test User");
//        Thread.sleep(1000);
        findElement("//input[@id='billing-phone-input']",Pather.xPath).sendKeys("+61 3 7010 4321");
//        Thread.sleep(1000);
        findElement("//input[@id='billing-address-input']",Pather.xPath).sendKeys("1223");
//        Thread.sleep(1000);
        findElement("//input[@id='billing-postcode-input']",Pather.xPath).sendKeys("3204");
//        Thread.sleep(1000);
        findElement("//input[@name='holderName']",Pather.xPath).sendKeys("Test");
//        Thread.sleep(1000);
        findElement("//div[@id='billing-postcode-input-items']/div[1]",Pather.xPath).click();
        Thread.sleep(2000);
        findElement("//input[@name='holderName']",Pather.xPath).sendKeys("Test");
//        Thread.sleep(1000);
        sitchToFrame("//iframe[@title='Iframe for secured card number']",Pather.xPath);
        findElement("//input[@placeholder='Enter card number']",Pather.xPath).sendKeys("4293 1891 0000 0008");
        sitchToMainWindow();
//        Thread.sleep(1000);
        sitchToFrame("//iframe[@title='Iframe for secured card expiry date']",Pather.xPath);
        findElement("//input[@aria-label='Expiry date']",Pather.xPath).sendKeys("03/30");
        sitchToMainWindow();
//        Thread.sleep(1000);
        sitchToFrame("//iframe[@title='Iframe for secured card security code']",Pather.xPath);
        findElement("//input[@aria-label='Security code']",Pather.xPath).sendKeys("737");
        sitchToMainWindow();
    }

    @And ("I click on place order cta")
    public void userClickOnPleaceOrderCTA() throws InterruptedException {
//        Thread.sleep(2000);
        findElement("//button[@id='place-order']",Pather.xPath).click();
        Thread.sleep(20000);
    }
}
