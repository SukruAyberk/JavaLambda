package day6_Lambda;

import day03_Lambda.D3T5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda06 {

    public static void main(String[] args) throws IOException {

        Path ayberk = Path.of("src/day6_Lambda/haluk.txt"); // path ayberk objesine atandı
        Stream<String> akis = Files.lines(ayberk);// haluk.txt dataları akış streame atandı

        //TASK 01 --> haluk.txt dosyasini okuyunuz.(Console'a print ediniz.)
        // 1. yol
        System.out.println("\nTASK 01 --> haluk.txt dosyasini okuyunuz -->  ");
        Files.lines(ayberk). // Files class'dan lines methodu call edilerek data çekilecek dosya yolu(path) parametre girilerek pathdeki odsyanın dataları akışa alındı
                // forEach(D3T5::yazdirString); akıştaki datalar(her satırdaki string) yazıldı ama bu şekilde yan yana yazar
                        forEach(System.out::println);

        System.out.println();

        // 2. yol
        System.out.println("\nTASK 01 --> haluk.txt dosyasini okuyunuz -->  ");
        akis.forEach(System.out::println);


        //TASK 02 --> haluk.txt dosyasini buyuk harflerle okuyunuz.(Console'a buyuk harflerle print ediniz.)
        System.out.println("\nTASK 02 --> haluk.txt dosyasini buyuk harflerle okuyunuz -->  ");
        Files.lines(Paths.get("src/day6_Lambda/haluk.txt")). // txt içini okuduk
                map(String::toUpperCase). // text içindeki stringleri string manpulation ile büyük harf yaptık
                forEach(System.out::println); // akıştaki bütün stringler yazıldı

        //TASK 03 --> haluk.txt dosyasindaki ilk satiri kucuk harflerle print ediniz..
        System.out.println("\nTASK 03 --> haluk.txt dosyasindaki ilk satiri kucuk harflerle okuyunuz 01 -->  ");

        // 1. yol limit
        Files.lines(ayberk).
                map(String::toLowerCase).
                limit(1).
                forEach(System.out::println);

        // 2. yol findsfirst
        System.out.println(Files.lines(ayberk).findFirst().map(String::toLowerCase));


        //TASK 04 --> haluk.txt dosyasinda "basari" kelimesinin kac satirda gectiginiz print ediniz.
        System.out.println("\nTASK 04 --> haluk.txt dosyasinda basari kelimesinin kac satirda gectiginiz yazdiriniz -->  ");
        System.out.println(Files.lines(ayberk).
                map(String::toLowerCase).
                filter(t -> t.contains("basari")).
                count());


        //TASK 05 --> haluk.txt dosyasindaki farkli kelimeleri  print ediniz..
        System.out.println("\nTASK 05 --> haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz. -->  ");

        /*
        Stream.flatMap, adıyla tahmin edilebileceği gibi, bir map ve flat işleminin birleşimidir. Bu, ilk önce elemanlarınıza bir
        fonksiyon uyguladığınız ve daha sonra düzleştirdiğiniz anlamına gelir.
        Stream.map yalnızca akışı düzleştirmeden bir işlevi uygular.

        Bir akışın düzleştirme'in neyi içerdiğini anlamak için, "iki seviye" olan [ [1,2,3],[4,5,6],[7,8,9] ] gibi bir yapı düşünün.
        Bunun düzleştirilmesi, "bir seviye" yapısında dönüştürülmesi anlamına gelir: [ 1,2,3,4,5,6,7,8,9 ].
        flatMap yöntemi, bir akışın her bir değerini başka bir akışla değiştirmenizi sağlar
        ve ardından oluşturulan tüm akışları tek bir akışa birleştirir.
        */

        // 1. yol
        System.out.println(Files.lines(ayberk).
                map(t -> t.split(" ")). // satırdaki elemanlar arraye atandı
                        flatMap(Arrays::stream). // 2D arraydeki elemanlar tek arraye döndü ve akışa alındı flatMap sayesinde
                        distinct(). // benzersiz yaptık
                        collect(Collectors.toList())); // listeye aldık

        // 2. yol set olduğu için distincte gerek yok
        System.out.println(Files.lines(ayberk).
                map(t -> t.split(" ")).
                flatMap(Arrays::stream).
                collect(Collectors.toSet()));


        //TASK 06 --> haluk.txt dosyasindaki tum kelimeleri natural order  print ediniz..
        System.out.println("\nTASK 06 --> haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz. -->  ");
        Files.lines(ayberk).
                map(t -> t.split(" ")). //satırlardaki kelimeler arraya atandı
                flatMap(Arrays::stream). //2D arraydaki elelmanlar tek eleman olarak akısa alındı
                sorted(). //harf sırası yapıldı
                forEach(System.out::println); //print edildi


        //TASK 07 --> haluk.txt dosyasinda "basari" kelimesinin kac kere gectigini buyuk harf kucuk harf bagımsız print ediniz.
        System.out.println("\nTASK 07 --> haluk.txt dosyasinda basari kelimesinin kac kere gectigini  yazdiriniz. -->  ");
        System.out.println(Files.lines(ayberk).
                map(t -> t.toLowerCase().split(" ")). // kelimeleri ayırıp arraye attık
                        flatMap(Arrays::stream). // 2D array 1D oldu
                        filter(t -> t.equals("basari")). // basariyı aradık
                        count()); // saydırdık

        //TASK 08 --> haluk.txt dosyasinda "a" harfi gecen kelimelerin sayisini print eden  programi create ediniz.
        System.out.println("\nTASK 08 --> haluk.txt dosyasinda a harfi gecen kelimelerin sayisini ekrana yazdiran programi yazdiriniz. -->  ");
        System.out.println(Files.lines(ayberk). //txt dosyasıne erişldi
                map(t -> t.split(" ")). //satırlar akısa alındı
                flatMap(Arrays::stream). //her satırdaki her kelime akısa alındı
                filter(t -> t.contains("a")). //a bulunduran kelimeler fitrelenedi
                count()); //a bulunduran kelimeler sayıldı


        //TASK 09 --> haluk.txt dosyasinda icinde "a" harfi gecen kelimeleri print ediniz.
        System.out.println("\nTASK 09 --> haluk.txt dosyasinda a harfi gecen kelimeler yazdiriniz. -->  ");
        Files.lines(ayberk).
                map(t -> t.split(" ")). //satırlar akısa alındı
                flatMap(Arrays::stream). //her satırdaki her kelime akısa alındı
                filter(t -> t.contains("a")). //a bulunduran kelimeler fitrelenedi
                collect(Collectors.toList()).
                forEach(System.out::println);


        //TASK 10 --> haluk.txt dosyasinda kac /farklı harf kullanildigini print ediniz.
        System.out.println("\nTASK 10 --> haluk.txt dosyasinda kac /farklı harf kullanildigini  yazdiriniz. -->  ");
        System.out.println(Files.lines(ayberk).
                map(t -> t.replaceAll("\\W", "").replace("\\d", ""). //satırlar \\W ifadesi a-z A-Z 0-9 _ disindakileri kapsar
                        split("")). //harf akısı saglanır
                        flatMap(Arrays::stream).
                distinct().
                count());


        //TASK 11 --> haluk.txt dosyasinda kac farkli kelime kullanildigini print ediniz.
        System.out.println("\nTASK 11 --> haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");
        System.out.println(Files.lines(ayberk).
                map(t -> t.replaceAll("[.!,:)\\-]", " ").
                        split(" ")). //kelime akısı saglanır
                        flatMap(Arrays::stream).
                distinct().
                count());

        //TASK 12 --> haluk.txt dosyasinda  farkli kelimeleri print ediniz
        System.out.println("\nTASK 12 --> haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");
        Files.lines(ayberk).
                map(t -> t.replaceAll("[.!,:)\\-]", " ").
                        split(" ")).
                flatMap(Arrays::stream).
                distinct().
                forEach(System.out::println);

        // gitle bağlandı

    }
}
