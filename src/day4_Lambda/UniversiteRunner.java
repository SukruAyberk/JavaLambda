package day4_Lambda;

import java.util.*;
import java.util.stream.Collectors;

public class UniversiteRunner {


    public static void main(String[] args) {

        Universite bogazici = new Universite("bogazici", "matematik", 571, 93);
        Universite itu = new Universite("istanbul teknik", "matematik", 622, 81);
        Universite istanbul = new Universite("istanbul", "hukuk", 1453, 71);
        Universite marmara = new Universite("marmara", "bilgisayar muh", 1071, 77);
        Universite ytu = new Universite("yıldız teknik", "gemi", 333, 74);

        List<Universite> uniList = new ArrayList<Universite>(Arrays.asList(bogazici, itu, istanbul, marmara, ytu));

        // // return typelı method olduğu için değişkene atamak yerinde direkt yazdırdık
        System.out.println(notOrt74denBuyukUnv(uniList)); // false çünkü 74'ten küçük bir tane var
        System.out.println(ogrSayisiKontrol(uniList)); // true
        System.out.println(matematikVarMi(uniList)); // true
        System.out.println(ogrSayiBkSirala(uniList));
        ogrSayiBkSiralaVoid(uniList);
        System.out.println(notOrtBkSiraliIlkUc(uniList));
        System.out.println(ogrSayisiEnAzOlanIkinciUni(uniList));
        System.out.println(notOrt63BykUnvOgrcSayisiTopla(uniList));
        System.out.println(ogrSayisi333BykNotOrtOrtalamaAl(uniList));
        System.out.println(matBolumSayisi(uniList));
        System.out.println(ogr130danFazlaOlanUnilerinEnBykNotOrt(uniList));
        System.out.println(ogr150denAzOlanUnilerinEnKckNotOrt(uniList));
    }

    //task 01--> notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.
    public static boolean notOrt74denBuyukUnv(List<Universite> uniList) {
        return uniList.
                stream().
                allMatch(t -> t.getNotOrt() > 74);
    }

    //task 02-->ogrc sayilarinin 110 den az olmadigini kontrol eden pr create ediniz.
    public static boolean ogrSayisiKontrol(List<Universite> uniList) {
        return uniList.stream().allMatch(t -> t.getOgrSayisi() > 110);
    }

    //task 03-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.
    public static boolean matematikVarMi(List<Universite> uniList) {
        return uniList.stream().anyMatch(t -> t.getBolum().equals("matematik"));
    }

    //task 04-->universite'leri ogr sayilarina gore b->k siralayiniz.

    // collect()-> akıştaki elemanları istenen şarta göre toplar
    // Collectors.toList()-> collect'e toplanan elemanları liste çevirir
    public static List<Universite> ogrSayiBkSirala(List<Universite> uniList) {
        return uniList.stream().sorted(Comparator.comparing(Universite::getOgrSayisi).reversed()).collect(Collectors.toList());
    }

    public static void ogrSayiBkSiralaVoid(List<Universite> uniList) {
        System.out.println(uniList.stream().sorted(Comparator.comparing(Universite::getOgrSayisi).reversed()).collect(Collectors.toList()));
    }

    //task 05-->universite'leri notOrt gore  b->k siralayip ilk 3 'unu print ediniz.
    public static List<Universite> notOrtBkSiraliIlkUc(List<Universite> uniList) {
        // limite aldığımız için stream çevirir referans yazdırır bunları bir collection'a atmak lazım
        return uniList.stream().sorted(Comparator.comparing(Universite::getNotOrt).reversed()).limit(3).collect(Collectors.toList());
    }

    //task 06--> ogrc sayisi en az olan 2. universite'yi  print ediniz.
    public static List<Universite> ogrSayisiEnAzOlanIkinciUni(List<Universite> uniList) {
        return uniList.stream().sorted(Comparator.comparing(Universite::getOgrSayisi)).limit(2).skip(1).collect(Collectors.toList());
    }

    //task 07--> notOrt 63 'den buyuk olan universite'lerin ogrc sayilarini toplamini print ediniz
    public static int notOrt63BykUnvOgrcSayisiTopla(List<Universite> uniList) {
        return uniList.
                stream().
                filter(t -> t.getNotOrt() > 63).
                map(t -> t.getOgrSayisi()).
                // reduce(Integer::sum);
                // reduce(Math::addExact);
                        reduce(0, (t, u) -> t + u);

    }

    //task 08--> Ogrenci sayisi 333'dan buyuk olan universite'lerin notOrt'larinin ortalamasini bulunuz.
    public static OptionalDouble ogrSayisi333BykNotOrtOrtalamaAl(List<Universite> uniList) {
        // avatage ortalama alır
        return uniList.stream().filter(t -> t.getOgrSayisi() > 333).mapToDouble(t -> t.getNotOrt()).average();
    }

    //task 09-->"matematik" bolumlerinin sayisini  print ediniz.
    public static long matBolumSayisi(List<Universite> uniList) {
        // count saydırır
        return uniList.stream().filter(t -> t.getBolum().equalsIgnoreCase("matematik")).count();
    }

    //task 10-->Ogrenci sayilari 571'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz
    public static OptionalInt ogr130danFazlaOlanUnilerinEnBykNotOrt(List<Universite> uniList) {
        // max akışın en büyük değerini return eder
        return uniList.stream().filter(t -> t.getOgrSayisi() > 571).mapToInt(t -> t.getNotOrt()).max();
    }

    //task 11-->Ogrenci sayilari 1071'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.
    public static OptionalInt ogr150denAzOlanUnilerinEnKckNotOrt(List<Universite> uniList) {
        // min akışın en küçük değerini return eder
        return uniList.stream().filter(t -> t.getOgrSayisi() < 1071).mapToInt(t -> t.getNotOrt()).min();
    }
}
