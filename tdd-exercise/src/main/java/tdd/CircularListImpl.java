package tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList{

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
        currentIndex = (currentIndex + 1) % list.size();
        return Optional.of(list.get(currentIndex));
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
}
