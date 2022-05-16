package day4_Lambda;

import day01_lambda.Lambda01;
import day01_lambda.Lambda02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class D4T1 {

    public static void main(String[] args) {

        // Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz..
        List<String> menu = new ArrayList<String>(Arrays.asList("küşleme", "adana", "triliçe", "havuçDilim", "buryan",
                "yağlama", "kokoreç", "arabaşı", "güveç", "triliçe", "triliçe", "triliçe"));

        charKaresiCiftSirala(menu);
    }

    private static void charKaresiCiftSirala(List<String> menu) {
        menu.stream().map(t -> t.length() * t.length()).filter(Lambda02::ciftBul).distinct().sorted(Comparator.reverseOrder()).forEach(Lambda01::yazdir);
    }
}
