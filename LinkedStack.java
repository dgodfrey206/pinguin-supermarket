public class LinkedStack<T> implements Stack<T> {
  private List<T> head = null;
  private int length = 0;

  public LinkedStack() {
    // sentry
    head = new List<T>(null);
  }

  public void push(T obj) {
    // insert in front of sentry
    head.insert(obj);
    length++;
  }

  public T pop() {
    if (head.getNext() == null) {
      return null;
    }
    T temp = (T)head.getNext().getInfo();
    head = head.getNext();
    return temp;
  }

  public int size() {
    return length;
  }

  public boolean isEmpty() {
    return length == 0;
  }
}