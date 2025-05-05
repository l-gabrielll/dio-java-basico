package br.com.dio.ui.custom.input;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import static br.com.dio.service.EventEnum.LIMPAR_ESPACO;
import static java.awt.Font.PLAIN;

import br.com.dio.model.Espaco;
import br.com.dio.service.EventEnum;
import br.com.dio.service.EventListener;

public class TextoNumerico extends JTextField implements EventListener {

    private final Espaco espaco;

    public TextoNumerico(final Espaco espaco) {
        this.espaco = espaco;
        var dimensao = new Dimension(50, 50);
        this.setSize(dimensao);
        this.setPreferredSize(dimensao);
        this.setVisible(true);
        this.setFont(new Font("Arial", PLAIN, 20));
        this.setHorizontalAlignment(CENTER);
        this.setDocument(new LimiteTextoNumerico());
        this.setEnabled(!espaco.isFixa());
        if (espaco.isFixa()) {
            this.setText(espaco.getValorAtual().toString());
        }
        this.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                mudarEspaco();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                mudarEspaco();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                mudarEspaco();
            }

            private void mudarEspaco() {
                if (getText().isEmpty()) {
                    espaco.espacoLivre();
                    return;
                }
                espaco.setValorAtual(Integer.parseInt(getText()));
            }
            
        });
    }
    
    @Override
    public void update(final EventEnum eventType) {
        if (eventType.equals(LIMPAR_ESPACO) && (this.isEnabled())) {
            this.setText("");
        }
    }
}
