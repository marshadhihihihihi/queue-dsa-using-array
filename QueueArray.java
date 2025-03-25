import java.util.Scanner;
class QueueArray {
	
	private int[] queue;
	private int front;
	private int rear;
	private int capacity;
	
	public QueueArray(int size) {
		
		this.queue = new int[size];
		front = 0;
		rear = -1;
		capacity = size;
		
	}

	public boolean isEmpty() {
		
		return front > rear;
		
	}
	
	public boolean isFull() {
		
		return (rear - front + 1) == capacity;
		
	}
	
	public void insert(int item) {
		
		if (isFull()) {
			
			System.out.println("Queue is full");
			return;
		}
		
		rear++;
		queue[rear] = item;
		System.out.println(item+" is inserted to the queue");
	}
	
	public int remove() {
		
		if (isEmpty()) {
			
			return -1;
			
		}
		
		int removedNumber = queue[front];
		front++;
		
		if (front > rear) {
			
			front = 0;
			rear = -1;
			
		}
		
		return removedNumber;
		
	}
	
	public int peekFront() {
		
		if (isEmpty()) {
			
			return -1;
			
		}
		
		return queue[front];
		
	}
	
	
	
	public int size() {
		
		return capacity;
		
	}
	
	//method to count number of elements in this queue after performing operations
	public int getCount() {
		
		if (isEmpty()) {
			
			return -1;
			
		}
		
		return rear - front + 1;
		
	}
	
	public void displayQueue() {
		
		for (int i = front; i <= rear; i++) {
			
			System.out.print(queue[i]+" ");
			
		}
	}
	
	public static void main(String...args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("What is the size of this queue : ");
		int size = sc.nextInt();
		System.out.println();
		
		QueueArray queue = new QueueArray(size);

		for (int i = 0; i < queue.size(); i++) {
			
			System.out.print("Enter number "+(i + 1)+" to store in this queue : ");
			int item = sc.nextInt();
			System.out.println();
			
			queue.insert(item);
			
		}
		
		System.out.println();
		
		System.out.println("Removed element : "+queue.remove());
		
		System.out.println("Front element : "+queue.peekFront());
		
		System.out.println("Queue is empty : "+queue.isEmpty());
		
		System.out.println("Queue is full : "+queue.isFull());
		
		System.out.println("Elements in this queue : ");
		queue.displayQueue();
		
		System.out.println();
		
		System.out.println("Number of elements in this queue : "+queue.getCount());
		
	}
}