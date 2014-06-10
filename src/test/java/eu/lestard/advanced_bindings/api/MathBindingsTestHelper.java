package eu.lestard.advanced_bindings.api;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.FloatBinding;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.LongBinding;
import javafx.beans.property.*;
import javafx.beans.value.ObservableDoubleValue;
import javafx.beans.value.ObservableFloatValue;
import javafx.beans.value.ObservableIntegerValue;
import javafx.beans.value.ObservableLongValue;

import java.util.function.BiFunction;
import java.util.function.Function;

import static eu.lestard.assertj.javafx.api.Assertions.assertThat;

/**
 * This class contains test helper methods for {@link eu.lestard.advanced_bindings.api.MathBindingsTest}.
 */
public class MathBindingsTestHelper {


    /**
     * Helper for math methods that take <b>one</b> param of type <code>Long</code> and returns a <code>Long</code>.
     *
     * @param bindingFunction a method reference to a binding factory method from {@link
     *                        eu.lestard.advanced_bindings.api.MathBindings}.
     * @param mathFunction    a method reference to the corresponding method of {@link java.lang.Math}.
     * @param args            example arguments that are used to verify.
     */
    static void testLongBinding(Function<ObservableLongValue, LongBinding> bindingFunction, Function<Long, Long> mathFunction, long... args) {
        LongProperty base = new SimpleLongProperty();
        final LongBinding binding = bindingFunction.apply(base);

        for (long arg : args) {
            base.set(arg);

            long expectedResult = mathFunction.apply(arg);

            assertThat(binding).hasValue(expectedResult);
        }
    }

    /**
     * Helper for math methods that take <b>one</b> param of type <code>Integer</code> and returns an <code>Integer</code>.
     *
     * @param bindingFunction a method reference to a binding factory method from {@link
     *                        eu.lestard.advanced_bindings.api.MathBindings}.
     * @param mathFunction    a method reference to the corresponding method of {@link java.lang.Math}.
     * @param args            example arguments that are used to verify.
     */
    static void testIntegerBinding(Function<ObservableIntegerValue, IntegerBinding> bindingFunction, Function<Integer, Integer> mathFunction, int... args) {
        IntegerProperty base = new SimpleIntegerProperty();
        final IntegerBinding binding = bindingFunction.apply(base);

        for (int arg : args) {
            base.set(arg);

            int expectedResult = mathFunction.apply(arg);

            assertThat(binding).hasValue(expectedResult);
        }
    }

    /**
     * Helper for math methods that take <b>one</b> param of type <code>Double</code> and returns a <code>Double</code>.
     *
     * @param bindingFunction a method reference to a binding factory method from {@link
     *                        eu.lestard.advanced_bindings.api.MathBindings}.
     * @param mathFunction    a method reference to the corresponding method of {@link java.lang.Math}.
     * @param args            example arguments that are used to verify.
     */
    static void testDoubleBinding(Function<ObservableDoubleValue, DoubleBinding> bindingFunction, Function<Double, Double> mathFunction, double... args) {

        DoubleProperty base = new SimpleDoubleProperty();

        final DoubleBinding binding = bindingFunction.apply(base);

        for (double arg : args) {

            base.set(arg);

            double expectedResult = mathFunction.apply(arg);

            assertThat(binding).hasValue(expectedResult);
        }
    }

    /**
     * Helper for math methods that take <b>one</b> param of type <code>Float</code> and returns a <code>Float</code>.
     *
     * @param bindingFunction a method reference to a binding factory method from {@link
     *                        eu.lestard.advanced_bindings.api.MathBindings}.
     * @param mathFunction    a method reference to the corresponding method of {@link java.lang.Math}.
     * @param args            example arguments that are used to verify.
     */
    static  void testFloatBinding(Function<ObservableFloatValue, FloatBinding> bindingFunction, Function<Float, Float> mathFunction, float... args) {

        FloatProperty base = new SimpleFloatProperty();

        final FloatBinding binding = bindingFunction.apply(base);

        for (float arg : args) {

            base.set(arg);

            float expectedResult = mathFunction.apply(arg);

            assertThat(binding).hasValue(expectedResult);
        }
    }

    /**
     * Helper for math methods that take <b>two</b> param of type <code>Integer</code> and returns a <code>Integer</code>.
     *
     * This method is used for bindings where <b>both</b> args are observables.
     *
     * @param bindingFunction a method reference to a binding factory method from {@link
     *                        eu.lestard.advanced_bindings.api.MathBindings}.
     * @param mathFunction    a method reference to the corresponding method of {@link java.lang.Math}.
     * @param args            example arguments that are used to verify.
     */
    @SafeVarargs
    static void testIntegerBinding2Args1(BiFunction<ObservableIntegerValue, ObservableIntegerValue, IntegerBinding> bindingFunction, BiFunction<Integer, Integer, Integer> mathFunction, Args<Integer>...args){

        IntegerProperty first = new SimpleIntegerProperty();
        IntegerProperty second = new SimpleIntegerProperty();

        IntegerBinding binding = bindingFunction.apply(first,second);


        for(Args<Integer> arg : args){
            first.set(arg.getFirst());
            second.set(arg.getSecond());

            int expectedResult = mathFunction.apply(arg.getFirst(), arg.getSecond());

            assertThat(binding).hasValue(expectedResult);
        }
    }

