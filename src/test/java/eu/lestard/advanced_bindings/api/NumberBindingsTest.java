package eu.lestard.advanced_bindings.api;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import org.junit.Test;

import static eu.lestard.assertj.javafx.api.Assertions.*;

public class NumberBindingsTest {

    @Test
    public void testIsNan(){
        DoubleProperty a = new SimpleDoubleProperty();
        DoubleProperty b = new SimpleDoubleProperty();

        final DoubleBinding quotient = a.divide(b);
        BooleanBinding nan = NumberBindings.isNaN(quotient);


        a.set(2);
        b.set(4);

        assertThat(nan).isFalse();


        a.set(0);
        b.set(0);

        assertThat(nan).isTrue();
    }

    @Test
    public void testIsInfinite(){
        DoubleProperty a = new SimpleDoubleProperty();
        DoubleProperty b = new SimpleDoubleProperty();

        DoubleBinding product =  a.multiply(b);

        BooleanBinding infinite = NumberBindings.isInfinite(product);


        a.set(2);
        b.set(4);

        assertThat(infinite).isFalse();

        b.set(Double.MAX_VALUE);

        assertThat(infinite).isTrue();
    }

}
