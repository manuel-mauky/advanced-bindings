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
import org.junit.Test;

import java.util.function.Function;

import static eu.lestard.assertj.javafx.api.Assertions.*;


/**
 * This test verifies the behaviour of all bindings from {@link eu.lestard.advanced_bindings.api.MathBindings} class.
 *
 * The purpose of this test class is NOT to verify the calculation logic of {@link java.lang.Math}
 * but to only verify that the created bindings are behaving correctly.
 *
 * Therefore I only verify that every binding has the same value as the corresponding method of the Math class with
 * some
 * example values.
 */
public class MathBindingsTest {

    @Test
    public void testAbs() {
        testDoubleBinding(MathBindings::abs, Math::abs, 10.13, -23.4);
        testFloatBinding(MathBindings::abs, Math::abs, 10.13f, -23.4f);
        testIntegerBinding(MathBindings::abs, Math::abs, 20, -13);
        testLongBinding(MathBindings::abs, Math::abs, 20l, -13l);
    }

    @Test
    public void testAcos() {
        testDoubleBinding(MathBindings::acos, Math::acos, 0, -1, 1, Double.NaN, 1.2);
    }

    /**
     * Helper for math methods that take <b>one</b> param of type <code>Long</code> and returns a <code>Long</code>.
     *
     * @param bindingFunction a method reference to a binding factory method from {@link
     *                        eu.lestard.advanced_bindings.api.MathBindings}.
     * @param mathFunction    a method reference to the corresponding method of {@link java.lang.Math}.
     * @param args            example arguments that are used to verify.
     */
    private void testLongBinding(Function<ObservableLongValue, LongBinding> bindingFunction, Function<Long, Long> mathFunction, long... args) {
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
    private void testIntegerBinding(Function<ObservableIntegerValue, IntegerBinding> bindingFunction, Function<Integer, Integer> mathFunction, int... args) {
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
    private void testDoubleBinding(Function<ObservableDoubleValue, DoubleBinding> bindingFunction, Function<Double, Double> mathFunction, double... args) {

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
    private void testFloatBinding(Function<ObservableFloatValue, FloatBinding> bindingFunction, Function<Float, Float> mathFunction, float... args) {

        FloatProperty base = new SimpleFloatProperty();

        final FloatBinding binding = bindingFunction.apply(base);

        for (float arg : args) {

            base.set(arg);

            float expectedResult = mathFunction.apply(arg);

            assertThat(binding).hasValue(expectedResult);
        }
    }

}
