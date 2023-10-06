import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import structures.AssociativeArray;
import structures.KeyNotFoundException;

/**
 * A series of tests for the AssociativeArray class.
 * 
 * @author Jayson Kunkel
 */
public class AssociativeArrayTests {

  /**
   * test that set works correctly when array is not full
   */
  @Test
  public void testSet() throws Exception{
    AssociativeArray<String, String> arr = new AssociativeArray<String, String>();

    arr.set("A", "Apple");
    arr.set("B", "Banana");
    arr.set("C", "Cookie");

    // check that each value was set and size updated
    assertEquals("Apple", arr.get("A"));
    assertEquals("Banana", arr.get("B"));
    assertEquals("Cookie", arr.get("C"));
    assertEquals(3, arr.size());

    // check that value is replaced
    arr.set("A", "Aardvark");
    assertEquals("Aardvark", arr.get("A"));
  } // testSet()

  /**
   * Test that set works correctly when array is full
   */
  @Test
  public void testSetFull() throws Exception{
    AssociativeArray<Integer, String> arr = new AssociativeArray<Integer, String>();

    // set some KVpairs
    for(int i = 0; i < 16; i++){
      arr.set(i, i + " mississippi");
    }
    assertEquals(16, arr.size());

    // test that new KVpair is added to end of array if it is full
    arr.set(16, "16 mississippi");
    assertEquals(17, arr.size());
    assertEquals("16 mississippi", arr.get(16));

  } // testSetFull()

  /**
   * Testing that get works as intended
   */
  @Test
  public void testGet(){
    AssociativeArray<Integer, String> arr = new AssociativeArray<Integer, String>();

    // should throw a KeyNotFoundException if key is not in array - empty array
    try{
      assertEquals("mississippi", arr.get(11));
      fail("key 11 does not exist in the array");
    } catch (KeyNotFoundException e){
      // do nothing
    }

    // set some KVpairs
    for(int i = 0; i < 10; i++){
      arr.set(i, i + " mississippi");
    }

    // check that find works correctly for each index
    try {
      for(int i = 0; i < 10; i++){
        assertEquals(i + " mississippi", arr.get(i));
      }
    } catch (KeyNotFoundException e) {
      fail("Could not find key in array");
    }

    // should throw a KeyNotFoundException if key is not in array - values in array
    try{
      assertEquals("11 mississippi", arr.get(11));
      fail("key 11 does not exist in the array");
    } catch (KeyNotFoundException e){
      // do nothing
    }
  } // testGet()

  /**
   * Test that array is changed upon calls to remove()
   * 
   */
  @Test
  public void testRemove(){
    AssociativeArray<String, String> arr = new AssociativeArray<String, String>();
    arr.set("A", "Apple");
    arr.set("B", "Banana");
    arr.remove("A");
    arr.remove("B");

    // array should be empty
    assertEquals(0, arr.size());
  } // testRemove()

  /**
   * Test that nothing happens when trying to remove a key that's not in the array
   */
  @Test
  public void testRemoveNotFound() throws Exception{
    AssociativeArray<String, String> arr = new AssociativeArray<String, String>();
    arr.set("A", "Apple");
    arr.set("B", "Banana");
    arr.remove("C");

    // array should be unchanged
    assertEquals("Apple", arr.get("A"));
    assertEquals("Banana", arr.get("B"));
    assertEquals(2, arr.size());
  } // testRemoveNotFound()

  /**
   * Test that the hasKey() method returns true and false as intended
   */
  @Test
  public void testHasKey(){
    AssociativeArray<String, String> arr = new AssociativeArray<String, String>();
    arr.set("A", "Apple");

    assertEquals(true, arr.hasKey("A"));
    assertEquals(false, arr.hasKey("B"));
  } // testHasKey()

  /**
   * Test that the hasKey() method returns false for an empty array
   */
  @Test
  public void testHasKeyEmpty(){
    AssociativeArray<String, String> arr = new AssociativeArray<String, String>();
    assertEquals(false, arr.hasKey("B"));
  } // testHasKeyEmpty()


  /**
   * Test the size() method for empty, some-full, and full arrays
   */
  @Test
  public void testSize(){
    AssociativeArray<String, String> arr = new AssociativeArray<String, String>();

    // empty array should have size 0
    assertEquals(0, arr.size());

    // should have size 1
    arr.set("0", "value");
    assertEquals(1, arr.size());

    // default size is 16; full array should have size 16
    for(int i = 0; i < 15; i++){
      arr.set("" + i, "value");
    } // for

    assertEquals(16, arr.size());

    arr.remove("2");
    arr.remove("4");
    assertEquals(14, arr.size());
  } // testSize()
  
  /**
   * Testing that find works as intended
   */
  @Test
  public void testFind(){
    AssociativeArray<Integer, String> arr = new AssociativeArray<Integer, String>();

    // should throw a KeyNotFoundException if key is not in array - empty array
    try{
      assertEquals(11, arr.find(11));
      fail("key 11 does not exist in the array");
    } catch (KeyNotFoundException e){
      // do nothing
    }

    // set some KVpairs
    for(int i = 0; i < 10; i++){
      arr.set(i, i + " mississippi");
    }

    // check that find works correctly for each index
    try {
      for(int i = 0; i < 10; i++){
        assertEquals(i, arr.find(i));
      }
    } catch (KeyNotFoundException e) {
      fail("Could not find key in array");
    }

    // should throw a KeyNotFoundException if key is not in array - values in array
    try{
      assertEquals(11, arr.find(11));
      fail("key 11 does not exist in the array");
    } catch (KeyNotFoundException e){
      // do nothing
    }
  } // testFind()

} // class AssociativeArrayTests
