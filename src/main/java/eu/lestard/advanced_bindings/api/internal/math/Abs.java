package eu.lestard.advanced_bindings.api.internal.math;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.FloatBinding;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.LongBinding;
import javafx.beans.value.ObservableDoubleValue;
import javafx.beans.value.ObservableFloatValue;
import javafx.beans.value.ObservableIntegerValue;
import javafx.beans.value.ObservableLongValue;


/**
 * Implementing class of bindings for {@link java.lang.Math#abs}.
 */
public class Abs {

    public static IntegerBinding abs(final ObservableIntegerValue base) {
        return new IntegerBinding() {
            {
                super.bind(base);
            }
            @Override
            protected int computeValue() {
                return Math.abs(base.get());
            }
        };
    }

    public static DoubleBinding abs(final ObservableDoubleValue base) {
        return new DoubleBinding() {
            {
                super.bind(base);
            }
            @Override
            protected double computeValue() {
                return Math.abs(base.get());
            }
        };
    }

    public static LongBinding abs(final ObservableLongValue base) {
        return new LongBinding() {
            {
                super.bind(base);
            }
            @Override
            protected long computeValue() {
                return Math.abs(base.get());
            }
        };
    }

    public static FloatBinding abs(final ObservableFloatValue base) {
        return new FloatBinding() {
            {
                super.bind(base);
            }
            @Override
            protected float computeValue() {
                return Math.abs(base.get());
            }
        };
    }
}
