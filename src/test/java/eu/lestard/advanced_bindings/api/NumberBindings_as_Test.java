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
