package com.tasks;

import com.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MoneyGaming {
    WebDriver driver;

    @Test
    public void money_gaming_test(){
        driver = Driver.getDriver();
        //Navigate to: https://moneygaming.qa.gameaccount.com/
        driver.get("https://moneygaming.qa.gameaccount.com/");

        //Click the JOIN NOW button to open the registration page
        driver.findElement(By.xpath("//a[@class='newUser green']")).click();

        //3. Select a title value from the dropdown
        Select select = new Select(driver.findElement(By.xpath("//select[@class='title required']")));
        select.selectByValue("Mr");

        //Enter your first name and surname in the form
        WebElement firstName = driver.findElement(By.xpath("//input[@id='forename']"));
        firstName.sendKeys("Mehmet");

        WebElement lastName = driver.findElement(By.xpath("//input[@name='map(lastName)']"));
        lastName.sendKeys("Ermis");
        //Check the tick box with text 'I accept the Terms and Conditions and certify that I am over
        //the age of 18.'
        driver.findElement(By.xpath("//input[@class='required checkbox terms']")).click();
        //Submit the form by clicking the JOIN NOW button
        driver.findElement(By.xpath("//input[@alt='Join Now']")).click();

        // Validate that a validation message with text ‘ This field is required’ appears under the date of birth box

        WebElement warningMessage = driver.findElement(By.xpath("//label[@for='dob']"));

        String expectedMessage = "This field is required";
        String actualMessage = warningMessage.getText();

        Assert.assertEquals(actualMessage,expectedMessage);




    }

}
/*
Task 2:
1. Navigate to: https://moneygaming.qa.gameaccount.com/
2. Click the JOIN NOW button to open the registration page
3. Select a title value from the dropdown
4. Enter your first name and surname in the form
5. Check the tick box with text 'I accept the Terms and Conditions and certify that I am over
the age of 18.'
6. Submit the form by clicking the JOIN NOW button
7. Validate that a validation message with text ‘ This field is required’ appears under the date of
birth box

 */