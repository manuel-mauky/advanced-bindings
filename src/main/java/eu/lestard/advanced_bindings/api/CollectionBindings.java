package eu.lestard.advanced_bindings.api;

import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

    @SafeVarargs
    public static <T> ObservableList<T> concat(ObservableList<T> ... lists) {
        ObservableList<T> result = FXCollections.observableArrayList();

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
