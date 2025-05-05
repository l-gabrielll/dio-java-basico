package br.com.dio.ui.custom.screen;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.com.dio.model.Espaco;
import br.com.dio.service.BoardService;
import br.com.dio.service.NotifierService;
import br.com.dio.ui.custom.button.BotaoChecarStatus;
import br.com.dio.ui.custom.button.BotaoFinalizarJogo;
import br.com.dio.ui.custom.button.BotaoReiniciar;
import br.com.dio.ui.custom.frame.MainFrame;
import br.com.dio.ui.custom.input.TextoNumerico;
import br.com.dio.ui.custom.panel.MainPanel;
import br.com.dio.ui.custom.panel.SudokuSector;

import static br.com.dio.service.EventEnum.LIMPAR_ESPACO;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class MainScreen {
    private final static Dimension dimensao = new Dimension(600, 600);

    private final BoardService boardService;
    private final NotifierService notifierService;

    private JButton botaoFinalizarJogo;
    private JButton botaoChecarStatus;
    private JButton botaoReiniciar;

    public MainScreen(final Map<String, String> configJogo) {
        this.boardService = new BoardService(configJogo);
        this.notifierService = new NotifierService();
    }

    public void construirTelaPrincipal() {
        JPanel mainPanel = new MainPanel(dimensao);
        JFrame mainFrame = new MainFrame(dimensao, mainPanel);
        for (int l = 0; l < 9; l += 3) {
            var linhaFinal = l + 2;
            for (int c = 0; c < 9; c += 3) {
                var colunaFinal = c + 2;
                var espacos = getSpacesFromSector(boardService.getEspacos(), c, colunaFinal, l, linhaFinal);
                JPanel sector = generateSection(espacos);
                mainPanel.add(sector);
            }
        }
        addBotaoReiniciar(mainPanel);
        addBotaoChecarStatus(mainPanel);
        addBotaoFinalizarJogo(mainPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private List<Espaco> getSpacesFromSector(final List<List<Espaco>> espacos, final int initCol, final int endCol,
    final int initRow, final int endRow){
        List<Espaco> spaceSector = new ArrayList<>();
        for (int r = initRow; r <= endRow; r++) {
            for (int c = initCol; c <= endCol; c++) {
                spaceSector.add(espacos.get(c).get(r));
            }
        }
        return spaceSector;
    }

    private JPanel generateSection(final List<Espaco> espacos) {
        List<TextoNumerico> campos = new ArrayList<>(espacos.stream().map(TextoNumerico::new).toList());
        campos.forEach(t -> notifierService.subscribe(LIMPAR_ESPACO, t));
        return new SudokuSector(campos);
    }

    private void addBotaoFinalizarJogo(final JPanel mainPanel) {
        botaoFinalizarJogo = new BotaoFinalizarJogo(e -> {
            if (boardService.jogoFinalizado()) {
                showMessageDialog(null, "Parabéns, você concluiu o jogo!");
                botaoReiniciar.setEnabled(false);
                botaoChecarStatus.setEnabled(false);
                botaoFinalizarJogo.setEnabled(false);
            } else {
                showMessageDialog(null, "Seu jogo tem alguma inconsistência, ajuste e tente novamente.");
            }
        });
        mainPanel.add(botaoFinalizarJogo);
    }

    private void addBotaoChecarStatus(final JPanel mainPanel) {
        botaoChecarStatus = new BotaoChecarStatus(e -> {
            var hasErrors = boardService.hasErrors();
            var statusJogo = boardService.getStatus();
            var mensagem = switch (statusJogo) {
                case NAO_INICIADO -> "O jogo não foi iniciado";
                case INCOMPLETO -> "O jogo está incompleto";
                case COMPLETO -> "O jogo está completo";
            };
            mensagem += hasErrors ? " e Contém erros" : " e não contém erros.";
            showMessageDialog(null, mensagem);
        });
        mainPanel.add(botaoChecarStatus);
    }

    private void addBotaoReiniciar(final JPanel mainPanel) {
        botaoReiniciar = new BotaoReiniciar(e -> {
            var dialogResult = showConfirmDialog(null, "Deseja realmente reiniciar o jogo?", "Limpar o jogo",
                    YES_NO_OPTION, QUESTION_MESSAGE);
            if (dialogResult == 0) {
                boardService.reiniciar();
                notifierService.notify(LIMPAR_ESPACO);
            }
        });
        mainPanel.add(botaoReiniciar);
    }

}
