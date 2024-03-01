package tdditerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Represents a list of integers, with a built-in iterator that is bidirectional and circular.
 */
public class CircularIteratorListImpl implements CircularIteratorList {

    private final List<Integer> list = new ArrayList<>();
    private int currentIndex = 0;

    @Override
    public void add(int element) {
        list.add(element);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        return iteratorCreator(1);
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return iteratorCreator(-1);
    }


    /**
     * Creates an iterator with a given step
     *
     * @param step the step to be used by the iterator
     * @return the iterator
     */
    private Iterator<Integer> iteratorCreator(int step) {
        return new Iterator<>() {

            @Override
            public boolean hasNext() {
                return !list.isEmpty();
            }

            @Override
            public Integer next() {
                if (list.isEmpty()) {
                    return null;
                }

                currentIndex = (currentIndex + step + list.size()) % list.size();

                return step > 0 ?
                        list.get((currentIndex - step + list.size()) % list.size()) :
                        list.get(currentIndex);
            }
        };
    }


}
