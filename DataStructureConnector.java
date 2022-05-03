public interface DataStructureConnector<T> {
  public abstract boolean hasNextElement();
  public abstract void addElement(T obj);
  public abstract T removeNextElement();
}