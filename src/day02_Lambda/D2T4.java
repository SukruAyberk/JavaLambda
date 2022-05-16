package day02_Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class D2T4 {

    public static void main(String[] args) {

        // Task : list'in en buyuk elemanini yazdiriniz
        List<Integer> sayi = new ArrayList<Integer>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));
        maxElemanBul(sayi);
    }

    /*
        reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
        kullanımı yaygındır pratiktir.
        Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
         bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
        reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
        reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
        İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.

    */

    private static void maxElemanBul(List<Integer> sayi) {
        // reduce akışa giren elemanların action sonrasında tek eleman haline getirir
        // yani bir listedem sadece bir çıktı alacaksak bunu kullanacağız
        Optional<Integer> maxSayi = sayi.stream().reduce(Math::max);
        System.out.println(maxSayi);
        // yada
        System.out.println("sout içinde " + sayi.stream().reduce(Math::max));
    }
}
