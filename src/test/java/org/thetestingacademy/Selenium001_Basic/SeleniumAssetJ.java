package org.thetestingacademy.Selenium001_Basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.assertj.core.api.Assertions.*;



public class SeleniumAssetJ {

    public static void main(String[] args) {

        //https://assertj.github.io/doc/

        WebDriver driver = new EdgeDriver();

        driver.get("https://vwo.com/");
        driver.getTitle();

        // Assert.assertEquals(driver.getCurrentUrl(),"https://vwo.com/" );
        //Assert.assertEquals(driver.getTitle(),"VWO | Digital Experience Optimization" );

        assertThat(driver.getTitle())
                .isNotBlank()
                .isNotEmpty()
                .isNotNull();

        driver.quit();
    }
}
