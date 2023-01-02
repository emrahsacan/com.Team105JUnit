package day11_seleniumwaits_cookies;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_WebTables  extends TestBase {

    @Test
    public void test01(){

        //1.“https://www.amazon.com” adresine gidin
        driver.get("https://www.amazon.com");
        //2.Sayfanin en altina inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END);
        //3.Web table tum body’sini yazdirin
        //4.Web table’daki satir sayisinin 9 oldugunu test edin
        //5.Tum satirlari yazdirin
        //6. Web table’daki sutun sayisinin 13 olduğunu test edin
        //7. 5.sutunu yazdirin
        //8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
    }
}
