package eu.lestard.advanced_bindings.api;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import org.junit.Test;

import static eu.lestard.assertj.javafx.api.Assertions.assertThat;


public class SwitchBindingsTest {

    public static enum State {
        A,
        B,
        C,
        D
    }

    @Test
    public void testSwitchWithEnum(){
        ObjectProperty<State> state = new SimpleObjectProperty<>();


        final ObservableValue<String> binding = SwitchBindings.switchBinding(state, String.class)
                .bindCase(State.A, e -> "Value A")
                .bindCase(State.B, e -> "Value B")
                .bindCase(State.C, e -> "Value C")
                .bindDefault(() -> "Default")
                .build();

        assertThat(binding).hasValue("Default");


        state.setValue(State.A);
        assertThat(binding).hasValue("Value A");

        state.setValue(State.C);
        assertThat(binding).hasValue("Value C");

        state.setValue(null);
        assertThat(binding).hasValue("Default");

        state.setValue(State.D);
        assertThat(binding).hasValue("Default");
    }

    @Test
    public void testSwitchWithString(){
        StringProperty base = new SimpleStringProperty();

        final ObservableValue<Integer> result = SwitchBindings.switchBinding(base, Integer.class)
                .bindCase("one", s -> 1)
                .bindCase("two", s -> 2)
                .bindCase("three", s -> 3)
                .build();

        assertThat(result).hasNullValue();

        base.setValue("one");
        assertThat(result).hasValue(1);


        base.setValue("three");
        assertThat(result).hasValue(3);


        base.setValue("four");
        assertThat(result).hasNullValue();
    }
}
