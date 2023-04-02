public class Main {

    public static void main(String[] args) {
        Basket basket1 = new Basket();
        basket1.add("Milk", 50,2,5);
        basket1.add("Potato",40,4,7);
        basket1.add("Cucumber",60,1,4);
        basket1.print("Состав корзины 1");

        Basket basket2 = new Basket();
        basket2.add("Tomato",20,4,7);
        basket2.add("Banana",30,2,4);
        basket2.print("\n" + "Состав корзины 2");


        System.out.println("\n" + "Общая стоимость всех товаров: " + Basket.getTotalPrice());
        System.out.println("Общее количество товаров: " + Basket.getTotalCount());
        System.out.println("Средняя стоимость товаров в корзине: " + Basket.getAveragePrice());
        System.out.println("Средняя стоимость товаров на корзину: " + Basket.getBasketAveragePrice());

    }
}
