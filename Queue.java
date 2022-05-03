public interface Queue<T> extends DataStructure {
  public abstract void enqueue(T obj);
  public abstract T dequeue();
}