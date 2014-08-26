package eu.lestard.advanced_bindings.api;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import org.junit.Test;

import static eu.lestard.assertj.javafx.api.Assertions.*;

public class LogicBindingsTest {


    @Test
    public void testAND(){

        BooleanProperty a = new SimpleBooleanProperty(false);
        BooleanProperty b = new SimpleBooleanProperty(false);
        BooleanProperty c = new SimpleBooleanProperty(false);
        BooleanProperty d = new SimpleBooleanProperty(false);

        BooleanBinding and = LogicBindings.and(a,b,c,d);

        assertThat(and).isFalse();

        a.set(true);
        assertThat(and).isFalse();

        b.set(true);
        assertThat(and).isFalse();

        c.set(true);
        assertThat(and).isFalse();

        d.set(true);
        assertThat(and).isTrue();

        b.set(false);
        assertThat(and).isFalse();
    }

    @Test
    public void testOR(){

        BooleanProperty a = new SimpleBooleanProperty(true);
        BooleanProperty b = new SimpleBooleanProperty(true);
        BooleanProperty c = new SimpleBooleanProperty(true);
        BooleanProperty d = new SimpleBooleanProperty(true);

        BooleanBinding or = LogicBindings.or(a,b,c,d);

        assertThat(or).isTrue();

        a.set(false);
        assertThat(or).isTrue();

        b.set(false);
        assertThat(or).isTrue();

        c.set(false);
        assertThat(or).isTrue();

        d.set(false);
        assertThat(or).isFalse();

        b.set(true);
        assertThat(or).isTrue();
    }
}
