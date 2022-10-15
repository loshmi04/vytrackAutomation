package com.vytrack.tests;

import com.vytrack.tests.Base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class OronicTitleVerification extends TestBase {

    @Test
    public void oronicDocumentationPageVerification(){

        //Environment: https://qa2.vytrack.com/user/login

        driver.get("https://qa2.vytrack.com/user/login");

        //3. Enter valid username - user160
        WebElement inputName = driver.findElement(By.xpath("//input[@name='_username']"));
        inputName.sendKeys("user160");

        //4. Enter valid password  //UserUser123
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='_password']"));
        inputPassword.sendKeys("UserUser123");

        //5. Click to Log In button
        WebElement loginBtn = driver.findElement(By.xpath("//button[@id='_submit']"));
        loginBtn.click();

        //6. Verify title is as expected: Dashboard
        BrowserUtils.verifyTitle(driver,"Dashboard");

        Set<String> allHandles= driver.getWindowHandles();

        WebElement clickQuestionBrtn = driver.findElement(By.xpath("//i[@class='fa-question-circle']"));
        clickQuestionBrtn.click();

        System.out.println("driver.getWindowHandles() = " + driver.getWindowHandles());
        allHandles = driver.getWindowHandles();

        for (String eachHandle : allHandles){
            System.out.println("eachHandle = " + eachHandle);
            driver.switchTo().window(eachHandle);
            System.out.println("driver.getTitle() = " + driver.getTitle());
        }

        //7.verify that user title is "Welcome to Oro Documentation"

        BrowserUtils.verifyTitle(driver,"Welcome to Oro Documentation");

    }

}
