package eu.lestard.advanced_bindings.api;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.value.ObservableBooleanValue;

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
    public static BooleanBinding and(ObservableBooleanValue...values) {
        return Bindings.createBooleanBinding(
            ()-> !Arrays.stream(values)
                .filter(observable -> !observable.get())
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
    public static BooleanBinding or(ObservableBooleanValue...values) {
        return Bindings.createBooleanBinding(()-> Arrays.stream(values)
            .filter(ObservableBooleanValue::get)
            .findAny()
            .isPresent(), values);
    }
}
