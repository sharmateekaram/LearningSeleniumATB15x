package org.thetestingacademy.Selenium001_Basic;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumAnnotations {

    //https://testng.org/

    @Test
    public void test_Selenium_o1(){
        WebDriver driver = new EdgeDriver();

        driver.get("https://vwo.com/");
        driver.getTitle();

       // Assert.assertEquals(driver.getCurrentUrl(),"https://vwo.com/" );
        Assert.assertEquals(driver.getTitle(),"VWO | Digital Experience Optimization" );


        driver.quit();

    }
}
