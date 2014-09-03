package eu.lestard.advanced_bindings.api;

import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import org.junit.Test;

import static eu.lestard.assertj.javafx.api.Assertions.*;

public class ObjectBindings_extract_Test {

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
    public void testExtract(){
        ObjectProperty<Person> selectedPerson = new SimpleObjectProperty<>();

        ObjectBinding<String> name = ObjectBindings.extract(selectedPerson, Person::getName);
        assertThat(name).hasNullValue();

        selectedPerson.set(obi);
        assertThat(name).hasValue("Obi-Wan");

        selectedPerson.set(luke);
        assertThat(name).hasValue("Luke");
    }

    @Test
    public void testExtractWithDefaultValue(){
        ObjectProperty<Person> selectedPerson = new SimpleObjectProperty<>();

        ObjectBinding<String> name = ObjectBindings.extract(selectedPerson, Person::getName, "empty");
        assertThat(name).hasValue("empty");
        selectedPerson.set(obi);
        assertThat(name).hasValue("Obi-Wan");

        selectedPerson.set(luke);
        assertThat(name).hasValue("Luke");
    }

}
