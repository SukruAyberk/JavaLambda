package day4_Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D4T2 {

    public static void main(String[] args) {

        // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
        List<String> menu = new ArrayList<String>(Arrays.asList("küşleme", "adana", "triliçe", "havuçDilim", "buryan",
                "yağlama", "kokoreç", "arabaşı", "güveç", "triliçe", "triliçe", "triliçe"));

        harfSayisiYedidenBuyukMuKucukMu(menu);
    }

    private static void harfSayisiYedidenBuyukMuKucukMu(List<String> menu) {
        //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
        //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
        //noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

        // allMatch hepsini kontrol et demek hepsinin 7den küçük olup olmadığını kontrol edicek
        // allMatch reduce gibidir sonrasında bir şey yazılmaz
        // bütün elemanların length'i 7 ve az olsaydı true olurdu
        // sonuca göre true/false döndürecek

        // amele code
        boolean kontrol = menu.stream().allMatch(t -> t.length() <= 7);
        if (kontrol) {
            System.out.println("list elemanları 7 ve daha az harften oluşuyor");
        } else {
            System.out.println("list elemanları 7'den daha fazla harften oluşuyor");
        }
        // kolay code
        System.out.println(menu.stream().allMatch(t -> t.length() <= 7) ?
                "list elemanları 7 ve daha az harften oluşuyor" : "list elemanları 7'den daha fazla harften oluşuyor");
    }
}
