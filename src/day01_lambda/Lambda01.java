package day01_lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {

    public static void main(String[] args) {

        /*
   1) D2T4 "Functional Programming"-->mathod(action) kullanma pr dili.
      D2T4 --> mathod create  etme değil mevcut method'ları(library)secip kullanmaktır...
      D2T4  kendi başına tanımlanabilen parametre alıp gönderebilen fonksiyonlardır.
      D2T4'lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
      Java 8 ile gelen bu özellik, Java 8’in en önemli özelliğidir.

      "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
   2) "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
   3) "Functional Programming" hiz, code kisaligi, code okunabilirligi
       ve hatasiz code yazma acilarindan cok faydalidir.
   4) D2T4 sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.
      D2T4 kullanmak hatasız code kullanmaktır.

          Collections Nedir?
          Çoğu yazılım tek tek öğeler yerine öğelerden oluşan toplulukları depolar ve onlar üzerinde işlem
          yapar. Array'ler onlardan birisidir. Java Collections Framework, arraylerle yapılan işleri daha kolay
          yaptığı gibi, daha fazlasını da yapar.
          Java'da bir koleksiyon (collection - bazen container, ambar diye adlandırılır) nesnelerden oluşan bir
          topluluğu bir arada tutan bir yapıdır. 'Collections Framework' ise arayüzler ve onların kurgularından
          (implementations) oluşur.
*/

        List<Integer> sayi = new ArrayList<Integer>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));

        // Task - 1 : Structured Programming kullanarak list elemanlarını aynı satırda+ aralarında boşluk olacak şekilde print et
        // bu bizim bildiğimiz(amelelik), bunun altına lambda(functional) ile çalışıcaz
        printEtStructured(sayi); // 34 22 16 11 35 20 63 21 65 44 66 64 81 38 15

        System.out.println("\n******");

        // Task - 1 : Functional Programming kullanarak list elemanlarını aynı satırda+ aralarında boşluk olacak şekilde print et lambda(functional) ile
        printEtFuntional1(sayi); // 34 22 16 11 35 20 63 21 65 44 66 64 81 38 15

        System.out.println("\n******");

        printEtFuntional2(sayi); // 342216113520632165446664813815

        System.out.println("\n******");

        printEtFuntional3(sayi); // 34 22 16 11 35 20 63 21 65 44 66 64 81 38 15

        System.out.println("\n******");

        printEtFuntional4(sayi); // 34 22 16 11 35 20 63 21 65 44 66 64 81 38 15
    }

    public static void printEtStructured(List<Integer> sayi) {
        for (Integer i : sayi) {
            System.out.print(i + " ");
        }
    }

    public static void printEtFuntional1(List<Integer> sayi) {
        sayi.stream().forEach(t -> System.out.print(t + " "));
    }
    /*
 stream() : datalari yukaridan asagiya akis sekline getirir. Stream bir interface olduğundan dolayı doğrudan nesne almaz.
 forEach() :datanin parametresine gore her bir elemanı isler
 t-> : D2T4 operatoru
  D2T4 Expression-->(parameter list) -> {action body}
      Parameter list: Fonksiyonun parametreleri tanımlanır. Hiç parametre geçirmeden boşta olabilir.
      -> Arrow-token: Argüman listesi ile expression gövdesini birbirine bağlamak için kullanılır.
      Body: Expressionları ve statementları içerir.

     Bir kod bloğundan oluşan bir body...
     Bu tip lambda body, block body olarak bilinir. Blok gövdesi, lambda gövdesinin birden çok ifade içermesine izin verir.
     Bu ifadeler parantez içine alınır ve parantezlerden sonra noktalı virgül eklemeniz gerekir.

         () -> {
          double pi = 3.1415;
             return pi;
         };
  Trick: D2T4 Expression yapisi cok tavsiye edilmez daha cok METHOD REFERENCE kullanilir

 */

    public static void printEtFuntional2(List<Integer> sayi) {
        sayi.stream().forEach(System.out::print); // Method reference --> System.out yapısından print methodu refere et
        // Ama bunda araya boşluk koyamayız yani method reference(printEtFuntional2) bazen ihtiyaçlarımızı karşılamaz
        // bu durumda mecbur lambda expression (printEtFuntional1) kullancaz
    }

    public static void yazdir(int a) { // yazdırmak için method create ettim
        System.out.print(a + " ");
    }

    public static void printEtFuntional3(List<Integer> sayi) {
        sayi.stream().forEach(t -> yazdir(t));
        // ama bunun yerine printEtFuntional4 kullan!
    }

    public static void printEtFuntional4(List<Integer> sayi) {
        sayi.stream().forEach(Lambda01::yazdir);
    }


}
