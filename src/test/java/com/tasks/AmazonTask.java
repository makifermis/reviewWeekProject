package com.tasks;

import com.utilities.BrowserUtils;
import com.utilities.ConfigurationReader;
import com.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class AmazonTask {
    WebDriver driver;
    @Test
    public void amazon_task(){
        driver = Driver.getDriver();
        //Go to https://www.amazon.com
        driver.get("https://www.amazon.com");

        //Search for "hats for men" (Call from Configuration.properties file)
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue")+ Keys.ENTER);

        //Add the first hat appearing to Cart with quantity 2

        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();

        driver.findElement(By.xpath("//span[@class='a-dropdown-label']")).click();

        driver.findElement(By.xpath("//a[@id='quantity_1']")).click();

        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();

        // Open cart and assert that the total price and quantity are correct
        driver.findElement(By.xpath("//span[@id='sw-gtc']")).click();

        String priceWholeOne = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[2]")).getText();

        String priceDecimalOne = driver.findElement(By.xpath("(//span[@class='a-price-fraction'])[2]")).getText();

        Double priceOfOne = Double.valueOf(priceWholeOne+"."+priceDecimalOne);

        String priceWholeTwo = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();

        String priceDecimalTwo = driver.findElement(By.xpath("(//span[@class='a-price-fraction'])[1]")).getText();

        Double priceOfTwo = Double.valueOf(priceWholeTwo+"."+priceDecimalTwo);

        Double expectedPriceForTwo = priceOfOne * 2;
        Double actualPriceForTwo = priceOfTwo;

        Assert.assertEquals(actualPriceForTwo,expectedPriceForTwo);

        Select select = new Select(driver.findElement(By.xpath("//select[@id='quantity']"))) ;
        String actualQuantity = select.getFirstSelectedOption().getText();
        String expectedQuantity = "2";

        Assert.assertEquals(actualQuantity,expectedQuantity);

        BrowserUtils.sleep(1);

        //Reduce the quantity from 2 to 1 in Cart for the item selected in the step 3

        Select select1 = new Select(driver.findElement(By.xpath("//select[@name='quantity']")));
        select1.selectByValue("1");

        BrowserUtils.sleep(1);

        // Assert that the total price and quantity has been correctly changed

        String priceWholeQuantityDecreased = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();

        String priceDecimalQuantityDecreased = driver.findElement(By.xpath("(//span[@class='a-price-fraction'])[1]")).getText();

        Double priceOfQuantityDecreased = Double.valueOf(priceWholeQuantityDecreased+"."+priceDecimalQuantityDecreased);

        Assert.assertEquals(priceOfOne,priceOfQuantityDecreased);

    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
        driver.close();
    }

}
/*
For the Tasks bellow create a new Maven Project, use the latest topics you have learned, like Page Object Modeling, singleton Driver class.
Share your project on GitHub, create a commit history. Also for each different task create a branch, then merge it when the task is over. (Optional; share you project Github Link at Tasks and Solutions Channel on Discord.)



Task 1: The task consists on the next steps:
1.	Go to https://www.amazon.com
2.	Search for "hats for men" (Call from Configuration.properties file)
3.	Add the first hat appearing to Cart with quantity 2
4.	Open cart and assert that the total price and quantity are correct
5.	Reduce the quantity from 2 to 1 in Cart for the item selected in the step 3
6.	Assert that the total price and quantity has been correctly changed
The goal of this test is to check if you are able to automate a test of a given website, but we'd like you to also demonstrate the coding quality, structure, and style of the deliverables.

 */
