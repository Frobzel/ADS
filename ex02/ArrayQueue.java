import java.util.*;
import java.io.*;

public class ArrayQueue<E> {

    public static final int CAPACITY = 10;  // default queue capacity
    private E[] Q;                          // E array used to implement the queue  
    private int n;                          // actual capacity of queue
    private int front;                      // index for the top of queue
    private int rear;                       // rear of the queue
    private int size;                       // size of the queue
    
	
    public ArrayQueue(){this(CAPACITY);}

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity){
		n = capacity;
		Q = (E[]) new Object [n]; 
		front = rear = size = 0;
    }
    //
    // NOTE: java does not allow creation of array with parametrised type!
    //
	
    public int size(){
		return size;
	}
	 
    public boolean isEmpty(){
		return(size <= 0);
	}

    public E front() throws ArrayQueueException {
		return Q[front];
	}
	
	/*
	Method to add enqueue a new element
	Throws overflow exception if the queue is full
	Otherwise adds an element to the rear and increments the size
	It then increments the rear and mods it by n so that if rear 
	was at the maximum element it is reset back to 0
	*/
    public void enqueue(E element) throws ArrayQueueException {
		if(size == n)
			throw new ArrayQueueException("Queue Overflow");
		else{
			Q[rear] = element;
			size++;
			rear = (rear + 1)%n;
		}
	
	}

    /*
	Method to dequeue an element
	If the queue is empty throws an underflow exception
	Otherwise stores the front element in a temporary variable
	then moves the front pointer to the next element in the queue
	and decreases the size of the queue
	The element stored in the temporary variable is then returned
	*/
    public E dequeue() throws ArrayQueueException {	
		if(isEmpty())
			throw new ArrayQueueException("Queue Underflow");
		else{
			E temp = front();
			front = (front+1)%n;
			size--;
			return temp;
		}
	}
    
    public String toString(){
		String s = "[";
		int currentCell = front;
		if(isEmpty())
			return s + "]";

		for(int x = 0; x < size -1; x++){
			s = s + Q[currentCell%n] + ",";
			currentCell = (currentCell + 1) % n;
		}
		s = s + Q[(front + size-1)%n] + "]";
		
		return s;
		
	}
    //
    // 
    // NOTE: if the queue contains 1,2,3 then return "[1,2,3]"
    //       if the queue contains 1 then return "[1]"
    //       if the queue is empty return "[]"
    //
}
	
