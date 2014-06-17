package eu.lestard.advanced_bindings.api;

import javafx.beans.binding.Binding;
import javafx.beans.property.*;
import javafx.beans.value.*;

import java.util.function.BiFunction;
import java.util.function.Function;

import static eu.lestard.assertj.javafx.api.Assertions.*;

/**
 * This class contains test helper methods for {@link eu.lestard.advanced_bindings.api.MathBindingsTest}.
 */
public class MathBindingsTestHelper {


    /**
     * Helper for math methods that take <b>one</b> param of type <code>Long</code> and returns a value of generic type
     * <code>R</code>.
     *
     * @param bindingFunction a method reference to a binding factory method from {@link
     *                        eu.lestard.advanced_bindings.api.MathBindings}.
     * @param mathFunction    a method reference to the corresponding method of {@link java.lang.Math}.
     * @param args            example arguments that are used to verify.
     * @param <R>             the generic type of the return type of the math function
     */
    @SuppressWarnings("unchecked")
    static <R extends Number> void testLongArgBinding(Function<ObservableLongValue, Binding<R>> bindingFunction, Function<Long, R> mathFunction, Long... args) {
        testBinding(bindingFunction, mathFunction, args);
    }

    /**
     * Helper for math methods that take <b>one</b> param of type <code>Integer</code> and returns a
     * value of generic type <code>R</code>.
     *
     * @param bindingFunction a method reference to a binding factory method from {@link
     *                        eu.lestard.advanced_bindings.api.MathBindings}.
     * @param mathFunction    a method reference to the corresponding method of {@link java.lang.Math}.
     * @param args            example arguments that are used to verify.
     * @param <R>             the generic type of the return type of the math function
     */
    @SuppressWarnings("unchecked")
    static <R extends Number> void testIntegerArgBinding(Function<ObservableIntegerValue, Binding<R>> bindingFunction, Function<Integer, R> mathFunction, Integer... args) {
        testBinding(bindingFunction, mathFunction, args);
    }

    /**
     * Helper for math methods that take <b>one</b> param of type <code>Double</code> and returns a
     * value of generic type <code>R</code>.
     *
     * @param bindingFunction a method reference to a binding factory method from {@link
     *                        eu.lestard.advanced_bindings.api.MathBindings}.
     * @param mathFunction    a method reference to the corresponding method of {@link java.lang.Math}.
     * @param args            example arguments that are used to verify.
     * @param <R>             the generic type of the return type of the math function
     */
    @SuppressWarnings("unchecked")
    static <R extends Number> void testDoubleArgBinding(Function<ObservableDoubleValue, Binding<R>> bindingFunction, Function<Double, R> mathFunction, Double... args) {
        testBinding(bindingFunction, mathFunction, args);
    }

    /**
     * Helper for math methods that take <b>one</b> param of type <code>Float</code> and returns a  value of generic
     * type <code>R</code>.
     *
     * @param bindingFunction a method reference to a binding factory method from {@link
     *                        eu.lestard.advanced_bindings.api.MathBindings}.
     * @param mathFunction    a method reference to the corresponding method of {@link java.lang.Math}.
     * @param args            example arguments that are used to verify.
     * @param <R>             the generic type of the return type of the math function
     */
    @SuppressWarnings("unchecked")
    static <R extends Number> void testFloatArgBinding(Function<ObservableFloatValue, Binding<R>> bindingFunction, Function<Float, R> mathFunction, Float... args) {
        testBinding(bindingFunction, mathFunction, args);
    }


    /**
     * Helper for math methods that take <b>two</b> param of type <code>Integer</code> and returns a
     * <code>Integer</code>.
     *
     * This method is used for bindings where <b>both</b> args are observables.
     *
     * @param bindingFunction a method reference to a binding factory method from {@link
     *                        eu.lestard.advanced_bindings.api.MathBindings}.
     * @param mathFunction    a method reference to the corresponding method of {@link java.lang.Math}.
     * @param args            example arguments that are used to verify.
     */
    @SafeVarargs
    static <R extends Number> void testIntegerBinding2Args1(BiFunction<ObservableIntegerValue, ObservableIntegerValue, Binding<R>> bindingFunction, BiFunction<Integer, Integer, R> mathFunction, Args<Integer, Integer>... args) {
        testTwoArgBinding1(bindingFunction, mathFunction, args);
    }

