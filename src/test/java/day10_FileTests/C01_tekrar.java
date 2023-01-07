package day10_FileTests;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class C01_tekrar {
    @Test
    public void test01() throws FileNotFoundException {
        String dosyaYolu = "\"C:\\Users\\emrah\\OneDrive\\Masaüstü\\MerhabaJava2\"";
        FileInputStream fis= new FileInputStream(dosyaYolu);
            /*
         File testlerinde genellıkle dowloads'a indırılecek bır dosyanın ınırıldıgını test etmek veya
          bır dosyanın web'e yuklenebıldıgını test etmek ısterız
         Ancak herkesın bılgısayarının ısmı , kullanıcı ısımlerı gıbı farklılıklar olacagınsan testler
         tek bır bılgısayarda calısacak  gibi yazılmak zorunda kalırnır.
         Bu karışıklıgın önüne geçebilmek için Java iki basit kod blogu sunmuş:
         System.out.println(System.getProperty("user.dir"));  // o anca çalışan dosyanın (C01_FileInputStream) yolunu verir
         System.out.println(System.getProperty("user.home")); //Kullanıcının temel path'ini verir.
     */
        System.out.println(System.getProperty("user.dir"));
        // o anda calisan dosyanin (C01_FileInputStreeam) yolunu verir
        // C:\Users\emrah\OneDrive\Masaüstü\com.Team105JUnit


        System.out.println(System.getProperty("user.home"));
        // kullanicinin temel path'ini verir.
        // C:\Users\emrah

        // Masaustune gitmek istersek
        // /Users/ahmetbulutluoz + /Desktop eklememiz yeterlidir

        // Downloads'a gitmek istersek
        // /Users/ahmetbulutluoz + /Downloads eklememiz yeterlidir


        // Kodlarimizin dinamik olmasi yani kisinin bilgisayarindaki
        // kullanici adi gibi detaylara takilmamasi icin
        // File testlerinde kullanilacak dosya yolunu
        // user.home... temel path'ini calistigi bilgisayardan alacak sekilde
        // olustururuz

        // dosyaYolu = "\"C:\\Users\\emrah\\OneDrive\\Masaüstü\\MerhabaJava2\"";


        String dinamikDosyaYolu= System.getProperty("user.home") +"\\Masaüstü\\MerhabaJava2\"";
    }
}
