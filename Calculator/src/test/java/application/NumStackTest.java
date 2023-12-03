package application;

import static org.junit.jupiter.api.Assertions.assertEquals;
<<<<<<< HEAD
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.EmptyStackException;
import org.junit.jupiter.api.Test;
=======
import org.junit.jupiter.api.Test;

>>>>>>> feature-StandardCalc

public class NumStackTest {

  // Test 1.0 Checks that push works
  @Test
  public void testPush() {
    NumStack numStack = new NumStack();
    assertEquals(0, numStack.size());
    numStack.push(5.9f);
  }

  // Test 1.1 Checks that pop works by returning a empty stack
  @Test
  public void testPop() {
    NumStack numStack = new NumStack();
    numStack.push(7.8f);
    numStack.pop();
    assertEquals(0, numStack.size());
  }

  // Test 1.2 Checks that top works by checking size has not changed
  @Test
  public void testTop() {
    NumStack numStack = new NumStack();
    numStack.push(17.9f);
    numStack.top();
    assertEquals(1, numStack.size());
  }

  // Test 1.3 Checks that size is correct after pushing
  @Test
  public void testSize() {
    NumStack numStack = new NumStack();
    assertEquals(0, numStack.size());
    numStack.push(3.3f);
    numStack.push(10.1f);
    assertEquals(2, numStack.size());
    numStack.pop();
    assertEquals(1, numStack.size());
  }
<<<<<<< HEAD

  // Test case to verify that popping from an empty stack throws EmptyStackException.
  @Test
  public void testPopEmptyStack() {
    NumStack numStack = new NumStack();
    assertThrows(EmptyStackException.class, () -> numStack.pop());
  }

  // Test case to verify that retrieving the top element from an empty stack throws
  // EmptyStackException.
  @Test
  public void testTopEmptyStack() {
    NumStack numStack = new NumStack();
    assertThrows(EmptyStackException.class, () -> numStack.top());
  }

=======
>>>>>>> feature-StandardCalc
}
