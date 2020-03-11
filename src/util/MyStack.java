package util;

import java.util.EmptyStackException;

public class MyStack<T> {
    private int capacity;
    private int size;
    private Object[] value;
    private static final int DEFAULT_CAPACITY = 10;
    public MyStack(int capacity){
        this.value = new Object[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public MyStack(){
        this(DEFAULT_CAPACITY);
    }

    public T peek(){
        if (this.isEmpty()){
            throw new EmptyStackException();
        }else {
            return (T) (this.value[this.size - 1]);
        }
    }

    public T pop(){
        if (this.isEmpty()){
            throw new EmptyStackException();
        }else {
            return (T) (this.value[--this.size]);
        }
    }

    public T push(T e){
        this.grow();
        this.value[this.size++] = e;
        return e;
    }

    private void grow(){
        if (this.size < this.capacity){
            return;
        }
        this.capacity <<= 1; //容量扩大为原来的2倍
        Object[] nv = new Object[this.capacity];
        System.arraycopy(nv, 0, this.value, 0, this.size);
        this.value = nv;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int size(){
        return this.size;
    }
}
