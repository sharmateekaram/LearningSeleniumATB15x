package org.thetestingacademy.Selenium_Task;

import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumTask3_2Mar_TerminatedEmp {

    @Owner("MrBhardwaj")
    @Test
    public  void  test_ORHM_Terminate() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");

        TimeUnit.SECONDS.sleep(2);

        WebElement input_UserName =  driver.findElement(By.xpath("//input[@name=\"username\"]"));
        WebElement input_Password =  driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement button_Login = driver.findElement(By.xpath("//button[normalize-space()= \"Login\"]"));
        //WebElement button_Login = driver.findElement(By.xpath("//button[(text()= ' Login ')]"));

        input_UserName.sendKeys("admin");
        input_Password.sendKeys("Hacker@4321");
        button_Login.click();

       TimeUnit.SECONDS.sleep(2);


        WebElement label_EmployeeInformation = driver.findElement(By.xpath("//h5[text()='Employee Information']"));
        Assert.assertEquals(label_EmployeeInformation.getText(),"Employee Information");

        //Way1:Direct click
        WebElement firstDeleteIcon = driver.findElement(By.xpath("(//div[text()='Terminated'])[1]/ancestor::div[contains(@class,'oxd-table-row')] //button[.//i[contains(@class,'bi-trash')]]"));
        firstDeleteIcon.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()=' No, Cancel ']")).click();
        Thread.sleep(1000);


        //Way 2: Travel  through table
        //Find the col num
        //Find the  row number ->get Emp ID ->Match is Employee Status = Terminated->click on Delete Icon->Click on Cancel on delete validation ->Rematch Emp id of same row

        int rowCount = driver.findElements(By.xpath("(//div[@class='oxd-table-card']/div[@role='row'])")).size();
        int colCount = driver.findElements(By.xpath("//div[@class='oxd-table-card'][1]/div[@role='row']/child::div")).size();

        //Get col num of Employment Status header column
        String first_part = "//div[@class='oxd-table-header']/descendant::div[@role='columnheader'][";
        String second_part ="]";
        int empStatus_ColNum = Integer.MIN_VALUE;
        for(int colNum = 1; colNum <= colCount; colNum++){
            String dynamic_xpath = first_part + colNum + second_part;
            String actualColName = driver.findElement(By.xpath(dynamic_xpath)).getText();
            if (actualColName.equalsIgnoreCase("Employment Status")){
                empStatus_ColNum  = colNum;
                System.out.println("Employment Status header column number is : "+ empStatus_ColNum );
               break;
            }else if(colNum == colCount){
                System.out.println("Employment Status header column number is NOT FOUND.");
                Assert.fail("Employment Status header column number is NOT FOUND.");
            }
        }


        //Find the  row number ->get Emp ID ->Match is Employee Status = Terminated->click on Delete Icon
        //Click on Cancel on delete validation ->Rematch Emp id of same row
        for(int rowNum = 1; rowNum < rowCount; rowNum++){
            String colText = driver.findElement(By.xpath("//div[@class='oxd-table-card']["+rowNum+"]/descendant::div[@role='cell']["+empStatus_ColNum+"]/div")).getText();
            if (colText.equals("Terminated")){
                // get the id of the emp who got terminated:
                String empID_Before = driver.findElement(By.xpath("//div[@class='oxd-table-card']["+rowNum+"]/descendant::div[@role='cell'][2]/div")).getText();
                System.out.println("Emp ID before click on deletion : " + empID_Before);

                driver.findElement(By.xpath("//div[@class='oxd-table-card']["+rowNum+"]/descendant::i[@class='oxd-icon bi-trash']")).click();
                Thread.sleep(2000);
                WebElement deletePopup = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--card-body']"));
                Assert.assertEquals(deletePopup.getText(), "The selected record will be permanently deleted. Are you sure you want to continue?");
                driver.findElement(By.xpath("//button[text()=' No, Cancel ']")).click();
                Thread.sleep(2000);

                String empID_After = driver.findElement(By.xpath("//div[@class='oxd-table-card']["+rowNum+"]/descendant::div[@role='cell'][2]/div")).getText();
                System.out.println("Emp ID After click on deletion : " + empID_After);
                Assert.assertEquals(Integer.valueOf(empID_Before), Integer.valueOf(empID_After));
                break;

            }
        }














        // for row //div[@class='oxd-table-card']
        //  for col //div[@class='oxd-table-header']/descendant::div[@role='columnheader']
        //div[@class='oxd-table-card'][1]/descendant::div[@role='cell']



        driver.quit();




    }

}
