package bolum07;

import java.util.Arrays;

public class BinaryHeap {
    private int[] items;
    private final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private int size;
    
    public BinaryHeap() {
        items = new int[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
        size = 0;
    }
    
    public BinaryHeap(int capacity) {
        items = new int[capacity];
        this.capacity = capacity;
        size = 0;
    }
    
    private boolean isEmpty() {
        return size == 0;
    }
    
    private boolean isFull() {
        return size == capacity;
    }
    
    private void enlarge() {
        items = Arrays.copyOf(items, capacity * 2);
        capacity *= 2;
    }
    
    private void swap(int i, int j) {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }
    
    private void heapifyDown(int index) {
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);
        
        while ((leftChildIndex < size && items[index] > items[leftChildIndex]) ||
                (rightChildIndex < size && items[index] > items[rightChildIndex])) {
            if (leftChildIndex >= size || items[leftChildIndex] < items[rightChildIndex]) {
                swap(index, leftChildIndex);
                index = getLeftChildIndex(index);
            } else {
                swap(index, rightChildIndex);
                index = getRightChildIndex(index);
            }
            leftChildIndex = getLeftChildIndex(index);
            rightChildIndex = getRightChildIndex(index);
        }
    }

    private int getRightChildIndex(int index) {
        return (2 * index) + 2;
    }

    private int getLeftChildIndex(int index) {
        return (2 * index) + 1;
    }
    
    private void heapifyUp() {
        int index = size - 1;
        int parentIndex = getParentIndex(index);
        
        while (parentIndex >= 0 && items[parentIndex] > items[index]) {
            swap(parentIndex, index);
            index = parentIndex;
            parentIndex = getParentIndex(index);
        }
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }
    
    public void add(int item) {
        if (isFull()) {
            enlarge();
        }
        items[size] = item;
        size++;
        heapifyUp();
    }
    
    public Integer extract() {
        if (!isEmpty()) {
            int item = items[0];
            items[0] = items[size - 1];
            heapifyDown(0);
            size--;
            return item;
        }
        return null;
    }
}
