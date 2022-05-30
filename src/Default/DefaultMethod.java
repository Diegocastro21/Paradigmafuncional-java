package Default;

public class DefaultMethod implements PersonaA, PersonaB{


    public static void main(String[] args) {
        DefaultMethod app = new DefaultMethod();
        app.caminar();
        app.hablar();

    }

    @Override
    public void caminar() {
        System.out.println("Yohohohohohohohoh ");
    }

    @Override
    public void hablar() {
        PersonaB.super.hablar();
    }
}
