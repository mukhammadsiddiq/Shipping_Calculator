import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import methods.Calculation;

class GUI_app {
    private JFrame frame;
    private JTextField laptopField;
    private JTextField mouseField;
    private JTextField desktopField;
    private JTextField lcdField;
    private static JLabel resultLabel;
    private static JLabel resultLabel1;
    private static JLabel resultLabel2;

    private Calculation calculation;

    public GUI_app() {
    	
    	//  creating a frame
    	
        frame = new JFrame("Shipping Cost Calculator");
        frame.setSize(420, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JLabel laptopsLabel = new JLabel("Enter the number of Laptops:");
        laptopField = new JTextField(10);
        panel.add(laptopsLabel);
        panel.add(laptopField);

        JLabel mouseLabel = new JLabel("Enter the number of Mice:");
        mouseField = new JTextField(10);
        panel.add(mouseLabel);
        panel.add(mouseField);

        JLabel desktopLabel = new JLabel("Enter the number of Desktops:");
        desktopField = new JTextField(10);
        panel.add(desktopLabel);
        panel.add(desktopField);

        JLabel lcdLabel = new JLabel("Enter the number of LCD Screens:");
        lcdField = new JTextField(10);
        panel.add(lcdLabel);
        panel.add(lcdField);

        JButton bestShippingMethod = new JButton("Calculate");
        bestShippingMethod.addActionListener(new ActionListener() {
        	// Importing some functions from calculation!
            public void actionPerformed(ActionEvent e) {
                try {
                    calculation.addOrder(
                            Integer.parseInt(laptopField.getText()),
                            Integer.parseInt(mouseField.getText()),
                            Integer.parseInt(desktopField.getText()),
                            Integer.parseInt(lcdField.getText())
                            
                    );

                    calculation.addItems();
                    
                    //For getting a shipping price 
                    
                    double shippingCost = calculation.shippingPrice();
                    
                    // For getting a total Volume and Weight
                    double totalWeight = calculation.totalWeight();
                    double totalVolume = calculation.totalVolume();
                    
                    
                    // functions To appear after pressing calculate button
                    resultLabel.setText("Best Shipping Cost: " + shippingCost + " Euro");
                    resultLabel1.setText("	Total Weight: " + totalWeight + " kg,");
                    resultLabel2.setText("	Total Volume: " + totalVolume + " cm^3");
                    
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input. Please enter numeric values.");
                }
            }
        });
        panel.add(bestShippingMethod);
        
        //Printing Best shipping cost
        resultLabel = new JLabel();
        panel.add(resultLabel);
        resultLabel1 = new JLabel();
        panel.add(resultLabel1);
        resultLabel2 = new JLabel();
        panel.add(resultLabel2);

        frame.getContentPane().add(panel);
        frame.setVisible(true);

        calculation = new Calculation();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUI_app();
            }
        });
    }
}