    /**
     * Helper for math methods that take <b>two</b> param of type <code>Integer</code> and returns a
     * <code>Integer</code>.
     *
     * This method is used for bindings where only the <b>second</b> argument is an observable.
     *
     * @param bindingFunction a method reference to a binding factory method from {@link
     *                        eu.lestard.advanced_bindings.api.MathBindings}.
     * @param mathFunction    a method reference to the corresponding method of {@link java.lang.Math}.
     * @param args            example arguments that are used to verify.
     */
    @SafeVarargs
    static <R extends Number> void testIntegerBinding2Args2(BiFunction<Integer, ObservableIntegerValue, Binding<R>> bindingFunction, BiFunction<Integer, Integer, R> mathFunction, Args<Integer, Integer>... args) {
        testTwoArgBinding2(bindingFunction, mathFunction, args);
    }


    /**
     * Helper for math methods that take <b>two</b> param of type <code>Integer</code> and returns a
     * <code>Integer</code>.
     *
     * This method is used for bindings where only the <b>first</b> argument is an observable.
     *
     * @param bindingFunction a method reference to a binding factory method from {@link
     *                        eu.lestard.advanced_bindings.api.MathBindings}.
     * @param mathFunction    a method reference to the corresponding method of {@link java.lang.Math}.
     * @param args            example arguments that are used to verify.
     */
    @SafeVarargs
    static <R extends Number> void testIntegerBinding2Args3(BiFunction<ObservableIntegerValue, Integer, Binding<R>> bindingFunction, BiFunction<Integer, Integer, R> mathFunction, Args<Integer, Integer>... args) {
        testTwoArgBinding3(bindingFunction, mathFunction, args);
    }

    /**
     * Helper for math methods that take <b>two</b> param of type <code>Long</code> and returns a <code>Long</code>.
     *
     * This method is used for bindings where <b>both</b> args are observables.
     *
     * @param bindingFunction a method reference to a binding factory method from {@link
     *                        eu.lestard.advanced_bindings.api.MathBindings}.
     * @param mathFunction    a method reference to the corresponding method of {@link java.lang.Math}.
     * @param args            example arguments that are used to verify.
     */
    @SafeVarargs
    static <R extends Number> void testLongBinding2Args1(BiFunction<ObservableLongValue, ObservableLongValue, Binding<R>> bindingFunction, BiFunction<Long, Long, R> mathFunction, Args<Long, Long>... args) {
        testTwoArgBinding1(bindingFunction, mathFunction, args);
    }

    /**
     * Helper for math methods that take <b>two</b> param of type <code>Integer</code> and returns a
     * <code>Integer</code>.
     *
     * This method is used for bindings where only the <b>second</b> argument is an observable.
     *
     * @param bindingFunction a method reference to a binding factory method from {@link
     *                        eu.lestard.advanced_bindings.api.MathBindings}.
     * @param mathFunction    a method reference to the corresponding method of {@link java.lang.Math}.
     * @param args            example arguments that are used to verify.
     */
    @SafeVarargs
    static <R extends Number> void testLongBinding2Args2(BiFunction<Long, ObservableLongValue, Binding<R>> bindingFunction, BiFunction<Long, Long, R> mathFunction, Args<Long, Long>... args) {
        testTwoArgBinding2(bindingFunction, mathFunction, args);
    }

    /**
     * Helper for math methods that take <b>two</b> param of type <code>Integer</code> and returns a
     * <code>Integer</code>.
     *
     * This method is used for bindings where only the <b>first</b> argument is an observable.
     *
     * @param bindingFunction a method reference to a binding factory method from {@link
     *                        eu.lestard.advanced_bindings.api.MathBindings}.
     * @param mathFunction    a method reference to the corresponding method of {@link java.lang.Math}.
     * @param args            example arguments that are used to verify.
     */
    @SafeVarargs
    static <R extends Number> void testLongBinding2Args3(BiFunction<ObservableLongValue, Long, Binding<R>> bindingFunction, BiFunction<Long, Long, R> mathFunction, Args<Long, Long>... args) {
        testTwoArgBinding3(bindingFunction, mathFunction, args);
    }

