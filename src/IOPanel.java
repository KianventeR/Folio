import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.Timer;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

// import com.itextpdf.text.Document;
// import com.itextpdf.text.DocumentException;
// import com.itextpdf.text.Image;
// import com.itextpdf.text.PageSize;
// import com.itextpdf.text.pdf.PdfWriter;

class CenterTextRenderer extends DefaultTableCellRenderer {
    
    private int desiredRow = 0;
    private int desiredColumn = 0;
    int rows = 0;

    public CenterTextRenderer(int desiredRow, int desiredColumn, int rows) {
        
        this.desiredRow =  desiredRow;
        this.desiredColumn = desiredColumn;
        this.rows = rows;
    }
   

   
    

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) { 
                                
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        final Border border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY);
        setHorizontalAlignment(SwingConstants.CENTER);
        // cellComponent.setBackground(Color.gray);
        ((JComponent) cellComponent).setBorder(border);
        
        if(desiredColumn == 0 && desiredRow == 0){
            cellComponent.setBackground(table.getBackground());
        }

        if (row == desiredRow && column == desiredColumn) {
            // Set the background color of the cell
            cellComponent.setBackground(Color.YELLOW);
        } else {
            // Reset the background color to the default
            cellComponent.setBackground(table.getBackground());
        }
        if(row == rows){
            ((JComponent) cellComponent).setBorder(null);
        }

        return cellComponent;
    }
}







