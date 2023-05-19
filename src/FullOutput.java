public class FullOutput extends javax.swing.JPanel {
    public FullOutput() {
        initComponents();
    }

    public void reset() {
        
        removeAll();
        initComponents();
        Folio.IO.removeAll();
        Folio.IO.initComponents();
    }

    private void initComponents() {
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

        io_page_label.setFont(new java.awt.Font("Poppins ExtraBold", 0, 16)); // NOI18N
        io_page_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        io_page_label.setText("0");
        add(io_page_label);
        io_page_label.setBounds(240, 40, 60, 30);

        io_page_bg.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        io_page_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/page_highlight.png"))); // NOI18N
        io_page_bg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(io_page_bg);
        io_page_bg.setBounds(170, 30, 150, 50);

        io_timer_label.setFont(new java.awt.Font("Poppins ExtraBold", 0, 16)); 
        io_timer_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        io_timer_label.setText("0");
        add(io_timer_label);
        io_timer_label.setBounds(90, 40, 60, 30);

        io_timer_bg.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        io_timer_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/timer_bg.png"))); 
        io_timer_bg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(io_timer_bg);
        io_timer_bg.setBounds(40, 30, 120, 50);

        io_output_scroll.setBorder(null);
        io_output_scroll.setOpaque(false);
        add(io_output_scroll);
        io_output_scroll.setBounds(60, 90, 960, 570);

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
        // Insert didi an table variable
        // IOPanel.saveTableAsImage(results_table, "panel_image.png");
    }

    private javax.swing.JButton exit;
    private javax.swing.JLabel io_bg;
    private javax.swing.JLabel io_output_bg;
    private javax.swing.JScrollPane io_output_scroll;
    private javax.swing.JLabel io_page_bg;
    private javax.swing.JLabel io_page_label;
    private javax.swing.JButton io_return;
    private javax.swing.JButton io_save;
    private javax.swing.JLabel io_timer_bg;
    private javax.swing.JLabel io_timer_label;
    private javax.swing.JButton minimize;
   
}