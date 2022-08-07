package heaps;

// implementation of MaxHeap
public class MaxHeap {

	// array which will store the heap
	private int[] Heap;
	private int size;
	private int maxSize;
	private static final int FRONT = 1;

	public MaxHeap(int maxSize) {
		this.maxSize = maxSize;
		this.size = 0;
		Heap = new int[maxSize + 1];
		Heap[0] = Integer.MAX_VALUE;
	}

	public MaxHeap() {
		this.maxSize = 11;
		this.size = 0;
		Heap = new int[this.maxSize];
		Heap[0] = Integer.MAX_VALUE;
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

	private void maxHeapify(int pos) {
		if (isLeaf(pos)) {
			return;
		}

		if (Heap[pos] < Heap[leftChild(pos)] && Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
			swap(pos, leftChild(pos));
			maxHeapify(leftChild(pos));
		}

		if (Heap[pos] < Heap[rightChild(pos)]) {
			swap(pos, rightChild(pos));
			maxHeapify(rightChild(pos));
		}
	}

	public void buildHeap() {
		for (int pos = (size / 2); pos >= 1; pos--) {
			maxHeapify(pos);
		}
	}

	public void insert(int element) {
		if (size >= maxSize) {
			return;
		}

		size++;

		Heap[size] = element;
		int current = size;

		while (Heap[current] > Heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}

	public int remove() {
		int pop = Heap[FRONT];

		Heap[FRONT] = Heap[size];

		Heap[size] = 0;

		size--;

		maxHeapify(FRONT);

		return pop;
	}

	public void print() {
		for (int i = 1; i <= size / 2; i++) {
			System.out.print(" PARENT : " + Heap[i]
					+ " LEFT CHILD : " + Heap[2 * i]
					+ " RIGHT CHILD :" + Heap[2 * i + 1]);
			System.out.println();
		}
	}

	public String toString() {
		this.print();
		return "Hello";
	}

	public static void main(String args[]) {
		System.out.println("The MaxHeapify Heap is ");
		MaxHeap maxHeap = new MaxHeap(15);

		maxHeap.insert(5);
		maxHeap.insert(3);
		maxHeap.insert(17);
		maxHeap.insert(10);
		maxHeap.insert(84);
		maxHeap.insert(19);
		maxHeap.insert(6);
		maxHeap.insert(22);
		maxHeap.insert(9);
		maxHeap.buildHeap();

		// maxHeap.print();
		System.out.println("Removing Max Element : " + maxHeap.remove());
		// maxHeap.print();
		System.out.println("Removing Max Element : " + maxHeap.remove());
		// maxHeap.print();
		System.out.println(maxHeap);
	}
}
