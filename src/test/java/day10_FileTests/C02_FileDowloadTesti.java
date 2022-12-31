package day10_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C02_FileDowloadTesti extends TestBase {

    @Test
    public void test01(){

        // 2. https://the-internet.herokuapp.com/download adresine gidelim.

        driver.get("https://the-internet.herokuapp.com/download");


        // 3. Facebookd.png dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='Facebookd.png']")).click();
        ReusableMethods.bekle(5);
        // 4. Dosyanın başarıyla indirilip indirilmediğini test edelim

        //Test icin oncelikle dosyanın indirildiğnde dosyaYolu ne olacak bunu olusturmliyiz

        String dosyaYolu = System.getProperty("user.home")+ "\\Downloads\\Facebookd.png"; //"C:\Users\emrah\Downloads\Facebookd.png"

        //Bir dosyanın bilgisayarımızda var olduğunu (exist) test etmek için
        //Java'daki Files class'ından yardım alacagız

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
    @Test
    public void test02(){
        //Masaustunde Merhabajava.docx dosyasi olduğunutest edin

        String dosyaYolu= System.getProperty("user.home")+ "\\OneDrive\\Masaüstü\\MerhabaJava.docx";     //"C:\Users\emrah\OneDrive\Masaüstü\MerhabaJava.docx"

        //Assert alalım
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }

}
