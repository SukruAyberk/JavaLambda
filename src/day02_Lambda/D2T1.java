package day02_Lambda;

import day01_lambda.Lambda02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D2T1 {

    public static void main(String[] args) {

        // Task : List'teki cift elemanlarin carpimini  yazdiriniz.
        List<Integer> sayi = new ArrayList<Integer>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));
        ciftCarp(sayi);

    }

    private static void ciftCarp(List<Integer> sayi) {
        System.out.println(sayi.stream().filter(Lambda02::ciftBul).reduce(Math::multiplyExact));
        int carpim = sayi.stream().filter(Lambda02::ciftBul).reduce(1, (x, y) -> (x * y));
        System.out.println(carpim);
    }
}
