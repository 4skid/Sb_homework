import javax.swing.*;

public class App {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Форма данных");
        frame.setContentPane(new NameForm().getMainPanel());
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
