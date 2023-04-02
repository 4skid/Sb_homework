import javax.swing.*;

public class NameForm {

    private JPanel mainPanel;
    private JTextField lastNameInput;
    private JTextField firstNameInput;
    private JTextField surNameInput;
    private JLabel lastNameLabel;
    private JLabel firstNameLabel;
    private JLabel surNameLabel;
    private JButton collapseButton;

    public NameForm() {
        collapseButton.addActionListener(actionEvent -> {
            if (collapseButton.getText().equals("Сжать")) {
                if (firstNameInput.getText().isEmpty() ||
                        surNameInput.getText().isEmpty() ||
                        lastNameInput.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(mainPanel, "Все поля должны быть заполнены!");
                } else {
                    lastNameLabel.setVisible(false);
                    surNameLabel.setVisible(false);
                    lastNameInput.setVisible(false);
                    surNameInput.setVisible(false);
                    firstNameInput.setText(lastNameInput.getText() + " " +
                            firstNameInput.getText() + " " + surNameInput.getText());
                    firstNameLabel.setText("Фамилия Имя Отчество");
                    collapseButton.setText("Разъединить");
                }
            } else if (collapseButton.getText().equals("Разъединить")) {
                String[] fio = firstNameInput.getText().split(" +");
                if (fio.length > 3) {
                    JOptionPane.showMessageDialog(mainPanel, "Полное имя не может быть больше трех слов");
                } else if (fio.length < 2) {
                    JOptionPane.showMessageDialog(mainPanel, "Полное имя не может быть меньше двух слов");
                } else {
                    collapseButton.setText("Сжать");
                    lastNameLabel.setVisible(true);
                    surNameLabel.setVisible(true);
                    lastNameInput.setVisible(true);
                    lastNameInput.setName(fio[0]);
                    surNameInput.setVisible(true);
                    surNameInput.setName(fio[2]);
                    firstNameLabel.setText("Имя");
                    firstNameInput.setText(fio[1]);
                }
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
