package eu.lestard.advanced_bindings.api;

import eu.lestard.advanced_bindings.api.internal.math.Abs;
import eu.lestard.advanced_bindings.api.internal.math.Acos;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.FloatBinding;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.LongBinding;
import javafx.beans.value.ObservableDoubleValue;
import javafx.beans.value.ObservableFloatValue;
import javafx.beans.value.ObservableIntegerValue;
import javafx.beans.value.ObservableLongValue;

public class MathBindings {

    public static IntegerBinding abs(final ObservableIntegerValue a) {
        return Abs.abs(a);
    }

    public static DoubleBinding abs(final ObservableDoubleValue a) {
        return Abs.abs(a);
    }

    public static LongBinding abs(final ObservableLongValue a) {
        return Abs.abs(a);
    }

    public static FloatBinding abs(final ObservableFloatValue a) {
        return Abs.abs(a);
    }


    public static DoubleBinding acos(final ObservableDoubleValue a) {
        return Acos.acos(a);
    }
}
