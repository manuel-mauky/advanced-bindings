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

import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import org.junit.Test;

import static eu.lestard.assertj.javafx.api.Assertions.*;

public class ObjectBindingsTest {

    private static class Person{
        private final String name;

        public Person(String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    private Person luke = new Person("Luke");
    private Person obi = new Person("Obi-Wan");


    @Test
    public void testMap(){
        ObjectProperty<Person> selectedPerson = new SimpleObjectProperty<>();

        ObjectBinding<String> name = ObjectBindings.map(selectedPerson, Person::getName);
        assertThat(name).hasNullValue();

        selectedPerson.set(obi);
        assertThat(name).hasValue("Obi-Wan");

        selectedPerson.set(luke);
        assertThat(name).hasValue("Luke");
    }

    @Test
    public void testMapWithDefaultValue(){
        ObjectProperty<Person> selectedPerson = new SimpleObjectProperty<>();

        ObjectBinding<String> name = ObjectBindings.map(selectedPerson, Person::getName, "empty");
        assertThat(name).hasValue("empty");
        selectedPerson.set(obi);
        assertThat(name).hasValue("Obi-Wan");

        selectedPerson.set(luke);
        assertThat(name).hasValue("Luke");
    }


    @Test
    public void testCastBinding(){
        class Student extends Person {
            public Student(String name){
                super(name);
            }
        }


        ObjectProperty<Student> studentProperty = new SimpleObjectProperty<>();

        ObjectBinding<Person> person = ObjectBindings.cast(studentProperty);

        assertThat(person).hasNullValue();


        Student student = new Student("luke");
        studentProperty.set(student);

        assertThat(person).hasValue(student);
    }

    @Test
    public void testCastBinding2(){
        ObjectProperty<Double> doubleProperty = new SimpleObjectProperty<>(10.0);

        ObjectBinding<Number> numberBinding = ObjectBindings.cast(doubleProperty);

        assertThat(numberBinding).hasValue(10.0);

        doubleProperty.setValue(12.34);
        assertThat(numberBinding).hasValue(12.34);
    }

}
