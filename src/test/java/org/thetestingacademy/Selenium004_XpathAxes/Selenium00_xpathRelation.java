package org.thetestingacademy.Selenium004_XpathAxes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Selenium00_xpathRelation {

    @Test
    public void realtionOfXpath(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/xpath/");


        //start with   end with
        //div[@class="Mammal"]/following-sibling::div
        //div[@class="Mammal"]//following-sibling::div

        //div[@class="Mammal"]//descendant::div

        //div[@class="Mammal"]/parent::div
        //div[@class="Mammal"]//parent::div

        //div[@class="Mammal"]//preceding-sibling::div
        //div[@class="Mammal"]/preceding-sibling::div

        //div[@class="Mammal"]/child::div
        //div[@class="Mammal"]//child::div

        //div[@class="Mammal"]/ancestor::div
        //div[@class="Mammal"]//ancestor::div

        //div[@class="Mammal"]/following::div
        //div[@class="Mammal"]//following::div

        //div[@class="Mammal"]/preceding::div
        //div[@class="Mammal"]//preceding::div

        //div[@class="Mammal"]/self::div
        //div[@class="Mammal"]//self::div



        //siblinng-the put--then child mix up like


    //https://awesomeqa.com/hr/web/index.php/pim/viewEmployeeList
        // (//div[@class="oxd-table-card"]/div[@role="row"])[2]
        // //div[@class="oxd-table-card"]/div[@role="row"][2]
    }
}
