package lessons_from_class.problem5;

import java.util.LinkedList;
import java.util.List;

public class MinStackImpl<T extends Comparable<T>> implements MinStack<T>{
    List<T> stack;
    T min;

    public MinStackImpl() {
        stack = new LinkedList<>();
        min = null;
    }

    @Override
    public void push(T element) {
        stack.add(0, element);
        if (min == null)
            min = element;
        else
            min = min.compareTo(element) > 0 ? element : min;
    }

    @Override
    public T pop() {
        T removedElement = stack.remove(0);
        if (stack.size() == 0)
            min = null;
        else
            min = min.compareTo(removedElement) == 0 ? getNextMin() : min;
        return removedElement;
    }

    T getNextMin(){
        T tmp = stack.get(0);
        for (T elem : stack) {
            tmp = tmp.compareTo(elem) > 0 ? elem : tmp;
        }
        return tmp;
    }

    @Override
    public T peek() {
        return stack.get(0);
    }

    @Override
    public T min() {
        return min;
    }

}
