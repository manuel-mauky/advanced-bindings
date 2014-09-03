package eu.lestard.advanced_bindings.api;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableDoubleValue;
import javafx.beans.value.ObservableIntegerValue;
import javafx.beans.value.ObservableNumberValue;

public class NumberBindings {

    /**
     * A boolean binding that is <code>true</code> if the given observable double is <b>Not a Number</b>.
     * See {@link Double#isNaN(double)}.
     *
     * @param observableValue the observable double value to use for the binding.
     * @return the boolean binding.
     */
    public static BooleanBinding isNaN(final ObservableDoubleValue observableValue) {
        return Bindings.createBooleanBinding(() -> Double.isNaN(observableValue.get()), observableValue);
    }

    /**
     * A boolean binding that is <code>true</code> if the given observable double is <b>Infinite</b>.
     * See {@link Double#isInfinite(double)}.
     *
     * @param observableValue the observable double value to use for the binding.
     * @return the boolean binding.
     */
    public static BooleanBinding isInfinite(final ObservableDoubleValue observableValue) {
        return Bindings.createBooleanBinding(() -> Double.isInfinite(observableValue.get()), observableValue);
    }


    /**
     * An number binding of a division that won't throw an {@link java.lang.ArithmeticException}
     * when a division by zero happens. See {@link #divideSafe(javafx.beans.value.ObservableIntegerValue,
     * javafx.beans.value.ObservableIntegerValue)}
     * for more informations.
     *
     * @param dividend     the observable value used as dividend
     * @param divisor      the observable value used as divisor
     * @return the resulting number binding
     */
    public static NumberBinding divideSafe(ObservableNumberValue dividend, ObservableNumberValue divisor) {
        return divideSafe(dividend, divisor, new SimpleDoubleProperty(0));
    }


    /**
     * An number binding of a division that won't throw an {@link java.lang.ArithmeticException}
     * when a division by zero happens. See {@link #divideSafe(javafx.beans.value.ObservableIntegerValue,
     * javafx.beans.value.ObservableIntegerValue)}
     * for more informations.
     *
     * @param dividend     the value used as dividend
     * @param divisor      the observable value used as divisor
     * @return the resulting number binding
     */
    public static NumberBinding divideSafe(double dividend, ObservableNumberValue divisor) {
        return divideSafe(new SimpleDoubleProperty(dividend), divisor);
    }


    /**
     * An number binding of a division that won't throw an {@link java.lang.ArithmeticException}
     * when a division by zero happens. See {@link #divideSafe(javafx.beans.value.ObservableIntegerValue,
     * javafx.beans.value.ObservableIntegerValue)}
     * for more informations.
     *
     * @param dividend     the observable value used as dividend
     * @param divisor      the value used as divisor
     * @return the resulting number binding
     */
    public static NumberBinding divideSafe(ObservableNumberValue dividend, double divisor) {
        return divideSafe(dividend, new SimpleDoubleProperty(divisor));
    }

    /**
     * An number binding of a division that won't throw an {@link java.lang.ArithmeticException}
     * when a division by zero happens. See {@link #divideSafe(javafx.beans.value.ObservableIntegerValue,
     * javafx.beans.value.ObservableIntegerValue)}
     * for more informations.
     *
     * @param dividend     the observable value used as dividend
     * @param divisor      the observable value used as divisor
     * @param defaultValue the observable value that is used as default value. The binding will have this value when a
     *                     division by zero happens.
     * @return the resulting number binding
     */
    public static NumberBinding divideSafe(ObservableNumberValue dividend, ObservableNumberValue divisor, ObservableNumberValue defaultValue) {
        return Bindings.createDoubleBinding(() -> {

            if (divisor.doubleValue() == 0) {
                return defaultValue.doubleValue();
            } else {
                return dividend.doubleValue() / divisor.doubleValue();
            }

        }, dividend, divisor);
    }

    /**
     * An number binding of a division that won't throw an {@link java.lang.ArithmeticException}
     * when a division by zero happens. See {@link #divideSafe(javafx.beans.value.ObservableIntegerValue,
     * javafx.beans.value.ObservableIntegerValue)}
     * for more information.
     *
     * @param dividend     the observable value used as dividend
     * @param divisor      the observable value used as divisor
     * @param defaultValue the default value. The binding will have this value when a
     *                     division by zero happens.
     * @return the resulting number binding
     */
    public static NumberBinding divideSafe(ObservableNumberValue dividend, ObservableNumberValue divisor, double defaultValue) {
        return divideSafe(dividend, divisor, new SimpleDoubleProperty(defaultValue));
    }


