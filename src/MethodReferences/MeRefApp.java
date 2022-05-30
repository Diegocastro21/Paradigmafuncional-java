package MethodReferences;

import java.util.Arrays;
import java.util.Comparator;
public class MeRefApp {
    public static void main(String[] args) {
        MeRefApp app = new MeRefApp();
        app.operar();
        app.referenciarMetodoInstanciaObjetoArbitrario();
        Operaction op = app::referenciarMetodoInstanciaObjetoParticular;
        op.saludar();

        app.referenciarConstructor();
    }

    public static void referenciarMetodoStatic(){
        System.out.println("Metodo Referido static");
    }

    public void referenciarMetodoInstanciaObjetoArbitrario(){
        String[] nombres = {"Monteria", "Cartagena", "Jamaica", "Barranquilla", "Buenaventura"};

        /*Arrays.sort(nombres, new Comparator<String>()){
            @Override
            public int compare(String o1, String o2){
                return o1.compareToIgnoreCase(o2);
            }
        }*/

        //reducirlo aun mas
        /*Arrays.sort(nombres, (s1,s2) -> s1.compareToIgnoreCase(s2));
        System.out.println(Arrays.toString(nombres));*/

        Arrays.sort(nombres, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(nombres));
    }

    public void referenciarMetodoInstanciaObjetoParticular(){
        System.out.println("Metodo Referido Instancia de Clase");
    }

    public void referenciarConstructor(){
        /*IPersona iper = new IPersona() {
            @Override
            public Persona crear(int id, String nombre) {
                return null;
            }
        };
        iper.crear(1, "Managua");*/

        /*IPersona iper2 = (x,y) -> (new Persona(x,y));
        Persona  per = iper2.crear(1, "Managua");
        System.out.println(per.getId()+"    -   "+per.getNombre());*/

        IPersona iper3 = Persona::new;
        Persona per = iper3.crear(1, "Monteria");
        System.out.println(per.getId()+"    -   "+per.getNombre());
    }

    public void operar(){
        /*Operaction op = () -> MeRefApp.referenciarMetodoStatic();
        op.saludar();*/

        Operaction op2 = MeRefApp::referenciarMetodoStatic;
        op2.saludar();
    }
}
