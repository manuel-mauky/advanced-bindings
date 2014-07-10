package eu.lestard.advanced_bindings.api;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.value.ObservableStringValue;

public class StringBindings {
    public static BooleanBinding matches(final ObservableStringValue text, final String pattern) {
        return Bindings.createBooleanBinding(()->{
            final String textToVerify = text.get();
            return textToVerify != null && textToVerify.matches(pattern);
        }, text);
    }

    public static BooleanBinding matches(final ObservableStringValue text, final ObservableStringValue pattern) {
        return Bindings.createBooleanBinding(()->{
            final String textToVerify = text.get();
            final String patternString = pattern.get();

            return textToVerify != null && patternString != null && textToVerify.matches(patternString);
        }, text, pattern);
    }
}
