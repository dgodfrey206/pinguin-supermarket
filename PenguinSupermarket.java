public class PenguinSupermarket {
  private Checkout[] checkouts;

  public PenguinSupermarket(int n) {
    if (n < 1) {
      ExceptionUtil.illegalArgument("N must be > 0");
    }
    checkouts = new Checkout[n];
    for (int i=0; i<n; i++) {
      checkouts[i] = new Checkout();
    }
  }

  public Checkout[] getCheckouts() {
    return checkouts;
  }

  public Checkout getCheckoutWithSmallestQueue() {
    Checkout minQueue = checkouts[0];
    for (int i=1; i<checkouts.length; i++) {
      if (checkouts[i].queueLength() < minQueue.queueLength()) {
        minQueue = checkouts[i];
        break;
      }
    }
    return minQueue;
  }

  public void closeCheckout(int i) {
    if (i < 0 || i >= checkouts.length || checkouts.length == 1) {
      ExceptionUtil.illegalArgument("Invalid");
    }
    Checkout till = checkouts[i];

    swap(checkouts, i, checkouts.length - 1);
    Checkout[] temp = new Checkout[checkouts.length-1];
    for (int j=0; j<temp.length; j++) {
      temp[j] = checkouts[j];
    }
    checkouts = temp;

    // use a stack to requeue customers in reverse order of arrival
    Stack<PenguinCustomer> s = new LinkedStack<PenguinCustomer>();
    new DataStructureLink<PenguinCustomer>(
      new QueueConnector<PenguinCustomer>(till.getQueue()),
      new StackConnector<PenguinCustomer>(s)
    ).moveAllFromAToB();

    while (!s.isEmpty()) {
      s.pop().goToCheckout(this);
    }
  }

  public void swap(Object[] arr, int i, int j) {
    Object temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public void serveCustomers() {
    for (int i=0; i<checkouts.length; i++) {
      checkouts[i].serveNextCustomer();
    }
  }
}