    /**
     * Helper for math methods that take <b>two</b> param of type <code>Float</code> and returns a <code>Float</code>.
     *
     * This method is used for bindings where <b>both</b> args are observables.
     *
     * @param bindingFunction a method reference to a binding factory method from {@link
     *                        eu.lestard.advanced_bindings.api.MathBindings}.
     * @param mathFunction    a method reference to the corresponding method of {@link java.lang.Math}.
     * @param args            example arguments that are used to verify.
     */
    @SafeVarargs
    static <R extends Number> void testFloatBinding2Args1(BiFunction<ObservableFloatValue, ObservableFloatValue, Binding<R>> bindingFunction, BiFunction<Float, Float, R> mathFunction, Args<Float, Float>... args) {
        testTwoArgBinding1(bindingFunction, mathFunction, args);
    }

    /**
     * Helper for math methods that take <b>two</b> param of type <code>Float</code> and returns a <code>Float</code>.
     *
     * This method is used for bindings where only the <b>second</b> argument is an observable.
     *
     * @param bindingFunction a method reference to a binding factory method from {@link
     *                        eu.lestard.advanced_bindings.api.MathBindings}.
     * @param mathFunction    a method reference to the corresponding method of {@link java.lang.Math}.
     * @param args            example arguments that are used to verify.
     */
    @SafeVarargs
    static <R extends Number> void testFloatBinding2Args2(BiFunction<Float, ObservableFloatValue, Binding<R>> bindingFunction, BiFunction<Float, Float, R> mathFunction, Args<Float, Float>... args) {
        testTwoArgBinding2(bindingFunction, mathFunction, args);
    }

    /**
     * Helper for math methods that take <b>two</b> param of type <code>Float</code> and returns a <code>Float</code>.
     *
     * This method is used for bindings where only the <b>first</b> argument is an observable.
     *
     * @param bindingFunction a method reference to a binding factory method from {@link
     *                        eu.lestard.advanced_bindings.api.MathBindings}.
     * @param mathFunction    a method reference to the corresponding method of {@link java.lang.Math}.
     * @param args            example arguments that are used to verify.
     */
    @SafeVarargs
    static <R extends Number> void testFloatBinding2Args3(BiFunction<ObservableFloatValue, Float, Binding<R>> bindingFunction, BiFunction<Float, Float, R> mathFunction, Args<Float, Float>... args) {
        testTwoArgBinding3(bindingFunction, mathFunction, args);
    }


    /**
     * Helper for math methods that take <b>two</b> param of type <code>Double</code> and returns a
     * <code>Double</code>.
     *
     * This method is used for bindings where <b>both</b> args are observables.
     *
     * @param bindingFunction a method reference to a binding factory method from {@link
     *                        eu.lestard.advanced_bindings.api.MathBindings}.
     * @param mathFunction    a method reference to the corresponding method of {@link java.lang.Math}.
     * @param args            example arguments that are used to verify.
     */
    @SafeVarargs
    static <R extends Number> void testDoubleBinding2Args1(BiFunction<ObservableDoubleValue, ObservableDoubleValue, Binding<R>> bindingFunction, BiFunction<Double, Double, R> mathFunction, Args<Double, Double>... args) {
        testTwoArgBinding1(bindingFunction, mathFunction, args);
    }

    /**
     * Helper for math methods that take <b>two</b> param of type <code>Double</code> and returns a
     * <code>Double</code>.
     *
     * This method is used for bindings where only the <b>second</b> argument is an observable.
     *
     * @param bindingFunction a method reference to a binding factory method from {@link
     *                        eu.lestard.advanced_bindings.api.MathBindings}.
     * @param mathFunction    a method reference to the corresponding method of {@link java.lang.Math}.
     * @param args            example arguments that are used to verify.
     */
    @SafeVarargs
    static <R extends Number> void testDoubleBinding2Args2(BiFunction<Double, ObservableDoubleValue, Binding<R>> bindingFunction, BiFunction<Double, Double, R> mathFunction, Args<Double, Double>... args) {
        testTwoArgBinding2(bindingFunction, mathFunction, args);
    }

    /**
     * Helper for math methods that take <b>two</b> param of type <code>Double</code> and returns a
     * <code>Double</code>.
     *
     * This method is used for bindings where only the <b>first</b> argument is an observable.
     *
     * @param bindingFunction a method reference to a binding factory method from {@link
     *                        eu.lestard.advanced_bindings.api.MathBindings}.
     * @param mathFunction    a method reference to the corresponding method of {@link java.lang.Math}.
     * @param args            example arguments that are used to verify.
     */
    @SafeVarargs
    static <R extends Number> void testDoubleBinding2Args3(BiFunction<ObservableDoubleValue, Double, Binding<R>> bindingFunction, BiFunction<Double, Double, R> mathFunction, Args<Double, Double>... args) {
        testTwoArgBinding3(bindingFunction, mathFunction, args);
    }


