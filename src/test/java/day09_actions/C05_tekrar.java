package day09_actions;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_tekrar extends TestBase {
    @Test
    public void test01(){
        // facebook.com sayfasina gidin
        driver.get("https://www.facebook.com");


        // cookies'i kabul et ---bende çıkmadı---

        // yeni hesap olustur butonuna basin
        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();

        // ilgili alanlari faker kutuphanesinden degerlerle doldurup

        WebElement firstnameKutusu=driver.findElement(By.name("firstname"));

        Actions actions= new Actions(driver);
        Faker faker=new Faker();

        String mailAdresi=faker.internet().emailAddress();

        actions.click(firstnameKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(mailAdresi)
                .sendKeys(Keys.TAB)
                .sendKeys(mailAdresi)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("23")
                .sendKeys(Keys.TAB)
                .sendKeys("Ocak")
                .sendKeys(Keys.TAB)
                .sendKeys("1987")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT).perform();

        // kaydol butonuna basin
        WebElement signupButonu= driver.findElement(By.xpath("//*[@class='_6j mvm _6wk _6wl _58mi _6o _6v']"));
        signupButonu.click();


        // Kayit olamadiginizi test edin


        ReusableMethods.bekle(20);
    }

}
