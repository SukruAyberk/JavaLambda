package day02_Lambda;

import day01_lambda.Lambda01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D2T6 {

    public static void main(String[] args) {

        // Task : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print edin
        List<Integer> sayi = new ArrayList<Integer>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));
        kupunBirFazlasiHesapla(sayi);
    }

    private static void kupunBirFazlasiHesapla(List<Integer> sayi) {
        sayi.stream().filter(t -> t % 2 != 0).map(t -> (t * t * t) + 1).forEach(Lambda01::yazdir);
    }
}
