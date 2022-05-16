package day03_Lambda;

import day01_lambda.Lambda01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class D3T6 {

    public static void main(String[] args) {

        // Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
        List<String> menu = new ArrayList<String>(Arrays.asList("küşleme", "adana", "triliçe", "havuçDilim", "buryan",
                "yağlama", "kokoreç", "arabaşı", "güveç", "triliçe", "triliçe", "triliçe"));

        chrSayisiTersSirali(menu);

    }

    private static void chrSayisiTersSirali(List<String> menu) {
        menu.stream().map(t -> t.length()).sorted(Comparator.reverseOrder()).distinct().forEach(Lambda01::yazdir); // 10 7 6 5
        menu.stream().map(String::length).sorted(Comparator.reverseOrder()).distinct().forEach(Lambda01::yazdir); // 10 7 6 5
    }
}
