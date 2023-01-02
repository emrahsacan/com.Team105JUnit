package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_tekrar {

    // 3 ayri test method'u olusturun
    // 1.method'da amazon'a gidip, amazona gittigimizi test edin
    // 2.method'da amazon'da nutella aratip, sonuclarin nutella icerdigini test edin
    // 3.method'da nutella arama sonuc sayisinin 50'den fazla oldugunu test edin

    static  WebDriver driver;
    @BeforeClass
    public static  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void teardown(){
        driver.close();
    }

    // 1.method'da amazon'a gidip, amazona gittigimizi test edin
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        String expectedKelime="Amazon";
        String actualTitle= driver.getTitle();
        if (actualTitle.contains(expectedKelime)) {
            System.out.println("Amazon giriş testi PASSED");
        }else {
            System.out.println("Amazon giriş testi FAILED");
        }
    }
    // 2.method'da amazon'da nutella aratip, sonuclarin nutella icerdigini test edin
    @Test
    public void test02(){
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        String expectedKelime= "Nutella";
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        String actualYaziStr=sonucYaziElementi.getText();
        if (actualYaziStr.contains(expectedKelime)){
            System.out.println("Sonuc yazı testi PASSED");
        }else {
            System.out.println("Sonuc yazı testi FAILED");
        }
    }


    // 3.method'da nutella arama sonuc sayisinin 50'den fazla oldugunu test edin

    @Test
    public void test03(){

        WebElement aramaSonucElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String actualSonucYazisiStr=aramaSonucElementi.getText();

        String[] sonucYazisiArr =actualSonucYazisiStr.split(" ");

         String sonucAdedistr=sonucYazisiArr[2];
        int actualsSonucAdediInt= Integer.parseInt(sonucAdedistr);

        int expectedSonucAdedi=50;

        if (actualsSonucAdediInt>expectedSonucAdedi){
            System.out.println("Nutella arama sonuc sayisi testi PASSED");
        }else{
            System.out.println("Nutella arama sonuc sayisi testi FAILED");
        }


    }


}
