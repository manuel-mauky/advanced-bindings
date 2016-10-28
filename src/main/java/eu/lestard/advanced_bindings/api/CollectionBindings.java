package eu.lestard.advanced_bindings.api;

import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * This class contains custom binding implementations for collections.
 *
 * @author manuel mauky
 */
public class CollectionBindings {

    /**
     * Creates a number binding that contains the sum of the numbers of the given observable list of numbers.
     *
     * @param numbers the observable list of numbers.
     * @return a number binding.
     */
    public static NumberBinding sum(final ObservableList<? extends Number> numbers) {
        return Bindings.createDoubleBinding(() -> numbers.stream().mapToDouble(Number::doubleValue).sum(), numbers);
    }

    /**
     * Creates a string binding that constructs a sequence of characters separated by a delimiter.
     *
     * @param items the observable list of items.
     * @param delimiter the sequence of characters to be used between each element.
     * @return a string binding.
     */
    public static StringBinding join(final ObservableList<?> items, final ObservableValue<String> delimiter) {
        return Bindings.createStringBinding(() -> items.stream().map(String::valueOf).collect(Collectors.joining(delimiter.getValue())), items, delimiter);
    }

    /**
     * Returns an object binding whose value is the reduction of all elements in the list.
     *
     * @param items        the observable list of elements.
     * @param defaultValue the value to be returned if there is no value present, may be null
     * @param reducer      an associative, non-interfering, stateless function for combining two values
     *
     * @return an object binding
     */
    public static <T> ObjectBinding<T> reducing(final ObservableList<T> items, final T defaultValue, final ObservableValue<BinaryOperator<T>> reducer) {
        return Bindings.createObjectBinding(() -> items.stream().reduce(reducer.getValue()).orElse(defaultValue), items, reducer);
    }

    /**
     * Returns an object binding whose value is the reduction of all elements in the list.
     *
     * @param items    the observable list of elements.
     * @param reducer  an associative, non-interfering, stateless function for combining two values
     * @param supplier a {@code Supplier} whose result is returned if no value is present
     *
     * @return an object binding
     */
    public static <T> ObjectBinding<T> reducing(final ObservableList<T> items, final ObservableValue<BinaryOperator<T>> reducer, final Supplier<T> supplier) {
        return Bindings.createObjectBinding(() -> items.stream().reduce(reducer.getValue()).orElseGet(supplier), items, reducer);
    }

    /**
     * Returns an object binding whose value is the mapped reduction of all elements in the list.
     *
     * @param items        the observable list of elements.
     * @param defaultValue the value to be returned if there is no value present, may be null
     * @param reducer      an associative, non-interfering, stateless function for combining two values
     * @param mapper       a non-interfering, stateless function to apply to the reduced value
     *
     * @return an object binding
     */
    public static <T, R> ObjectBinding<R> reduceAndMap(final ObservableList<T> items, final T defaultValue, final ObservableValue<BinaryOperator<T>> reducer, final ObservableValue<Function<T, R>> mapper) {
        return Bindings.createObjectBinding(() -> mapper.getValue().apply(items.stream().reduce(reducer.getValue()).orElse(defaultValue)), items, reducer, mapper);
    }

    /**
     * Returns an object binding whose value is the mapped reduction of all elements in the list.
     *
     * @param items    the observable list of elements.
     * @param reducer  an associative, non-interfering, stateless function for combining two values
     * @param supplier a {@code Supplier} whose result is returned if no value is present
     * @param mapper   a non-interfering, stateless function to apply to the reduced value
     *
     * @return an object binding
     */
    public static <T, R> ObjectBinding<R> reduceAndMap(final ObservableList<T> items, final ObservableValue<BinaryOperator<T>> reducer, final ObservableValue<Function<T, R>> mapper, final Supplier<T> supplier) {
        return Bindings.createObjectBinding(() -> mapper.getValue().apply(items.stream().reduce(reducer.getValue()).orElseGet(supplier)), items, reducer, mapper);
    }

    /**
     * Creates an observable list that represents the concatenated source lists. All elements from the all source lists
     * will be contained in the new list. If there is a change in any of the source lists this change will also be done
     * in the concatenated list.
     *
     * The order of elements will be maintained. All elements of the first source list will be located before all elements of
     * the second list and so on. So if an element is added to the first list, this element will be located
     * between the old elements of the first list and the second list's elements.
     *
     *
     * **Hint:** *At the moment this observable list is implemented with {@link javafx.beans.InvalidationListener}s on
     * the source lists and by clearing and recreating the concatenated list on every change. This should be kept in mind
     * when using a {@link javafx.collections.ListChangeListener} on the concatenated list as it will react multiple times
     * when a change is done to one of the source lists.
     *
     * This behaviour will likely be changed in the future as it means a performance limitation too.
     *
     *
     * @param lists a var-args array of observable lists.
     * @param <T> the generic type of the lists.
     * @return a new observable list representing the concatenation of the source lists.
     */
    @SafeVarargs
    public static <T> ObservableList<T> concat(ObservableList<T> ... lists) {
        ObservableList<T> result = FXCollections.observableArrayList();

        // todo: think about a smarter solution
        for (ObservableList<T> list : lists) {
            list.addListener((Observable observable) -> {
                result.clear();

                for (ObservableList<T> ts : lists) {
                    result.addAll(ts);
                }
            });
        }

        return result;
    }
}
