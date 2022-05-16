package day02_Lambda;

import day01_lambda.Lambda01;
import day01_lambda.Lambda02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D2T5 {

    public static void main(String[] args) {

        // Task : Functional Programming ile listin cift elemanlarinin  karelerini ayni satirda aralarina bosluk bırakarak print ediniz

        List<Integer> sayi = new ArrayList<Integer>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));
        ciftKarelePrint(sayi);


    }

    private static void ciftKarelePrint(List<Integer> sayi) {
        // buradaki map ile önceden gördüğümüz map aynı değil
        // önceki map key ve valuedan oluşan data saklama yeriydi
        // buradaki emir kulu matematiksel işlem yaptırdık
        sayi.stream().filter(Lambda02::ciftBul).map(t -> t * t).forEach(Lambda01::yazdir);
    }


}
