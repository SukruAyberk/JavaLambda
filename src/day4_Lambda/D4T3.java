package day4_Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D4T3 {

    public static void main(String[] args) {

        // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
        List<String> menu = new ArrayList<String>(Arrays.asList("küşleme", "adana", "triliçe", "havuçDilim", "buryan",
                "yağlama", "kokoreç", "arabaşı", "güveç", "triliçe", "triliçe", "triliçe"));

        wIleBasliyorMu(menu);
    }

    private static void wIleBasliyorMu(List<String> menu) {
        System.out.println(menu.stream().noneMatch(t -> t.startsWith("W")) ? "Hiçbir eleman W ile başlamıyor" : "En az bir eleman W ile başlıyor");

    }
}
