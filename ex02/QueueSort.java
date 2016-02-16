import java.util.*;


import java.io.*;

public class QueueSort<E extends Comparable<E>> {

    private ArrayQueue<ArrayQueue<E>> Q;
    public static final int CAPACITY = 10;  // default queue capacity
    private int n;    
    private boolean trace;
	
    public QueueSort(){this(CAPACITY);}
	
    public QueueSort(int capacity){
	n = capacity;
	Q = new ArrayQueue<ArrayQueue<E>>(n);
    }

    private ArrayQueue<E> merge(ArrayQueue<E> q1,ArrayQueue<E> q2) throws ArrayQueueException {
		ArrayQueue<E> q3 = new ArrayQueue<E>(q1.size()+q2.size());
		E el = null;
		
		//Sizes have to be set here as dequeuing reduces the size of the queue and ends the loops early
		int q1Size = q1.size();
		int q2Size = q2.size();
		
		for(int x = 0; x < q1Size; x++){
			el = q1.dequeue();
			q3.enqueue(el);
		}
		
		for(int x = 0; x < q2Size; x++){
			el = q2.dequeue();
			q3.enqueue(el);
		}
		
		return q3;
    }
    //
    // Take two sorted queues and merge them to produce a third
    // sorted queue
    //

    public void sort(){
		
		if(Q.size() != 1){
			ArrayQueue<E> tempQueue1 = Q.dequeue();
			ArrayQueue<E> tempQueue2 = Q.dequeue();
			ArrayQueue<E> tempQueue3 = merge(tempQueue1, tempQueue2);
			Q.enqueue(tempQueue3);
			sort();
		}
		
	}
    //
    // IMPLEMENT ME
    // given a queue Q of queues
    // (1) if Q is of size 1 deliver the first queue in Q
    // (2) if Q is of size 2 or more 
    //     - get the first and second queues off Q
    //     - merge these two queues to create a third queue
    //     - add the third queue to the queue
    //     - go back to (1)
    //

    public void add(E element){
		ArrayQueue<E> temp = new ArrayQueue<E>();
		temp.enqueue(element);
		Q.enqueue(temp);
	}
    //
    // IMPLEMENT ME
    // create an ArrayQueue<E> that contains the element
    // enqueue it onto Q
    //
    
    public String toString(){return Q.toString();}

    public void trace(){trace = !trace;}

    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new File(args[0]));
	ArrayList<String> data = new ArrayList<String>();
	while (sc.hasNext()) data.add(sc.next());
	int n = data.size();
	QueueSort<String> QS = new QueueSort<String>(n);
	for (String s : data) QS.add(s);
	if (args.length > 1) QS.trace();
	QS.sort();
	System.out.println(QS);
    }
}
