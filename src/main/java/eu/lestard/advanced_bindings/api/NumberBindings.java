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

    public static BooleanBinding isNaN(final ObservableDoubleValue observableValue) {
        return Bindings.createBooleanBinding(() -> Double.isNaN(observableValue.get()), observableValue);
    }

    public static BooleanBinding isInfinite(final ObservableDoubleValue observableValue){
        return Bindings.createBooleanBinding(() -> Double.isInfinite(observableValue.get()), observableValue);
    }

    public static NumberBinding divideSafe(ObservableNumberValue dividend, ObservableNumberValue divisor) {
        return divideSafe(dividend, divisor, new SimpleDoubleProperty(0));
    }

    public static NumberBinding divideSafe(double dividend, ObservableNumberValue divisor){
        return divideSafe(new SimpleDoubleProperty(dividend), divisor);
    }

    public static NumberBinding divideSafe(ObservableNumberValue dividend, double divisor){
        return divideSafe(dividend, new SimpleDoubleProperty(divisor));
    }

    public static NumberBinding divideSafe(ObservableNumberValue dividend, ObservableNumberValue divisor, ObservableNumberValue defaultValue) {
        return Bindings.createDoubleBinding(() -> {

            if (divisor.doubleValue() == 0) {
                return defaultValue.doubleValue();
            } else {
                return dividend.doubleValue() / divisor.doubleValue();
            }

        }, dividend, divisor);
    }

    public static NumberBinding divideSafe(ObservableNumberValue dividend, ObservableNumberValue divisor, double defaultValue) {
        return divideSafe(dividend, divisor, new SimpleDoubleProperty(defaultValue));
    }


    public static IntegerBinding divideSafe(ObservableIntegerValue dividend, ObservableIntegerValue divisor){
        return divideSafe(dividend, divisor, new SimpleIntegerProperty(0));
    }

    public static IntegerBinding divideSafe(int dividend, ObservableIntegerValue divisor) {
        return divideSafe(new SimpleIntegerProperty(dividend), divisor);
    }

    public static IntegerBinding divideSafe(ObservableIntegerValue dividend, int divisor){
        return divideSafe(dividend, new SimpleIntegerProperty(divisor));
    }

    public static IntegerBinding divideSafe(ObservableIntegerValue dividend, ObservableIntegerValue divisor, ObservableIntegerValue defaultValue){
        return Bindings.createIntegerBinding(() -> {

            if (divisor.intValue() == 0) {
                return defaultValue.get();
            } else {
                return dividend.intValue() / divisor.intValue();
            }

        }, dividend, divisor);
    }

    public static IntegerBinding divideSafe(ObservableIntegerValue dividend, ObservableIntegerValue divisor, int defaultValue){
        return divideSafe(dividend, divisor, new SimpleIntegerProperty(defaultValue));
    }
}
