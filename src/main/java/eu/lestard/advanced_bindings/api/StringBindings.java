package eu.lestard.advanced_bindings.api;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.value.ObservableValue;

import java.util.Locale;
import java.util.function.Function;

/**
 * This class contains custom binding implementations for Strings.
 *
 * @author manuel mauky
 * @author andres almiray
 */
public class StringBindings {
	
	
	/**
	 * Creates a boolean binding that is `true` when the given observable string matches the given RegExp pattern.
	 *
	 * @param text
	 *            the observable string that is verified.
	 * @param pattern
	 *            the RegExp pattern that is used.
	 * @return a boolean binding instance.
	 */
	public static BooleanBinding matches(final ObservableValue<String> text, final String pattern) {
		return Bindings.createBooleanBinding(() -> {
			final String textToVerify = text.getValue();
			return textToVerify != null && textToVerify.matches(pattern);
		}, text);
	}
	
	/**
	 * Creates a boolean binding that is `true` when the given observable string matches the given RegExp pattern (also
	 * given as observable string).
	 *
	 * @param text
	 *            the observable string that is verified.
	 * @param pattern
	 *            the observable string with the RegExp pattern that is used.
	 * @return a boolean binding instance.
	 */
	public static BooleanBinding matches(final ObservableValue<String> text, final ObservableValue<String> pattern) {
		return Bindings.createBooleanBinding(() -> {
			final String textToVerify = text.getValue();
			final String patternString = pattern.getValue();
			
			return textToVerify != null && patternString != null && textToVerify.matches(patternString);
		}, text, pattern);
	}
	
	/**
	 * Creates a string binding that contains the trimmed value of the given observable string. See
	 * {@link String#trim()}.
	 *
	 * If the given observable string has a value of `null` the created binding will contain an empty string.
	 *
	 * @param text
	 *            the source string that will used for trimming.
	 * @return a binding containing the trimmed string.
	 */
	public static StringBinding trim(ObservableValue<String> text) {
		return Bindings.createStringBinding(()
				-> text.getValue() == null ? "" : text.getValue().trim(), text);
	}
	
	
	/**
	 * Creates a string binding that contains the value of the given observable string converted to lowercase. See
	 * {@link String#toLowerCase()}.
	 *
	 * If the given observable string has a value of `null` the created binding will contain an empty string.
	 * 
	 * @param text
	 *            the source string that will used for the conversion.
	 * @return a binding containing the lowercase string.
	 */
	public static StringBinding toLowerCase(ObservableValue<String> text) {
		return Bindings.createStringBinding(()
				-> text.getValue() == null ? "" : text.getValue().toLowerCase(), text);
	}
	
	/**
	 * Creates a string binding that contains the value of the given observable string converted to lowercase with the
	 * given locale. See {@link String#toLowerCase(Locale)}.
	 *
	 * If the given observable string has a value of `null` the created binding will contain an empty string.
	 *
	 * @param text
	 *            the source string that will used for the conversion.
	 * @param locale
	 *            the locale that will be used for conversion.
	 * @return a binding containing the lowercase string.
	 */
	public static StringBinding toLowerCase(ObservableValue<String> text, Locale locale) {
		return Bindings.createStringBinding(()
				-> text.getValue() == null ? "" : text.getValue().toLowerCase(locale), text);
	}


    /**
     * Creates a string binding that contains the value of the given observable string converted to lowercase with the
     * given locale. See {@link String#toLowerCase(Locale)}.
     *
     * If the given observable string has a value of `null` the created binding will contain an empty string.
     *
     * If the given observable locale has a value of `null` {@link Locale#getDefault()} will be used instead.
     *
     * @param text
     *            the source string that will used for the conversion.
     * @param locale
     *            an observable containing the locale that will be used for conversion.
     * @return a binding containing the lowercase string.
     */
	public static StringBinding toLowerCase(ObservableValue<String> text, ObservableValue<Locale> locale) {
		return Bindings.createStringBinding(() -> {
			if (text.getValue() == null) {
				return "";
			}
			
			final Locale localeValue = locale.getValue() == null ? Locale.getDefault() : locale.getValue();
			
			return text.getValue().toLowerCase(localeValue);
		}, text, locale);
	}

