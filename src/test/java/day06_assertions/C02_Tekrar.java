package day06_assertions;

import org.junit.Assert;
import org.junit.Test;

public class C02_Tekrar {
     /*
       JUnit framework'u calistirilan testlerin passed veya failed olmasini raporlar
       Ancak raporlamanin dogru sonuc vermesi icin
       Test'lerin Assert class'indaki hazir method'larla yapilmasi gerekir.
       Eger Assert class'i kullanilmazsa
       JUnit kodlarin sorunsuz olarak calisip bittigini raporlar
       C01'de testleri if-else ile yaptigimiz icin
       Testler failed olsa da kodlar sorunsuz calistigi icin
       testler yesil tik olarak isaretlendi
     */

     int P1Yas=60;
     int P2yas=66;
     int P3yas=70;
    @Test
    public void test01(){
        //emekli yasi 65 olduğuna göre
        //P2'nin emekli olamayacağını test edin

        Assert.assertTrue(P2yas>65);
    }

    @Test
    public void test02(){
        Assert.assertFalse(P1Yas>65);
    }

    @Test
    public void test03(){
        Assert.assertFalse("Girilen yaş 65'ten küçük olmadığından emekli olabilir. ", P3yas>65);
    }
}
