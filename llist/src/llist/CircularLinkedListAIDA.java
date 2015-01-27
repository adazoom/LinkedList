package llist;

import static org.junit.Assert.*;

import org.junit.Test;

public class CircularLinkedListAIDA {

	  /** Test to see that the initial list is empty */
  @Test
  public void test1() {
      CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
      assertEquals(0, testInstance.size());
  }

  /**
   * Test to see that the get method throws an
   * exception on an empty list
   */
  @Test(expected = IndexOutOfBoundsException.class)
  public void test2() {
      CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
      assertNull(testInstance.get(0));
  }

  /** Test to see that add method inserts an item */ 
  @Test
  public void test3() {
      CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
      testInstance.add("tom");
      assertEquals(1, testInstance.size());
      assertEquals("[tom]", testInstance.toString());
  }
	

  /** Test to see that add method inserts three items */
  @Test
  public void test4() {
      CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
      testInstance.add("tom");
      testInstance.add("dick");
      testInstance.add("harry");
      assertEquals(3, testInstance.size());
      assertEquals("[tom ==> dick ==> harry]", testInstance.toString());
  }

  /** Test the get method on a list of three items */
  @Test
  public void test5() {
      CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
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
      CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
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
      CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
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
      CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
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
      CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
      testInstance.add("tom");
      testInstance.add("dick");
      testInstance.add("harry");
      testInstance.add(3, "sam");
      assertEquals(4, testInstance.size());
      assertEquals("[tom ==> dick ==> harry ==> sam]",
              testInstance.toString());
  }

  
  
  //////////////////////////   Remove Part   /////////////////////////////////////
  
  // Test the remove(item) method on an empty list 
  @Test
  public void test10() {
      CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
      assertFalse(testInstance.remove("tom"));
  }

  
  // Test the remove method on an empty list 
  @Test(expected = IndexOutOfBoundsException.class)
  public void test11() {
      CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
      assertEquals("tom", testInstance.remove(0));
  }

 
  // Test the remove method on a list with only one item 
  @Test
  public void test12() {
  	CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
  	testInstance.add("tom");
  	assertEquals("tom", testInstance.remove(0));
      assertEquals(0, testInstance.size());
  }

  // Test the remove method by removing the first item 
  @Test
  public void test13() {
  	CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
  	testInstance.add("tom");
      testInstance.add("dick");
      testInstance.add("harry");
  	assertEquals("tom", testInstance.remove(0));
  	assertEquals("[dick ==> harry]",testInstance.toString());
      assertEquals(2, testInstance.size());
  }

  // Test the remove method by removing the middle item 
  @Test
  public void test14() {
  	CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
  	testInstance.add("tom");
    testInstance.add("dick");
    testInstance.add("harry");
  	assertEquals("dick", testInstance.remove(1));
  	assertEquals("[tom ==> harry]",testInstance.toString());
    assertEquals(2, testInstance.size());
  }
  

  // Test the remove method by removing the last item 
  @Test
  public void test15() {   
      CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
  	  testInstance.add("tom");
      testInstance.add("dick");
      testInstance.add("harry");
      testInstance.add("sam");
  	  assertEquals("sam", testInstance.remove(3));
  	assertEquals("[tom ==> dick ==> harry]",testInstance.toString());
      assertEquals(3, testInstance.size());
  }

 
  // Test the remove(item) method on a list with one item 
  @Test
  public void test16() {
      CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
  	testInstance.add("tom");
  	assertTrue(testInstance.remove("tom"));
      assertEquals(0, testInstance.size());  	
  }

  // Test the remove(item) from the first item of a list 
  @Test
  public void test17() {
      CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
  	testInstance.add("tom");
      testInstance.add("dick");
      testInstance.add("harry");
      testInstance.add("sam");
  	assertTrue(testInstance.remove("tom"));
  	assertEquals("[dick ==> harry ==> sam]",testInstance.toString());
      assertEquals(3, testInstance.size());
  }

  // Test the remove(item) from the second item of a list 
  @Test
  public void test18() {
      CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
  	  testInstance.add("tom");
      testInstance.add("dick");
      testInstance.add("harry");
      testInstance.add("sam");
  	  assertTrue(testInstance.remove("dick"));
  	assertEquals("[tom ==> harry ==> sam]",testInstance.toString());
      assertEquals(3, testInstance.size());
  }

  // Test the remove(item) from the third item of a list 
  @Test
  public void test19() {
      CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
  	  testInstance.add("tom");
      testInstance.add("dick");
      testInstance.add("harry");
      testInstance.add("sam");
  	  assertTrue(testInstance.remove("harry"));
  	assertEquals("[tom ==> dick ==> sam]",testInstance.toString());
      assertEquals(3, testInstance.size());
  }

  // Test the remove(item) from the last item of a list 
  @Test
  public void test20() {
      CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
  	  testInstance.add("tom");
      testInstance.add("dick");
      testInstance.add("harry");
      testInstance.add("sam");
  	  assertTrue(testInstance.remove("sam"));
  	assertEquals("[tom ==> dick ==> harry]",testInstance.toString());
      assertEquals(3, testInstance.size());
  }
  
  @Test
  public void test21(){
  	CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
   	  testInstance.add("tom");
      testInstance.add("dick");
      testInstance.add("sam");
      testInstance.add(0, "aida");
      assertEquals("[aida ==> tom ==> dick ==> sam]",testInstance.toString());
      
   	  assertTrue(testInstance.remove("tom"));
   	  assertEquals("[aida ==> dick ==> sam]",testInstance.toString());
      assertEquals(3, testInstance.size());   
      assertTrue(testInstance.remove("dick"));
      assertEquals("[aida ==> sam]",testInstance.toString());
      assertEquals(2, testInstance.size());   
      assertTrue(testInstance.remove("aida"));
      assertEquals("[sam]",testInstance.toString());
      assertEquals(1, testInstance.size());   
  }
  

}
