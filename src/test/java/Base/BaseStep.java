package Base;


import Steps.Hooks;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BaseStep {

    protected BaseStep(){
    }

    public enum Pather {
        id,
        className,
        name,
        xPath,
        cssSelector,
        linkText
    }

    public enum TimeOut {
        LOW(5),
        MIDDLE(10),
        HIGH(15),
        CUSTOM_MAX(60);
        private final int value;

        public int getValue() {
            return value;
        }

        // enum constructor - cannot be public or protected
        private TimeOut(int value) {
            this.value = value;
        }

    }
    public void geturl()
    {
        Hooks.driver.get("http://www.reece.com.au");
    }

    public void waitElement(WebElement element, TimeOut timeOut) {

        try {
            WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(timeOut.value));
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception ex) {

        }

    }

    public WebElement findElement(String path, Pather type) {

        try {
            WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(TimeOut.MIDDLE.value));
            WebElement element = null;
            switch (type) {
                case className:
                    element = wait.until(ExpectedConditions.presenceOfElementLocated(By.className(path)));
                    break;
                case id:
                    element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(path)));
                    break;
                case name:
                    element = wait.until(ExpectedConditions.presenceOfElementLocated(By.name(path)));
                    break;
                case xPath:
                    element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
                    break;
                case cssSelector:
                    element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(path)));
                    break;
                case linkText:
                    element = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(path)));
                    break;
                default:
                    throw new NotFoundException();
            }
            return element;
        } catch (Exception ex) {
            System.out.println("find element method error" + ex.getMessage());
            return null;
        }
    }


    }
