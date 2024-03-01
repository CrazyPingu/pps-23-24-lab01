package tddfilter;

import tdd.CircularList;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * Represents a list of integers, with a built-in iterator that is bidirectional and circular.
 * Example: with a list like {1,2,3}, the first call of next() returns 1, the second call returns 2,
 * the third returns 3, the fourth returns 1, and so on. Call to previous() goes in the other way.
 */
public interface CircularFilteredList extends CircularList {

    /**
     * Provides the next element of the list that satisfies a given condition, as given by the built-in iterator.
     *
     * @param predicate the condition to be satisfied by the next element
     * @return the next element of the list that satisfies the given condition, or an empty optional if the list is empty
     */
    Optional<Integer> filteredNext(final Predicate<Integer> predicate);
}
