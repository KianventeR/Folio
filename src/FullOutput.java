import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneLayout;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

class CenterTextRenderer extends DefaultTableCellRenderer {

    private int desiredRow = 0;
    private int desiredColumn = 0;
    int rows = 0;

    public CenterTextRenderer(int desiredRow, int desiredColumn, int rows) {

        this.desiredRow = desiredRow;
        this.desiredColumn = desiredColumn;
        this.rows = rows;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {

        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        final Border border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY);
        setHorizontalAlignment(SwingConstants.CENTER);
        // cellComponent.setBackground(Color.gray);
        ((JComponent) cellComponent).setBorder(border);

        if (desiredColumn == 0 && desiredRow == 0) {
            cellComponent.setBackground(table.getBackground());
        }

        if (row == desiredRow && column == desiredColumn) {
            // Set the background color of the cell
            cellComponent.setBackground(Color.YELLOW);
        } else {
            // Reset the background color to the default
            cellComponent.setBackground(table.getBackground());
        }
        if (row == rows) {
            ((JComponent) cellComponent).setBorder(null);
        }

        return cellComponent;
    }
}


public class FullOutput extends javax.swing.JPanel {
    public FullOutput() {
        initComponents();
    }

    public void reset() {
    
        Folio.IO.flag = false;
        
        Folio.IO.current_frames = 3;
        Folio.IO.main_Array = null;
        Folio.IO.io_reference_input.setText("");
        
        removeAll();
        initComponents();
        
    }

    public void initComponents() {
        results_model = new DefaultTableModel();
        tableScrollPane = new javax.swing.JScrollPane();
        exit = new javax.swing.JButton();
        minimize = new javax.swing.JButton();
        io_save = new javax.swing.JButton();
        io_return = new javax.swing.JButton();
        io_page_label = new javax.swing.JLabel();
        io_page_bg = new javax.swing.JLabel();
        io_timer_label = new javax.swing.JLabel();
        io_timer_bg = new javax.swing.JLabel();
        io_output_scroll = new javax.swing.JScrollPane();
        io_output_bg = new javax.swing.JLabel();
        io_bg = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();
        setLayout(null);

    //    create_tables();
       

    }
    String[] global_header;
    public void create_tables() {
        // initComponents();
        mainPanel.setBounds(60, 90, 960, 560);
        mainPanel.setLayout(new BorderLayout());
            int spacing = 20; // Adjust the spacing as desired
            String [] algorithms = {"First in First Out", "Least Recently Used", "Optimal Page Replacement", "Second Chance Algorithm", "Enhanced Second Chance Algorithm", "Least Frequency Used", "Most Frequency Used"};
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            

            global_header = new String [Folio.IO.main_Array.length];
            


            int[] results = new int[7];


            // FIFO fifo = 

            for(int x = 0; x < global_header.length; x++){
                
                global_header[x] = String.valueOf(Folio.IO.main_Array[x]);
            }

            for (int i = 0; i < 7; i++) {
                
                String[] header = global_header;
                Object[][] rowData = {
                };
              

                
                // Create a JTable with sample data
               
                

               
                JLabel label = new JLabel(algorithms[i], null, SwingConstants.RIGHT);
                JTable table = new JTable(rowData, header);

                
                TableCellRenderer cellRenderer = new CenterTextRenderer(-1, -1, Folio.IO.current_frames);
                table.setDefaultRenderer(Object.class, cellRenderer);
                
                table.setModel(new javax.swing.table.DefaultTableModel(rowData, header));
                DefaultTableModel proxy_model = (DefaultTableModel) table.getModel();
                proxy_model.setColumnCount(results_model.getColumnCount());
                proxy_model.setRowCount(Folio.IO.current_frames);


    
                table.setFillsViewportHeight(true);
                table.setGridColor(new java.awt.Color(255, 255, 255));
                table.setSelectionBackground(new java.awt.Color(211, 211, 211));
                table.setSelectionForeground(new java.awt.Color(0, 0, 0));
                table.setInheritsPopupMenu(true);
                table.setIntercellSpacing(new java.awt.Dimension(35, 1));
                table.setRowHeight(40);
                table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);

                // Create a scroll pane for the table
                JScrollPane tableScrollPane = new JScrollPane(table);

                // Set the preferred size of the scroll pane
                // tableScrollPane.setPreferredSize(new Dimension(300, 200));

                // Add spacing between the scroll panes
                if (i > 0) {
                    panel.add(Box.createRigidArea(new Dimension(0, spacing)));
                    
                }

                // Add the scroll pane to the panel
                label.setFont(new java.awt.Font("Poppins ExtraBold", 0, 16));
                panel.add(label);
                panel.add(tableScrollPane);
              
            }
            

            // Add an empty border around the panel to create additional spacing
            panel.setBorder(new EmptyBorder(spacing, spacing, spacing, spacing));

            // Add the panel to the main panel
            mainPanel.add(panel, BorderLayout.CENTER);
          

            
            io_output_scroll.setBorder(null);
            io_output_scroll.setBounds(60, 90, 960, 550);
            io_output_scroll.setOpaque(false);
            io_output_scroll.setBackground(Color.white);
            io_output_scroll.setViewportView(mainPanel);
            

            
            add(io_output_scroll);

            
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

