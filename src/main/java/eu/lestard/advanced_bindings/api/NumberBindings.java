package eu.lestard.advanced_bindings.api;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.value.ObservableDoubleValue;

public class NumberBindings {

    public static BooleanBinding isNaN(final ObservableDoubleValue observableValue) {
        return Bindings.createBooleanBinding(() -> Double.isNaN(observableValue.get()), observableValue);
    }

    public static BooleanBinding isInfinite(final ObservableDoubleValue observableValue){
        return Bindings.createBooleanBinding(() -> Double.isInfinite(observableValue.get()), observableValue);
    }

}
