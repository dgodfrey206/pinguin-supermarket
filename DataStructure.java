public interface DataStructure {
  public abstract int size();
  public default boolean isEmpty() { return true; }
}