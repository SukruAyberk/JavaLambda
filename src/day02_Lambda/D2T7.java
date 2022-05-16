package day02_Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D2T7 {

    public static void main(String[] args) {

        // Task : List'teki tum elemanlarin toplamini yazdiriniz.
        //Lambda Expression...
        List<Integer> sayi = new ArrayList<Integer>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));

        elemanlariTopla(sayi);

    }

    private static void elemanlariTopla(List<Integer> sayi) {
        System.out.println(sayi.stream().reduce(Integer::sum)); // bu method reference dir Çıktı: Optional[43]
        int toplam = sayi.stream().reduce(0, (x, y) -> x + y); // Lambda Expression
        System.out.println(toplam); // Çıktı: 43

        /*
        x ilk değerini her zaman atanan değerden(identity) alır
        y değeri her zaman akıştan alır
        x ilk değerinden sonraki her değeri aksiyondan alır
        yani x = 0, y = 4, x+y = 4 -> x = 4, y = 2, x + y = 6 -> x = 6 vs...
         */
    }
}
