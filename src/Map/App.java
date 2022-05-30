package Map;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
public class App {

    private Map<Integer, String> map;

    public void poblar(){
        map = new HashMap<>();
        map.put(1, "Manizales");
        map.put(2, "Cartagena");
        map.put(3, "Cucuta");
        map.put(4, "Buenaventura");
        map.put(5, "Cali");
        map.put(6, "Barranquilla");
    }

    public void imprimir_v7(){
        for (Entry<Integer, String> e: map.entrySet()) {
            System.out.println("Llave: "+e.getKey() + " Valor: "+ e.getValue());
        }
    }

    public void imprimir_v8(){
        //map.forEach((k,v) -> System.out.println("Llave: "+k + " Valor: "+ v));

        map.entrySet().stream().forEach(System.out::println);
    }

    public void recolectar(){
        Map<Integer, String> mapaRecolectado = map.entrySet().stream()
                .filter(e -> e.getValue().contains("C"))
                .collect(Collectors.toMap(p -> p.getKey(), p->p.getValue()));

        mapaRecolectado.forEach((k,v) -> System.out.println("Llave: "+k+" Valor: "+v));
    }

    public void insertarSiAusente(){
        map.putIfAbsent(7, "San Andres Islas");
        map.putIfAbsent(4, "Medellin");
    }

    public void operarSiPresente(){
        map.computeIfPresent(3, (k,v) -> k + v);
        System.out.println(map.get(3));
    }

    public void obtenerOrPredeterminado(){
       String valor = map.getOrDefault(9, "valor por defecto");
        System.out.println(valor);
    }

    public static void main(String[] args) {
        App app = new App();

        app.poblar();
        app.imprimir_v8();
        System.out.println();
        app.insertarSiAusente();
        app.imprimir_v8();
        System.out.println();
        app.operarSiPresente();
        System.out.println();
        app.obtenerOrPredeterminado();
        System.out.println();
        app.recolectar();
    }


}
