package Anotaciones;

public @interface AnnotacionCustom {

    String nombre();
    boolean habilitado() default true;
}
