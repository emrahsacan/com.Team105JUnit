package day13_writeExcel_Screetshot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_TakeScreenshotTumSayfa extends TestBase {

    @Test
    public void test01(){
        //amazon.com'a gidip
        driver.get("https://www.amazon.com");
        // Nutella aratıp
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearch"));
        // arama sonuclarının Nutella içerdiğini test edin
        //Tum sayfanın screenshot'ını alın
    }

}
