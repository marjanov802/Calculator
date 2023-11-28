package application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import java.util.EmptyStackException;
import org.junit.jupiter.api.Test;

public class OpStackTest {

  // Test 1.0 tests the push onto the stack
  @Test
  public void testPush() {
    OpStack opStack = new OpStack();
    opStack.push(Symbol.PLUS);
    assertEquals(1, opStack.size());
  }

  // Test 1.1 testing the top operation on OpStack
  @Test
  public void testTop() throws EmptyStackException, BadType {
    OpStack opStack = new OpStack();
    opStack.push(Symbol.PLUS);
    assertEquals(Symbol.PLUS, opStack.top());
    assertEquals(1, opStack.size());
  }

  // Test 1.2 Testing the pop operation on OpStack
  @Test
  public void testPop() throws EmptyStackException, BadType {
    OpStack opStack = new OpStack();
    opStack.push(Symbol.PLUS);
    assertEquals(Symbol.PLUS, opStack.pop());
    assertEquals(0, opStack.size());
  }

  // Test 1.3 Testing the size operation on OpStack
  @Test
  public void testSize() throws EmptyStackException, BadType {
    OpStack opStack = new OpStack();
    assertEquals(0, opStack.size());
    opStack.push(Symbol.PLUS);
    assertEquals(1, opStack.size());
    opStack.pop();
    assertEquals(0, opStack.size());
  }

  // Test 1.4 Checks error is thrown when pop is done to an empty stack
  @Test
  public void testTopEmptyStack() throws EmptyStackException, BadType {
    OpStack opStack = new OpStack();
    try {
      opStack.top();
      fail("Expected EmptyStackException");
    } catch (EmptyStackException e) {
      // Expected exception
    }
  }


  // Test 1.5 Checks error is throw when top is taken from an empty stack
  @Test
  public void testPopEmptyStack1() throws EmptyStackException, BadType {
    OpStack opStack = new OpStack();
    try {
      opStack.pop();
      fail("Expected EmptyStackException");
    } catch (EmptyStackException e) {
      // Expected exception
    }
  }
}