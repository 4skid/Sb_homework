public class Basket {

    private static int count = 0;
    private String items;
    private static int totalPrice = 0;
    private int limit;
    private double totalWeight = 0;
    private static int totalCount = 0;

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice, double totalWeight) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
        this.totalWeight = totalWeight;
    }

    public static int getCount() {
        return count;
    }

    public static int getTotalCount() {
        return totalCount;
    }

    public static int getAveragePrice() {
        int averagePrice = Basket.getTotalPrice() / Basket.getTotalCount();
        return averagePrice;
    }

    public static int getBasketAveragePrice() {
        int basketAveragePrice = Basket.getTotalPrice()/Basket.getCount();
        return basketAveragePrice;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public void add(String name, int price) {
        add(name, price, 1, 0);
    }

    public void add(String name, int price, int count, double weight) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " шт. - " + price + " весом:" + weight;
        totalPrice = totalPrice + count * price;
        totalWeight = totalWeight + count * weight;
        totalCount = totalCount + count;
    }

    public void clear() {
        items = "";
        totalPrice = 0;
    }

    public static int getTotalPrice() {
        return totalPrice;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }


    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
            System.out.println("Общим весом: " + getTotalWeight());
        }
    }
}
