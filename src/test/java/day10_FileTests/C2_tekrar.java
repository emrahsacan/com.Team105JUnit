package day10_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C2_tekrar extends TestBase {
    @Test
    public void test01(){
       // 1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
       // 2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        ReusableMethods.bekle(3);
       // 3. Facebookd.png dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='file.png']")).click();

        ReusableMethods.bekle(4);
       // 4. Dosyanın başarıyla indirilip indirilmediğini test edelim

        //Test icin oncelikle dosyanın indirildiğnde dosyaYolu ne olacak bunu olusturmaliyiz

       String dosyaYolu= System.getProperty("user.home")+ "\\Downloads\\file.png";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }
    @Test
    public void test02(){
        // Masaustunde Merhabajava.docx dosyasi oldugunu test edin
        // "C:\Users\emrah\OneDrive\Masaüstü\MerhabaJava.docx"

        // dinamik dosya yolu olusturalim

        String dosyaYolu=System.getProperty("user.home")+ "\\OneDrive\\Masaüstü\\MerhabaJava.docx";


        //Assert alalım
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
