package br.com.dio.ui.custom.panel;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import br.com.dio.ui.custom.input.TextoNumerico;

import java.awt.Dimension;
import java.util.List;

import static java.awt.Color.black;

public class SudokuSector extends JPanel {

    public SudokuSector(final List<TextoNumerico> camposTexto) {
        var dimensao = new Dimension(170, 170);
        this.setSize(dimensao);
        this.setPreferredSize(dimensao);
        this.setBorder(new LineBorder(black, 2, true));
        this.setVisible(true);
        camposTexto.forEach(this::add);
    }
}