    /**
     * Creates a string binding that contains the value of the given observable string converted to uppercase. See
     * {@link String#toUpperCase()}.
     *
     * If the given observable string has a value of `null` the created binding will contain an empty string.
     *
     * @param text
     *            the source string that will used for the conversion.
     * @return a binding containing the uppercase string.
     */
	public static StringBinding toUpperCase(ObservableValue<String> text) {
		return Bindings.createStringBinding(()
				-> text.getValue() == null ? "" : text.getValue().toUpperCase(), text);
	}

    /**
     * Creates a string binding that contains the value of the given observable string converted to uppercase with the
     * given locale. See {@link String#toUpperCase(Locale)}.
     *
     * If the given observable string has a value of `null` the created binding will contain an empty string.
     *
     * @param text
     *            the source string that will used for the conversion.
     * @param locale
     *            the locale that will be used for conversion.
     * @return a binding containing the uppercase string.
     */
	public static StringBinding toUpperCase(ObservableValue<String> text, Locale locale) {
		return Bindings.createStringBinding(()
				-> text.getValue() == null ? "" : text.getValue().toUpperCase(locale), text);
	}


    /**
     * Creates a string binding that contains the value of the given observable string converted to uppercase with the
     * given locale. See {@link String#toUpperCase(Locale)}.
     *
     * If the given observable string has a value of `null` the created binding will contain an empty string.
     *
     * If the given observable locale has a value of `null` {@link Locale#getDefault()} will be used instead.
     *
     * @param text
     *            the source string that will used for the conversion.
     * @param locale
     *            an observable containing the locale that will be used for conversion.
     * @return a binding containing the uppercase string.
     */
	public static StringBinding toUpperCase(ObservableValue<String> text, ObservableValue<Locale> locale) {
		return Bindings.createStringBinding(() -> {
			final Locale localeValue = locale.getValue() == null ? Locale.getDefault() : locale.getValue();
			
			return text.getValue() == null ? "" : text.getValue().toUpperCase(localeValue);
		}, text, locale);
	}

	/**
	 * Creates a string binding that contains the value of the given observable string transformed using the supplied
	 * function.
	 *
	 * If the given observable string has a value of `null` the created binding will contain an empty string.
	 *
	 * If the given function has a value of `null` {@link Function#identity()} will be used instead.
	 *
	 * @param text
	 *            the source string that will used for the conversion.
	 * @param transformer
	 *            a non-interfering, stateless function to apply to the source string.
	 * @return a binding containing the transformed string.
	 */
	public static StringBinding transforming(ObservableValue<String> text, Function<String, String> transformer) {
		return Bindings.createStringBinding(()
			-> {
			Function<String, String> func = transformer == null ? Function.identity() : transformer;
			return text.getValue() == null ? "" : func.apply(text.getValue());
		}, text);
	}

	/**
	 * Creates a string binding that contains the value of the given observable string transformed using the supplied
	 * function.
	 *
	 * If the given observable string has a value of `null` the created binding will contain an empty string.
	 *
	 * If the given observable function has a value of `null` {@link Function#identity()} will be used instead.
	 *
	 * @param text
	 *            the source string that will used for the conversion.
	 * @param transformer
	 *            a non-interfering, stateless function to apply to the source string.
	 * @return a binding containing the transformed string.
	 */
	public static StringBinding transforming(ObservableValue<String> text, ObservableValue<Function<String, String>> transformer) {
		return Bindings.createStringBinding(() -> {
			Function<String, String> func = transformer.getValue() == null ? Function.identity() : transformer.getValue();
			return text.getValue() == null ? "" : func.apply(text.getValue());
		}, text, transformer);
	}
}
