import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class NestedTablesExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BorderLayout());
            int spacing = 50; // Adjust the spacing as desired

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            for (int i = 1; i <= 7; i++) {
                // Create a JTable with sample data
                String[] columnNames = {"Name", "Age"};
                Object[][] rowData = {
                        {"John", 25},
                        {"Alice", 30},
                        {"Bob", 35},
                        {"John", 25},
                        {"Alice", 30},
                        {"Bob", 35},
                        {"John", 25},
                        {"Alice", 30},
                        {"Bob", 35},
                        {"John", 25},
                        {"Alice", 30},
                        {"Bob", 35},
                        {"John", 25},
                        {"Alice", 30},
                        {"Bob", 35},
                        {"John", 25},
                        {"Alice", 30},
                        {"Bob", 35},
                        {"John", 25},
                        {"Alice", 30},
                        {"Bob", 35},
                        {"John", 25},
                        {"Alice", 30},
                        {"Bob", 35},
                        {"John", 25},
                        {"Alice", 30},
                        {"Bob", 35},
                        {"John", 25},
                        {"Alice", 30},
                        {"Bob", 35},
                        {"John", 25},
                        {"Alice", 30},
                        {"Bob", 35},
                        {"John", 25},
                        {"Alice", 30},
                        {"Bob", 35},
                        {"John", 25},
                        {"Alice", 30},
                        {"Bob", 35}
                        // ... more data
                };
                JLabel label = new JLabel("Test", null, SwingConstants.CENTER);
                JTable table = new JTable(rowData, columnNames);

                // Create a scroll pane for the table
                JScrollPane tableScrollPane = new JScrollPane(table);

                // Set the preferred size of the scroll pane
                tableScrollPane.setPreferredSize(new Dimension(300, 200));

                // Add spacing between the scroll panes
                if (i > 1) {
                    panel.add(Box.createRigidArea(new Dimension(0, spacing)));
                }

                // Add the scroll pane to the panel
                panel.add(label);
                panel.add(tableScrollPane);
              
            }

            // Add an empty border around the panel to create additional spacing
            panel.setBorder(new EmptyBorder(spacing, spacing, spacing, spacing));

            // Add the panel to the main panel
            mainPanel.add(panel, BorderLayout.CENTER);

            // Create a scroll pane for the main panel
            JScrollPane mainScrollPane = new JScrollPane(mainPanel);

            // Create a frame and add the main scroll pane
            JFrame frame = new JFrame("Nested Tables Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(mainScrollPane);
            frame.pack();
            frame.setVisible(true);
        });
    }
}