package Streams;
import java.util.ArrayList;
import java.util.List;
public class ParallelStream {

    private List<Integer> numeros;

    public void llenar(){
        numeros = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numeros.add(i);
        }
    }

    public void probarStream(){
        numeros.stream().forEach(System.out::println);
    }

    public void probarParalelo(){
        numeros.parallelStream().forEach(System.out::println);
    }

    public static void main(String[] args) throws InterruptedException{
        ParallelStream app = new ParallelStream();

        app.llenar();
        app.probarStream();
        System.out.println();
        System.out.println();
        app.probarParalelo();
    }
}
