package application;

import java.util.EmptyStackException;

/**
 * Extension of stack class for string values. This class handles exceptions such as
 * EmptyStackException and BadType.
 */
public class StrStack {

  private Stack numStack = new Stack();

  /**
   * Pushes a string onto the stack.
   *
   * @param value The string to be pushed onto the stack.
   */
  public void push(String value) {
    numStack.push(new Entry(value));
  }

  /**
   * Checks if the stack is empty.
   *
   * @return true if the stack is empty, false otherwise.
   */
  public boolean isEmpty() {
    return numStack.isEmpty();
  }

  /**
   * Pops and returns the top string from the stack.
   *
   * @return The string popped from the stack.
   * @throws EmptyStackException if the stack is empty.
   */
  public String pop() throws EmptyStackException {
    if (isEmpty()) {
      throw new EmptyStackException();
    }

    try {
      Entry poppedEntry = numStack.pop();
      return poppedEntry.getString();
    } catch (BadType e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Returns the top string from the stack without removing it.
   *
   * @return The top string from the stack.
   * @throws EmptyStackException if the stack is empty.
   */
  public String top() throws EmptyStackException {
    if (isEmpty()) {
      throw new EmptyStackException();
    }

    try {
      return numStack.top().getString();
    } catch (BadType e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Returns the number of strings in the stack.
   *
   * @return The number of strings in the stack.
   */
  public int size() {
    return numStack.size();
  }
}
