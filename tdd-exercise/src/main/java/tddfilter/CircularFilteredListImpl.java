package tddfilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class CircularFilteredListImpl implements CircularFilteredList {

    private int currentIndex = 0;
    private final List<Integer> list = new ArrayList<>();

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
    public Optional<Integer> next() {
        if (list.isEmpty()) {
            return Optional.empty();
        }
        Optional<Integer> result = Optional.of(list.get(currentIndex));
        currentIndex = (currentIndex + 1) % list.size();
        return result;
    }

    @Override
    public Optional<Integer> previous() {
        if (list.isEmpty()) {
            return Optional.empty();
        }
        currentIndex = (currentIndex - 1 + list.size()) % list.size();
        return Optional.of(list.get(currentIndex));
    }

    @Override
    public void reset() {
        currentIndex = 0;
    }

    @Override
    public Optional<Integer> filteredNext(Predicate<Integer> predicate) {
        if (list.isEmpty()) {
            return Optional.empty();
        }
        int initialIndex = currentIndex;
        while (!predicate.test(list.get(currentIndex))) {
            currentIndex = (currentIndex + 1) % list.size();
            if (currentIndex == initialIndex) {
                return Optional.empty();
            }
        }
        Optional<Integer> result = Optional.of(list.get(currentIndex));
        currentIndex = (currentIndex + 1) % list.size();
        return result;
    }
}
