package day10_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_FileUploadTesti extends TestBase {


    @Test
    public void test01(){
        //1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //2.chooseFile butonuna basalim
        //3.Yuklemek istediginiz dosyayi secelim.
        //4.Upload butonuna basalim.
        //5.“File Uploaded!” textinin goruntulendigini test edelim.

        /*
        Bu görevi
         */

        WebElement chooseFileButonu= driver.findElement(By.xpath("//input[@id='file-upload']"));
        String dosyaYolu= System.getProperty("user.home") + "\\OneDrive\\Masaüstü\\MerhabaJava.docx";

        chooseFileButonu.sendKeys(dosyaYolu);

        // Upload butonuna basalim.
        driver.findElement(By.xpath("//*[@id=\"file-submit\"]"));

        //5.“File Uploaded!” textinin goruntulendigini test edelim.

        WebElement fileUploadedelementi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedelementi.isDisplayed());

        ReusableMethods.bekle(3);


    }
}
