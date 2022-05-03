public class Checkout {
  private Queue<PenguinCustomer> customers;
  private Queue<FishyProduct> bandBefore, bandAfter;

  // set initial values
  public Checkout() {
    this.customers = new LinkedQueue<PenguinCustomer>();
    this.bandBefore = new LinkedQueue<FishyProduct>();
    this.bandAfter = new LinkedQueue<FishyProduct>();
  }

  public Queue<PenguinCustomer> getQueue() {
    return customers;
  }

  public Queue<FishyProduct> getBandBeforeCashier() {
    return bandBefore;
  }

  public Queue<FishyProduct> getBandAfterCashier() {
    return bandAfter;
  }

  public void addCustomer(PenguinCustomer pc) {
    customers.enqueue(pc);
  }

  public int queueLength() {
    return customers.size();
  }

  public void serveNextCustomer() {
    // get the next customer from the queue
    PenguinCustomer customer = customers.dequeue();
    if (customer != null) {
      // put all the products on the belt before the register
      customer.placeAllProductsOnBand(bandBefore);
      int total = 0;
      // collect tems
      while (!bandBefore.isEmpty()) {
        FishyProduct product = bandBefore.dequeue();
        // and price to the total
        total += product.getPrice();
        // put the product on the belt ahead of the register
        bandAfter.enqueue(product);
      }
      // customer takes back the products and pays total
      customer.pay(total);
      customer.takeAllProductsFromBand(bandAfter);
    }
  }

  public String toString() {
    Queue<PenguinCustomer> customerQ = getQueue();
    String temp = "", sep = "";
    while (!customerQ.isEmpty()) {
      PenguinCustomer customer = customerQ.dequeue();
      temp += sep + customer.toString();
      sep = ", ";
    }
    return temp;
  }
}