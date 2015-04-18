package eu.lestard.advanced_bindings.api;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.value.ObservableValue;

import java.util.Arrays;


public class LogicBindings {

    /**
     * A boolean binding that is `true` only when all dependent observable boolean values
     * are `true`.
     *
     * This can be useful in cases where the
     * {@link Bindings#and(javafx.beans.value.ObservableBooleanValue, javafx.beans.value.ObservableBooleanValue)}
     * with 2 arguments isn't enough.
     *
     * @param values variable number of observable boolean values that are used for the binding
     * @return the boolean binding
     */
    @SafeVarargs
    public static BooleanBinding and(ObservableValue<Boolean>...values) {
        return Bindings.createBooleanBinding(
            ()-> !Arrays.stream(values)
                .filter(observable -> !observable.getValue())
                .findAny()
                .isPresent(), values);
    }

    /**
     * A boolean binding that is only `true` when at leased one of the dependent observable boolean values
     * are `true`.
     *
     * This can be useful in cases where the
     * {@link Bindings#or(javafx.beans.value.ObservableBooleanValue, javafx.beans.value.ObservableBooleanValue)}
     * with 2 arguments isn't enough.
     *
     * @param values variable number of observable boolean values that are used for the binding
     * @return the boolean binding
     */
    @SafeVarargs
    public static BooleanBinding or(ObservableValue<Boolean>...values) {
        return Bindings.createBooleanBinding(()-> Arrays.stream(values)
            .filter(ObservableValue::getValue)
            .findAny()
            .isPresent(), values);
    }
}
