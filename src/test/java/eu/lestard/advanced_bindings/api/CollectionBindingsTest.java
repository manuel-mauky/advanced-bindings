package eu.lestard.advanced_bindings.api;

import javafx.beans.binding.NumberBinding;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Test;

import java.util.function.BinaryOperator;
import java.util.function.Function;

import static eu.lestard.assertj.javafx.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class CollectionBindingsTest {

    @Test
    public void testSumOfIntegerCollection() {
        ObservableList<Integer> numbers = FXCollections.observableArrayList();
        NumberBinding sum = CollectionBindings.sum(numbers);
        assertThat(sum).hasValue(0.0);

        numbers.addAll(1, 2, 3, 5, 8, 13, 21);

        assertThat(sum).hasValue(53.0);

        numbers.add(34);

        assertThat(sum).hasValue(87.0);


    }

    @Test
    public void testSumOfDoubleCollection() {
        ObservableList<Double> numbers = FXCollections.observableArrayList();
        NumberBinding sum = CollectionBindings.sum(numbers);
        assertThat(sum).hasValue(0.0);

        numbers.addAll(1.1, 2.2, 3.3, 5.5, 8.8, 13.13, 21.21);

        assertThat(sum).hasValue(55.24);

        numbers.add(34.34);

        assertThat(sum).hasValue(89.58, offset(0.0001));

    }

    @Test
    public void testSumOfFloatCollection() {
        ObservableList<Float> numbers = FXCollections.observableArrayList();
        NumberBinding sum = CollectionBindings.sum(numbers);
        assertThat(sum).hasValue(0.0);

        numbers.addAll(1f, 2f, 3f, 5f, 8f, 13f, 21f);

        assertThat(sum).hasValue(53.0);

        numbers.add(34f);

        assertThat(sum).hasValue(87.0);
    }

    @Test
    public void testSumOfLongCollection() {
        ObservableList<Long> numbers = FXCollections.observableArrayList();
        NumberBinding sum = CollectionBindings.sum(numbers);
        assertThat(sum).hasValue(0.0);

        numbers.addAll(1l, 2l, 3l, 5l, 8l, 13l, 21l);

        assertThat(sum).hasValue(53.0);

        numbers.add(34l);

        assertThat(sum).hasValue(87.0);

    }

    @Test
    public void testConcatList() {
        ObservableList<String> listA = FXCollections.observableArrayList();
        ObservableList<String> listB = FXCollections.observableArrayList();

        ObservableList<String> concatList = CollectionBindings.concat(listA, listB);

        assertThat(concatList).isEmpty();

        listA.add("a1");
        assertThat(concatList).contains("a1");

        listB.add("b3");
        assertThat(concatList).containsExactly("a1", "b3");

        listB.add("b2");
        assertThat(concatList).containsExactly("a1", "b3", "b2");

        listA.add("a2");
        assertThat(concatList).containsExactly("a1", "a2", "b3", "b2");


        listA.add("z");
        listA.add("m");
        assertThat(concatList).containsExactly("a1", "a2", "z", "m", "b3", "b2");

        listB.remove("b2");
        assertThat(concatList).containsExactly("a1", "a2", "z", "m", "b3");

        listA.remove("a2");
        assertThat(concatList).containsExactly("a1", "z", "m", "b3");

        listB.add("m");
        assertThat(concatList).containsExactly("a1", "z", "m", "b3", "m");
    }

    @Test
    public void testJoinList() {
        ObservableList<Object> items = FXCollections.observableArrayList();
        StringProperty delimiter = new SimpleStringProperty(", ");
        StringBinding joined = CollectionBindings.join(items, delimiter);

        assertThat(joined.get()).isEqualTo("");

        items.add("A");
        assertThat(joined.get()).isEqualTo("A");

        items.add(1);
        assertThat(joined.get()).isEqualTo("A, 1");

        items.add(Runnable.class);
        assertThat(joined.get()).isEqualTo("A, 1, interface java.lang.Runnable");

        delimiter.set(":");
        assertThat(joined.get()).isEqualTo("A:1:interface java.lang.Runnable");
    }

    @Test
    public void testReducingListWithDefaultValue() {
        ObservableList<Number> numbers = FXCollections.observableArrayList();
        ObjectProperty<BinaryOperator<Number>> reducer = new SimpleObjectProperty<>((n1, n2) -> n1.intValue() + n2.intValue());
        ObjectBinding<Number> result = CollectionBindings.reducing(numbers, 0, reducer);

        assertThat(result).hasValue(0);

        numbers.addAll(1, 2, 3, 5, 8, 13, 21);

        assertThat(result).hasValue(53);

        numbers.add(34);

        assertThat(result).hasValue(87);

        reducer.set((n1, n2) -> n2.intValue());

        assertThat(result).hasValue(34);
    }

    @Test
    public void testReducingListWithSupplier() {
        ObservableList<Number> numbers = FXCollections.observableArrayList();
        ObjectProperty<BinaryOperator<Number>> reducer = new SimpleObjectProperty<>((n1, n2) -> n1.intValue() + n2.intValue());
        ObjectBinding<Number> result = CollectionBindings.reducing(numbers, reducer, () -> 0);

        assertThat(result).hasValue(0);

        numbers.addAll(1, 2, 3, 5, 8, 13, 21);

        assertThat(result).hasValue(53);

        numbers.add(34);

        assertThat(result).hasValue(87);

        reducer.set((n1, n2) -> n2.intValue());

        assertThat(result).hasValue(34);
    }

    @Test
    public void testReduceAndMapListWithDefaultValue() {
        ObservableList<Number> numbers = FXCollections.observableArrayList();
        ObjectProperty<BinaryOperator<Number>> reducer = new SimpleObjectProperty<>((n1, n2) -> n1.intValue() + n2.intValue());
        ObjectProperty<Function<Number, String>> mapper = new SimpleObjectProperty<>(String::valueOf);
        ObjectBinding<String> result = CollectionBindings.reduceAndMap(numbers, 0, reducer, mapper);

        assertThat(result).hasValue("0");

        numbers.addAll(1, 2, 3, 5, 8, 13, 21);

        assertThat(result).hasValue("53");

        numbers.add(34);

        assertThat(result).hasValue("87");

        reducer.set((n1, n2) -> n2.intValue());

        assertThat(result).hasValue("34");

        mapper.set(n -> "n=" + n);

        assertThat(result).hasValue("n=34");
    }

    @Test
    public void testReduceAndMapListWithSupplier() {
        ObservableList<Number> numbers = FXCollections.observableArrayList();
        ObjectProperty<BinaryOperator<Number>> reducer = new SimpleObjectProperty<>((n1, n2) -> n1.intValue() + n2.intValue());
        ObjectProperty<Function<Number, String>> mapper = new SimpleObjectProperty<>(String::valueOf);
        ObjectBinding<String> result = CollectionBindings.reduceAndMap(numbers, reducer, mapper, () -> 0);

        assertThat(result).hasValue("0");

        numbers.addAll(1, 2, 3, 5, 8, 13, 21);

        assertThat(result).hasValue("53");

        numbers.add(34);

        assertThat(result).hasValue("87");

        reducer.set((n1, n2) -> n2.intValue());

        assertThat(result).hasValue("34");

        mapper.set(n -> "n=" + n);

        assertThat(result).hasValue("n=34");
    }

    @Test
    public void testMinOfIntegerCollection() {
        ObservableList<Integer> numbers = FXCollections.observableArrayList();
        NumberBinding min = CollectionBindings.min(numbers, 0);
        assertThat(min).hasValue(0.0);

        numbers.addAll(1, 2, 3, 5, 8, 13, 21);

        assertThat(min).hasValue(1.0);

        numbers.remove(0);

        assertThat(min).hasValue(2.0);
    }

    @Test
    public void testMinOfLongCollection() {
        ObservableList<Long> numbers = FXCollections.observableArrayList();
        NumberBinding min = CollectionBindings.min(numbers, 0);
        assertThat(min).hasValue(0.0);

        numbers.addAll(1L, 2L, 3L, 5L, 8L, 13L, 21L);

        assertThat(min).hasValue(1.0);

        numbers.remove(0);

        assertThat(min).hasValue(2.0);
    }

    @Test
    public void testMinOfFloatCollection() {
        ObservableList<Float> numbers = FXCollections.observableArrayList();
        NumberBinding min = CollectionBindings.min(numbers, 0);
        assertThat(min).hasValue(0.0);

        numbers.addAll(1f, 2f, 3f, 5f, 8f, 13f, 21f);

        assertThat(min).hasValue(1.0);

        numbers.remove(0);

        assertThat(min).hasValue(2.0);
    }

    @Test
    public void testMinOfDoubleCollection() {
        ObservableList<Double> numbers = FXCollections.observableArrayList();
        NumberBinding min = CollectionBindings.min(numbers, 0);
        assertThat(min).hasValue(0.0);

        numbers.addAll(1d, 2d, 3d, 5d, 8d, 13d, 21d);

        assertThat(min).hasValue(1.0);

        numbers.remove(0);

        assertThat(min).hasValue(2.0);
    }

    @Test
    public void testMaxOfIntegerCollection() {
        ObservableList<Integer> numbers = FXCollections.observableArrayList();
        NumberBinding max = CollectionBindings.max(numbers, 0);
        assertThat(max).hasValue(0.0);

        numbers.addAll(1, 2, 3, 5, 8, 13, 21);

        assertThat(max).hasValue(21.0);

        numbers.add(34);

        assertThat(max).hasValue(34.0);
    }

    @Test
    public void testMaxOfLongCollection() {
        ObservableList<Long> numbers = FXCollections.observableArrayList();
        NumberBinding max = CollectionBindings.max(numbers, 0);
        assertThat(max).hasValue(0.0);

        numbers.addAll(1L, 2L, 3L, 5L, 8L, 13L, 21L);

        assertThat(max).hasValue(21.0);

        numbers.add(34L);

        assertThat(max).hasValue(34.0);
    }

    @Test
    public void testMaxOfFloatCollection() {
        ObservableList<Float> numbers = FXCollections.observableArrayList();
        NumberBinding max = CollectionBindings.max(numbers, 0);
        assertThat(max).hasValue(0.0);

        numbers.addAll(1f, 2f, 3f, 5f, 8f, 13f, 21f);

        assertThat(max).hasValue(21.0);

        numbers.add(34f);

        assertThat(max).hasValue(34.0);
    }

    @Test
    public void testMaxOfDoubleCollection() {
        ObservableList<Double> numbers = FXCollections.observableArrayList();
        NumberBinding max = CollectionBindings.max(numbers, 0);
        assertThat(max).hasValue(0.0);

        numbers.addAll(1d, 2d, 3d, 5d, 8d, 13d, 21d);

        assertThat(max).hasValue(21.0);

        numbers.add(34d);

        assertThat(max).hasValue(34.0);
    }

    @Test
    public void testAverageOfIntegerCollection() {
        ObservableList<Integer> numbers = FXCollections.observableArrayList();
        NumberBinding average = CollectionBindings.average(numbers, 0);
        assertThat(average).hasValue(0.0);

        numbers.addAll(1, 2, 3, 5, 10, 21);

        assertThat(average).hasValue(7.0);

        numbers.add(42);

        assertThat(average).hasValue(12.0);
    }

    @Test
    public void testAverageOfLongCollection() {
        ObservableList<Long> numbers = FXCollections.observableArrayList();
        NumberBinding average = CollectionBindings.average(numbers, 0);
        assertThat(average).hasValue(0.0);

        numbers.addAll(1L, 2L, 3L, 5L, 10L, 21L);

        assertThat(average).hasValue(7.0);

        numbers.add(42L);

        assertThat(average).hasValue(12.0);
    }

    @Test
    public void testAverageOfFloatCollection() {
        ObservableList<Float> numbers = FXCollections.observableArrayList();
        NumberBinding average = CollectionBindings.average(numbers, 0);
        assertThat(average).hasValue(0.0);

        numbers.addAll(1f, 2f, 3f, 5f, 10f, 21f);

        assertThat(average).hasValue(7.0);

        numbers.add(42f);

        assertThat(average).hasValue(12.0);
    }

    @Test
    public void testAverageOfDoubleCollection() {
        ObservableList<Double> numbers = FXCollections.observableArrayList();
        NumberBinding average = CollectionBindings.average(numbers, 0);
        assertThat(average).hasValue(0.0);

        numbers.addAll(1d, 2d, 3d, 5d, 10d, 21d);

        assertThat(average).hasValue(7.0);

        numbers.add(42d);

        assertThat(average).hasValue(12.0);
    }
}