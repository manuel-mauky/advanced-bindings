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
import javafx.beans.binding.StringBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.Test;

import java.util.Locale;

import static eu.lestard.assertj.javafx.api.Assertions.assertThat;

public class StringBindingsTest {

    @Test
    public void testMatchesWithFixedPattern(){

        StringProperty text = new SimpleStringProperty();

        String pattern = "[0-9]*";

        BooleanBinding matches = StringBindings.matches(text, pattern);


        text.set("19");

        assertThat(matches).isTrue();

        text.set("");
        assertThat(matches).isTrue();

        text.set("no number");

        assertThat(matches).isFalse();

        text.set("1");
        assertThat(matches).isTrue();

        text.set(null);
        assertThat(matches).isFalse();
    }

    @Test
    public void testMatchesWithObservablePattern(){
        StringProperty text = new SimpleStringProperty();

        StringProperty pattern = new SimpleStringProperty();


        BooleanBinding matches = StringBindings.matches(text, pattern);

        assertThat(matches).isFalse();

        text.set("12");
        pattern.set("[0-9]*");
        assertThat(matches).isTrue();

        text.set("");
        assertThat(matches).isTrue();

        pattern.set("[0-9]+");
        assertThat(matches).isFalse();


        pattern.set("(hello|world)");
        assertThat(matches).isFalse();

        text.set("hello");
        assertThat(matches).isTrue();


        text.set(null);
        assertThat(matches).isFalse();

        text.set("world");
        assertThat(matches).isTrue();

        pattern.set(null);
        assertThat(matches).isFalse();
    }


    @Test
    public void testTrim() {
        StringProperty text = new SimpleStringProperty();

        StringBinding trimmed = StringBindings.trim(text);
        assertThat(trimmed).hasValue("");

        text.setValue("test");
        assertThat(trimmed).hasValue("test");

        text.setValue("test  ");
        assertThat(trimmed).hasValue("test");

        text.setValue("   test  ");
        assertThat(trimmed).hasValue("test");
    }

    @Test
    public void testToLowercase () {
        StringProperty text = new SimpleStringProperty();

        StringBinding lowercase = StringBindings.toLowerCase(text);

        assertThat(lowercase).hasValue("");

        text.setValue("Test");

        assertThat(lowercase).hasValue("test");
    }

    @Test
    public void testToLowercaseWithLocale () {
        StringProperty text = new SimpleStringProperty();

        StringBinding lowercase = StringBindings.toLowerCase(text, Locale.ENGLISH);

        assertThat(lowercase).hasValue("");

        text.setValue("Test");

        assertThat(lowercase).hasValue("test");

    }

    @Test
    public void testToLowercaseWithObservableLocale(){
        StringProperty text = new SimpleStringProperty();
        ObjectProperty<Locale> locale = new SimpleObjectProperty<>();

        final StringBinding lowercase = StringBindings.toLowerCase(text, locale);

        assertThat(lowercase).hasValue("");


        text.setValue("Test İ"); // 'İ' will be converted to 'i' in turkish language

        assertThat(lowercase).hasValue("test i̇");

        locale.setValue(Locale.forLanguageTag("tr"));
        assertThat(lowercase).hasValue("test i");
    }


    @Test
    public void testToUppercase () {
        StringProperty text = new SimpleStringProperty();

        StringBinding uppercase = StringBindings.toUpperCase(text);

        assertThat(uppercase).hasValue("");

        text.setValue("Test");

        assertThat(uppercase).hasValue("TEST");
    }

    @Test
    public void testToUppercaseWithLocale () {
        StringProperty text = new SimpleStringProperty();

        StringBinding uppercase = StringBindings.toUpperCase(text, Locale.ENGLISH);

        assertThat(uppercase).hasValue("");

        text.setValue("Test");

        assertThat(uppercase).hasValue("TEST");
    }

    @Test
    public void testToUppercaseWithObservableLocale(){
        StringProperty text = new SimpleStringProperty();
        ObjectProperty<Locale> locale = new SimpleObjectProperty<>();

        final StringBinding uppercase = StringBindings.toUpperCase(text, locale);

        assertThat(uppercase).hasValue("");


        text.setValue("Test i");

        assertThat(uppercase).hasValue("TEST I");

        locale.setValue(Locale.forLanguageTag("tr"));
        assertThat(uppercase).hasValue("TEST İ");
    }

}
