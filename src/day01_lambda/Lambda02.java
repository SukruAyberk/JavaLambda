package day01_lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda02 {

    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<Integer>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));
        // Task - 2 Structured/Functional programming ile list elemanlarının cift olanlarını aynı satırda aralarına boşluk bırakarak print et

        // Structered Programming
        ciftOlaniPrintEtStructured(sayi); // 34 22 16 20 44 66 64 38

        System.out.println("\n******");

        // Funtional Programming
        ciftOlaniPrintEtFunctional1(sayi); // 34 22 16 20 44 66 64 38

        System.out.println("\n******");

        // asıl çalışman gereken şekli bu
        ciftOlaniPrintEtFunctional2(sayi); // 34 22 16 20 44 66 64 38
    }

    private static void ciftOlaniPrintEtFunctional2(List<Integer> sayi) {
        sayi.stream().filter(Lambda02::ciftBul).forEach(Lambda01::yazdir);
    }

    private static void ciftOlaniPrintEtFunctional1(List<Integer> sayi) {
        sayi.stream().filter(t -> t % 2 == 0).forEach(Lambda01::yazdir);
    }


    private static void ciftOlaniPrintEtStructured(List<Integer> sayi) {
        for (Integer i : sayi) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean ciftBul(int i) { // seed(tohum) method kendisine verilen int değerin çiftliğini kontrol eder

        return i % 2 == 0;
    }


}