    /**
     * Helper for math methods that take <b>two</b> param of type <code>Integer</code> and returns a <code>Integer</code>.
     *
     * This method is used for bindings where only the <b>second</b> argument is an observable.
     *
     * @param bindingFunction a method reference to a binding factory method from {@link
     *                        eu.lestard.advanced_bindings.api.MathBindings}.
     * @param mathFunction    a method reference to the corresponding method of {@link java.lang.Math}.
     * @param args            example arguments that are used to verify.
     */
    @SafeVarargs
    static void testIntegerBinding2Args2(BiFunction<Integer, ObservableIntegerValue, IntegerBinding> bindingFunction, BiFunction<Integer, Integer, Integer> mathFunction, Args<Integer>...args){
        for(Args<Integer> arg : args){
            IntegerProperty second = new SimpleIntegerProperty();
            IntegerBinding binding = bindingFunction.apply(arg.getFirst(),second);

            second.set(arg.getSecond());

            int expectedResult = mathFunction.apply(arg.getFirst(), arg.getSecond());

            assertThat(binding).hasValue(expectedResult);
        }
    }

    /**
     * Helper for math methods that take <b>two</b> param of type <code>Integer</code> and returns a <code>Integer</code>.
     *
     * This method is used for bindings where only the <b>first</b> argument is an observable.
     *
     * @param bindingFunction a method reference to a binding factory method from {@link
     *                        eu.lestard.advanced_bindings.api.MathBindings}.
     * @param mathFunction    a method reference to the corresponding method of {@link java.lang.Math}.
     * @param args            example arguments that are used to verify.
     */
    @SafeVarargs
    static void testIntegerBinding2Args3(BiFunction<ObservableIntegerValue, Integer, IntegerBinding> bindingFunction, BiFunction<Integer, Integer, Integer> mathFunction, Args<Integer>...args){
        for(Args<Integer> arg : args){
            IntegerProperty first = new SimpleIntegerProperty();
            IntegerBinding binding = bindingFunction.apply(first, arg.getSecond());

            first.set(arg.getFirst());

            int expectedResult = mathFunction.apply(arg.getFirst(), arg.getSecond());

            assertThat(binding).hasValue(expectedResult);
        }
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
    static void testLongBinding2Args1(BiFunction<ObservableLongValue, ObservableLongValue, LongBinding> bindingFunction, BiFunction<Long, Long, Long> mathFunction, Args<Long>...args){

        LongProperty first = new SimpleLongProperty();
        LongProperty second = new SimpleLongProperty();

        LongBinding binding = bindingFunction.apply(first,second);


        for(Args<Long> arg : args){
            first.set(arg.getFirst());
            second.set(arg.getSecond());

            long expectedResult = mathFunction.apply(arg.getFirst(), arg.getSecond());

            assertThat(binding).hasValue(expectedResult);
        }
    }

    /**
     * Helper for math methods that take <b>two</b> param of type <code>Integer</code> and returns a <code>Integer</code>.
     *
     * This method is used for bindings where only the <b>second</b> argument is an observable.
     *
     * @param bindingFunction a method reference to a binding factory method from {@link
     *                        eu.lestard.advanced_bindings.api.MathBindings}.
     * @param mathFunction    a method reference to the corresponding method of {@link java.lang.Math}.
     * @param args            example arguments that are used to verify.
     */
    @SafeVarargs
    static void testLongBinding2Args2(BiFunction<Long, ObservableLongValue, LongBinding> bindingFunction, BiFunction<Long, Long, Long> mathFunction, Args<Long>...args){
        for(Args<Long> arg : args){
            LongProperty second = new SimpleLongProperty();
            LongBinding binding = bindingFunction.apply(arg.getFirst(),second);

            second.set(arg.getSecond());

            long expectedResult = mathFunction.apply(arg.getFirst(), arg.getSecond());

            assertThat(binding).hasValue(expectedResult);
        }
    }

    /**
     * Helper for math methods that take <b>two</b> param of type <code>Integer</code> and returns a <code>Integer</code>.
     *
     * This method is used for bindings where only the <b>first</b> argument is an observable.
     *
     * @param bindingFunction a method reference to a binding factory method from {@link
     *                        eu.lestard.advanced_bindings.api.MathBindings}.
     * @param mathFunction    a method reference to the corresponding method of {@link java.lang.Math}.
     * @param args            example arguments that are used to verify.
     */
    @SafeVarargs
    static void testLongBinding2Args3(BiFunction<ObservableLongValue, Long, LongBinding> bindingFunction, BiFunction<Long, Long, Long> mathFunction, Args<Long>...args){
        for(Args<Long> arg : args){
            LongProperty first = new SimpleLongProperty();
            LongBinding binding = bindingFunction.apply(first, arg.getSecond());

            first.set(arg.getFirst());

            long expectedResult = mathFunction.apply(arg.getFirst(), arg.getSecond());

            assertThat(binding).hasValue(expectedResult);
        }
    }


    /**
     * Helper class that represents an combination of two args. It is used for tests of bindings with 2 args.
     * @param <T>
     */
    static class Args<T extends Number> {

        private final T first;
        private final T second;

        public Args(T first, T second){
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public T getSecond() {
            return second;
        }
    }
}
