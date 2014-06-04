package eu.lestard.advanced_bindings;

import eu.lestard.advanced_bindings.api.MathBindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.FloatBinding;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.LongBinding;
import javafx.beans.property.*;
import org.junit.Test;

import static eu.lestard.assertj.javafx.api.Assertions.*;

public class MathBindings_abs_test {

    @Test
    public void testAbsOfTypeInteger(){
        IntegerProperty base = new SimpleIntegerProperty(20);
        IntegerBinding abs = MathBindings.abs(base);

        assertThat(abs).hasValue(20);

        base.setValue(-13);
        assertThat(abs).hasValue(13);
    }

    @Test
    public void testAbsOfTypeDouble(){
        DoubleProperty base = new SimpleDoubleProperty(20.13);
        DoubleBinding abs = MathBindings.abs(base);

        assertThat(abs).hasValue(20.13);

        base.setValue(-13.422);
        assertThat(abs).hasValue(13.422);
    }


    @Test
    public void testAbsOfTypeLong(){
        LongProperty base = new SimpleLongProperty(20);
        LongBinding abs = MathBindings.abs(base);

        assertThat(abs).hasValue(20);

        base.setValue(-13);
        assertThat(abs).hasValue(13);
    }

    @Test
    public void testAbsOfTypeFloat(){
        FloatProperty base = new SimpleFloatProperty(20.13f);
        FloatBinding abs = MathBindings.abs(base);

        assertThat(abs).hasValue(20.13f);

        base.setValue(-13.422f);
        assertThat(abs).hasValue(13.422f);
    }
}
