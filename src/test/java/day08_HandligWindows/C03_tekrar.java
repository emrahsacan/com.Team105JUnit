package day08_HandligWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C03_tekrar {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        // https://the-internet.herokuapp.com/iframe adresine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");
        // elemental selenium linkini tiklayin
        // linke tikladigimizda yeni sayfa acilacagindan
        // click yapmadan once ilk sayfanin WHD'ini alip kaydedelim
       String ilkSayfaWHD=driver.getWindowHandle();
       driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();
        // click yapinca yeni tab acilir ancak driver eski tab'da kalir
        // yeni tab'a driver'i gecirmek icin yeni tab'in WHD ihtiyacimiz var
        Set<String> ikiSayfaninWHDegerlerSeti= driver.getWindowHandles();
        String ikinciSayfaWHD="";
        for (String eachWHD: ikiSayfaninWHDegerlerSeti
             ) {
            if (!eachWHD.equals(ilkSayfaWHD)){
                ikinciSayfaWHD=eachWHD;
            }
        }
        // foreach loop bittiginde ikinci sayfanin WHD'ini elde etmis olacagiz
        // bu degeri kullanarak, driver'i 2.sayfaya  gecirebiliriz
        driver.switchTo().window(ikinciSayfaWHD);
        // yeni tab'a gecip sayfadaki en buyuk yazinin "Elemental Selenium" oldugunu test edin
        String actualEnBuyukYazi=driver.findElement(By.tagName("h1")).getText();
        String expectedEnBuyukYazi="Elemental Selenium";

        Assert.assertEquals(expectedEnBuyukYazi,actualEnBuyukYazi);

        // ilk sayfaya geri donup sayfadaki yazinin
        driver.switchTo().window(ilkSayfaWHD);
        // "An iFrame containing the TinyMCE WYSIWYG Editor" oldugunu test edin
        String actualIlkSayfaYazi=driver.findElement(By.tagName("h3")).getText();
        String expectedIlkSayfaYazi="An iFrame containing the TinyMCE WYSIWYG Editor";

        Assert.assertEquals(expectedIlkSayfaYazi,actualIlkSayfaYazi);

        Thread.sleep(3000);

    }
}


