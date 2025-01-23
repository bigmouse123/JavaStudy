package com.situ.day8;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/1/20 16:24
 */
public class IODemo {

    @Test
    public void test1() {

        FileReader fileReader = null;
        try {
            fileReader = new FileReader("io.txt");
            int ch = -1;
            while ((ch = fileReader.read()) != -1) {
                System.out.println((char) ch);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void test2() {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader("io.txt");
            fileWriter = new FileWriter("io_back.txt");
            char[] chars = new char[10];
            int length = -1;
            while ((length = fileReader.read(chars)) != -1) {
                System.out.println(Arrays.toString(chars));
                fileWriter.write(chars, 0, length);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
