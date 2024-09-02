import javax.swing.*;

public class CommissionProgramUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Commission Calculator");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JTextField lockField = createInputField(frame, "Enter number of Locks:", 30);
        JTextField stockField = createInputField(frame, "Enter number of Stocks:", 70);
        JTextField barrelField = createInputField(frame, "Enter number of Barrels:", 110);
        JLabel resultLabel = createLabel(frame, "", 50, 200);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(150, 150, 100, 30);
        frame.add(calculateButton);

        lockField.addActionListener(e -> stockField.requestFocus());
        stockField.addActionListener(e -> barrelField.requestFocus());
        barrelField.addActionListener(e -> calculateButton.doClick());

        calculateButton.addActionListener(e -> {
            try {
                int locks = Integer.parseInt(lockField.getText());
                int stocks = Integer.parseInt(stockField.getText());
                int barrels = Integer.parseInt(barrelField.getText());

                double sales = locks * 45 + stocks * 30 + barrels * 25;
                double commission = sales > 1800 ? 230 + 0.20 * (sales - 1800)
                            : sales > 1000 ? 100 + 0.15 * (sales - 1000)
                            : 0.10 * sales;

                resultLabel.setText(String.format("Total sales: $%.2f | Commission: $%.2f", sales, commission));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        });

        frame.setVisible(true);
    }

    private static JTextField createInputField(JFrame frame, String labelText, int yPosition) {
        JLabel label = new JLabel(labelText);
        label.setBounds(50, yPosition, 150, 25);
        frame.add(label);

        JTextField textField = new JTextField();
        textField.setBounds(200, yPosition, 100, 25);
        frame.add(textField);

        return textField;
    }

    private static JLabel createLabel(JFrame frame, String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 300, 25);
        frame.add(label);
        return label;
    }
}
