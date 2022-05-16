package day02_Lambda;

import day01_lambda.Lambda02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class D2T3 {

    public static void main(String[] args) {

        // Task : List'in cift elemanlarin karelerinin en buyugunu print ediniz
        List<Integer> sayi = new ArrayList<Integer>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));
        ciftKareninBuyugu(sayi);

    }

    private static void ciftKareninBuyugu(List<Integer> sayi) {
        Optional<Integer> max = sayi.stream().filter(Lambda02::ciftBul).map(t -> t * t).reduce(Math::max);
        System.out.println(max); // Optional[36]
        // ya da (yazdırmak için)
        System.out.println(sayi.stream().filter(Lambda02::ciftBul).map(t -> t * t).reduce(Math::max));

        // math class alternatifi ama math daha kapsamlı, ama Integer Math'e göre daha dar olduğu için daha hızlı çalışır
        System.out.println(sayi.stream().filter(Lambda02::ciftBul).map(t -> t * t).reduce(Integer::max));


    }
}
