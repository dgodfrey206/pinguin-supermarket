public class PenguinCustomer {
  private String name;
  private int money;
  private Stack<FishyProduct> products;

  public PenguinCustomer(String name, int initialMoney) {
    this.name = name;
    this.money = initialMoney;
    this.products = new LinkedStack<FishyProduct>();

    if (name == null || initialMoney < 0) {
      ExceptionUtil.illegalArgument("Illegal argument");
    }
  }

  public String getName() {
    return name;
  }

  public int getMoney() {
    return money;
  }

  public Stack<FishyProduct> getProducts() {
    return products;
  }

  public void addProductToBasket(FishyProduct product) {
    products.push(product);
  }

  public void placeAllProductsOnBand(Queue<FishyProduct> band) {
    new DataStructureLink<FishyProduct>(
      new StackConnector<FishyProduct>(products),
      new QueueConnector<FishyProduct>(band)
    ).moveNextFromAToB();
  }

  public void takeAllProductsFromBand(Queue<FishyProduct> band) {
    new DataStructureLink<FishyProduct>(
      new QueueConnector<FishyProduct>(band),
      new StackConnector<FishyProduct>(products)
    ).moveAllFromAToB();
  }

  public int pay(int val) {
    if (val < 0 || money - val < 0) {
      ExceptionUtil.illegalArgument("Illegal argument");
    }
    money -= val;
    return money;
  }

  public String toString() {
    String temp = name + "($" + money + ") ";
    Stack<FishyProduct> stack = getProducts();
    String sep = "";
    while (!stack.isEmpty()) {
      temp += sep + stack.pop();
      sep = ", ";
    }
    return temp;
  }

  void goToCheckout(PenguinSupermarket market) {
    // find smallest queue and go there
    Checkout c = market.getCheckoutWithSmallestQueue();
    c.addCustomer(this);
  }
}