package com.demo.academy;

import com.demo.academy.arrays.LearnArray;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Array;
import java.util.Arrays;

@SpringBootApplication
public class AcademyApplication implements Runnable {
    int a = 0;
    int b = 0;
    @Override
    public void run() {
        for(int i= 0; i < 3; i++){
            System.out.println(incrementA() + "" + incrementB());
        }
    }

    private int incrementB() {
        return ++a;
    }

    private int incrementA() {
        return ++b;
    }

    public static void main(String[] args) {
        AcademyApplication test1 = new AcademyApplication();
        AcademyApplication test2 = new AcademyApplication();

        Thread t1 = new Thread(test1);
        Thread t2 = new Thread(test2);
        t2.start();
        t1.start();
    }

//	public static void main(String[] args) {
//
//		SpringApplication.run(AcademyApplication.class, args);
//		LearnArray array = new LearnArray();
//		int[] sumIndex = array.twoSum();
//		System.out.println(Arrays.toString(sumIndex));
//	}



}
