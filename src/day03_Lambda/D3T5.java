package day03_Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D3T5 {

    //distinct() => Bu method tekrarlı elemanları sadece bir kere yazdırır. Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
    // Sıralı akışlar için, farklı elemanın seçimi sabittir (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
    // Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder.






    public static void main(String[] args) {
        // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
        List<String> menu = new ArrayList<String>(Arrays.asList("küşleme", "adana", "triliçe", "havuçDilim", "buryan",
                "yağlama", "kokoreç", "arabaşı", "güveç", "triliçe", "triliçe", "triliçe"));

        alfabetikBuyukHarfTekrarsiz(menu);


    }

    private static void alfabetikBuyukHarfTekrarsiz(List<String> yemek) {
        // sorted - natural order yaptı
        // distinct - benzersiz hale getirdi tekrar eden varsa birini sildi
        // 1. yöntem(distinct yok)
        yemek.stream().map(t -> t.toUpperCase()).sorted().forEach(t -> System.out.print(t + " "));

        System.out.println();

        // 2. yöntem(distinct var)
        yemek.stream().map(String::toUpperCase).sorted().distinct().forEach(D3T5::yazdirString);
    }

    public static void yazdirString(String a) {
        System.out.print(a + " ");
    }


}
