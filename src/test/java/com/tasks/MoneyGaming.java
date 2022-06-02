package com.tasks;

import com.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class MoneyGaming {
    WebDriver driver;

    @Test
    public void money_gaming_test(){
        driver = Driver.getDriver();
        driver.get("https://moneygaming.qa.gameaccount.com/");

        driver.findElement(By.xpath("//a[@class='newUser green']")).click();

        //driver.findElement(By.xpath("//a[@class='newUser green']")).click();
        Select select = new Select(driver.findElement(By.xpath("//select[@class='title required']")));
        select.selectByValue("Mr");

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