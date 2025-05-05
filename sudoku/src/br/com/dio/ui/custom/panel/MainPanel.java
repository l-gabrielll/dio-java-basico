package br.com.dio.ui.custom.panel;

import java.awt.Dimension;

import javax.swing.JPanel;

public class MainPanel extends JPanel {

    public MainPanel(final Dimension dimensao) {
        this.setSize(dimensao);
        this.setPreferredSize(dimensao);
    }
}
