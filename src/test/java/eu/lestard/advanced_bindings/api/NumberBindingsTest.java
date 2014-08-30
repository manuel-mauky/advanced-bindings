package eu.lestard.advanced_bindings.api;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
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


    @Test
    public void testDivideSafeDouble(){
        DoubleProperty a = new SimpleDoubleProperty();
        DoubleProperty b = new SimpleDoubleProperty();

        final NumberBinding quotient = NumberBindings.divideSafe(a, b);

        assertThat(quotient).hasValue(0.0);

        a.set(10);
        assertThat(quotient).hasValue(0.0);

        b.set(5);
        assertThat(quotient).hasValue(2.0);

        a.set(12);
        assertThat(quotient).hasValue(2.4);

        b.set(0);
        assertThat(quotient).hasValue(0.0);
    }

    @Test
    public void testDivideSafeDoubleWithDefaultValue(){
        DoubleProperty a = new SimpleDoubleProperty();
        DoubleProperty b = new SimpleDoubleProperty();

        DoubleProperty defaultValue = new SimpleDoubleProperty(3.2);

        final NumberBinding quotient = NumberBindings.divideSafe(a, b, defaultValue);

        assertThat(quotient).hasSameValue(defaultValue);
        assertThat(quotient).hasSameValue(defaultValue);

        a.set(10);
        assertThat(quotient).hasSameValue(defaultValue);

        b.set(5);
        assertThat(quotient).hasValue(2.0);

        a.set(12);
        assertThat(quotient).hasValue(2.4);

        b.set(0);
        assertThat(quotient).hasSameValue(defaultValue);
    }

    @Test
    public void testDivideSafeInteger(){

        IntegerProperty a = new SimpleIntegerProperty();
        IntegerProperty b = new SimpleIntegerProperty();

        final IntegerBinding quotient = NumberBindings.divideSafe(a, b);

        assertThat(quotient).hasValue(0);

        a.set(10);
        assertThat(quotient).hasValue(0);

        b.set(5);
        assertThat(quotient).hasValue(2);

        a.set(12);
        assertThat(quotient).hasValue(2);

        b.set(0);
        assertThat(quotient).hasValue(0);
    }

    @Test
    public void testDivideSafeIntegerWithDefaultValue(){
        IntegerProperty a = new SimpleIntegerProperty();
        IntegerProperty b = new SimpleIntegerProperty();

        IntegerProperty defaultValue = new SimpleIntegerProperty(10);

        final IntegerBinding quotient = NumberBindings.divideSafe(a, b, defaultValue);

        assertThat(quotient).hasSameValue(defaultValue);

        a.set(10);
        assertThat(quotient).hasSameValue(defaultValue);

        b.set(5);
        assertThat(quotient).hasValue(2);

        a.set(12);
        assertThat(quotient).hasValue(2);

        b.set(0);
        assertThat(quotient).hasSameValue(defaultValue);
    }


}
