package llist;

import static org.junit.Assert.*;

import org.junit.Test;

public class SingleLinkedListTailTestAIDA {

	
	 /** Test to see that the initial list is empty */
    @Test
    public void test1() {
        SingleLinkedListTail<String> testInstance = new SingleLinkedListTail<String>();
        assertEquals(0, testInstance.size());
    }

    /**
     * Test to see that the get method throws an
     * exception on an empty list
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void test2() {
        SingleLinkedListTail<String> testInstance = new SingleLinkedListTail<String>();
        assertNull(testInstance.get(0));
    }

    /** Test to see that add with no specified index method inserts a tail node */
    @Test
    public void test3() {
        SingleLinkedListTail<String> testInstance = new SingleLinkedListTail<String>();
        testInstance.add("tom");
        assertEquals(1, testInstance.size());
        assertEquals("[tom]", testInstance.toString());
    }
    

    /** Test to see that add method with no specified index inserts three items */
    
   	@Test
       public void test4() {
           SingleLinkedListTail<String> testInstance = new SingleLinkedListTail<String>();
           testInstance.add("tom");
           testInstance.add("dick");
           testInstance.add("harry");
           assertEquals(3, testInstance.size());
           assertEquals("[tom ==> dick ==> harry]", testInstance.toString());
       }

    /** Test the getTail method on a list of three items returns a tail for the last node*/
    @Test
    public void test5() {
        SingleLinkedListTail<String> testInstance = new SingleLinkedListTail<String>();
        testInstance.add("tom");
        testInstance.add("dick");
        testInstance.add("harry");
        assertEquals("tom", testInstance.get(0));
        assertEquals("dick", testInstance.get(1));
        assertEquals("harry", testInstance.get(2));
        
    }
    /** Test the add method to see if it adds in the middle */   
    @Test
    public void test6() {
        SingleLinkedListTail<String> testInstance = new SingleLinkedListTail<String>();
        testInstance.add("tom");
        testInstance.add("dick");
        testInstance.add("harry");
        testInstance.add(1, "sam");
        assertEquals(4, testInstance.size());
        assertEquals("[tom ==> sam ==> dick ==> harry]",
                testInstance.toString());
    }

    /** Test the add method to see if it adds in the middle */
    @Test
    public void test7() {
        SingleLinkedListTail<String> testInstance = new SingleLinkedListTail<String>();
        testInstance.add("tom");
        testInstance.add("dick");
        testInstance.add("harry");
        testInstance.add(2, "sam");
        assertEquals(4, testInstance.size());
        assertEquals("[tom ==> dick ==> sam ==> harry]",
                testInstance.toString());
    }
   

    /** Test the add method to see if it adds at the beginning */
    @Test
    public void test8() {
        SingleLinkedListTail<String> testInstance = new SingleLinkedListTail<String>();
        testInstance.add("tom");
        testInstance.add("dick");
        testInstance.add("harry");
        testInstance.add(0, "sam");
        assertEquals(4, testInstance.size());
        assertEquals("[sam ==> tom ==> dick ==> harry]",
                testInstance.toString());
    }

    /** Test the add method to see if it adds at the end */
    @Test
    public void test9() {
        SingleLinkedList<String> testInstance = new SingleLinkedList<String>();
        testInstance.add("tom");
        testInstance.add("harry");
        testInstance.add(2, "sam");
        assertEquals(3, testInstance.size());
        assertEquals("[tom ==> harry ==> sam]",
                testInstance.toString());
    }
    

 //////////////////////////   Remove Part   /////////////////////////////////////
    
    // Test the remove(item) method on an empty list 
    @Test
    public void test10() {
        SingleLinkedListTail<String> testInstance = new SingleLinkedListTail<String>();
        assertFalse(testInstance.remove("tom"));
    }

    
    // Test the remove method on an empty list 
    @Test(expected = IndexOutOfBoundsException.class)
    public void test11() {
        SingleLinkedListTail<String> testInstance = new SingleLinkedListTail<String>();
        assertEquals("tom", testInstance.remove(0));
    }

   
    // Test the removeTail method on a list with only one item 
    @Test
    public void test12() {
    	 SingleLinkedList<String> testInstance = new SingleLinkedList<String>();
         testInstance.add("tom");
         assertEquals("tom",testInstance.remove(0));
         assertEquals(0, testInstance.size());
    }

    // Test the remove method by removing the first item 
    @Test
    public void test13() {
    	SingleLinkedListTail<String> testInstance = new SingleLinkedListTail<String>();
    	testInstance.add("tom");
        testInstance.add("dick");
        testInstance.add("harry");
        assertEquals("[tom ==> dick ==> harry]",testInstance.toString());
        assertEquals(3, testInstance.size());
    	assertEquals("tom", testInstance.remove(0));
    	assertEquals(2, testInstance.size());
    	assertEquals("[dick ==> harry]",testInstance.toString());
    }

    // Test the remove method by removing the middle item 
    @Test
    public void test14() {
    	SingleLinkedListTail<String> testInstance = new SingleLinkedListTail<String>();
    	testInstance.add("tom");
        testInstance.add("dick");
        testInstance.add("harry");
    	assertEquals("dick", testInstance.remove(1));
        assertEquals(2, testInstance.size());
        assertEquals("[tom ==> harry]",testInstance.toString());
    }
    

    // Test the remove tail method by removing the last item through removeTail
    @Test
    public void test15() {   
        SingleLinkedListTail<String> testInstance = new SingleLinkedListTail<String>();
    	testInstance.add("tom");
        testInstance.add("dick");
        testInstance.add("harry");
        testInstance.add("sam");
        assertEquals(4, testInstance.size());
    	assertEquals("sam", testInstance.remove(3));
        assertEquals(3, testInstance.size());
    }

}
