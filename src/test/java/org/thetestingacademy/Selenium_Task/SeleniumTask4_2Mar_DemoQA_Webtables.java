package org.thetestingacademy.Selenium_Task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SeleniumTask4_2Mar_DemoQA_Webtables {


    @Test
    public void DemoQA_LegalDepartment() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/webtables");

        //Details of  users
        String[][] usersDetails = {
                {"Indian", "BCCI", "33", "BCCI@example.com", "13000", "Legal Department"},
                {"Rohit", "sharma", "31", "Rohit@example.com", "11000", "Captain"},
                {"Virat", "Kohli", "32", "Virat@example.com", "12000", "Batter"},
                {"Jasprit", "Bumrah", "34", "Jasprit@example.com", "14000", "Bowler"},
                {"Rishab", "Pant", "35", "Rishabh@example.com", "15000", "WicketKeeper"},
        };

        String xpathTillTable = "//table[@class='-striped -highlight table table-striped table-bordered table-hover']";
        //delete 1 row so that Legal notice can add on row 3
        driver.findElement(By.xpath(xpathTillTable+"//tbody/tr[1]/td[6]/following-sibling::td[1]//span[@title='Delete']")).click();
        Thread.sleep(2000);



        //click on add->enter user details->click on submit
        for(String[] user : usersDetails){
            driver.findElement(By.xpath("//button[@id='addNewRecordButton']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(user[0]);
            driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(user[1]);
            driver.findElement(By.xpath("//input[@id='age']")).sendKeys(user[2]);
            driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(user[3]);
            driver.findElement(By.xpath("//input[@id='salary']")).sendKeys(user[4]);
            driver.findElement(By.xpath("//input[@id='department']")).sendKeys(user[5]);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//button[@id='submit']")).click();
            Thread.sleep(1000);
        }


        int rowCount = driver.findElements(By.xpath(xpathTillTable+"//tbody/tr")).size();

        int colCount = driver.findElements(By.xpath(xpathTillTable+"//thead/tr/th")).size();

        //Get col num of Department header column
        String first_part = xpathTillTable+"//thead/tr/th[";
        String second_part ="]";
        int empDepartment_ColNum = Integer.MIN_VALUE;
        for(int colNum = 1; colNum <= colCount; colNum++){
            String dynamic_xpath = first_part + colNum + second_part;
            String actualColName = driver.findElement(By.xpath(dynamic_xpath)).getText();
            if (actualColName.equalsIgnoreCase("Department")){
                empDepartment_ColNum  = colNum;
                System.out.println("Department header column number is : "+ empDepartment_ColNum );
                break;
            }else if(colNum == colCount){
                System.out.println("Department header column number is NOT FOUND.");
                Assert.fail("Department header column number is NOT FOUND.");
            }
        }


        //Find the  row number ->get Emp ID ->Match is Department = Legal Department->click on Delete Icon
        for(int rowNum = 1; rowNum < rowCount; rowNum++){
            String colText = driver.findElement(By.xpath(xpathTillTable+"//tbody/tr["+rowNum+"]/td["+empDepartment_ColNum+"]")).getText();
            if (colText.equals("Legal Department")){
                // get emp name who got Legal Department:
                String empFName_Before = driver.findElement(By.xpath(xpathTillTable+"//tbody/tr[" + rowNum+"]/td[1]")).getText();
                System.out.println("Emp Name before click on deletion : " + empFName_Before);

                driver.findElement(By.xpath(xpathTillTable+"//tbody/tr[" + rowNum +"]/td["+empDepartment_ColNum+"]/following-sibling::td[1]//span[@title='Delete']")).click();
                Thread.sleep(2000);

//
//                String empFName_After = driver.findElement(By.xpath(xpathTillTable+"//tbody/tr[" + rowNum+"]/td[1]")).getText();
//                System.out.println("Emp Name After click on deletion : " + empFName_After);
//                Assert.assertFalse(empFName_After.equals(empFName_Before), "Emp name is not showing");

                break;

            }
        }




    }


}
