package day10_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_tekrar extends TestBase {
    @Test
    public void test01(){
        //1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //2.chooseFile butonuna basalim
        //3.Yuklemek istediginiz dosyayi secelim.
        //4.Upload butonuna basalim.
        //5.“File Uploaded!” textinin goruntulendigini test edelim.

        /*
             Bu gorevi yapabilmek icin chooseFile butonuna basildiginda
             acilan bilgisayarimizdaki file dosyalarini click yapabilmeemiz gerekir
             ancak Selenium bilgisayarimizdaki dosyalari click yapamaz
             Bunun yerine soyle bir cozum uretilmistir
             1- chooseFile butonunu locate edin
             2- upload edilecek dosyanin dosya yolunu olusturun
             3- chooseFile butonuna sendKeys ile dosya yolunu gonderin
         */

        WebElement chooseFileButounu= driver.findElement(By.id("file-upload"));
        String dosyaYolu=System.getProperty("user.home")+"\\OneDrive\\Masaüstü\\MerhabaJava.docx";   //"C:\Users\emrah\OneDrive\Masaüstü\MerhabaJava.docx"

        chooseFileButounu.sendKeys(dosyaYolu);



        // Upload butonuna basalim.

        driver.findElement(By.id("file-submit")).click();


        //5.“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUploadElementi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadElementi.isDisplayed());


        ReusableMethods.bekle(3);

    }
}
