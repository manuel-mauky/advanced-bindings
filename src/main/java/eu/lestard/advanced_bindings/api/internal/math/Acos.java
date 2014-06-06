package eu.lestard.advanced_bindings.api.internal.math;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.value.ObservableDoubleValue;

public class Acos {

    public static DoubleBinding acos(final ObservableDoubleValue base){
        return new DoubleBinding() {
            {
                super.bind(base);
            }
            @Override
            protected double computeValue() {
                return Math.acos(base.doubleValue());
            }
        };
    }
}
