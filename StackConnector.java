public class StackConnector<T> implements DataStructureConnector<T> {
  private final Stack<T> stack;
  public StackConnector(Stack<T> stack) {
    this.stack = stack;
  }
  public boolean hasNextElement() {
    return !stack.isEmpty();
  }

  public void addElement(T obj) {
    stack.push(obj);
  }

  public T removeNextElement() {
    if (stack.isEmpty()) {
      return null;
    }
    return stack.pop();
  }
}