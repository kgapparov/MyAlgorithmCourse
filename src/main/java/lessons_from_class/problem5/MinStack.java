package lessons_from_class.problem5;

public interface MinStack<T> {
    void push(T element);
    T pop();
    T peek();
    T min();
}