public class IOPanel extends javax.swing.JPanel {
    
        
    public int desiredRow;
    public int desiredColumn;
    boolean flag = false;
    public int Selected;
    public double default_speed = 1;
    public double current_speed = default_speed;
    public IOPanel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        initComponents();
    }

    public static void saveTableAsImage(JTable table, String filename) {
        Dimension tableSize = table.getSize();
        BufferedImage image = new BufferedImage(tableSize.width, tableSize.height + 40, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();

        graphics.setColor(table.getBackground());
        graphics.fillRect(0, 0, tableSize.width, tableSize.height + 40);

        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.print(graphics);

        int headerHeight = tableHeader.getHeight();
        graphics.translate(0, headerHeight);
        table.print(graphics);
        graphics.dispose();

        try {
            ImageIO.write(image, "png", new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void reset(){
       
        if(flag == true){
            timer.stop();
        }
        default_speed = 1; 
        current_speed = default_speed;
        default_frames = 3;
        current_frames = default_frames;
        removeAll();
        initComponents();
        Folio.fullOutput.reset();
    }
    public void adjustScrollBar(javax.swing.JComboBox<String> box) {
        if (box.getItemCount() == 0) return;
        Object comp = box.getUI().getAccessibleChild(box, 0);
        if (!(comp instanceof JPopupMenu)) {
            return;
        }
        JPopupMenu popup = (JPopupMenu) comp;
        JScrollPane scrollPane = (JScrollPane) popup.getComponent(0);
        scrollPane.setHorizontalScrollBar(new JScrollBar(JScrollBar.HORIZONTAL));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }
    
    public void initComponents() {
        length_upper = 40;
        length_lower = 10;
        lower_value = 0;
        upper_value = 20;
        frame_lower = 3;
        frame_upper = 10;
        
        fault_value = new javax.swing.JLabel();
        results_table = new javax.swing.JTable();
        exit = new javax.swing.JButton();
        minimize = new javax.swing.JButton();
        io_save = new javax.swing.JButton();
        io_return = new javax.swing.JButton();
        io_simulate = new javax.swing.JButton();
        io_simulateAll = new javax.swing.JButton();
        io_frames_add = new javax.swing.JButton();
        io_frames_minus = new javax.swing.JButton();
        io_speed_add = new javax.swing.JButton();
        io_speed_minus = new javax.swing.JButton();
        io_import = new javax.swing.JButton();
        io_random = new javax.swing.JButton();
        io_page_label = new javax.swing.JLabel();
        io_page_bg = new javax.swing.JLabel();
        io_timer_label = new javax.swing.JLabel();
        io_timer_bg = new javax.swing.JLabel();
        io_output_scroll = new javax.swing.JScrollPane();
        io_speed_value = new javax.swing.JLabel();
        io_speed_label = new javax.swing.JLabel();
        io_speed_bg = new javax.swing.JLabel();
        io_reference_input = new javax.swing.JTextField();
        io_reference_label = new javax.swing.JLabel();
        io_reference_bg = new javax.swing.JLabel();
        io_algorithm_select = new javax.swing.JComboBox<>();
        io_algorithm_label = new javax.swing.JLabel();
        io_algorithm_bg = new javax.swing.JLabel();
        io_frames_value = new javax.swing.JLabel();
        io_frames_label = new javax.swing.JLabel();
        io_frames_bg = new javax.swing.JLabel();
        io_output_bg = new javax.swing.JLabel();
        io_bg = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1080, 720));
        setLayout(null);

        fault_value.setFont(new java.awt.Font("Poppins ExtraBold", 0, 16));
        fault_value.setText("Page Faults: ");
        fault_value.setBounds(65, 610, 200, 80);
        fault_value.setBackground(Color.cyan);
        
        add(fault_value);

        
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/close.png"))); 
        exit.setBorder(null);
        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        exit.setFocusPainted(false);
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitMouseExited(evt);
            }
        });
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        add(exit);
        exit.setBounds(1030, 10, 40, 30);

        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/min.png"))); 
        minimize.setBorder(null);
        minimize.setBorderPainted(false);
        minimize.setContentAreaFilled(false);
        minimize.setFocusPainted(false);
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizeMouseExited(evt);
            }
        });
        minimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeActionPerformed(evt);
            }
        });
        add(minimize);
        minimize.setBounds(990, 10, 40, 30);

        io_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/save.png"))); 
        io_save.setBorder(null);
        io_save.setBorderPainted(false);
        io_save.setContentAreaFilled(false);
        io_save.setFocusPainted(false);
        io_save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                io_saveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                io_saveMouseExited(evt);
            }
        });
        io_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                io_saveActionPerformed(evt);
            }
        });
        add(io_save);
        io_save.setBounds(910, 630, 80, 80);

        io_return.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/return.png"))); 
        io_return.setBorder(null);
        io_return.setBorderPainted(false);
        io_return.setContentAreaFilled(false);
        io_return.setFocusPainted(false);
        io_return.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                io_returnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                io_returnMouseExited(evt);
            }
        });
        io_return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                io_returnActionPerformed(evt);
            }
        });
        add(io_return);
        io_return.setBounds(990, 630, 80, 80);

        io_simulate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/simulate.png"))); 
        io_simulate.setBorder(null);
        io_simulate.setBorderPainted(false);
        io_simulate.setContentAreaFilled(false);
        io_simulate.setFocusPainted(false);
        io_simulate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                io_simulateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                io_simulateMouseExited(evt);
            }
        });
        io_simulate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                io_simulateActionPerformed(evt);
            }
        });
        add(io_simulate);
        io_simulate.setBounds(770, 190, 180, 60);

        io_simulateAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/simulateAll.png"))); 
        io_simulateAll.setBorder(null);
        io_simulateAll.setBorderPainted(false);
        io_simulateAll.setContentAreaFilled(false);
        io_simulateAll.setFocusPainted(false);
        io_simulateAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                io_simulateAllMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                io_simulateAllMouseExited(evt);
            }
        });
        io_simulateAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                io_simulateAllActionPerformed(evt);
            }
        });
        add(io_simulateAll);
        io_simulateAll.setBounds(560, 190, 210, 60);

        io_frames_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/add.png"))); 
        io_frames_add.setBorder(null);
        io_frames_add.setBorderPainted(false);
        io_frames_add.setContentAreaFilled(false);
        io_frames_add.setFocusPainted(false);
        io_frames_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                io_frames_addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                io_frames_addMouseExited(evt);
            }
        });
        io_frames_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                io_frames_addActionPerformed(evt);
            }
        });
        add(io_frames_add);
        io_frames_add.setBounds(720, 80, 40, 50);

        io_frames_minus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/minus.png"))); 
        io_frames_minus.setBorder(null);
        io_frames_minus.setBorderPainted(false);
        io_frames_minus.setContentAreaFilled(false);
        io_frames_minus.setFocusPainted(false);
        io_frames_minus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                io_frames_minusMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                io_frames_minusMouseExited(evt);
            }
        });
        io_frames_minus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                io_frames_minusActionPerformed(evt);
            }
        });
        add(io_frames_minus);
        io_frames_minus.setBounds(680, 80, 40, 50);

        io_speed_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/add.png"))); 
        io_speed_add.setBorder(null);
        io_speed_add.setBorderPainted(false);
        io_speed_add.setContentAreaFilled(false);
        io_speed_add.setFocusPainted(false);
        io_speed_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                io_speed_addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                io_speed_addMouseExited(evt);
            }
        });
        io_speed_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                io_speed_addActionPerformed(evt);
            }
        });
        add(io_speed_add);
        io_speed_add.setBounds(270, 180, 40, 50);

        io_speed_minus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/minus.png"))); 
        io_speed_minus.setBorder(null);
        io_speed_minus.setBorderPainted(false);
        io_speed_minus.setContentAreaFilled(false);
        io_speed_minus.setFocusPainted(false);
        io_speed_minus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                io_speed_minusMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                io_speed_minusMouseExited(evt);
            }
        });
        io_speed_minus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                io_speed_minusActionPerformed(evt);
            }
        });
        add(io_speed_minus);
        io_speed_minus.setBounds(230, 180, 40, 50);

        io_import.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/import.png"))); 
        io_import.setBorder(null);
        io_import.setBorderPainted(false);
        io_import.setContentAreaFilled(false);
        io_import.setFocusPainted(false);
        io_import.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                io_importMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                io_importMouseExited(evt);
            }
        });
        io_import.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                io_importActionPerformed(evt);
            }
        });
        add(io_import);
        io_import.setBounds(40, 230, 120, 40);

        io_random.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/random.png"))); 
        io_random.setBorder(null);
        io_random.setBorderPainted(false);
        io_random.setContentAreaFilled(false);
        io_random.setFocusPainted(false);
        io_random.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                io_randomMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                io_randomMouseExited(evt);
            }
        });
        io_random.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                io_randomActionPerformed(evt);
            }
        });
        add(io_random);
        io_random.setBounds(160, 230, 130, 40);

        io_page_label.setFont(new java.awt.Font("Poppins ExtraBold", 0, 16)); // NOI18N
        io_page_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        io_page_label.setText("0");
        add(io_page_label);
        io_page_label.setBounds(232, 310, 60, 30);

        io_page_bg.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        io_page_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/page_highlight.png"))); // NOI18N
        io_page_bg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(io_page_bg);
        io_page_bg.setBounds(160, 300, 150, 50);

        io_timer_label.setFont(new java.awt.Font("Poppins ExtraBold", 0, 16)); 
        io_timer_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        io_timer_label.setText("0");
        add(io_timer_label);
        io_timer_label.setBounds(90, 310, 60, 30);

        io_timer_bg.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        io_timer_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/timer_bg.png"))); 
        io_timer_bg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(io_timer_bg);
        io_timer_bg.setBounds(40, 300, 120, 50);

        io_output_scroll.setBorder(null);
        io_output_scroll.setOpaque(false);
        add(io_output_scroll);
        io_output_scroll.setBounds(50, 360, 980, 300);

        io_speed_value.setFont(new java.awt.Font("Poppins ExtraBold", 0, 16)); 
        io_speed_value.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        io_speed_value.setText(String.valueOf(current_speed) + "x");
        add(io_speed_value);
        io_speed_value.setBounds(178, 190, 40, 30);

        io_speed_label.setFont(new java.awt.Font("Poppins ExtraBold", 0, 16)); 
        io_speed_label.setForeground(new java.awt.Color(255, 255, 255));
        io_speed_label.setText("Timer Speed");
        add(io_speed_label);
        io_speed_label.setBounds(50, 180, 130, 50);

        io_speed_bg.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        io_speed_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/timer_speed.png"))); 
        io_speed_bg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(io_speed_bg);
        io_speed_bg.setBounds(40, 180, 190, 50);

        io_reference_input.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); 
        io_reference_input.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        io_reference_input.setToolTipText("");
        io_reference_input.setBorder(null);
        io_reference_input.setOpaque(false);
        add(io_reference_input);
        io_reference_input.setBounds(210, 140, 730, 30);

        io_reference_label.setFont(new java.awt.Font("Poppins ExtraBold", 0, 16)); 
        io_reference_label.setForeground(new java.awt.Color(255, 255, 255));
        io_reference_label.setText("Page Reference");
        add(io_reference_label);
        io_reference_label.setBounds(50, 130, 140, 50);

        io_reference_bg.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        io_reference_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/reference.png"))); 
        io_reference_bg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(io_reference_bg);
        io_reference_bg.setBounds(40, 130, 920, 50);

        io_algorithm_select.setFont(new java.awt.Font("Poppins Regular", 0, 12)); 
        io_algorithm_select.setAutoscrolls(getAutoscrolls());
        io_algorithm_select.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"First In First Out", "Least Recently Used", "Optimal Page Replacement", "Second Chance Algorithm", "Enhanced Second Chance Algorithm", "Least Frequently Used", "Most Frequently Used" }));
        io_algorithm_select.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        io_algorithm_select.setFocusable(false);
        io_algorithm_select.setOpaque(false);
        adjustScrollBar(io_algorithm_select);
        add(io_algorithm_select);
        io_algorithm_select.setBounds(326, 90, 160, 30);

        io_algorithm_label.setFont(new java.awt.Font("Poppins ExtraBold", 0, 16)); 
        io_algorithm_label.setForeground(new java.awt.Color(255, 255, 255));
        io_algorithm_label.setText("Page Replacement Algorithm");
        add(io_algorithm_label);
        io_algorithm_label.setBounds(50, 80, 260, 50);

        io_algorithm_bg.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        io_algorithm_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/algorithm.png"))); 
        io_algorithm_bg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(io_algorithm_bg);
        io_algorithm_bg.setBounds(40, 80, 460, 50);

        io_frames_value.setFont(new java.awt.Font("Poppins ExtraBold", 0, 16)); 
        io_frames_value.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        io_frames_value.setText(String.valueOf(default_frames));
        add(io_frames_value);
        io_frames_value.setBounds(620, 90, 50, 30);

        io_frames_label.setFont(new java.awt.Font("Poppins ExtraBold", 0, 16)); 
        io_frames_label.setForeground(new java.awt.Color(255, 255, 255));
        io_frames_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        io_frames_label.setText("Frames");
        add(io_frames_label);
        io_frames_label.setBounds(510, 80, 80, 50);

        io_frames_bg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        io_frames_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/frames.png"))); 
        io_frames_bg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(io_frames_bg);
        io_frames_bg.setBounds(500, 80, 180, 50);

        io_output_bg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        io_output_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/algorithm_bg.png"))); 
        io_output_bg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(io_output_bg);
        io_output_bg.setBounds(0, 290, 1080, 430);

        io_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/backgrounds/background.png"))); 
        io_bg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        io_bg.setOpaque(true);
        add(io_bg);
        io_bg.setBounds(0, 0, 1080, 720);

        results_table.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        results_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                " ", " ", " "
            }
        ){
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class,
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class,
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class,
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class,
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class,
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });

      
    }
  
    public void create_table(int[] main_Array, int selected_algo, int current_frames) {
        results_table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TableCellRenderer cellRenderer = new CenterTextRenderer(-1, -1, current_frames);
        results_table.setDefaultRenderer(Object.class, cellRenderer);
        
        

        results_table.setForeground(new java.awt.Color(0, 0, 0));
        Object[][] data = new Object[0][0];
        String [] header = new String [main_Array.length];

        for(int i = 0; i < main_Array.length; i++){
            header[i] = String.valueOf(main_Array[i]);
        }

        results_table.setModel(new javax.swing.table.DefaultTableModel(data, header));
        
        DefaultTableModel results_model = (DefaultTableModel) results_table.getModel();
        results_model.setRowCount(current_frames + 1);
        results_model.setColumnCount(main_Array.length);

        results_table.setFillsViewportHeight(true);
        results_table.setGridColor(new java.awt.Color(255, 255, 255));
        results_table.setSelectionBackground(new java.awt.Color(211, 211, 211));
        results_table.setSelectionForeground(new java.awt.Color(0, 0, 0));
        results_table.setInheritsPopupMenu(true);
        results_table.setIntercellSpacing(new java.awt.Dimension(35, 1));
        results_table.setRowHeight(40);

        results_table.getTableHeader().setReorderingAllowed(false);
        results_table.getTableHeader().setResizingAllowed(false);
        JTableHeader results_header = results_table.getTableHeader();
        TableCellRenderer renderer = results_header.getDefaultRenderer();
        ((JLabel) renderer).setHorizontalAlignment(SwingConstants.CENTER);
        
        
       

        // results_table.setPreferredSize(new Dimension(20, 60));
        results_table.setBorder(null);
        
        io_output_scroll.setBorder(null);
        if(main_Array.length < 12){
            io_output_scroll.setBounds(60, 360, main_Array.length*75, 265);
        }
        else{
            io_output_scroll.setBounds(60, 360, 12*80, 265);
        }
        
        io_output_scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        io_output_scroll.setViewportView(results_table);
    }

    public void exitMouseEntered(java.awt.event.MouseEvent evt) {
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/close_hover.png")));
    }

    public void exitMouseExited(java.awt.event.MouseEvent evt) {
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/close.png")));
    }

    public void exitActionPerformed(java.awt.event.ActionEvent evt) {
        Music.sfx();
        System.exit(0);
    }

    public void minimizeMouseEntered(java.awt.event.MouseEvent evt) {
        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/min_hover.png")));
    }

    public void minimizeMouseExited(java.awt.event.MouseEvent evt) {
        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/min.png")));
    }

    public void minimizeActionPerformed(java.awt.event.ActionEvent evt) {
        Music.sfx();
        Folio.mainFrame.setState(java.awt.Frame.ICONIFIED);
    }

    public void io_returnMouseEntered(java.awt.event.MouseEvent evt) {
        io_return.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/return_hover.png")));
    }

    public void io_returnMouseExited(java.awt.event.MouseEvent evt) {
        io_return.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/return.png")));
    }

    public void io_returnActionPerformed(java.awt.event.ActionEvent evt) {
        Music.sfx();
        reset();
        Folio.card.show(Folio.mainPanel, "2");
    }

    public void io_saveMouseEntered(java.awt.event.MouseEvent evt) {
        io_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/save_hover.png")));
    }

    public void io_saveMouseExited(java.awt.event.MouseEvent evt) {
        io_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/save.png")));
    }

    public void io_saveActionPerformed(java.awt.event.ActionEvent evt) {
        Music.sfx();
        saveTableAsImage(results_table, "panel_image.png");
        String imagePath = "panel_image.png";
        String pdfPath = "panel.pdf"; 

        // try {
        //     BufferedImage bufferedImage = ImageIO.read(new File(imagePath));
        //     int imageWidth = bufferedImage.getWidth() + 70;
        //     int imageHeight = bufferedImage.getHeight() + 70;

        //     Document document = new Document();
        //     document.setPageSize(new com.itextpdf.text.Rectangle(imageWidth, imageHeight));
        //     PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
        //     document.open();

        //     Image image = Image.getInstance(bufferedImage, null);
        //     document.add(image);

        //     document.close();
        //     System.out.println("Image converted to PDF successfully.");
        // } catch (IOException | DocumentException e) {
        //     e.printStackTrace();
        // }
    }

    public void io_randomMouseEntered(java.awt.event.MouseEvent evt) {
        io_random.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/random_hover.png")));
    }

    public void io_randomMouseExited(java.awt.event.MouseEvent evt) {
        io_random.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/random.png")));
    }

    public void io_randomActionPerformed(java.awt.event.ActionEvent evt) {
        Music.sfx();
        seed = (int) System.currentTimeMillis();
        Random rand = new Random(seed);


        int random_length = rand.nextInt(length_upper-length_lower) + length_lower;
        int random_frame = rand.nextInt(frame_upper-frame_lower) + frame_lower;
        int random_value = rand.nextInt(upper_value-lower_value) + lower_value;

        System.out.println(random_length + " Length");
        System.out.println(random_frame + " frame");
        System.out.println(random_value + " value");

        current_frames = random_frame;

        io_frames_value.setText(String.valueOf(current_frames));

        random_Array = new int[random_length];

        for(int i = 0; i < random_length; i++){
            random_Array[i] = random_value;
            random_value = rand.nextInt(upper_value-lower_value) + lower_value;
            
        }
        String array_string ="";
       for(int i = 0; i < random_Array.length; i++){
        if(i+1 < random_Array.length){
            array_string = array_string + String.valueOf(random_Array[i]) + " ";
        }
        else{
            array_string = array_string + String.valueOf(random_Array[i]) + "";
        }
       }
       
    //    System.out.println(array_string);

       io_reference_input.setText(array_string);
       main_Array = new int[random_Array.length];
       main_Array = random_Array.clone();
    }

    public void io_importMouseEntered(java.awt.event.MouseEvent evt) {
        io_import.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/import_hover.png")));
    }

    public void io_importMouseExited(java.awt.event.MouseEvent evt) {
        io_import.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/import.png")));
    }

    public void io_importActionPerformed(java.awt.event.ActionEvent evt) {
        Music.sfx();
        System.out.println("importing");

        io_reference_input.setText("");

        final JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        File file = fc.getSelectedFile();

        
     try (Scanner read = new Scanner(file)){
        String frames = " ";
        String algo = " ";
        String page_reference = "";
     
            for(int i = 0; i < 4; i++){
                if(i < 2){
                    frames = read.next();
                }
                else{
                    algo = read.next();
                }
            }
            read.next();
            import_ArrayList = new ArrayList<Integer>();
            while(read.hasNext()){
                import_ArrayList.add(read.nextInt());  
            }
          
            System.out.println(import_ArrayList);

            main_Array = new int [import_ArrayList.size()];

            for(int i = 0; i < import_ArrayList.size(); i++){
                main_Array[i] = import_ArrayList.get(i);
            }

            if(main_Array.length > 40 || Integer.parseInt(frames) > 10){
                JOptionPane.showMessageDialog(null, "Invalid File",
                "Invalid Input", JOptionPane.ERROR_MESSAGE);
                return;
            }

            current_frames = Integer.parseInt(frames);
            io_frames_value.setText(String.valueOf(current_frames));

            for(int i = 0; i < main_Array.length; i++){
                if(i+1 < main_Array.length){
                    io_reference_input.setText(io_reference_input.getText() + main_Array[i] + " ");
                }
                else{
                    io_reference_input.setText(io_reference_input.getText() + main_Array[i] + "");
                }
            }
            
            Selected = checkSelected(algo);
            System.out.println(Selected);

            io_algorithm_select.setSelectedIndex(Selected);
            io_random.setEnabled(false);
            io_frames_add.setEnabled(false);
            io_frames_minus.setEnabled(false);
            io_algorithm_select.setEditable(false);
            io_reference_input.setEditable(false);
        } catch (Exception e) {
            System.out.println("errpr");
        }
    }

    private int checkSelected(String algo) {
        int selected = 0;
        if(algo.equals("FIFO")){
            selected = 0;
        }
        else if(algo.equals("LRU")){
            selected = 1;
        }
        else if(algo.equals("OPT")){
            selected = 2;
        }
        else if(algo.equals("SCA")){
            selected = 3;
        }
        else if(algo.equals("ESCA")){
            selected = 4;
        }
        else if(algo.equals("LFU")){
            selected = 5;
        }
        else if(algo.equals("MFU")){
            selected = 6;
        }
        return selected;
    }

    public void io_simulateAllMouseEntered(java.awt.event.MouseEvent evt) {
        io_simulateAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/simulateAll_hover.png")));
    }

    public void io_simulateAllMouseExited(java.awt.event.MouseEvent evt) {
        io_simulateAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/simulateAll.png")));
    }

    public void io_simulateAllActionPerformed(java.awt.event.ActionEvent evt) {
        flag = true;
        Music.sfx();
        Folio.card.show(Folio.mainPanel, "6");
    }

    public void io_simulateMouseEntered(java.awt.event.MouseEvent evt) {
        io_simulate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/simulate_hover.png")));
    }

    public void io_simulateMouseExited(java.awt.event.MouseEvent evt) {
        io_simulate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/simulate.png")));
    }

    public void io_simulateActionPerformed(java.awt.event.ActionEvent evt) {
        Music.sfx();
        int int_values = 0;
        String values = io_reference_input.getText();
        values.trim();
        System.out.println(values);

        if(io_reference_input.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Page Reference Cannot be Empty!",
      "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        if(values.charAt(values.length() - 1) == ' '){
            System.out.println("Invalid input");
            return;
        }

        for(int i = 0; i < values.length(); i++){
            if(values.charAt(i) == ' '){
                int_values++;
            }
            else{
                continue;
            }
        }
        int_values = int_values+1;

        System.out.println(int_values);
        try (Scanner read = new Scanner(values)){
            flag = true;
            //main_array loading - contains arrays
            main_Array = new int[int_values];
            for(int i = 0; i < int_values; i++){
                main_Array[i] = read.nextInt();
                if(main_Array[i] > 20){
                    System.out.println("Value exceeding 20");
                    return;
                }
            }

        //selected algo
        Selected = io_algorithm_select.getSelectedIndex();

        //No. of frames
        System.out.println(current_frames);

        //table creation
        create_table(main_Array, Selected, current_frames);
    //    results_table.setEnabled(false);
    
    boolean[] hitMatrix;
    int[][] framesMatrix;
        System.out.println(current_speed);
    
    //
    
    switch(Selected){
        case 0:
            System.out.println("FIFO");
            FIFO fifo = new FIFO(main_Array,main_Array.length,current_frames);
            hitMatrix = fifo.getHitMatrix();
            framesMatrix = fifo.getFramesMatrix();
            //framesMatrix[numofpages][framesize]
            System.out.println(framesMatrix.length + "no of frames");

            initiate_print(hitMatrix, framesMatrix);

            break;
        case 1:
            System.out.println("LRU");
            LRU lru = new LRU(main_Array, main_Array.length, current_frames);
            hitMatrix = lru.getHitMatrix();
            framesMatrix = lru.getFramesMatrix();
            //framesMatrix[numofpages][framesize]
            System.out.println(framesMatrix.length + "no of frames");
            initiate_print(hitMatrix, framesMatrix);

            break;
        case 2:
            System.out.println("OPT");
            OPT opt = new OPT(main_Array, main_Array.length, current_frames);
            hitMatrix = opt.getHitMatrix();
            framesMatrix = opt.getFramesMatrix();
            //framesMatrix[numofpages][framesize]
            System.out.println(framesMatrix.length + "no of frames");
            initiate_print(hitMatrix, framesMatrix);
            break;
        case 4:
            System.out.println("ESCA");

            ESC esc = new ESC(main_Array, main_Array.length, current_frames);
            hitMatrix = esc.getHitMatrix();
            framesMatrix = esc.getFramesMatrix();
            //framesMatrix[numofpages][framesize]
            System.out.println(framesMatrix.length + "no of frames");
            initiate_print(hitMatrix, framesMatrix);
            break;
        case 5:
            System.out.println("LFU");

            LFU lfu = new LFU(main_Array, main_Array.length, current_frames);
            hitMatrix = lfu.getHitMatrix();
            framesMatrix = lfu.getFramesMatrix();
            //framesMatrix[numofpages][framesize]
            System.out.println(framesMatrix.length + "no of frames");
            initiate_print(hitMatrix, framesMatrix);
            break;
        case 6:
            System.out.println("MFU");

            MFU mfu = new MFU(main_Array, main_Array.length, current_frames);
            hitMatrix = mfu.getHitMatrix();
            framesMatrix = mfu.getFramesMatrix();
            //framesMatrix[numofpages][framesize]
            System.out.println(framesMatrix.length + "no of frames");
            initiate_print(hitMatrix, framesMatrix);

        break;
    }
       } catch (Exception e) {
        System.out.println(e);
        System.out.println("errr");
        // TODO: handle exception
       }
        //variables
        //current_frames;
        //main_Array;
        //current_speed
    }

    private void initiate_print(boolean[] hitMatrix, int[][] framesMatrix) {

        
            // for(int i = 0; i < main_Array.length; i++){
                
            // }
            
            //matrix + hits
            // for(int i = 0; i < main_Array.length; i++){

            //     System.out.println(hitMatrix[i]);
            //     if(hitMatrix[i] == false){
            //         results_table.setValueAt("Miss", current_frames, i);
            //     }
            //     else{
            //         results_table.setValueAt("Hit", current_frames, i);
            //     }
                
            //     for(int j = 0; j < current_frames; j++){
            //         if(framesMatrix[i][j] == -1){
            //             results_table.setValueAt(" ", (current_frames - 1)-j, i);
            //         }
            //         else{
            //         results_table.setValueAt(framesMatrix[i][j], (current_frames - 1)-j, i);
            //         }
            //     }
            // }

        timer = new Timer((int) (500/current_speed), new ActionListener() {
                
            //matrix + hits
            int faults = 0;
            int col = 0;
            public void actionPerformed(ActionEvent evt){
                io_frames_add.setEnabled(false);
                io_frames_minus.setEnabled(false);
                io_reference_input.setEditable(false);
                io_speed_add.setEnabled(false);
                io_speed_minus.setEnabled(false);
                io_algorithm_select.setEnabled(false);
                io_simulate.setEnabled(false);
                io_simulateAll.setEnabled(false);

                results_table.setEnabled(false);
                io_timer_label.setText(String.valueOf(col));
                io_page_label.setText(String.valueOf(main_Array[col]));
                if(col < main_Array.length){

                    System.out.println(hitMatrix[col]);
                    if(hitMatrix[col] == false){
                        results_table.setValueAt("Miss", current_frames, col);
                        faults++;
                        fault_value.setText("Page Faults: " + faults);
                    }
                    else{
                        results_table.setValueAt("Hit", current_frames, col);
                    }
            
                    for(int row = 0; row < current_frames; row++){
                        if(framesMatrix[col][row] == -1){
                            results_table.setValueAt(" ", (current_frames - 1)-row, col);
                        }
                        else{
                            if(main_Array[col] == framesMatrix[col][row]){
                               // edit table highlight here 
                               System.out.println("higlight at " + results_table.getValueAt((current_frames - 1)-row, col));
                               desiredRow = (current_frames - 1)-row;
                               desiredColumn = col;
                               
                               TableCellRenderer cellRenderer = new CenterTextRenderer(desiredRow, desiredColumn, current_frames);
                               results_table.setDefaultRenderer(Object.class, cellRenderer);
                               io_output_scroll.setViewportView(results_table);
                               
                               
                            }
                            results_table.setValueAt(framesMatrix[col][row], (current_frames - 1)-row, col);
                        }
                    }
                    col++;
                } 
                if(col == main_Array.length){
                    io_frames_add.setEnabled(true);
                    io_frames_minus.setEnabled(true);
                    io_reference_input.setEditable(true);
                    io_speed_add.setEnabled(true);
                    io_speed_minus.setEnabled(true);
                    io_algorithm_select.setEnabled(true);
                    io_simulate.setEnabled(true);
                    io_simulateAll.setEnabled(true);
                    timer.stop();
                }
                
            }
        });
        if(!timer.isRunning()){
            timer.start();
        }
    }

    public void io_speed_minusMouseEntered(java.awt.event.MouseEvent evt) {
        io_speed_minus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/minus_hover.png")));
    }

    public void io_speed_minusMouseExited(java.awt.event.MouseEvent evt) {
        io_speed_minus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/minus.png")));
    }

    public void io_speed_minusActionPerformed(java.awt.event.ActionEvent evt) {
        Music.sfx();
        if(current_speed > 0.5){
            current_speed = current_speed - 0.5;
            io_speed_value.setText(String.valueOf(current_speed)+"x");
        }
        else{
            System.out.println("cannot subtract more than 0.5");
        }
        
    }

    public void io_speed_addMouseEntered(java.awt.event.MouseEvent evt) {
        io_speed_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/add_hover.png")));
    }

    public void io_speed_addMouseExited(java.awt.event.MouseEvent evt) {
        io_speed_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/add.png")));
    }

    public void io_speed_addActionPerformed(java.awt.event.ActionEvent evt) {
        Music.sfx();
        if(current_speed < 2.0){
            current_speed = current_speed + 0.5;
            io_speed_value.setText(String.valueOf(current_speed)+"x");
        }
        else{
            System.out.println("cannot add more than 2");
        }
    }

    public void io_frames_addMouseEntered(java.awt.event.MouseEvent evt) {
        io_frames_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/add_hover.png")));
    }

    public void io_frames_addMouseExited(java.awt.event.MouseEvent evt) {
        io_frames_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/add.png")));
    }

    public void io_frames_addActionPerformed(java.awt.event.ActionEvent evt) {
        Music.sfx();
        System.out.println("adding frames");
        if(current_frames >= 3 && current_frames < 10){
            current_frames++;
            io_frames_value.setText(String.valueOf(current_frames));
            System.out.println(current_frames);
        }
        else{
            System.out.println("cannot add more than 10");
            System.out.println(current_frames);
        }
    }

    public void io_frames_minusMouseEntered(java.awt.event.MouseEvent evt) {
        io_frames_minus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/minus_hover.png")));
    }

    public void io_frames_minusMouseExited(java.awt.event.MouseEvent evt) {
        io_frames_minus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/minus.png")));
    }

    public void io_frames_minusActionPerformed(java.awt.event.ActionEvent evt) {
        Music.sfx();
        if(current_frames <= 3) {
            System.out.println("removing frames");
            System.out.println("cannot subtract less than 3");
        } else {
            current_frames--;
            io_frames_value.setText(String.valueOf(current_frames));
            System.out.println(current_frames);
        }
    }
    
    int default_frames = 3;
    int current_frames = default_frames;
    int length_upper, length_lower, seed, frame_lower, frame_upper, lower_value, upper_value;
        
    public javax.swing.JButton exit;
    public javax.swing.JLabel io_algorithm_bg;
    public javax.swing.JLabel io_algorithm_label;
    public javax.swing.JComboBox<String> io_algorithm_select;
    public javax.swing.JLabel io_bg;
    public javax.swing.JButton io_frames_add;
    public javax.swing.JLabel io_frames_bg;
    public javax.swing.JLabel io_frames_label;
    public javax.swing.JButton io_frames_minus;
    public javax.swing.JLabel io_frames_value;
    public javax.swing.JButton io_import;
    public javax.swing.JLabel io_output_bg;
    public javax.swing.JScrollPane io_output_scroll;
    public javax.swing.JLabel io_page_bg;
    public javax.swing.JLabel io_page_label;
    public javax.swing.JButton io_random;
    public javax.swing.JLabel io_reference_bg;
    public javax.swing.JTextField io_reference_input;
    public javax.swing.JLabel io_reference_label;
    public javax.swing.JButton io_return;
    public javax.swing.JButton io_save;
    public javax.swing.JButton io_simulate;
    public javax.swing.JButton io_simulateAll;
    public javax.swing.JButton io_speed_add;
    public javax.swing.JLabel io_speed_bg;
    public javax.swing.JLabel io_speed_label;
    public javax.swing.JButton io_speed_minus;
    public javax.swing.JLabel io_speed_value;
    public javax.swing.JLabel io_timer_bg;
    public javax.swing.JLabel io_timer_label;
    public javax.swing.JLabel fault_value;
    public javax.swing.JButton minimize;
    public javax.swing.JTable results_table;
    public Timer timer;

    public int[] random_Array;
    public int[] main_Array;
    public ArrayList<Integer> import_ArrayList;
}