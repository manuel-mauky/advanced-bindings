package eu.lestard.advanced_bindings;

import eu.lestard.advanced_bindings.api.MathBindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import org.junit.Test;

import static eu.lestard.assertj.javafx.api.Assertions.assertThat;

public class MathBindings_acos_test {

    @Test
    public void testAcos(){
        DoubleProperty base = new SimpleDoubleProperty(0);

        DoubleBinding acos = MathBindings.acos(base);
        assertThat(acos).hasValue(1.5707963267948966);

        base.set(-1);
        assertThat(acos).hasValue(Math.PI);

        base.set(1);

        assertThat(acos).hasValue(0.0);
    }

    @Test
    public void testAcosNaN(){
        DoubleProperty base = new SimpleDoubleProperty(1.1);

        DoubleBinding acos = MathBindings.acos(base);

        assertThat(acos).hasValue(Double.NaN);

        base.set(Double.NaN);

        assertThat(acos).hasValue(Double.NaN);
    }

}
