package application;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.BooleanSupplier;

/**
 * The Stack class is a stack which uses the Entry class.
 * 
 * @author DMarjanov
 */
public class Stack {

  private List<Entry> entries = new ArrayList<>();

  /**
   * Pushes an Entry onto the stack.
   *
   * @param entry The Entry to be pushed onto the stack.
   */
  public void push(Entry entry) {
    entries.add(entry);
  }

  /**
   * Checks if the stack is empty.
   *
   * @return true if the stack is empty, false otherwise.
   */
  public boolean isEmpty() {
    return entries.isEmpty();
  }

  /**
   * Pops and returns the top Entry from the stack.
   *
   * @return The Entry popped from the stack.
   * @throws NoSuchElementException if the stack is empty.
   */
  public Entry pop() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    Entry poppedEntry = entries.remove(entries.size() - 1);
    return poppedEntry;
  }

  /**
   * Returns the top Entry from the stack without removing it.
   *
   * @return The top Entry from the stack.
   * @throws NoSuchElementException if the stack is empty.
   */
  public Entry top() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return entries.get(entries.size() - 1);
  }

  /**
   * Returns the number of entries in the stack.
   *
   * @return The number of entries in the stack.
   */
  public int size() {
    return entries.size();
  }
}
