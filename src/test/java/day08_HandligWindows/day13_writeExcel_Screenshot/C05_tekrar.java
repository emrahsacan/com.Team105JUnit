package day08_HandligWindows.day13_writeExcel_Screenshot;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_tekrar extends TestBase {
    @Test
    public void test01(){
        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // Nutella aratin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        // Sonuclarin nutella icerdigini test edin
        WebElement aramaSonucElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualSonuc=aramaSonucElementi.getText();
        String expectedSonuc="Nutella";
        Assert.assertTrue(actualSonuc.contains(expectedSonuc));
        // arama sonuc elementinin screenshot'ini cekin
        ReusableMethods.elementSSCek(aramaSonucElementi);
    }
}