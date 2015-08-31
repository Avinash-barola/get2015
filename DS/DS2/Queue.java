

import java.util.*;
public class Queue {
	Object queue[];// make a object type of array to hold all type of values
	int front;// front variable keep starting index of queue
	int rear;// real variable keep last index of queue
	Queue() {
		queue = new Object[10];
		front = -1;
		rear = 0;
	}
	void enqueue(Object queuInformation) {
		if(rear==queue.length) { // if rear is reached at queue length than resize the queue
			Object[] queueBuffer = new Object[queue.length];
			int i;
			for(i=0; i<queue.length; i++) {
				queueBuffer[i] = queue[i];
			}
			queue = new Object[queue.length+10];
			for(i=0; i<queueBuffer.length; i++) {
				queue[i] = queueBuffer[i];
			}
		}
		queue[rear++] = queuInformation;				// put item at rear index and increase rear by one
		if( front == -1 ) {
			front = 0;				// if front = -1 than make it is 0
		}
	}
	Object dequeue() {
		if( front == -1 ) {  // check whether queue is empty
			return null;
		}
		else {
			Object frontInformation = queue[front];		// make a remove object to hold the dequeue item
			int i;
			rear--;				// reduce rear by one
			if( rear == 0 )	{ // if after remove item queue is empty than set front = -1
				front--;
			}
			else { // otherwise shift element one by one
				for(i=0; i<rear; i++) {
					queue[i] = queue[i+1];
				}
			}
			return frontInformation;				// return the remove item
		}
	}
	void makeEmpty() {
		front = -1;
		rear = 0;
		queue = new Object[10];			// reassign queue
	}
	Object getFront() {
		if( front == -1 ) {
			Object t = null;		// check whether queue is empty
			return t;
		}
		else {
			return queue[front];		// return the item at front index
		}
	}
	void display() {			// display the queue items 
		if( front == -1 ) {
			System.out.print("\n Queue is Empty ");
		}
		else {
			int i;
			System.out.print("\n Queue is: ");
			for(i=0; i<rear; i++ ) {
				System.out.print(queue[i]+" ");
			}
		}
	}
	public static void main(String[] args) {
		int choise;
		Object queueInformation;
		Scanner sc = new Scanner(System.in);
		Queue queue = new Queue();
		try {
					queue.enqueue(1); 
					queue.enqueue(2); 
					queue.enqueue(3); 
					queue.enqueue(4); 
					queue.enqueue(5); 
					queue.display();
					System.out.println("Dequeued item is "+queue.dequeue());
					System.out.println("Front item is "+queue.getFront());
					queue.display(); 
					queue.makeEmpty();
					queue.display();
		}
		catch(Exception exception)
		{
			System.out.println(exception.getMessage());
		}
	}

}
		

		
