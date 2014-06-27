package eu.lestard.advanced_bindings.api;

import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.NumberBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Test;

import static eu.lestard.assertj.javafx.api.Assertions.*;
import static org.assertj.core.api.Assertions.offset;

public class CollectionBindingsTest {

    @Test
    public void testSumOfIntegerCollection(){
        ObservableList<Integer> numbers = FXCollections.observableArrayList();
        NumberBinding sum = CollectionBindings.sum(numbers);
        assertThat(sum).hasValue(0.0);

        numbers.addAll(1, 2, 3, 5, 8, 13, 21);

        assertThat(sum).hasValue(53.0);


        numbers.add(34);

        assertThat(sum).hasValue(87.0);
    }

    @Test
    public void testSumOfDoubleCollection(){
        ObservableList<Double> numbers = FXCollections.observableArrayList();
        NumberBinding sum = CollectionBindings.sum(numbers);
        assertThat(sum).hasValue(0.0);

        numbers.addAll(1.1, 2.2, 3.3, 5.5, 8.8, 13.13, 21.21);

        assertThat(sum).hasValue(55.24);


        numbers.add(34.34);

        assertThat(sum).hasValue(89.58, offset(0.0001));

    }

    @Test
    public void testSumOfFloatCollection(){
        ObservableList<Float> numbers = FXCollections.observableArrayList();
        NumberBinding sum = CollectionBindings.sum(numbers);
        assertThat(sum).hasValue(0.0);

        numbers.addAll(1f, 2f, 3f, 5f, 8f, 13f, 21f);

        assertThat(sum).hasValue(53.0);


        numbers.add(34f);

        assertThat(sum).hasValue(87.0);
    }

    @Test
    public void testSumOfLongCollection(){
        ObservableList<Long> numbers = FXCollections.observableArrayList();
        NumberBinding sum = CollectionBindings.sum(numbers);
        assertThat(sum).hasValue(0.0);

        numbers.addAll(1l, 2l, 3l, 5l, 8l, 13l, 21l);

        assertThat(sum).hasValue(53.0);


        numbers.add(34l);

        assertThat(sum).hasValue(87.0);

    }

    @Test
    public void testSize(){
        ObservableList<Number> numbers = FXCollections.observableArrayList();
        IntegerBinding size = CollectionBindings.size(numbers);

        assertThat(size).hasValue(0);

        numbers.addAll(1, 2, 3, 5, 8, 13, 21);

        assertThat(size).hasValue(7);

        numbers.add(34);

        assertThat(size).hasValue(8);
    }

}
