package day01_lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda03 {

    public static void main(String[] args) {

        // Task - 2 Functional programming ile list elemanlarının 34'ten küçük olanlarının cift olanlarını aynı satırda aralarına boşluk bırakarak print et
        List<Integer> sayi = new ArrayList<Integer>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));

        otuzDorttenKucukCiftPrintEt(sayi); // 22 16 20
        System.out.println();
        otuzDorttenKucukCiftPrintEt2(sayi); // 22 16 20

    }

    private static void otuzDorttenKucukCiftPrintEt2(List<Integer> sayi) {
        sayi.stream().filter(t->t<34 && t%2==0).forEach(Lambda01::yazdir);
    }

    private static void otuzDorttenKucukCiftPrintEt(List<Integer> sayi) {
        sayi.stream().filter(Lambda03::otuzDorttenKucukMu).filter(Lambda02::ciftBul).forEach(Lambda01::yazdir);
    }

    public static boolean otuzDorttenKucukMu(int i) {
        return i < 34;
    }
}
