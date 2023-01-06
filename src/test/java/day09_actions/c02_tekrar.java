package day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class c02_tekrar extends TestBase {
    @Test
    public void test01(){
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim


        WebElement dragMe=driver.findElement(By.id("draggable"));

        WebElement dropMe=driver.findElement(By.id("droppable"));

        Actions actions=new Actions(driver);

        actions.dragAndDrop(dragMe,dropMe).perform();


        ReusableMethods.bekle(3);




        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

        WebElement droppedYazisi=driver.findElement(By.xpath("//*[text()='Dropped!']"));

        Assert.assertTrue(droppedYazisi.isDisplayed());

        ReusableMethods.bekle(3);



    }
}
