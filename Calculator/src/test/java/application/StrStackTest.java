package application;

import static org.junit.Assert.*;
import java.util.EmptyStackException;
import org.junit.Test;

public class StrStackTest {

  @Test
  public void testPush() {
    StrStack strStack = new StrStack();

    strStack.push("Hello");

    assertFalse(strStack.isEmpty());
    assertEquals("Hello", strStack.top());
    assertEquals(1, strStack.size());
  }

  @Test
  public void testPop() throws EmptyStackException {
    StrStack strStack = new StrStack();
    strStack.push("World");

    String poppedValue = strStack.pop();

    assertEquals("World", poppedValue);
    assertTrue(strStack.isEmpty());
  }

  @Test
  public void testTop() throws EmptyStackException {
    StrStack strStack = new StrStack();
    strStack.push("Stack");

    String topValue = strStack.top();

    assertEquals("Stack", topValue);
    assertFalse(strStack.isEmpty());
  }

  @Test
  public void testSize() {
    StrStack strStack = new StrStack();
    strStack.push("One");
    strStack.push("Two");

    assertEquals(2, strStack.size());
  }

  @Test
  public void testPopEmptyStack() {
    StrStack strStack = new StrStack();

    assertThrows(EmptyStackException.class, () -> strStack.pop());
  }

  @Test
  public void testTopEmptyStack() {
    StrStack strStack = new StrStack();

    assertThrows(EmptyStackException.class, () -> strStack.top());
  }
}

