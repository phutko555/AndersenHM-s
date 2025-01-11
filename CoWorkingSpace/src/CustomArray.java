import java.io.Serializable;
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CustomArray<T> implements Iterable<T>, Serializable {
    private Object[] arr;

    private int count;


    public CustomArray() {
        this.arr = new Object[3];
    }
    public void add(T item){
        if(arr.length == count) {
            Object[] newItems = new Object[count * 2];
            for (int i = 0; i < count; i++)
                newItems[i] = arr[i];
            arr = newItems;
        }
        arr[count++] = item;
    }

    public void remove(int index){
        for(int i = index; i < count - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[count - 1] = 0;
        count--;
    }
    public int size(){
        return count;
    }

    public T get(int index){
        for(int i = 0; i < count; i++){
            return (T) arr[index];
        }
        throw new IndexOutOfBoundsException("Index out of bounds");
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < count;
            }
            @Override
            public T next() {
                return (T) arr[index++];
            }
        };
    }
    public boolean isEmpty(){
        return count == 0;
    }

    @Override
    public Spliterator<T> spliterator() {
        return new Spliterators.AbstractSpliterator<T>(count, 0) {
            private int index = 0;

            @Override
            public boolean tryAdvance(java.util.function.Consumer<? super T> action) {
                if (index < count) {
                    action.accept((T) arr[index++]);
                    return true;
                }
                return false;
            }
        };
    }

    public Stream<T> stream() {
        return StreamSupport.stream(this.spliterator(), false);
    }
}


