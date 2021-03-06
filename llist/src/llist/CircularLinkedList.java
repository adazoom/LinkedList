package llist;
/**
 * Similar to SingleLinkedListTail except that no tail.
 * tail should not appear anywhere in this class.
 * @author aidazhumabekova
 *
 * @param <E>
 */

public class CircularLinkedList<E> {
	
		    // Nested Class
		    /*<listing chapter="2" number="1">*/
		    /** A Node is the building block for the SingleLinkedList */
		    private static class Node<E> {

		        /** The data value. */
		        private E data;
		        /** The link */
		        private Node<E> next = null;

		        /**
		         * Construct a node with the given data value and link
		         * @param data - The data value 
		         * @param next - The link
		         */
		        public Node(E data, Node<E> next) {
		            this.data = data;
		            this.next = next;
		        }

		        /**
		         * Construct a node with the given data value
		         * @param data - The data value 
		         */
		        public Node(E data) {
		            this(data, null);
		        }
		    }
		    
		    // Data fields
		    /** A reference to the tail and the tail of the list */
		    private Node<E> tail= null;
		    /** The size of the list */
		    private int size = 0;

		    // Helper Methods
		    /** Insert an item as the first item of the list.
		     *	@param item The item to be inserted
		     */
		    private void addFirst(E item) {
		        tail = new Node<E>(item, tail);
		        size++;
		    }

		    /**
		     * Add a node after a given node
		     * @param node The node which the new item is inserted after
		     * @param item The item to insert
		     */
		    private void addAfter(Node<E> node, E item) {
		        node.next = new Node<E>(item, node.next);
		        size++;
		    }

		    /**
		     * Remove the first node from the list
		     * @returns The removed node's data or null if the list is empty
		     */
		    private E removeFirst() {
		        Node<E> temp = tail;
		        if (tail != null) {
		            tail = tail.next;
		        }
		        if (temp != null) {
		            size--;
		            return temp.data;
		        } else {
		            return null;
		        }
		    }

		    /**
		     * Remove the node after a given node
		     * @param node The node before the one to be removed
		     * @returns The data from the removed node, or null
		     *          if there is no node to remove
		     */
		    private E removeAfter(Node<E> node) {
		        Node<E> temp = node.next;
		        if (temp != null) {
		            node.next = temp.next;
		            size--;
		            return temp.data;
		        } else {
		            return null;
		        }
		    }

		    /**
		     * Find the node at a specified index
		     * @param index The index of the node sought
		     * @returns The node at index or null if it does not exist
		     */
		    private Node<E> getNode(int index) {
		        Node<E> node = tail;
		        for (int i = 0; i < index && node != null; i++) {
		            node = node.next;
		        }
		        return node;
		    }

		    // Public Methods
		    /**
		     * Get the data value at index
		     * @param index The index of the element to return
		     * @returns The data at index
		     * @throws IndexOutOfBoundsException if the index is out of range
		     */
		    public E get(int index) {
		        if (index < 0 || index >= size) {
		            throw new IndexOutOfBoundsException(Integer.toString(index));
		        }
		        if(index==size-1){
		        	getTail();
		        }
		        Node<E> node = getNode(index);
		        return node.data;
		    }

		    /**
		     * Set the data value at index
		     * @param index The index of the item to change
		     * @param newValue The new value
		     * @returns The data value previously at index
		     * @throws IndexOutOfBoundsException if the index is out of range
		     */
		    public E set(int index, E newValue) {
		        if (index < 0 || index >= size) {
		            throw new IndexOutOfBoundsException(Integer.toString(index));
		        }
		        Node<E> node = getNode(index);
		        E result = node.data;
		        node.data = newValue;
		        return result;
		    }

		    /**
		     * Insert the specified item at the specified position in the list.
		     * Shifts the element currently at that position (if any) and any
		     * subsequent elements to the right (adds one to their indicies)
		     * @param index Index at which the specified item is to be inserted
		     * @param item The item to be inserted
		     * @throws IndexOutOfBoundsException if the index is out of range
		     */
		    public void add(int index, E item) {
		        if (index < 0 || index > size) {
		            throw new IndexOutOfBoundsException(Integer.toString(index));
		        }
		        if (index == 0) {
		            addFirst(item);
		        } 
		        
		        else {
		            Node<E> node = getNode(index - 1);
		            addAfter(node, item);
		        }
		    }

