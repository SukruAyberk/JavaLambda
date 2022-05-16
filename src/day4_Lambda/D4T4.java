package day4_Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D4T4 {

    public static void main(String[] args) {

        // Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.
        List<String> menu = new ArrayList<String>(Arrays.asList("küşleme", "adana", "triliçe", "havuçDilim", "buryan",
                "yağlama", "kokoreç", "arabaşı", "güveç", "triliçe", "triliçe", "triliçe"));

        xIleBitenVarMi(menu);
    }

    private static void xIleBitenVarMi(List<String> menu) {
        System.out.println(menu.stream().anyMatch(t -> t.endsWith("x")) ? "En az bir eleman x ile bitiyor" : "Hiçbir eleman x ile bitmiyor");
    }
}