        // io_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/save.png"))); 
        // io_save.setBorder(null);
        // io_save.setEnabled(false);
        // io_save.setBorderPainted(false);
        // io_save.setContentAreaFilled(false);
        // io_save.setFocusPainted(false);
        // io_save.addMouseListener(new java.awt.event.MouseAdapter() {
        //     public void mouseEntered(java.awt.event.MouseEvent evt) {
        //         io_saveMouseEntered(evt);
        //     }
        //     public void mouseExited(java.awt.event.MouseEvent evt) {
        //         io_saveMouseExited(evt);
        //     }
        // });
        // io_save.addActionListener(new java.awt.event.ActionListener() {
        //     public void actionPerformed(java.awt.event.ActionEvent evt) {
        //         io_saveActionPerformed(evt);
        //     }
        // });
        // add(io_save);
        // io_save.setBounds(910, 630, 80, 80);

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

        // io_page_label.setFont(new java.awt.Font("Poppins ExtraBold", 0, 16)); // NOI18N
        // io_page_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        // io_page_label.setText("0");
        // add(io_page_label);
        // io_page_label.setBounds(240, 40, 60, 30);

        // io_page_bg.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        // io_page_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/page_highlight.png"))); // NOI18N
        // io_page_bg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        // add(io_page_bg);
        // io_page_bg.setBounds(170, 30, 150, 50);

        // io_timer_label.setFont(new java.awt.Font("Poppins ExtraBold", 0, 16)); 
        // io_timer_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        // io_timer_label.setText("0");
        // add(io_timer_label);
        // io_timer_label.setBounds(90, 40, 60, 30);

        // io_timer_bg.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        // io_timer_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/timer_bg.png"))); 
        // io_timer_bg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        // add(io_timer_bg);
        // io_timer_bg.setBounds(40, 30, 120, 50);

        

        io_output_bg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        io_output_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/algorithm_bg_full.png"))); 
        io_output_bg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(io_output_bg);
        io_output_bg.setBounds(0, 50, 1080, 650);

        io_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/backgrounds/background.png"))); 
        io_bg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        io_bg.setOpaque(true);
        add(io_bg);
        io_bg.setBounds(0, 0, 1080, 720);
    }

    private void minimizeMouseEntered(java.awt.event.MouseEvent evt) {
        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/min_hover.png")));
    }

    private void minimizeMouseExited(java.awt.event.MouseEvent evt) {
        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/min.png")));
    }

    private void minimizeActionPerformed(java.awt.event.ActionEvent evt) {
        Music.sfx();
        Folio.mainFrame.setState(java.awt.Frame.ICONIFIED);
    }

    private void exitMouseEntered(java.awt.event.MouseEvent evt) {
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/close_hover.png")));
    }

    private void exitMouseExited(java.awt.event.MouseEvent evt) {
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/close.png")));
    }

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {
        Music.sfx();
        System.exit(0);
    }

    private void io_returnMouseEntered(java.awt.event.MouseEvent evt) {
        io_return.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/return_hover.png")));
    }

    private void io_returnMouseExited(java.awt.event.MouseEvent evt) {
        io_return.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/return.png")));
    }

    private void io_returnActionPerformed(java.awt.event.ActionEvent evt) {
        Music.sfx();
        reset();
        Folio.card.show(Folio.mainPanel, "2");
    }

    private void io_saveMouseEntered(java.awt.event.MouseEvent evt) {
        io_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/save_hover.png")));
    }

    private void io_saveMouseExited(java.awt.event.MouseEvent evt) {
        io_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/save.png")));
    }

    private void io_saveActionPerformed(java.awt.event.ActionEvent evt) {
        Music.sfx();
        Music.sfx();
        int fileNumber = 1;

        String fileName = "image_" + String.format("%03d", fileNumber) + ".png";
        File file = new File(fileName);
        
        // Check if the file already exists
        while (file.exists()) {
            fileNumber++; // Increment the file number
            
            // Generate a new file name
            fileName = "image_" + String.format("%03d", fileNumber) + ".png";
            file = new File(fileName);
        }
        // saveTableAsImage(table, fileName);

        String pdfPath = "pdf_" + String.format("%03d", fileNumber) + ".pdf"; 

        try {
            BufferedImage bufferedImage = ImageIO.read(new File(fileName));
            int imageWidth = bufferedImage.getWidth() + 70;
            int imageHeight = bufferedImage.getHeight() + 70;

            Document document = new Document();
            document.setPageSize(new com.itextpdf.text.Rectangle(imageWidth, imageHeight));
            PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
            document.open();

            Image image = Image.getInstance(bufferedImage, null);
            document.add(image);

            document.close();
            System.out.println("Image converted to PDF successfully.");
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }

    private javax.swing.JButton exit;
    private javax.swing.JLabel io_bg;
    private javax.swing.JLabel io_output_bg;
    public javax.swing.JScrollPane io_output_scroll;
    private javax.swing.JLabel io_page_bg;
    private javax.swing.JLabel io_page_label;
    private javax.swing.JButton io_return;
    public javax.swing.JButton io_save;
    private javax.swing.JLabel io_timer_bg;
    private javax.swing.JLabel io_timer_label;
    private javax.swing.JButton minimize;
    public javax.swing.JPanel panel;
    public javax.swing.JPanel mainPanel;
    public javax.swing.JScrollPane tableScrollPane;
    public DefaultTableModel results_model;
   
}