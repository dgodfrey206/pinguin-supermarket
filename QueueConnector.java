public class QueueConnector<T> implements DataStructureConnector<T> {
  private final Queue<T> queue;
  public QueueConnector(Queue<T> queue) {
    this.queue = queue;
  }

  public boolean hasNextElement() {
    return !queue.isEmpty();
  }

  public void addElement(T obj) {
    queue.enqueue(obj);
  }

  public T removeNextElement() {
    if (queue.isEmpty()) {
      return null;
    }
    return queue.dequeue();
  }
}