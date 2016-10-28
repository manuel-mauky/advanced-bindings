/*
 * Copyright (c) 2014-2016 Manuel Mauky
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
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
