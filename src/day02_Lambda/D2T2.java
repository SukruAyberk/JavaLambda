package day02_Lambda;

import day01_lambda.Lambda02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D2T2 {

    public static void main(String[] args) {

        // Task : Functional Programming ile listin cift elemanlarinin   karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
        List<Integer> sayi = new ArrayList<Integer>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));
        ciftKarekokPrint(sayi);

    }

    private static void ciftKarekokPrint(List<Integer> sayi) {
        sayi.stream().filter(Lambda02::ciftBul).map(Math::sqrt).forEach(t-> System.out.print(t + " "));
    }
}
