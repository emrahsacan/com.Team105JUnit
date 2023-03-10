package day07_dropdown_jsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_tekrar {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void teardown(){
        driver.close();
    }



    @Test
    public void test01() throws InterruptedException {
        // ilgili ayarlari yapip
        // amazon anasayfaya gidin
        // arama kutusu yanindaki dropdown menuden book secin
        // arama kutusuna java yazdirip aramayi yapin
        // title'in java icerdigini test edin
        driver.get("https://www.amazon.com");

        WebElement dropdownWebElementi= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        Select select=new Select(dropdownWebElementi);

        select.selectByVisibleText("Books");

        // arama kutusuna java yazdirip aramayi yapin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));

        aramaKutusu.sendKeys("java" + Keys.ENTER);

        String expectedKelime="java";
        String actualElement= driver.getTitle();

        Assert.assertTrue(actualElement.contains(expectedKelime));

        // dropdown menuden Books seceneginin secildigini test edin

        dropdownWebElementi= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select=new Select(dropdownWebElementi);
        select.selectByVisibleText("Books");

        String actualsecilenOption=select.getFirstSelectedOption().getText();
        String expectedSecilecekOption="Books";

        Assert.assertEquals(expectedSecilecekOption,actualsecilenOption);

        // Dropdown menudeki secenek sayisinin 28 oldugunu test edin

        List<WebElement> optionsWebElementListesi = select.getOptions();

        int actualOptionSayisi=optionsWebElementListesi.size();

        int expectedOptionSayisi=28;

        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);






     Thread.sleep(5000);
    }
}
