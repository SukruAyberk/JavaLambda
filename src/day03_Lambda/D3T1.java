package day03_Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class D3T1 {


    public static void main(String[] args) {

        // Task : List'teki elemanlardan en kucugunu 4 farklı yontem ile print ediniz.
        //1. yontem Method Reference --> Integer class
        //2. yontem Method Reference --> Math class
        //3. yontem Lambda Expression
        //4. yontem Method Reference --> Haluk class
        List<Integer> sayi = new ArrayList<Integer>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));
        enKucuk1(sayi);
        enKucuk2(sayi);

    }

    private static void enKucuk2(List<Integer> sayi) {
        Optional<Integer> minSayi1 = sayi.stream().reduce(Integer::min); // 1. Yöntem
        System.out.println(minSayi1);

        Optional<Integer> minSayi2 = sayi.stream().reduce(Math::min); // 2. Yöntem
        System.out.println(minSayi2);

        Integer minSayi3 = sayi.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y); // 3. Yöntem
        System.out.println(minSayi3);

        Optional<Integer> minSayi4 = sayi.stream().reduce(D3T1::enKucukBul);
        System.out.println(minSayi4);
    }


    private static void enKucuk1(List<Integer> sayi) {
        int min = Integer.MAX_VALUE;
        for (Integer i : sayi) {
            if (min > i) {
                min = i;
            }
        }
        System.out.println("En küçük sayı = " + min);
    }

    public static int enKucukBul(int i, int j) {

        return i < j ? i : j;
    }

    public static int enBuyukBul(int i, int j) {

        return i > j ? i : j;
    }
}
