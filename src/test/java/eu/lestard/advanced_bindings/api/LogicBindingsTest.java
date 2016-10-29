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
