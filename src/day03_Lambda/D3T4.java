package day03_Lambda;

import day01_lambda.Lambda01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class D3T4 {

    public static void main(String[] args) {

        // Task : list'in tek  elemanlarinin kareleri ni buykten kucuge  print ediniz.
        List<Integer> sayi = new ArrayList<Integer>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));
        tekKareBuyuktenKucuge(sayi);
    }

    private static void tekKareBuyuktenKucuge(List<Integer> sayi) {
        sayi.stream().filter(t -> t % 2 != 0).map(t -> t * t).sorted(Comparator.reverseOrder()).forEach(Lambda01::yazdir);
    }
}
