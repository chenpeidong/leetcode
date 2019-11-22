package site.syso.explore;

/**
 * 循环队列
 *
 * @author chenpeidong
 * @date 2019/11/22 下午3:05
 */
public class MyCircularQueue {

    private int[] arr;

    private int size = 0;

    private int head = -1;

    private int tail = -1;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        if (k <= 0) throw new RuntimeException("illegal size!");
        this.arr = new int[k];
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        this.tail = (this.tail + 1) % this.arr.length;
        if (isEmpty()) {
            this.head = this.tail;
        }
        this.arr[this.tail] = value;
        this.size++;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        if (this.head == this.tail) {
            this.head = -1;
            this.tail = -1;
        } else {
            this.head = (this.head + 1) % this.arr.length;
        }
        this.size--;
        return true;
    }

    /**
     * Get the head item from the queue.
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return this.arr[this.head];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return this.arr[this.tail];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return this.size == this.arr.length;
    }

}
