package day03_Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class D3T7 {

    public static void main(String[] args) {

        // Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
        List<String> menu = new ArrayList<String>(Arrays.asList("küşleme", "adana", "triliçe", "havuçDilim", "buryan",
                "yağlama", "kokoreç", "arabaşı", "güveç", "triliçe", "triliçe", "triliçe"));

        chrSayisiBykKck(menu);

    }

    private static void chrSayisiBykKck(List<String> menu) {
        menu.stream().sorted(Comparator.comparing(String::length)).forEach(D3T5::yazdirString);
    }


}
