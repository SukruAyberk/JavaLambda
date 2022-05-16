package day5_Lambda;

import day01_lambda.Lambda01;
import day01_lambda.Lambda02;

import java.util.stream.IntStream;

public class Lambda05 {

    public static void main(String[] args) {

        System.out.println("TASK 01 amele topla-->" + ameleTopla(10));
        System.out.println("TASK 01 cincix topla-->" + cincixTopla(10));
        System.out.println("   ***   ");

        System.out.println("TASK 02 -->" + toplaCift(10));//2+4+6+8+10 =30
        System.out.println("   ***   ");

        System.out.println("TASK 03 -->" + toplaIlkCift(10));//2+4+6+...+18+20=110
        System.out.println("   ***   ");

        System.out.println("TASK 04 -->" + toplaIlkTek(10));//1+3+5+...+19=100
        System.out.println("   ***   ");

        System.out.println("TASK 05 -->");
        ikininIlkXKuvvetPrint(7);
        System.out.println();
        System.out.println("   ***   ");

        System.out.println("TASK 06 -->");
        istenilenSayininIlkXKuvveti(4, 3);
        System.out.println();
        istenilenSayininIlkXKuvveti(3, 4);
        System.out.println();
        istenilenSayininIlkXKuvveti(14531453, 0);
        System.out.println();
        System.out.println("   ***   ");

        System.out.println("TASK 07 -->" + istenilenSayininFaktoriyeli(5));//1*2*3*...*5=120
        System.out.println("   ***   ");

        System.out.println("TASK 08 -->" + istenilenSayininXKuvveti1(4, 3));//64
        System.out.println("TASK 08 -->" + istenilenSayininXKuvveti2(4, 3));//64
        System.out.println("   ***   ");


    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program create ediniz.

    //Structured(AMELE) Programming
    public static int ameleTopla(int x) {
        int toplam = 0;
        for (int i = 1; i <= x; i++) {
            toplam += i;
        }
        return toplam;
    }

    //Functional(cincix) Programming

    public static int cincixTopla(int x) {
        return IntStream.
                rangeClosed(1, x + 1). // 1den x'e kadar (x dahil, x + 1 hariç) int değerlerini akışa aldı
                        sum(); // akıştaki int değerlerini topladı
    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int toplaCift(int x) {
        return IntStream.
                rangeClosed(1, x). // 1den x'e kadar (x dahil) int değerlerini akışa aldı
                        filter(Lambda02::ciftBul).
                sum();
    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
    public static int toplaIlkCift(int x) {
        return IntStream.
                iterate(2, t -> t + 2). // 2den sonsuza kadar elemanları 2 artırarak akışa alır
                        limit(x). // akıştaki ilk x int değeri akışa alır
                        sum();
    }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static int toplaIlkTek(int x) {
        return IntStream.
                iterate(1, t -> t + 2). // 1den sonsuza kadar elemanları 2 artırarak akışa alır
                        limit(x). // akıştaki ilk x int değeri akışa alır
                        sum();
    }

    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ikininIlkXKuvvetPrint(int x) {
        IntStream.
                iterate(2, t -> t * 2). // 2den sonsuza kadar elemanları 2 ile çarparak akışa alır
                limit(x). // akıştaki ilk x int değeri akışa alır
                forEach(Lambda01::yazdir);
    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void istenilenSayininIlkXKuvveti(int istenenSayi, int x) {
        IntStream.
                iterate(istenenSayi, t -> t * istenenSayi). // istenenSayidan sonsuza kadar elemanları istenenSayi ile çarparak akışa alır
                limit(x). // akıştaki ilk x int değeri akışa alır
                forEach(Lambda01::yazdir);
    }

    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
    public static int istenilenSayininFaktoriyeli(int x) {
        return IntStream.
                rangeClosed(1, x).
                //reduce(Math::multiplyExact).
                        reduce(1, (t, u) -> t * u);
    }

    //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi  create ediniz.
    public static double istenilenSayininXKuvveti1(int istenenSayi, int x) {
        return Math.pow(istenenSayi, x);
    }

    public static int istenilenSayininXKuvveti2(int istenenSayi, int x) {
        return IntStream.iterate(istenenSayi, t -> t * istenenSayi).limit(x).reduce(0, (t, u) -> u);
    }

}
