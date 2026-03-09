package org.thetestingacademy.Selenium_Task;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.thetestingacademy.CommonToAll;

import java.time.Duration;

public class SeleniumTask6_9Mar_BookingCom extends CommonToAll {


    @Test
    public void bookingCom(){

        WebDriver driver = new ChromeDriver();
        String url = "https://www.booking.com/";
        openBrowser(driver, url);

        //close sign or register popup
        waitForVisibility(driver,"//span[text()='Sign in or register']" );
        String closeSignIn_PopupXpath = "//button[@aria-label='Dismiss sign-in info.']//*[local-name()='svg']";
        waitForVisibilityandClick(driver, 5,closeSignIn_PopupXpath );

        //click on flight tab
        String flightTab_Xpath = "//a[@id='flights']";
        waitForVisibility(driver, 5, flightTab_Xpath);
        //clickElementFound(flightTab_Xpath);
        WebElement element = driver.findElement(By.xpath(flightTab_Xpath));
        element.click();


        //waitForVisibility(driver, 10, "//input[@id='search_type_option_ROUNDTRIP']");
        WebElement destination = driver.findElement(By.xpath("//button[@data-ui-name='input_location_to_segment_0']"));
        destination.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement cityNameTextBox = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//input[@data-ui-name='input_text_autocomplete']")
                )
        );

       // WebElement cityNameTextBox = driver.findElement(By.xpath("//input[@data-ui-name='input_text_autocomplete']"));
       // WebElement checkbox =driver.findElement(By.xpath("//span/b[text()='BLR']/ancestor::ul//descendant::span[@class='InputCheckbox-module__field___5DCVC']"));
        Actions action = new Actions(driver);
        action
                .moveToElement(cityNameTextBox).sendKeys("BLR")
                .pause(Duration.ofSeconds(2))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .build().perform();

        clickElementFound("//button[@data-ui-name='button_search_submit']");
        waitForVisibility(driver, 10, "//h2[text()='Search summary']");


    }


}
