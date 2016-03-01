
public class Heap <E extends Comparable<E>> {
 
    private Object H[];   // contains the objects in the heap
    private int last;     // index of last element in heap
    private int capacity; // max number of elements in heap  

    public Heap(int n){
	capacity = n;
	H        = new Object[capacity+1];
	last     = 0;
    }
    //
    // create a heap with capacity n
    // NOTE: H is an array of objects
    //       must use casting when delivering the minimum
    //       See min() below.
    //       This must also be done in removeMin()
    //

    public Heap(){this(7);}
    //
    // by default, create a new heap with capacity 7
    //

    @SuppressWarnings("unchecked")
    private int compare(Object x,Object y){return ((E)x).compareTo((E)y);}
    
    public int size(){return last;}
    //
    // returns the number of elements in the heap
    //
    
    public boolean isEmpty(){return (last == 0);}
    //
    // is the heap empty?
    //
    
    @SuppressWarnings("unchecked")
    public E min() throws HeapException {
	if (isEmpty()) throw new HeapException("underflow");
	return (E) H[1];
    }
    //
    // returns element with smallest key, without removal
    // NOTE: must use casting to class (E)
    //
	
    
    public void insert(E e) throws HeapException {
	
		if(last == capacity){ throw new HeapException("Overflow");}
	
		//if list is empty, no checks are needed to maintain order
		if(isEmpty()){
			last++;
			H[last] = e;
		}
		
		//inserts e and makes sure the Heap is in the correct order
		else{
			last++;
			H[last] = e;
			
			bubbleUp(last, last/2);
		}
    }
    //
    // inserts e into the heap
    // throws exception if heap overflow
    //
	
	public void bubbleUp(int child, int parent){
		if(compare(H[child], H[parent]) < 0){
			E temp = (E) H[parent];
			H[parent]  = H[child];
			H[child] = temp;
			
			if(parent != 1){bubbleUp(parent, parent/2);}
		}
	}
	//
	//makes sure that parent < child is maintained when a node is inserted
	//calls itself recursively each time a swap is made util parent cell is the root
	//
    
    @SuppressWarnings("unchecked")
    public E removeMin() throws HeapException {
	return null;
    }
    //
    // removes and returns smallest element of the heap
    // throws exception if heap is empty
    // NOTE: must cast result to class (E)
    //       see min() above
    //

    public String toString(){
		StringBuilder s = new StringBuilder("[");
		for(int x = 1; x < last; x++){
			s.append(H[x]);
			s.append(",");
		}
		
		s.append(H[last]);
		s.append("]");
		String theString = s.toString();
	
		return theString;
    }
    //
    // outputs the entries in H in the order H[1] to H[last]
    // in same style as used in ArrayQueue
    // 
    
}

