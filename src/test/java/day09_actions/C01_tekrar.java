package day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class C01_tekrar extends TestBase {
    @Test
    public void test01(){

        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapin
        Actions actions= new Actions(driver);

        WebElement ciziliAlanElementi=driver.findElement(By.id("hot-spot"));

        actions.contextClick(ciziliAlanElementi).perform();


        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedAlertYazisi= "You selected a context menu";
        String actualAlertYazisi= driver.switchTo().alert().getText();

        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);


        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim

        String ilkSayfaWHD= driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();



        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String> ikiSayfaninWHDegerleriSeti= driver.getWindowHandles();
        String ikinciSayfaWHD="";

        for (String eachWHD: ikiSayfaninWHDegerleriSeti
             ) {
            if (!eachWHD.equals(ilkSayfaWHD)){
               ikinciSayfaWHD = eachWHD;
            }
        }

        driver.switchTo().window(ikinciSayfaWHD);

        String expectedYeniSayfaYazi="Elemental Selenium";
        String actualYeniSayfaYazi= driver.findElement(By.tagName("h1")).getText();


        Assert.assertEquals(expectedYeniSayfaYazi,actualYeniSayfaYazi);



        ReusableMethods.bekle(3);
    }
}
