package day01_lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda04 {

    public static void main(String[] args) {

        // Task - 2 Functional programming ile list elemanlarının 34'den büyük veya olanlarının cift olanlarını aynı satırda aralarına boşluk bırakarak print et
        List<Integer> sayi = new ArrayList<Integer>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));
        otuzdorttenBuyukVeyaCiftYazdir(sayi); // 34 22 16 35 20 63 65 44 66 64 81 38

    }

    private static void otuzdorttenBuyukVeyaCiftYazdir(List<Integer> sayi) {
        sayi.stream().filter(t -> t> 34 || t % 2 == 0).forEach(Lambda01::yazdir);
    }
}
