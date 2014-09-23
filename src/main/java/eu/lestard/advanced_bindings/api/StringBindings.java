package eu.lestard.advanced_bindings.api;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.value.ObservableStringValue;

/**
 * This class contains custom binding implementations for Strings.
 */
public class StringBindings {


    /**
     * Creates a boolean binding that is `true` when the given observable string matches the given
     * RegExp pattern.
     *
     * @param text the observable string that is verified.
     * @param pattern the RegExp pattern that is used.
     * @return a boolean binding instance.
     */
    public static BooleanBinding matches(final ObservableStringValue text, final String pattern) {
        return Bindings.createBooleanBinding(()->{
            final String textToVerify = text.get();
            return textToVerify != null && textToVerify.matches(pattern);
        }, text);
    }

    /**
     * Creates a boolean binding that is `true` when the given observable string matches the given
     * RegExp pattern (also given as observable string).
     *
     * @param text the observable string that is verified.
     * @param pattern the observable string with the RegExp pattern that is used.
     * @return a boolean binding instance.
     */
    public static BooleanBinding matches(final ObservableStringValue text, final ObservableStringValue pattern) {
        return Bindings.createBooleanBinding(()->{
            final String textToVerify = text.get();
            final String patternString = pattern.get();

            return textToVerify != null && patternString != null && textToVerify.matches(patternString);
        }, text, pattern);
    }
}
