package day03_Lambda;

import day01_lambda.Lambda01;
import day01_lambda.Lambda02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D3T3 {

    public static void main(String[] args) {

        // Task : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
        List<Integer> sayi = new ArrayList<Integer>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));
        ciftKareKucuktenBuyuge(sayi);
        // Collections.sort(sayi); bunu aşağıda sorted olarak koyduk


    }

    private static void ciftKareKucuktenBuyuge(List<Integer> sayi) {
        // sorted natural order yapar
        // Listteki sort gibi
        sayi.stream().filter(Lambda02::ciftBul).map(t -> t * t).sorted().forEach(Lambda01::yazdir); // 4 16 36
    }
}
