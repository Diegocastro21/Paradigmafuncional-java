package Default;

public interface PersonaB {

    default public void hablar(){
        System.out.println("Saludos Persona B");
    }
}
