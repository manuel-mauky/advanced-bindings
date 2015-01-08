package eu.lestard.advanced_bindings.api;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableValue;
import javafx.util.Callback;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class SwitchBindings {

    public static class SwitchBuilder<E, R>  {

        private final ObservableValue<E> observableEnum;
        private Map<E, Callback<E, R>> valueMap = new HashMap<>();

        private Supplier<R> defaultValue;

        private SwitchBuilder(ObservableValue<E> observableEnum){
            this.observableEnum = observableEnum;
        }

        public SwitchBuilder<E, R> bindCase(E value, Callback<E, R> callback){
            valueMap.put(value, callback);
            return this;
        }

        public SwitchBuilder<E, R> bindDefault(Supplier<R> consumer){
            this.defaultValue = consumer;
            return this;
        }

        public ObservableValue<R> build(){
            return Bindings.createObjectBinding(()-> {
                final E enumValue = observableEnum.getValue();

                if(enumValue == null){
                    return getDefaultValue();
                }

                if(valueMap.containsKey(enumValue)){
                    return valueMap.get(enumValue).call(enumValue);
                }

                return getDefaultValue();
            }, observableEnum);
        }

        private R getDefaultValue(){
            if(defaultValue == null){
                return null;
            }else {
                return defaultValue.get();
            }
        }

    }

    public static <E, R> SwitchBuilder<E, R> switchBinding(ObservableValue<E> observableEnum, Class<R> bindingType) {
        return new SwitchBuilder<>(observableEnum);
    }


}
