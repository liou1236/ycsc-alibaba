package lessonPhaseTwo.day0829;

import java.util.Arrays;
import java.util.IllformedLocaleException;

public class IntArrayList {
    private int[] elementDate;
    private int size;
    public IntArrayList(){
        this.elementDate = new int[10];
    }
    public IntArrayList(int initCapacity) throws IllegalAccessException {
        if (initCapacity < 0){
            throw new IllegalAccessException("水族的初始长度不能小于0：" + initCapacity);
        }
        this.elementDate = new int[initCapacity];
    }

    public void add(int e) throws IllegalAccessException {
        // ensureCapacity(size+1);
        insert(size,e);
    }
    private void ensureCapacity(int i){
        if (elementDate.length < 10){
            elementDate = Arrays.copyOf(elementDate,10);
        }
        grow();
    }
    private void grow(){
        int oldCapacity = elementDate.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        elementDate = Arrays.copyOf(elementDate,newCapacity);
    }
    private void insert(int index,int e) throws IllegalAccessException {
        if (index < 0 || index > size){
            throw new IllegalAccessException("新元素插入下标越界：" + index);
        }

        ensureCapacity(size + 1);
        for (int i = size-1; i >= index ; i--) {
            elementDate[i+1] = elementDate[i];
        }

        elementDate[index] = e;
        size++;

    }
    public int remove(int index) throws IllegalAccessException {
        if (index < 0 || index >= size){
            throw new IllegalAccessException("删除元素下标越界：" + index);
        }
        int removed = elementDate[index];
        for (int i = index + 1;i <= size-1;i++){
            elementDate[i-1] = elementDate[i];
        }
        size--;
        return removed;
    }
    public int get(int index){
        if (index < 0 || index >= size){
            throw new IllformedLocaleException("查询数组下标越界："+ index);
        }
        return elementDate[index];
    }
    public void trimToSize(){
        elementDate = Arrays.copyOf(elementDate,size);
    }
    public int size(){
        return size;
    }
}
