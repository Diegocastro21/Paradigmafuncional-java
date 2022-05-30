package Colecciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
public class ColeccionApp {

    private List<String> lista;

    public void llenarLista(){
        lista = new ArrayList<>();

        lista.add("Manizales");
        lista.add("Monteria");
        lista.add("Cartagena");
        lista.add("Buenaventura");
        lista.add("Guajira");
    }

    public void usarForEach(){
        /*for (String elemento: lista) {
            System.out.println(elemento);
        }*/

        //lista.forEach(x -> System.out.println(x));
        lista.forEach(System.out::println);
    }

    public void usarRemoveIf() {
        /*Iterator<String> it = lista.iterator();
        while(it.hasNext()){
            if (it.next().equalsIgnoreCase("Cartagena")) {
                it.remove();
            }
        }*/

        lista.removeIf(x -> x.equalsIgnoreCase("Cartagena"));
    }

    public void usarSort(){
        lista.sort((x,y) -> x.compareTo(y));
    }

    public static void main(String[] args) {
        ColeccionApp app = new ColeccionApp();
        app.llenarLista();
        app.usarForEach();
        app.usarRemoveIf();
        System.out.println();
        app.usarForEach();
        app.usarSort();
        System.out.println();
        app.usarForEach();
    }
}
