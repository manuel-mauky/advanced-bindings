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
