package day12_webtables_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_tekrar {
    @Test
    public void test() throws IOException {
        // Ulkeler excel'indeki sayfa1'e gidecek sekilde ayarlari yapalim
        String dosyaYolu="src/test/java/day12_webtables_excel/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        //		- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(workbook.getSheet("Sayfa1").getRow(0).getCell(1));
        //		- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
         String istenenHucreStr= workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println(istenenHucreStr);


        //		- 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim

        String actualBaskent= workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        String expectedBaskent="Kabil";
        Assert.assertEquals(expectedBaskent,actualBaskent);

        //		- Satir sayisini bulalim
        //		- Fiziki olarak kullanilan satir sayisini bulun
        //      Bunun icin Sayfa2 deki son satir indexi'ni ve fiziki kullanilan satir sayisini yazdiralim
        //		- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        //  Ulke ismi ingilizce ==> key, geriye kalan 3 bilgi ise birlestirilerek value olsun

    }
}
