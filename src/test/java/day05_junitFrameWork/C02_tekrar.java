package day05_junitFrameWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_tekrar {

    // 3 farkli test method'u olusturun
    // her bir method'un basinda driver'i olusturup
    // 1- amazon.com
    // 2- wisequarter.com
    // 3- youtube.com'a gidip
    // title'lari yazdirin ve method'dan sonra driver'i kapatin

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        System.out.println("setUp methodu calıstı");

    }
    @After
    public void tearDown(){
        System.out.println("teardown methodu calıstı");
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
        Thread.sleep(2000);

    }

    @Test
    public void test02() throws InterruptedException {
        driver.get("https://www.wisequarter.com");
        System.out.println(driver.getTitle());
        Thread.sleep(2000);

    }

    @Test
    public void test03() throws InterruptedException {
        driver.get("https://www.youtube.com");
        System.out.println(driver.getTitle());
        Thread.sleep(2000);

    }

}
