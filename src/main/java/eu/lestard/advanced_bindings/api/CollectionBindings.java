package eu.lestard.advanced_bindings.api;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
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
}
