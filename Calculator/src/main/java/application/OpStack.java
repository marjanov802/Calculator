package application;

import java.util.EmptyStackException;

/**
 * Extension of the stack class for handling symbols.
 * 
 * @author DMarjanov
 */
public class OpStack {

  private Stack opStack = new Stack();

  /**
   * Pushes a Symbol onto the stack.
   *
   * @param symbol The Symbol to be pushed onto the stack.
   */
  public void push(Symbol symbol) {
    Entry entry = new Entry(symbol);
    opStack.push(entry);
  }

  /**
   * Pops and returns the top Symbol from the stack.
   *
   * @return The Symbol popped from the stack.
   * @throws EmptyStackException if the stack is empty.
   * @throws BadType if the types to not match.
   */
  public Symbol pop() throws EmptyStackException, BadType {
    Entry entry = opStack.pop();
    return entry.getSymbol();
  }

  /**
   * Returns the top Symbol from the stack without removing it.
   *
   * @return The top Symbol from the stack.
   * @throws EmptyStackException if the stack is empty.
   * @throws BadType if the types do not match.
   */
  public Symbol top() throws EmptyStackException, BadType {
    Entry entry = opStack.top();
    return entry.getSymbol();
  }

  /**
   * Returns the number of Symbols in the stack.
   *
   * @return The number of Symbols in the stack.
   */
  public int size() {
    return opStack.size();
  }
}
