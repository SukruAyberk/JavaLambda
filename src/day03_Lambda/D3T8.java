package day03_Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class D3T8 {

    public static void main(String[] args) {

        // Task : list elemanlarinin son harfine gore ters sirali print ediniz.
        List<String> menu = new ArrayList<String>(Arrays.asList("küşleme", "adana", "triliçe", "havuçDilim", "buryan",
                "yağlama", "kokoreç", "arabaşı", "güveç", "triliçe", "triliçe", "triliçe"));

        sonHarfeGoreTersSirali(menu);

    }

    private static void sonHarfeGoreTersSirali(List<String> menu) {
        menu.stream().sorted(Comparator.comparing(t -> t.toString().charAt(t.toString().length() - 1)).reversed()).forEach(D3T5::yazdirString);
    }
}
