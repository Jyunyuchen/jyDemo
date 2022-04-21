package com.example.demo;

import com.example.demo.domain.MyUSer;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
public class JyTest {

    @Test
    void test01(){
        MyUSer myUSer = new MyUSer(1, "jy","12345");
        System.out.println("==============> " + myUSer.getAuthorities());
    }

    @Test
    void test02() throws Exception {
        FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\jy\\Desktop\\abc.txt"));
        File targetFile = new File("D:\\test\\");
        FileUtils.copyInputStreamToFile(inputStream,targetFile);
        System.out.println("File name ======>" + targetFile.getName());
    }
}
