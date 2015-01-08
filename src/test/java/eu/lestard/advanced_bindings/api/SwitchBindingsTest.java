package eu.lestard.advanced_bindings.api;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
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
}
