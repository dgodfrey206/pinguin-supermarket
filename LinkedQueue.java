public class LinkedQueue<T> implements Queue<T> {
  private List<T> head = null;
  private List<T> tail = null;
  private int length = 0;

  public void enqueue(T obj) {
    // handle empty case
    if (head == null) {
      head = tail = new List<T>(obj);
    } else {
      // insert and set tail
      tail.insert(obj);
      tail = tail.getNext();
    }
  }

  public T dequeue() {
    if (head == null) {
      return null;
    }
    T temp = head.getInfo();
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