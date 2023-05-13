import java.lang.reflect.Array;
import java.util.Random;

import javax.swing.JComboBox;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class IOPanel extends javax.swing.JPanel {
    private String Selected;
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

    public void reset(){
        default_speed = 1; 
        current_speed = default_speed;
        default_frames = 3;
        current_frames = default_frames;
        removeAll();
        initComponents();
        Folio.fullOutput.reset();
    }
    private void adjustScrollBar(javax.swing.JComboBox<String> box) {
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
    

    private void initComponents() {
        length_upper = 40;
        length_lower = 10;
        lower_value = 0;
        upper_value = 20;
        frame_lower = 3;
        frame_upper = 10;
        
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
        io_output_scroll.setBounds(50, 340, 980, 330);

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
    }

    private void exitMouseEntered(java.awt.event.MouseEvent evt) {
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/close_hover.png")));
    }

    private void exitMouseExited(java.awt.event.MouseEvent evt) {
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/close.png")));
    }

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void minimizeMouseEntered(java.awt.event.MouseEvent evt) {
        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/min_hover.png")));
    }

    private void minimizeMouseExited(java.awt.event.MouseEvent evt) {
        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/min.png")));
    }

    private void minimizeActionPerformed(java.awt.event.ActionEvent evt) {
        Folio.mainFrame.setState(java.awt.Frame.ICONIFIED);
    }

    private void io_returnMouseEntered(java.awt.event.MouseEvent evt) {
        io_return.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/return_hover.png")));
    }

    private void io_returnMouseExited(java.awt.event.MouseEvent evt) {
        io_return.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/return.png")));
    }

    private void io_returnActionPerformed(java.awt.event.ActionEvent evt) {
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
        
    }

    private void io_randomMouseEntered(java.awt.event.MouseEvent evt) {
        io_random.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/random_hover.png")));
    }

    private void io_randomMouseExited(java.awt.event.MouseEvent evt) {
        io_random.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/random.png")));
    }

    private void io_randomActionPerformed(java.awt.event.ActionEvent evt) {

        
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
            array_string = array_string + String.valueOf(random_Array[i]) + ",";
        }
        else{
            array_string = array_string + String.valueOf(random_Array[i]) + "";
        }
       }
       
       System.out.println(array_string);

       io_reference_input.setText(array_string);


    

    }

    private void io_importMouseEntered(java.awt.event.MouseEvent evt) {
        io_import.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/import_hover.png")));
    }

    private void io_importMouseExited(java.awt.event.MouseEvent evt) {
        io_import.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/import.png")));
    }

    private void io_importActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("importing");

        
    }

    private void io_simulateAllMouseEntered(java.awt.event.MouseEvent evt) {
        io_simulateAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/simulateAll_hover.png")));
    }

    private void io_simulateAllMouseExited(java.awt.event.MouseEvent evt) {
        io_simulateAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/simulateAll.png")));
    }

    private void io_simulateAllActionPerformed(java.awt.event.ActionEvent evt) {
        Folio.card.show(Folio.mainPanel, "6");
    }

    private void io_simulateMouseEntered(java.awt.event.MouseEvent evt) {
        io_simulate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/simulate_hover.png")));
    }

    private void io_simulateMouseExited(java.awt.event.MouseEvent evt) {
        io_simulate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/simulate.png")));
    }

    private void io_simulateActionPerformed(java.awt.event.ActionEvent evt) {
        Selected = io_algorithm_select.getSelectedItem().toString();

        System.out.println(Selected);
        
        
    }

    private void io_speed_minusMouseEntered(java.awt.event.MouseEvent evt) {
        io_speed_minus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/minus_hover.png")));
    }

    private void io_speed_minusMouseExited(java.awt.event.MouseEvent evt) {
        io_speed_minus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/minus.png")));
    }

    private void io_speed_minusActionPerformed(java.awt.event.ActionEvent evt) {
        if(current_speed > 0.5){
            current_speed = current_speed - 0.5;
            io_speed_value.setText(String.valueOf(current_speed)+"x");
        }
        else{
            System.out.println("cannot subtract more than 0.5");
        }
        
    }

    private void io_speed_addMouseEntered(java.awt.event.MouseEvent evt) {
        io_speed_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/add_hover.png")));
    }

    private void io_speed_addMouseExited(java.awt.event.MouseEvent evt) {
        io_speed_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/add.png")));
    }

    private void io_speed_addActionPerformed(java.awt.event.ActionEvent evt) {
        
        if(current_speed < 2.0){
            current_speed = current_speed + 0.5;
            io_speed_value.setText(String.valueOf(current_speed)+"x");
        }
        else{
            System.out.println("cannot add more than 2");
        }
        
    }

    private void io_frames_addMouseEntered(java.awt.event.MouseEvent evt) {
        io_frames_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/add_hover.png")));
    }

    private void io_frames_addMouseExited(java.awt.event.MouseEvent evt) {
        io_frames_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/add.png")));
    }

    private void io_frames_addActionPerformed(java.awt.event.ActionEvent evt) {
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

    private void io_frames_minusMouseEntered(java.awt.event.MouseEvent evt) {
        io_frames_minus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/minus_hover.png")));
    }

    private void io_frames_minusMouseExited(java.awt.event.MouseEvent evt) {
        io_frames_minus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buttons/minus.png")));
    }

    private void io_frames_minusActionPerformed(java.awt.event.ActionEvent evt) {

        if(current_frames <= 3){
            System.out.println("removing frames");
            System.out.println("cannot subtract less than 3");
        }
        else{
            current_frames--;
            io_frames_value.setText(String.valueOf(current_frames));
            System.out.println(current_frames);
           
        }
        
    }
    
    
    int default_frames = 3;
    int current_frames = default_frames;
    int length_upper, length_lower, seed, frame_lower, frame_upper, lower_value, upper_value;
        
    private javax.swing.JButton exit;
    private javax.swing.JLabel io_algorithm_bg;
    private javax.swing.JLabel io_algorithm_label;
    private javax.swing.JComboBox<String> io_algorithm_select;
    private javax.swing.JLabel io_bg;
    private javax.swing.JButton io_frames_add;
    private javax.swing.JLabel io_frames_bg;
    private javax.swing.JLabel io_frames_label;
    private javax.swing.JButton io_frames_minus;
    private javax.swing.JLabel io_frames_value;
    private javax.swing.JButton io_import;
    private javax.swing.JLabel io_output_bg;
    private javax.swing.JScrollPane io_output_scroll;
    private javax.swing.JButton io_random;
    private javax.swing.JLabel io_reference_bg;
    private javax.swing.JTextField io_reference_input;
    private javax.swing.JLabel io_reference_label;
    private javax.swing.JButton io_return;
    private javax.swing.JButton io_save;
    private javax.swing.JButton io_simulate;
    private javax.swing.JButton io_simulateAll;
    private javax.swing.JButton io_speed_add;
    private javax.swing.JLabel io_speed_bg;
    private javax.swing.JLabel io_speed_label;
    private javax.swing.JButton io_speed_minus;
    private javax.swing.JLabel io_speed_value;
    private javax.swing.JLabel io_timer_bg;
    private javax.swing.JLabel io_timer_label;
    private javax.swing.JButton minimize;

    public int[] random_Array;
}
