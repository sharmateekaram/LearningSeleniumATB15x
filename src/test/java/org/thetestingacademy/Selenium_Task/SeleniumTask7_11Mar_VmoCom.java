package org.thetestingacademy.Selenium_Task;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.thetestingacademy.CommonToAll;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

public class SeleniumTask7_11Mar_VmoCom extends CommonToAll {

    @Test
    public void vmoLogin(){

        String url = "https://app.vwo.com/#/login";
        WebDriver driver = new ChromeDriver();
        openBrowser(driver, url);

        String window_Parent_Id = driver.getWindowHandle();
      //  System.out.println(window_Parent_Id);

        WebElement freeTrial = driver.findElement(By.xpath("//span[text()='Start a FREE TRIAL']"));
        if (freeTrial.isDisplayed()){
            waitForVisibilityandClick(driver, 5,  "//span[text()='Start a FREE TRIAL']");
        } else if (driver.findElement(By.xpath("//span[text()='Start a FREE TRIAL']")).isDisplayed()) {
            waitForVisibilityandClick(driver, 5,  "//a[contains(@href, 'free-trial')]");
        }

        //waitForVisibilityandClick(driver, 5,  "//span[text()='Start a FREE TRIAL']");

        Set<String> window_Handles_Id = driver.getWindowHandles();
        for(String windowId : window_Handles_Id){
            //System.out.println(windowId);
            if (!windowId.equalsIgnoreCase(window_Parent_Id)){
                driver.switchTo().window(windowId);
                System.out.println(driver.getTitle());
            }
        }
        //enter business Id->click on Checkbox->click on button  Create a Free Trial Account
        Random random = new Random();
        int randomNumber = random.nextInt((100 - 1) + 1) + 1;

        String businessEmail= "Akash"+randomNumber+"@abc.com";
        driver.findElement(By.xpath("//input[@data-qa='page-su-step1-v1-email']")).sendKeys(businessEmail);
        waitForJVM(1000);
        driver.findElement(By.xpath("//input[contains(@id,'page-free-trial-step1-cu-gdpr-consent-checkbox')]")).click();
        driver.findElement(By.xpath("//button[@data-qa='page-su-submit' and text()='Create a Free Trial Account']")).click();
        waitForJVM(1000);

        //wait for next page Create Account to load and  enter details
            waitForVisibility(driver, 10,  "//button[text()='Create Account']");
            driver.findElement(By.xpath("//input[@id='page-v1-fname']")).sendKeys("Rohit");
            driver.findElement(By.xpath("//input[@id='page-v1-lname']")).sendKeys("Sharma");
            driver.findElement(By.xpath("//input[@id='page-v1-pnumber']")).sendKeys("081232 56789");
            driver.findElement(By.xpath("//button[text()='Create Account']")).click();

        //wait and click on cookies then on  skip & continue to app
            WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(20));
             WebDriverWait  waitLong = new WebDriverWait(driver, Duration.ofSeconds(80));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Curious how it works? Get a 1-on-1 demo']")));
            driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
            waitForJVM(1000);
            WebElement freeTrialThankYouLink = driver.findElement(By.xpath("//button[contains(text(),'continue to app') ]"));
            freeTrialThankYouLink.click();
             //button[@data-step='free-trial-thankyou']"


            // Fluent wait for error message
            Wait<WebDriver> waitFluent = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(40)) // Max wait time
                    .pollingEvery(Duration.ofSeconds(5)) // Check every 1 second
                    .ignoring(NoSuchElementException.class); // Ignore this exception


        //wait and click on Continue Setup
        WebElement errorMessage = waitLong.until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[text()='Continue account Setup' or text()='Set Up Your Account']")));
        String continueAccountSetupXpath  = "//h4[text()='Continue account Setup']";
        if(!driver.findElements(By.xpath(continueAccountSetupXpath)).isEmpty() && driver.findElement(By.xpath(continueAccountSetupXpath)).isDisplayed()){
            driver.findElement(By.xpath("//button[@vwo-async-click='vm.continueSetup()']")).click();

            WebElement setUpAccount = waitFluent.until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[text()='Set Up Your Account']")));
            driver.findElement(By.xpath("//h5[@data-qa='gavoliwovo' and text()='Choose a data centre']")).click();
        }


        //wait for Set Up Your Account page  and click on SAve button under
        waitFluent.until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[text()='Set Up Your Account']")));
        WebElement saveButton = waitFluent.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-qa='boxasuraza']")));
        saveButton.click();

        //wait for VWO Insights - Web  and click startFreeTrail
        WebElement startFreeTrail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(.,'Start free trial')])[2]")));
        //  (//div[@data-qa='fupalawuwa'])[2]
        startFreeTrail.click();

        //wait for Add Trial under Connect Your First Website
        WebElement addTrial = waitLong.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Add domain ']")));
        addTrial.click();

        //wait for //h5[text()='Steps to install HTML SmartCode']
        waitLong.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Steps to install HTML SmartCode']")));
        WebElement copyLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-qa='xugejexijo']")));
        copyLink.click();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));

        Actions actions = new Actions(driver);
        actions.click(searchBox)
                .keyDown(Keys.CONTROL)
                .sendKeys("v")
                .keyUp(Keys.CONTROL)
                .perform();

        String pastedText = searchBox.getAttribute("value");
        Assert.assertTrue(pastedText.length() > 0);




        //button[@class='btn btn--primary ng-binding ng-scope']






        //sendKeysInEle("//input[@data-qa='page-su-step1-v1-email']", "Akash@abc.com");
        //clickElementFound("//input[contains(@id,'page-free-trial-step1-cu-gdpr-consent-checkbox')]");\
        //clickElementFound("//button[@data-qa='page-su-submit' and text()='Create a Free Trial Account']");


        //sendKeysInEle("//input[@id='page-v1-fname']", "Rohit");
        //sendKeysInEle("//input[@id='page-v1-lname']", "Sharma");
        //sendKeysInEle("//input[@id='page-v1-pnumber']", "081234 56789");
        //clickElementFound("//button[text()='Create Account']");

        //waitForVisibilityandClick(driver,10, "//button[@data-step='free-trial-thankyou']");
        //waitForVisibilityandClick(driver, 10 ,  "//button[@vwo-async-click='vm.continueSetup()']");
        //waitForVisibilityandClick(driver, 10 ,  "//h5[@data-qa='gavoliwovo' and text()='Choose a data centre']");
       // waitForVisibility(driver, 5,  "//button[@data-qa='boxasuraza']");








        //driver.switchTo().window(window_Parent_Id);







    }




}
