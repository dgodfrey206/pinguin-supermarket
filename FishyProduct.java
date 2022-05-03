public class FishyProduct {
  private final String name;
  private final int price;

  public FishyProduct(String name, int price) {
    this.name = name;
    this.price = price;

    if (name == null || price < 0) {
      ExceptionUtil.illegalArgument("Illegal argument");
    }
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }

  public String toString() {
    return name + " " + price;
  }
}