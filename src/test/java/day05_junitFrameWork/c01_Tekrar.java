package day05_junitFrameWork;

import org.junit.Ignore;
import org.junit.Test;

public class c01_Tekrar {
    @Test
    public void test01(){
        System.out.println("test1 çalıstı");
    }

    @Test @Ignore
    public void test02(){
        System.out.println("test2 çalıstı");
    }

    @Test
    public void test03(){
        System.out.println("test3 calıstı");
    }
}
