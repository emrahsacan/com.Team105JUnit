package D_11_Tekrari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_hepsi_11 {
    /*
    1-hepsiburada adresine gidin
    2-arama çubuğunda "samsung telefon" aratalım
    3-kaç adet ürün sonuçlandığını gösterin
    4-samsung ve 4 yıldız üzeri radio butonlarına tik atın
    5-ilk ürünü tıklayın
    6-sepete ekle butonuna tıklayın
    7-sepete git butonuna tıklayın
    8 alışveririşi tamamla butonuna tıklayın
    9-üye olmadan devamm et linkine tıklayın
    10-e-posta yazan kısma uydurma bir e-posta gönderin
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
        //1-hepsiburada adresine gidin
        driver.get("https://www.hepsiburada.com");
        Thread.sleep(2000);
    }
    @Test
    public void test02() throws InterruptedException {
        //2-arama çubuğunda "samsung telefon" aratalım
        driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("samsung telefon"+ Keys.ENTER);
    }
    @Test
    public void test03(){
        //3-kaç adet ürün sonuçlandığını gösterin
        WebElement searchResult = driver.findElement(By.xpath("(//*[text()='106'])[1]"));
        System.out.println("listelenen urunsayisi: "+searchResult.getText());
    }
    @Test
    public void test04(){
        //samsung ve 4 yıldız üzeri radio butonlarına tik atın
        driver.findElement(By.xpath("//input[@value='samsung']")).click();
        driver.findElement(By.xpath("//input[@value='4-max']")).click();
    }

    @Test
    public void test05() throws InterruptedException {
        // ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@data-test-id='carousel-grid-item'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='addToCart']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Sepete git']")).click();
        Thread.sleep(2000);
    }

    @Test
    public void test06() throws InterruptedException {
        // 8 alışveririşi tamamla butonuna tıklayın
        driver.findElement(By.xpath("//*[text()='Alışverişi tamamla']")).click();
        Thread.sleep(2000);
    }

    // 9-üye olmadan devamm et linkine tıklayın
    @Test
    public void test07 () throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='_1GIDa1xqXxB-fbq1_0_8tc']")).click();
        Thread.sleep(2000);
    }

    // 10-e-posta yazan kısma uydurma bir e-posta gönderin
    @Test
    public void test08 () throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("emrahsacan@gmail.com");
        Thread.sleep(2000);
    }

}
