package eu.lestard.advanced_bindings.api;

import eu.lestard.advanced_bindings.api.internal.math.Abs;
import javafx.beans.binding.*;
import javafx.beans.value.ObservableDoubleValue;
import javafx.beans.value.ObservableFloatValue;
import javafx.beans.value.ObservableIntegerValue;
import javafx.beans.value.ObservableLongValue;

public class MathBindings {
    public static IntegerBinding abs(final ObservableIntegerValue base) {
        return Abs.abs(base);
    }

    public static DoubleBinding abs(final ObservableDoubleValue base) {
        return Abs.abs(base);
    }

    public static LongBinding abs(final ObservableLongValue base) {
        return Abs.abs(base);
    }

    public static FloatBinding abs(final ObservableFloatValue base) {
        return Abs.abs(base);
    }
}
