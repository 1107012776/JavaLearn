package com.test;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.javaPHP.*;

public class TestUtil {

    static {
        System.out.println(123123);
    }

    public static void main(String[] args) {
        PHP.echo("hello word");
        PHP.print_r(PHP.file_get_contents("D:\\git-project\\JavaLearn\\src\\test\\java\\com\\test\\TestUtil.java"));
//        JSONArray newJson =  (JSONArray)null;
//        System.out.println(newJson);
//        domain();

//        addJson();

//        forTest();
//        pdfTrans1();
    }

    public static void pdfAspose() {

    }


}