		    /**
		     * Append the specified item to the end of the list
		     * @param item The item to be appended
		     * @returns true (as specified by the Collection interface)
		     */
		    public boolean add(E item) {
		    	if(size==0){
		    		addFirst(item);
		    	}
		    	else
		        addTail(item);
		        return true;
		    }

		    /**
		     * Query the size of the list
		     * @return The number of objects in the list
		     */
		    int size() {
		        return size;
		    }

		    /**
		     * Obtain a string representation of the list
		     * @return A String representation of the list 
		     */
		    @Override
		    public String toString() {
		        StringBuilder sb = new StringBuilder("[");
		        Node p = tail;
		        if (p != null) {
		            while (p.next != null) {
		                sb.append(p.data.toString());
		                sb.append(" ==> ");
		                p = p.next;
		            }
		            sb.append(p.data.toString());
		        }
		        sb.append("]");
		        return sb.toString();
		    }

		    /*<exercise chapter="2" section="5" type="programming" number="1">*/
		    /**
		     * Remove the item at the specified position in the list. Shifts
		     * any subsequent items to the left (subtracts one from their
		     * indices). Returns the item that was removed.
		     * @param index The index of the item to be removed
		     * @returns The item that was at the specified position
		     * @throws IndexOutOfBoundsException if the index is out of range
		     */
		    
		    public E remove(int index) {
		    	Node<E> indexNode=getNode(index);
		    	if (index < 0 || index>= size)
		    	{
		    	    //out of bounds
		    	    throw new IndexOutOfBoundsException();
		    	}
		    	else if(index==0){
		    		removeFirst();
		    	}
		    	else if(index==size-1){
		    		removeTail();
		    	}
		    	else{
		    	//get the current one at the specified index -1
		    	Node<E> curNode=getNode(index-1);
		    	//remove a node that is after it
		    	removeAfter(curNode);
		    	}
		    	return indexNode.data;
		    	
		    	
		    }
		    
		    
		    /*<exercise chapter="2" section="5" type="programming" number="3">*/
		    /**
		     * Remove the first occurrence of element item.
		     * @param item The item to be removed
		     * @return true if item is found and removed; otherwise, return false.
		     */
		    
		    public boolean remove(E item) {
		        //return null if tail is null
		        if(tail == null) 
		        	return false;
		        //if the item is the tail 
		        if((tail.data).equals(item)) {
		        	if(tail.next!=null){
		            	tail=getNode(1);
		            	}
		            	else
		            		tail=null;
		            	size--;
		        	
		        	return true;
		        	}
		        //if the item is elsewhere
		        //create a temporary node starting with tail
		        Node<E> temp=tail;
		        int count=1;
		        //while the data in the node is not the item data 
		        while( !temp.data.equals(item) && temp!=null){
		        temp=getNode(count);
		        count++;
		        }
		        //if the node with such item wasnt found
		        if(temp==null){
		        	return false;
		        }
		        //remove the node that has a matching item
		        remove(count-1);
		        count=1;
		        return true;
		        
		    }
			/**
			 * Get the tail node of the list.
			 **/
			private Node<E> getTail(){
				//create a temp node to go through array
				Node<E> temp=tail;
				while(temp.next!=null){
					//get the next to temporary node
					temp= temp.next;
				}
				return temp;
			}
			
			/**
			 * Insert the node at the tail of the list.
			 **/
			private void addTail(E node ){
				//add a new last Node after the previous tail
				addAfter(getTail(),node);
				
			}
			 
			/**
			 * Remove tail node
			 **/
			public void removeTail(){
				//change the pointer of the node previous to the last node to null
				//create a temp node to go through array
				Node<E> temp=tail;
				//check whether the node two from now is null
				while(temp.next.next!=null){
					//set the temp to next node
					temp= temp.next;
				}
				//remove the tail and update the tail instance
				removeAfter(temp);
			}
		    

		

	

}
