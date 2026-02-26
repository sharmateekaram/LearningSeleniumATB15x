package org.thetestingacademy.Selenium001_Basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumNewTabWindow {

    public static void main(String[] args) throws InterruptedException {
        // Set up the driver (make sure the driver executable is in your system's PATH)
        WebDriver driver = new ChromeDriver();

        try {
            // 1. Open the initial URL in the first tab
            driver.get("https://www.selenium.dev/");

            System.out.println("First tab title: " + driver.getTitle());
            Thread.sleep(2000);

            // Store the handle of the original window/tab
            String originalWindowHandle = driver.getWindowHandle();

            // 2. Open a new tab and automatically switch to it
            // The newWindow method handles both creation and switching
            driver.switchTo().newWindow(WindowType.TAB);

            // 3. Navigate to a new URL in the second tab
            driver.get("https://opensource.saucelabs.com/");
            System.out.println("Second tab title: " + driver.getTitle());

            // 4. (Optional) Switch back to the original tab
            driver.switchTo().window(originalWindowHandle);
            System.out.println("Switched back to first tab title: " + driver.getTitle());
            Thread.sleep(2000);

        } finally {
            // Close all tabs/windows when done
            driver.quit();
        }
    }
}