    /**
     * @param <A>   the type of the argument
     * @param <Obs> the type of the observable
     * @param <R>   the type of the return value
     */
    @SuppressWarnings("unchecked")
    private static <A extends Number, Obs extends ObservableNumberValue, R extends Number> void testBinding(Function<Obs, Binding<R>> bindingFunction, Function<A, R> mathFunction, A... args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("No args to verify!");
        }

        Property base = createProperty(args[0]);

        final Binding<R> binding = bindingFunction.apply((Obs) base);

        for (A arg : args) {
            base.setValue(arg);

            R expectedResult = mathFunction.apply(arg);

            assertThat(binding).hasValue(expectedResult);
        }
    }

    private static <A extends Number> Property createProperty(A arg) {
        if (arg instanceof Integer) {
            return new SimpleIntegerProperty();
        } else if (arg instanceof Long) {
            return new SimpleLongProperty();
        } else if (arg instanceof Float) {
            return new SimpleFloatProperty();
        } else if (arg instanceof Double) {
            return new SimpleDoubleProperty();
        } else {
            throw new IllegalArgumentException("Illegal type of arguments");
        }
    }


    @SuppressWarnings("unchecked")
    static <A1 extends Number, A2 extends Number, Obs1 extends ObservableNumberValue, Obs2 extends ObservableNumberValue, R extends Number> void testTwoArgBinding1(BiFunction<Obs1, Obs2, Binding<R>> bindingFunction, BiFunction<A1, A2, R> mathFunction, Args<A1, A2>... args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("No args to verify!");
        }

        Property arg1 = createProperty(args[0].getFirst());
        Property arg2 = createProperty(args[0].getSecond());

        final Binding<R> binding = bindingFunction.apply((Obs1) arg1, (Obs2) arg2);

        for (Args<A1, A2> arg : args) {
            arg1.setValue(arg.getFirst());
            arg2.setValue(arg.getSecond());

            R expectedResult = mathFunction.apply(arg.getFirst(), arg.getSecond());

            assertThat(binding).hasValue(expectedResult);
        }
    }

    @SuppressWarnings("unchecked")
    static <A1 extends Number, A2 extends Number, Obs extends ObservableNumberValue, R extends Number>
    void testTwoArgBinding2(BiFunction<A1, Obs, Binding<R>> bindingFunction, BiFunction<A1, A2, R> mathFunction, Args<A1, A2>... args) {

        if (args.length == 0) {
            throw new IllegalArgumentException("No args to verify!");
        }

        Property second = createProperty(args[0].getSecond());
        for (Args<A1, A2> arg : args) {
            second.setValue(arg.getSecond());

            final Binding<R> binding = bindingFunction.apply(arg.getFirst(), (Obs) second);

            R expectedResult = mathFunction.apply(arg.getFirst(), arg.getSecond());
            assertThat(binding).hasValue(expectedResult);

        }
    }

    @SuppressWarnings("unchecked")
    static <A1 extends Number, A2 extends Number, Obs extends ObservableNumberValue, R extends Number>
    void testTwoArgBinding3(BiFunction<Obs, A2, Binding<R>> bindingFunction, BiFunction<A1, A2, R> mathFunction, Args<A1, A2>... args) {

        if (args.length == 0) {
            throw new IllegalArgumentException("No args to verify!");
        }

        Property first = createProperty(args[0].getFirst());
        for (Args<A1, A2> arg : args) {
            first.setValue(arg.getFirst());

            final Binding<R> binding = bindingFunction.apply((Obs) first, arg.getSecond());

            R expectedResult = mathFunction.apply(arg.getFirst(), arg.getSecond());
            assertThat(binding).hasValue(expectedResult);

        }
    }


    /**
     * Helper class that represents an combination of two args. It is used for tests of bindings with 2 args.
     *
     * @param <A1>
     * @param <A2>
     */
    static class Args<A1 extends Number, A2 extends Number> {

        private final A1 first;
        private final A2 second;

        public Args(A1 first, A2 second) {
            this.first = first;
            this.second = second;
        }

        public A1 getFirst() {
            return first;
        }

        public A2 getSecond() {
            return second;
        }
    }
}
