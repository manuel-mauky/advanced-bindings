package eu.lestard.advanced_bindings.api;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.NumberBinding;
import javafx.collections.ObservableList;

public class CollectionBindings {

    public static NumberBinding sum(final ObservableList<? extends Number> numbers) {
        return Bindings.createDoubleBinding(() -> numbers.stream().mapToDouble(Number::doubleValue).sum(), numbers);
    }

    public static IntegerBinding size(final ObservableList<?> observableList) {
        return Bindings.createIntegerBinding(observableList::size, observableList);
    }
}
