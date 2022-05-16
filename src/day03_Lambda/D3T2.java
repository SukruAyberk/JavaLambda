package day03_Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class D3T2 {

    public static void main(String[] args) {

        // Task : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
        List<Integer> sayi = new ArrayList<Integer>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));
        bestenKucukTekSayiPrint(sayi);

    }

    private static void bestenKucukTekSayiPrint(List<Integer> sayi) {
        Optional<Integer> i = sayi.stream().filter(t -> t > 5 && t % 2 != 0).reduce(Integer::min);
        System.out.println(i);
    }

}
