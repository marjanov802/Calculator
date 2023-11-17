package application;

public class NumStack {

  private Stack numStack = new Stack();

  public void push(float value) {
    Entry entry = new Entry(value);
    numStack.push(entry);
  }

  public float pop() {
    Entry entry = numStack.pop();
    return entry.getValue();
  }

  public float top() {
    Entry entry = numStack.top();
    return entry.getValue();
  }

  public int size() {
    return numStack.size();
  }
}
