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
import javafx.beans.value.ObservableValue;
import javafx.util.Callback;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class SwitchBindings {

    public static class SwitchBuilder<T, R>  {

        private final ObservableValue<T> baseObservable;
        private Map<T, Callback<T, R>> valueMap = new HashMap<>();

        private Supplier<R> defaultValue;

        private SwitchBuilder(ObservableValue<T> baseObservable){
            this.baseObservable = baseObservable;
        }

        /**
         * This builder method is used to define a callback that is used
         * when the base observable has the given value.
         *
         * This is the equivalent to the "case" in a java switch statement.
         *
         * @param value the value for this case statement.
         * @param callback a callback that is executed when this case statement matches the actual value of the base observable.
         * @return this builder instance.
         */
        public SwitchBuilder<T, R> bindCase(T value, Callback<T, R> callback){
            valueMap.put(value, callback);
            return this;
        }

        /**
         * This builder method is used to define a consumer that is used when
         * no case is defined for the actual value of the base observable.
         *
         * This is the equivalent to the "default" case in a java switch statement.
         *
         * @param consumer a consumer that is used to get the default value.
         * @return this builder instance.
         */
        public SwitchBuilder<T, R> bindDefault(Supplier<R> consumer){
            this.defaultValue = consumer;
            return this;
        }

        /**
         * the build-step of the builder. This creates the actual observable binding.
         * @return the observable value defined by this builder.
         */
        public ObservableValue<R> build(){
            return Bindings.createObjectBinding(()-> {
                final T enumValue = baseObservable.getValue();

                if(enumValue == null){
                    return getDefaultValue();
                }

                if(valueMap.containsKey(enumValue)){
                    return valueMap.get(enumValue).call(enumValue);
                }

                return getDefaultValue();
            }, baseObservable);
        }

        private R getDefaultValue(){
            if(defaultValue == null){
                return null;
            }else {
                return defaultValue.get();
            }
        }

    }

    /**
     * Creates builder for a binding that works like a switch-case in java.
     *
     * Example:
     *
     * ```java
     * IntegerProperty base = new SimpleIntegerProperty();
     *
     * ObservableValue<String> result = switchBinding(base, String.class)
     *      .bindCase(3, i -> "three")
     *      .bindCase(10, i -> "ten")
     *      .bindCase(1, i -> "one")
     *      .bindDefault(() -> "nothing")
     *      .build();
     * ```
     *
     * this is the equivalent without observables:
     *
     * ```java
     * int base = ...;
     *
     * switch(base) {
     *     case 3 :
     *          return "three";
     *     case 10:
     *          return "ten";
     *     case 1:
     *          return "one";
     *     default:
     *          return "nothing";
     * }
     *
     * ```
     *
     * There are two differences between this switch binding and the switch statement in java:
     *
     * 1. In the java switch statement only a limited number of types can be used. This binding has no such limitation.
     * You can use every type in the observable that has a properly overwritten {@link Object#equals(Object)} and {@link Object#hashCode()} method.
     *
     * 2. There is no "fall through" and therefore no "break" is needed. Only the callback for the matching case is executed.
     *
     * See [the switch documentation](http://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html) for more information.
     *
     *
     * @param observable the base observable that is used in the switch statement
     * @param bindingType the type of the created observable.
     * @param <T> the generic type of the base observable.
     * @param <R> the generic type of the returned observable.
     * @return a builder that is used to create the switch binding.
     */
    public static <T, R> SwitchBuilder<T, R> switchBinding(ObservableValue<T> observable, Class<R> bindingType) {
        return new SwitchBuilder<>(observable);
    }


}
