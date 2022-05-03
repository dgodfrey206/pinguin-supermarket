public class DataStructureLink<T> {
  public final DataStructureConnector<T> a, b;
  public DataStructureLink(DataStructureConnector<T> a,
                           DataStructureConnector<T> b) {
    this.a = a;
    this.b = b;
  }

  public boolean moveNextFromAToB() {
    if (!a.hasNextElement()) {
      return false;
    }
    b.addElement(a.removeNextElement());
    return true;
  }

  public void moveAllFromAToB() {
    // keep adding to B while there are elements in A
    while ( moveNextFromAToB() )
      ;
  }
}