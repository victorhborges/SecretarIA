import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TarefaPainel {
    public static JPanel criar(Tarefa tarefa, JPanel listaTarefas, List<Tarefa> tarefas) {
        JPanel painel = new JPanel(new BorderLayout());

        painel.setMaximumSize (new Dimension(Integer.MAX_VALUE, 40));
        painel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        JPanel informacoes = new JPanel();

        JCheckBox concluida = new JCheckBox();

        JLabel tarefaTexto = new JLabel(tarefa.getTexto());
        JLabel labelPrioridade = new JLabel("Prioridade: " + tarefa.getPrioridade());
        JLabel labelPrazo = new JLabel("Prazo: "+ tarefa.getPrazo());


        concluida.addActionListener(e -> {
            if (concluida.isSelected()) {
                tarefa.setConcluida(true);
                tarefaTexto.setText("✓ " + tarefa.getTexto());
            }
            else {
                tarefa.setConcluida(false);
                tarefaTexto.setText(tarefa.getTexto());
            }
        });

        JButton botaoExcluir = new JButton("X");

        botaoExcluir.addActionListener(e -> {
            tarefas.remove(tarefa);
            listaTarefas.remove(painel);

            listaTarefas.revalidate();
            listaTarefas.repaint();
        });

        painel.add(informacoes, BorderLayout.CENTER);
        painel.add(botaoExcluir, BorderLayout.EAST);

        informacoes.add(concluida);
        informacoes.add(tarefaTexto);
        informacoes.add(labelPrioridade);
        informacoes.add(labelPrazo);

        return painel;
    }
}
