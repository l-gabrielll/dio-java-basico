package br.com.dio.ui.custom.frame;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
    public MainFrame(final Dimension dimensao, final JPanel maiJPanel) {
        super("Sudoku");
        this.setSize(dimensao);
        this.setPreferredSize(dimensao);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.add(maiJPanel);
    }
}
