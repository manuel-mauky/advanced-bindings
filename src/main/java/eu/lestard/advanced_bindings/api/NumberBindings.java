package eu.lestard.advanced_bindings.api;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.DoubleBinding;

public class NumberBindings {

    public static BooleanBinding isNaN(final DoubleBinding binding) {
        return Bindings.createBooleanBinding(() -> Double.isNaN(binding.get()), binding);
    }

}
