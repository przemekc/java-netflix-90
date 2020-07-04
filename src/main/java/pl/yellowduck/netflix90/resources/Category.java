package pl.yellowduck.netflix90.resources;

public enum Category implements Discontable {

  COMEDY(0, "Funny films") {
    @Override
    public String toString() {
      return "Hahaha....";
    }
  }, // orinal value 0

  FANTASY(5, "Sci-fy films"),

  DRAMA(3, "Got tissue?"),  // orinal value 1

  HORROR(4,"Can't sleep at night"), // orinal value 2

  MUSICAL(3, "Wanna dance?"), // orinal value 3

  ACTION(2, "Shoot and drive fast"); // orinal value 4

  private final int discount;
  private final String description;

  Category(int discount, String description) {
    this.discount = discount;
    this.description = description;
  }

  public int getDiscount() {
    return discount;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public String toString() {
    return name() + " " + description;
  }

    @Override
  public int discount() {
    return discount;
  }
}