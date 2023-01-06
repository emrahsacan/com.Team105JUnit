package day08_HandligWindows;

import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;


public class C04_tekrar extends TestBase {
    @Test
    public void test01(){
        //amazona git
        driver.get("https://www.amazon.com");
        //amazona gittiğını test et

        String expectedKelime="amazon";
        String actualURL=driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedKelime));
        ReusableMethods.bekle(3);
    }
}
