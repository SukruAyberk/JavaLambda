package day4_Lambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class D4T5 {

    public static void main(String[] args) {

        // Task : Karakter sayisi en buyuk elemani yazdiriniz.
        List<String> menu = new ArrayList<String>(Arrays.asList("küşleme", "adana", "triliçe", "havuçDilim", "buryan",
                "yağlama", "kokoreç", "arabaşı", "güveç", "triliçe", "triliçe", "triliçe"));

        uzunluguEnFazlaOlanElemani(menu);
    }

    private static void uzunluguEnFazlaOlanElemani(List<String> menu) {
        // limitin içine 3 yazarsan ilk 3 elemanı alır
        // findFirst ilk elemanı alır

        //limit(a) akısdan cıkan elemanları a parametresine gore ilk a elamanı alır
        //limit(1) => Sınırlandırma demek. Bu akışın elemanlarından oluşan, uzunluğu maxSize'dan uzun olmayacak
        // şekilde kesilmiş bir akış return eder. Stream return eder.

        System.out.println(menu.stream().sorted(Comparator.comparing(t -> t.toString().length()).reversed()).findFirst()); // Optional[havuçDilim]

        // ya da
        Optional<String> enBuyuk = menu.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).reversed()).
                findFirst(); // bunun yerine limit(1) 'de yazılabilirdi
        System.out.println(enBuyuk); // Optional[havuçDilim]

        /*
            TRİCK :
            •Stream'ler ekrana direk yazdırılamaz. Stream'i toArray() ile Array'e çeviririz. Array'i de Arrays.toString() 'in içine alıp yazdırabiliriz.
            •Ör; System.out.println(Arrays.toString(***.toArray())); veya System.out.println(Arrays.asList(***.toArray())); kullanılabilir.

         */
        Stream<String> enBuyuk2 = menu.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).reversed()).
                limit(1);
        System.out.println(Arrays.toString(enBuyuk2.toArray())); // [havuçDilim]



    }
}
