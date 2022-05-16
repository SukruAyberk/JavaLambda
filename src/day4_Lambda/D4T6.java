package day4_Lambda;

import day03_Lambda.D3T5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class D4T6 {

    public static void main(String[] args) {

        // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
        List<String> menu = new ArrayList<String>(Arrays.asList("küşleme", "adana", "triliçe", "havuçDilim", "buryan",
                "yağlama", "kokoreç", "arabaşı", "güveç", "triliçe", "triliçe", "triliçe"));

        sonHarfeGore(menu);

    }

    private static void sonHarfeGore(List<String> menu) {

        //skip(1) => atlama demek. Akışın ilk n elemanını attıktan sonra bu akışın kalan elemanlarından oluşan bir akış return eder.
        // Bu akış n'den daha az öğe içeriyorsa, boş bir akış döndürülür. Bu, durum bilgisi olan bir ara işlemdir.
        //skip(list.size()-1) => List'in uzunluğunun 1 eksiğini yazarsak son elemanı yazdırırız.

        menu.
                stream(). // akışa girdi
                sorted(Comparator.comparing(t -> t.charAt(t.length() - 1))). // son garfe göre sıralandı
                skip(1). // ilk eleman atlandı
                forEach(D3T5::yazdirString); // print
    }
}
