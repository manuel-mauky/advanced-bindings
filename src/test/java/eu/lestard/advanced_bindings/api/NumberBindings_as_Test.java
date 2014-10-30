package eu.lestard.advanced_bindings.api;

import javafx.beans.binding.*;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import org.junit.Test;

import static eu.lestard.assertj.javafx.api.Assertions.*;

public class NumberBindings_as_Test {


    @Test
    public void testAsInteger(){
        ObjectProperty<Number> source = new SimpleObjectProperty<>();

        IntegerBinding target = NumberBindings.asInteger(source);

        assertThat(target).hasValue(0);

        source.setValue(3);

        assertThat(target).hasValue(3);

        source.setValue(13.37);
        assertThat(target).hasValue(13);
    }

    @Test
    public void testAsDouble(){
        ObjectProperty<Number> source = new SimpleObjectProperty<>();

        DoubleBinding target = NumberBindings.asDouble(source);

        assertThat(target).hasValue(0.0);

        source.setValue(3);

        assertThat(target).hasValue(3.0);

        source.setValue(13.37);
        assertThat(target).hasValue(13.37);
    }

    @Test
    public void testAsLong(){
        ObjectProperty<Number> source = new SimpleObjectProperty<>();

        LongBinding target = NumberBindings.asLong(source);

        assertThat(target).hasValue(0l);

        source.setValue(3);

        assertThat(target).hasValue(3l);

        source.setValue(13.37);
        assertThat(target).hasValue(13l);
    }

    @Test
    public void testAsFloat(){
        ObjectProperty<Number> source = new SimpleObjectProperty<>();

        FloatBinding target = NumberBindings.asFloat(source);

        assertThat(target).hasValue(0f);

        source.setValue(3);

        assertThat(target).hasValue(3f);

        source.setValue(13.37);
        assertThat(target).hasValue(13.37f);
    }

}
