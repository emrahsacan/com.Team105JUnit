package day08_HandligWindows.day13_writeExcel_Screenshot;

import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_tekrar extends TestBase {
    @Test
    public void test01(){
        driver.get("https://www.wisequarter.com");
        String expectedUrl="wisequarter";
        String actualUrl=driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));

        ReusableMethods.tumSayfaScreenshotCek(driver);

    }

}
