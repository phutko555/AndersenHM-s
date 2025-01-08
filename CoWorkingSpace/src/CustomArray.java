import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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
}


