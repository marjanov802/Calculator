package application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;
import java.util.EmptyStackException;
import org.junit.jupiter.api.Test;

/**
 * @author DMarjanov
 */


public class StackTest {

  // TEST PUSH ENTRY

  @Test
  // test 1.1 checks if push entry adds to an empty stack
  public void testPushEntryToEmptyStack() {
    Stack stack = new Stack();
    Entry entry = new Entry(1.7f);
    stack.push(entry);
    assertFalse(stack.isEmpty());// check if stack is not empty
  }

  @Test
  // test 1.2 checks if push entry adds to an non empty stack
  public void testPushEntryToStack() {
    Stack stack = new Stack();
    Entry entry1 = new Entry(1.9f);
    Entry entry2 = new Entry(2.1f);
    stack.push(entry1);
    stack.push(entry2);
    assertFalse(stack.isEmpty());
  }

  @Test
  // test 1.3 checks if push entry adds symbols as well as floats to non empty
  // stack
  public void testStackSymbolAndNumber() {
    Stack stack = new Stack();
    Entry entryA = new Entry(3.1f);
    Entry entryB = new Entry(Symbol.PLUS);
    stack.push(entryA);
    stack.push(entryB);
    assertFalse(stack.isEmpty());
  }

  // TEST POP ENTRY

  @Test
  // test 2.1 checks if pop returns exception when empty stack is popped
  // Exception should state that stack is empty
  public void testStackEmptyPop() {
    Stack stack = new Stack();
    try {
      stack.pop();
      fail("Expected EmptyStackException"); // Changed from NoSuchElementException to EmptyStackException
    } catch (EmptyStackException e) {
      // No need to check the error message for EmptyStackException
    }
  }

  @Test
  // test 2.2 checks if pop gets top entry in non-empty stack
  public void testStackPopReturn() {
    Stack stack = new Stack();
    Entry entry = new Entry(9.9f);
    Entry entry1 = new Entry(9.8f);
    Entry entry2 = new Entry(9.7f);
    stack.push(entry);
    stack.push(entry1);
    stack.push(entry2);
    Entry poppedEntry = stack.pop();
    assertEquals(entry2, poppedEntry);
  }

  @Test
  // test 2.3 check that symbols can be popped in a non empty stack
  public void testStackSymbolPop() {
    Stack stack = new Stack();
    Entry entry = new Entry(3.0f);
    Entry entry2 = new Entry(Symbol.PLUS);
    stack.push(entry);
    stack.push(entry2);
    Entry poppedEntry = stack.pop();
    assertEquals(entry2, poppedEntry);
  }

  // TEST TOP ENTRY

  @Test
  // test 3.1 checks if top entry is returned form stack
  public void testStackTopEntryReturn() {
    Stack stack = new Stack();
    Entry entry1 = new Entry(3.0f);
    Entry entry2 = new Entry(5.0f);
    stack.push(entry1);
    stack.push(entry2);

    Entry topEntry = stack.top();
    assertEquals(entry2, topEntry);
  }

  @Test
  // test 3.2 checks if top entry is returned from an empty stack
  // error should be throw
  public void testStackTopEntryReturnEmptyStack() {
    Stack stack = new Stack();
    try {
      stack.top();
      fail("Expected EmptyStackException"); // Changed from NoSuchElementException to EmptyStackException
    } catch (EmptyStackException e) {
      // No need to check the error message for EmptyStackException
    }
  }

  @Test
  // test 3.3 checks if top entry is returned when it is a symbol
  public void testStackTopEntryReturnWhenSymbol() {
    Stack stack = new Stack();
    Entry entry1 = new Entry(7.0f);
    Entry entry2 = new Entry(8.0f);
    Entry entry3 = new Entry(Symbol.DIVIDE);
    stack.push(entry1);
    stack.push(entry2);
    stack.push(entry3);

    Entry topEntry = stack.top();
    assertEquals(entry3, topEntry);
  }

  // TEST FOR SIZE INT

  @Test
  // test 4.1 checks if size returns 0 for empty stack
  public void testStackEmptyStackSize() {
    Stack stack = new Stack();
    int stackSize = stack.size();
    assertEquals(0, stackSize);
  }

  @Test
  // test 4.2 checks if size returns correct size
  public void testStackSize() {
    Stack stack = new Stack();
    Entry entry1 = new Entry(11.3f);
    Entry entry2 = new Entry(12.4f);
    stack.push(entry1);
    stack.push(entry2);

    int stackSize = stack.size();
    assertEquals(2, stackSize);
  }

  @Test
  // test 4.3 checks if size returns correct after multiple pops and pushes
  // 4 push , 2 pop , 1 push , return size 3
  public void testStackPopPushCorrectSize() {
    Stack stack = new Stack();
    Entry entry1 = new Entry(3.0f);
    Entry entry2 = new Entry(5.0f);
    Entry entry3 = new Entry(Symbol.LEFT_BRACKET);
    Entry entry4 = new Entry(Symbol.RIGHT_BRACKET);
    stack.push(entry1);
    stack.push(entry2);
    stack.push(entry4);
    stack.push(entry3);
    stack.pop();
    stack.pop();
    stack.push(entry4);
    int stackSize = stack.size();
    assertEquals(3, stackSize);
  }

}
