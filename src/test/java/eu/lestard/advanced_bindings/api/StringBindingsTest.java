package eu.lestard.advanced_bindings.api;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.Test;

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
}
