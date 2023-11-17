package application;

/**
 * Extension of the stack class for float values.
 * 
 * @author DMarjanov
 */
public class NumStack {

  private Stack numStack = new Stack();

  /**
   * Method pushes float value on the stack.
   * 
   * @param value The value should be pushed onto the stack
   */
  public void push(float value) {
    Entry entry = new Entry(value);
    numStack.push(entry);
  }

  /**
   * Pops from the stack , therefore the top value is taken off.
   * 
   * @return The popped value which is the float on the top of the stack.
   * @throws EmptyStackException if there is no value to remove fromt the top of the stack.
   */

  public float pop() {
    Entry entry = numStack.pop();
    return entry.getValue();
  }

  /**
   * Returns the top value in the stack.
   * 
   * @return The top value from the stack.
   * @throws EmptyStackException if the stack is empty when retrieving the top value.
   */
  public float top() {
    Entry entry = numStack.top();
    return entry.getValue();
  }

  /**
   * Returns the amount of values in the stack.
   * 
   * @return The amount of values in the stack.
   */
  public int size() {
    return numStack.size();
  }
}
