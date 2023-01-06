package day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_tekrar extends TestBase{
    @Test
    public void test1(){

        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        //   mouse’u bu menunun ustune getirin
        WebElement accountListMenusu=driver.findElement(By.id("nav-link-accountList-nav-line-1"));

        Actions actions= new Actions(driver);

        actions.moveToElement(accountListMenusu).perform();

        ReusableMethods.bekle(3);


        //3- “Create a list” butonuna basin
        driver.findElement(By.linkText("Create a List")).click();


        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin

        WebElement actualYourListYazisi= driver.findElement(By.id("my-lists-tab"));

        Assert.assertTrue(actualYourListYazisi.isDisplayed());

        ReusableMethods.bekle(3);

    }



}
