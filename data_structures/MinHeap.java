public class MinHeap {

    public int[] Heap;
    private int size; // current size
    private int maxSize;
    private static final int FRONT = 1;

    public MinHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        Heap = new int[this.maxSize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return 2 * pos;
    }

    private int rightChild(int pos) {
        return 2 * pos + 1;
    }

    public void updateSize(int newSize) {
        this.maxSize = newSize;
    }

    private boolean isLeaf(int pos) {
        if (pos >= size / 2 && pos <= size) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos) {
        int temp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = temp;
    }

    private void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (Heap[pos] > Heap[leftChild(pos)] && Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                minHeapify(leftChild(pos));
            }
            if (Heap[pos] > Heap[rightChild(pos)]) {
                swap(pos, rightChild(pos));
                minHeapify(rightChild(pos));
            }
        }
    }

    public void insert(int element) {
        if (size >= maxSize) {
            return;
        }

        size++;

        Heap[size] = element;
        int current = size;

        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int remove() {
        int pop = Heap[FRONT];

        Heap[FRONT] = Heap[size];

        Heap[size] = 0;

        size--;

        minHeapify(FRONT);

        return pop;
    }

    public void buildHeap() {
        for (int pos = (size / 2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }

    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + Heap[i]
                    + " LEFT CHILD : " + Heap[2 * i]
                    + " RIGHT CHILD :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    public static void main(String args[]) {
        System.out.println("The Min Heap is ");
        MinHeap minHeap = new MinHeap(15);

        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.buildHeap();

        minHeap.print();
        System.out.println("Removing Min Element : " + minHeap.remove());
        minHeap.print();
    }
}
