package Steps;

import Base.BaseStep;
import com.github.javafaker.Faker;
import com.microsoft.cognitiveservices.speech.*;
import com.microsoft.cognitiveservices.speech.audio.AudioConfig;
import com.microsoft.cognitiveservices.speech.audio.AudioProcessingOptions;
import com.microsoft.cognitiveservices.speech.speaker.SpeakerRecognizer;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.concurrent.ExecutionException;

public class Contact_Us_Form extends BaseStep {


    @Given("I fill contact service feedback form {int} times")
    public void userFillForm(int count) throws InterruptedException, ExecutionException {

        Faker faker = new Faker();
//        Launch contact form page
        Hooks.driver.get("https://www.reece.com.au/aboutus/contactus");

        for (int i=0;i<count;i++) {

//          Click on General Enquiries link
            findElement("//a[text()='General Enquiries']",Pather.xPath).click();
            Thread.sleep(2000);
//          Fill form details
            findElement("//input[@placeholder='First Name']", Pather.xPath).sendKeys("Test");
            findElement("//input[@placeholder='Surname']", Pather.xPath).sendKeys("Test");
            findElement("//input[@placeholder='Email']", Pather.xPath).sendKeys(faker.internet().safeEmailAddress());
            findElement("//input[@placeholder='Phone']", Pather.xPath).sendKeys("Test");
            findElement("//input[@name='Postcode']", Pather.xPath).sendKeys("3100");
            findElement("//textarea[@name='Comments']", Pather.xPath).sendKeys("Test");
            sitchToFrame("//iframe[@title='reCAPTCHA']",Pather.xPath);
            findElement("//div[@class='recaptcha-checkbox-border']", Pather.xPath).click();
            Hooks.driver.switchTo().defaultContent();
            sitchToFrame("//iframe[@title='recaptcha challenge expires in two minutes']",Pather.xPath);
            findElement("//button[@title='Get an audio challenge']",Pather.xPath).click();

//            AudioProcessingOptions audio = AudioProcessingOptions.create(1);
////            AudioConfig config = AudioConfig.fromDefaultMicrophoneInput(audio);
//            SpeechConfig config = SpeechConfig.fromSubscription("YourSubscriptionKey", "YourServiceRegion");
//            SpeechRecognizer recognizer = new SpeechRecognizer(config);
////            recognizer = new SpeakerRecognizer(config);
//            SpeechRecognitionResult result = recognizer.recognizeOnceAsync().get();
//
//            // Checks result.
//            if (result.getReason() == ResultReason.RecognizedSpeech) {
//                System.out.println("RECOGNIZED: Text=" + result.getText());
//            }
//            else if (result.getReason() == ResultReason.NoMatch) {
//                System.out.println("NOMATCH: Speech could not be recognized.");
//            }
//            else if (result.getReason() == ResultReason.Canceled) {
//                CancellationDetails cancellation = CancellationDetails.fromResult(result);
//                System.out.println("CANCELED: Reason=" + cancellation.getReason());
//
//                if (cancellation.getReason() == CancellationReason.Error) {
//                    System.out.println("CANCELED: ErrorCode=" + cancellation.getErrorCode());
//                    System.out.println("CANCELED: ErrorDetails=" + cancellation.getErrorDetails());
//                    System.out.println("CANCELED: Did you update the subscription info?");
//                }
//            }

//            result.close();
//          Click on Submit CTA
            findElement("//input[@value='Submit']",Pather.xPath).click();

//          Verify Thank you text on the page
            Assert.assertTrue(findElement("//div[@class='inner-wrapper']//div[@class='alert-complete'][3]//strong[contains(text(),'Thank you')]", Pather.xPath).isDisplayed());
        }
    }

}
