public class Printer {
    private String queue = "Очередь печати пуста";
    private String text;
    private String name;
    private int pendingPagesCount;

    public Printer (String title) {
        queue = queue + "";
        pendingPagesCount = getPendingPagesCount();

    }

    public void append (String text, String name, int countOfPages){
        this.text = text;
        this.name = name;
        pendingPagesCount = pendingPagesCount + countOfPages;
        queue = queue + "\n" + text + "\n " + name + "\n" + "Количество страниц в очереди: "
                + countOfPages;
    }
    public void append (String text,String name) {
        this.text = text;
        this.name = name;
        queue  = queue + "\n" + text + "\n " + name;
    }
    public void append(String text){
        this.text = text;
        queue  = queue + "\n" + text;
    }
    public void clear(){
        queue = "";
        pendingPagesCount = 0;
    }
    public void print(){
        System.out.println("\n" + "Очередь печати: " );
        System.out.println(queue);
        System.out.println("Общее количесто страниц для печати: " + getPendingPagesCount() );
    }
    public int getPendingPagesCount(){
        return pendingPagesCount;
    }
}
