package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {
        // Function takes 1 argument and produces 1 result
        int increment = incrementByOne(1);
        System.out.println(increment);
        System.out.println("  ");

        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);
        System.out.println();

        int incrementTwo = incrementByTwoFunction.apply(10);
        System.out.println(incrementTwo);
        System.out.println();

        int multiply = multiplyBy10Function.apply(increment2);
        System.out.println(multiply);
        int multiplyOneHundred = multiplyBy100Function.apply(increment2);
        System.out.println(multiplyOneHundred);
        System.out.println();

        Function<Integer, Integer> addBy1AndThenMultiplyBy10 =
                incrementByOneFunction.andThen(multiplyBy10Function);
        System.out.println(addBy1AndThenMultiplyBy10.apply(5));

        Function<Integer, Integer> addBy2AndThenMultiplyBy100 = incrementByTwoFunction.andThen(multiplyBy100Function);
        System.out.println(addBy2AndThenMultiplyBy100.apply(6));
        System.out.println();

        // BiFunction takes 2 argument and produces 1 result
        System.out.println(
                incrementByOneAndMultiply(4, 100)
        );

        System.out.println(
                incrementByOneAndMultiplyBiFunction.apply(4, 100)
        );

        System.out.println(
                incrementByTwoAndMultiplyBiFunction.apply(4, 100)
        );
    }

    static Function<Integer, Integer> incrementByOneFunction =
            number -> number + 1;

    static Function<Integer, Integer> incrementByTwoFunction= number -> number + 2;

    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;
    static Function<Integer, Integer> multiplyBy100Function = number -> number * 100;



    static int incrementByOne(int number) {
        return number + 1;
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy)
                    -> (numberToIncrementByOne + 1) * numberToMultiplyBy;

    static BiFunction<Integer, Integer, Integer> incrementByTwoAndMultiplyBiFunction =
            (numero, numberMultiply)
                    -> (numero + 2) * numberMultiply;

    static int incrementByOneAndMultiply(int number, int numToMultiplyBy) {
        return (number + 1) * numToMultiplyBy;
    }
}
