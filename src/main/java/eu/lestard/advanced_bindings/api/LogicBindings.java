package eu.lestard.advanced_bindings.api;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.value.ObservableBooleanValue;

import java.util.Arrays;


public class LogicBindings {

    public static BooleanBinding and(ObservableBooleanValue...values) {
        return Bindings.createBooleanBinding(
            ()-> !Arrays.stream(values)
                .filter(observable -> !observable.get())
                .findAny()
                .isPresent(), values);
    }

    public static BooleanBinding or(ObservableBooleanValue...values) {
        return Bindings.createBooleanBinding(()-> Arrays.stream(values)
            .filter(ObservableBooleanValue::get)
            .findAny()
            .isPresent(), values);
    }
}
