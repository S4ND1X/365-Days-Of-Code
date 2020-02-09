public class ArrayStack {
    private Integer[] arr;
    private Integer size;

    // 开辟一个固定大小的栈
    public ArrayStack(int inSize) {
        if (inSize < 0) {
            throw new IllegalArgumentException("less than 0");
        }
        this.arr = new Integer[inSize];
        this.size = 0;
    }

    public Integer check() {
        if (this.size == 0) {
            return null;
        }
        return this.arr[this.size - 1];
    }

    public void push(int value) {
        if (this.size == this.arr.length) {
            throw new ArrayIndexOutOfBoundsException("Full");
        }
        this.arr[this.size++] = value;
    }

    public Integer pop() {
        if (this.size == 0) {
            throw new ArrayIndexOutOfBoundsException("Empty");
        }
        return this.arr[--thi.size];
    }
}
