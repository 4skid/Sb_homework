public class Main {

    public static void main(String[] args) {

        Container container = new Container();
        container.addCount(5672);
        container.addCount(1000);
        System.out.println(container.getCount());


        for(char c = 'А'; c <= 'я'; c++) {
            System.out.println((int)c + " - " + c);
        }
        char c = 'ё';
        System.out.println((int)c + " - " + c);
        c = 'Ё';
        System.out.println((int)c + " - " + c);

    }
}
