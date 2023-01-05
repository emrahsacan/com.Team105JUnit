package day13_writeExcel_Screetshot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class C01_ReadExcel {
    @Test
    public void test01() throws FileNotFoundException {
        //excel dosyaları bilgisayarımızda olduğu için
        //Java2dan File InputStream class'i yardımıyla ulaşacağız

        String dosyaYolu="src/test/java/day12_webtables_excel/ulkeler.xlsx";

        FileInputStream fis= new FileInputStream(dosyaYolu);

        // Workbook workbook= WorkbookFactory.create(fis);
      //  workbook.getSheet("Sayfa1").getRow(3).getCell(1);


        dataYazdir(25,2);
    }
    private void dataYazdir(int  satir,int sutun) {
        String dosyaYolu="src/test/java/day12_webtables_excel/ulkeler.xlsx";

    }
}
