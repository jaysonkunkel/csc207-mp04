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
public class AssociativeArrayTestsJayson {
  
  // @Before
  // public static void setUp(){
  //   AssociativeArray<String, String> strings = new AssociativeArray<String, String>();
  //   // strings.set("a", "apple");
  //   // strings.set("b", "banana");
  // }


  /**
   * 
   */
  @Test
  public void testRemove() throws Exception{
    AssociativeArray<String, String> arr = new AssociativeArray<String, String>();
    arr.set("A", "Apple");
    arr.set("B", "Banana");
    arr.remove("A");
    arr.remove("C");

    // should work
    assertEquals("Banana", arr.get("B"));

    // should throw an exception
    try{
      arr.get("A");
    } catch(Exception e) {
      fail("Key not found exception");
    }
    assertEquals("Banana", arr.get("B"));
  } // testRemove

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
  } // testSize()


} // class AssociativeArrayTestsJayson
