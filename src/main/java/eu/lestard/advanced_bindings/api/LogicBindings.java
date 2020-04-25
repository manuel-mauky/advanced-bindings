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

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.value.ObservableValue;

import java.util.Arrays;
import java.util.Collection;


public class LogicBindings {

    /**
     * A boolean binding that is `true` only when all dependent observable boolean values
     * are `true`.
     *
     * This can be useful in cases where the
     * {@link Bindings#and(javafx.beans.value.ObservableBooleanValue, javafx.beans.value.ObservableBooleanValue)}
     * with 2 arguments isn't enough.
     *
     * @param values variable number of observable boolean values that are used for the binding
     * @return the boolean binding
     */
    @SafeVarargs
    public static BooleanBinding and(ObservableValue<Boolean>...values) {
        return Bindings.createBooleanBinding(
            ()-> !Arrays.stream(values)
                .filter(observable -> !observable.getValue())
                .findAny()
                .isPresent(), values);
    }

    /**
     * A boolean binding that is `true` only when all dependent observable boolean values
     * are `true`.
     *
     * This can be useful in cases where the
     * {@link Bindings#and(javafx.beans.value.ObservableBooleanValue, javafx.beans.value.ObservableBooleanValue)}
     * with 2 arguments isn't enough.
     *
     * @param values collection of observable boolean values that are used for the binding
     * @return the boolean binding
     */
    @SuppressWarnings("unchecked")
    public static BooleanBinding and(Collection<ObservableValue<Boolean>> values) {
        return and(values.toArray(new ObservableValue[0]));
    }

    /**
     * A boolean binding that is only `true` when at leased one of the dependent observable boolean values
     * are `true`.
     *
     * This can be useful in cases where the
     * {@link Bindings#or(javafx.beans.value.ObservableBooleanValue, javafx.beans.value.ObservableBooleanValue)}
     * with 2 arguments isn't enough.
     *
     * @param values variable number of observable boolean values that are used for the binding
     * @return the boolean binding
     */
    @SafeVarargs
    public static BooleanBinding or(ObservableValue<Boolean>...values) {
        return Bindings.createBooleanBinding(()-> Arrays.stream(values)
            .filter(ObservableValue::getValue)
            .findAny()
            .isPresent(), values);
    }

    /**
     * A boolean binding that is only `true` when at leased one of the dependent observable boolean values
     * are `true`.
     *
     * This can be useful in cases where the
     * {@link Bindings#or(javafx.beans.value.ObservableBooleanValue, javafx.beans.value.ObservableBooleanValue)}
     * with 2 arguments isn't enough.
     *
     * @param values collection of observable boolean values that are used for the binding
     * @return the boolean binding
     */
    @SuppressWarnings("unchecked")
    public static BooleanBinding or(Collection<ObservableValue<Boolean>> values) {
        return or(values.toArray(new ObservableValue[0]));
    }
}