    /**
     * A number binding with the division of the two observable number values.
     * The difference to the existing bindings (
     * {@link Bindings#divide(javafx.beans.value.ObservableNumberValue, javafx.beans.value.ObservableNumberValue)})
     * is that this binding will <b>not</b> throw an {@link java.lang.ArithmeticException} when the second param (the
     * divisor)
     * is zero. Instead an default value of <code>0</code> is returned.
     *
     * This can be useful because bindings like this aren't working as expected:
     *
     * <pre>
     *     IntegerProperty a = ...;
     *     IntegerProperty b = ...;
     *
     *     NumberBinding result = Bindings
     *          .when(b.isEqualTo(0))
     *          .then(0)
     *          .otherwise(a.divide(b));
     * </pre>
     *
     * At first one would expect that this binding will have a value <code>0</code> when <code>b</code> is <code>0</code>.
     * Instead the binding in the example will throw an {@link java.lang.ArithmeticException} when <code>b</code>
     * has an (initial) value of 0. The when-otherwise construct doesn't help in this case because
     * the <code>divide</code> binding will still be evaluated.
     *
     * In such cases you can use the binding created by this method which makes this distinction internally
     * and won't throw an exception.
     *
     *
     * If you <code>0</code> isn't suitable as a default value for your use case you can use the overloaded
     * method {@link #divideSafe(javafx.beans.value.ObservableIntegerValue, javafx.beans.value.ObservableIntegerValue,
     * int)}.
     *
     * @param dividend the observable value used as dividend
     * @param divisor  the observable value used as divisor
     * @return the resulting integer binding
     */
    public static IntegerBinding divideSafe(ObservableIntegerValue dividend, ObservableIntegerValue divisor) {
        return divideSafe(dividend, divisor, new SimpleIntegerProperty(0));
    }

    /**
     * An integer binding of a division that won't throw an {@link java.lang.ArithmeticException}
     * when a division by zero happens. See {@link #divideSafe(javafx.beans.value.ObservableIntegerValue,
     * javafx.beans.value.ObservableIntegerValue)}
     * for more information.
     *
     * @param dividend the value used as dividend
     * @param divisor  the observable value used as divisor
     * @return the resulting integer binding
     */
    public static IntegerBinding divideSafe(int dividend, ObservableIntegerValue divisor) {
        return divideSafe(new SimpleIntegerProperty(dividend), divisor);
    }

    /**
     * An integer binding of a division that won't throw an {@link java.lang.ArithmeticException}
     * when a division by zero happens. See {@link #divideSafe(javafx.beans.value.ObservableIntegerValue,
     * javafx.beans.value.ObservableIntegerValue)}
     * for more information.
     *
     * @param dividend the observable value used as dividend
     * @param divisor  the value used as divisor
     * @return the resulting integer binding
     */
    public static IntegerBinding divideSafe(ObservableIntegerValue dividend, int divisor) {
        return divideSafe(dividend, new SimpleIntegerProperty(divisor));
    }


    /**
     * An integer binding of a division that won't throw an {@link java.lang.ArithmeticException}
     * when a division by zero happens. See {@link #divideSafe(javafx.beans.value.ObservableIntegerValue,
     * javafx.beans.value.ObservableIntegerValue)}
     * for more information.
     *
     * @param dividend     the observable value used as dividend
     * @param divisor      the observable value used as divisor
     * @param defaultValue the observable value that is used as default value. The binding will have this value when a
     *                     division by zero happens.
     * @return the resulting integer binding
     */
    public static IntegerBinding divideSafe(ObservableIntegerValue dividend, ObservableIntegerValue divisor, ObservableIntegerValue defaultValue) {
        return Bindings.createIntegerBinding(() -> {

            if (divisor.intValue() == 0) {
                return defaultValue.get();
            } else {
                return dividend.intValue() / divisor.intValue();
            }

        }, dividend, divisor);
    }

    /**
     * An integer binding of a division that won't throw an {@link java.lang.ArithmeticException}
     * when a division by zero happens. See {@link #divideSafe(javafx.beans.value.ObservableIntegerValue,
     * javafx.beans.value.ObservableIntegerValue)}
     * for more information.
     *
     * @param dividend     the observable value used as dividend
     * @param divisor      the observable value used as divisor
     * @param defaultValue the default value. The binding will have this value when a
     *                     division by zero happens.
     * @return the resulting integer binding
     */
    public static IntegerBinding divideSafe(ObservableIntegerValue dividend, ObservableIntegerValue divisor, int defaultValue) {
        return divideSafe(dividend, divisor, new SimpleIntegerProperty(defaultValue));
    }
}
