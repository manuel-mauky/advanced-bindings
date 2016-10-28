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

import javafx.beans.binding.NumberBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Test;

import static eu.lestard.assertj.javafx.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;

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
    public void testConcatList(){
        ObservableList<String> listA = FXCollections.observableArrayList();
        ObservableList<String> listB = FXCollections.observableArrayList();

        ObservableList<String> concatList =  CollectionBindings.concat(listA, listB);

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
        assertThat(concatList).containsExactly("a1", "a2","z", "m", "b3");

        listA.remove("a2");
        assertThat(concatList).containsExactly("a1", "z", "m", "b3");

        listB.add("m");
        assertThat(concatList).containsExactly("a1", "z", "m", "b3", "m");
    }
}