import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TarefaPainel {
    public static JPanel criar(Tarefa tarefa, JPanel listaTarefas, GerenciadorTarefas gerenciador, JLabel resumo) {
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

            TelaTarefas.atualizarResumo(resumo, gerenciador);
        });

        JButton botaoExcluir = new JButton("X");

        botaoExcluir.addActionListener(e -> {
            gerenciador.remover(tarefa);
            listaTarefas.remove(painel);

            TelaTarefas.atualizarResumo(resumo, gerenciador);

            listaTarefas.revalidate();
            listaTarefas.repaint();
        });

        JButton botaoEditar = new JButton("Editar");

        botaoEditar.addActionListener(e->{
            JTextField campoTexto = new JTextField(tarefa.getTexto());

            String[] prioridades = {"Baixa", "Média", "Alta"};
            JComboBox<String> campoPrioridade = new JComboBox<>(prioridades);
            campoPrioridade.setSelectedItem(tarefa.getPrioridade());

            JTextField campoPrazo = new JTextField(tarefa.getPrazo());

            JPanel painelEdicao = new JPanel();

            painelEdicao.add(new JLabel("Tarefa: "));
            painelEdicao.add(campoTexto);

            painelEdicao.add(new JLabel ("Prioridades: "));
            painelEdicao.add(campoPrioridade);

            painelEdicao.add(new JLabel ("Prazo:"));
            painelEdicao.add(campoPrazo);

            int resultado = JOptionPane.showConfirmDialog(null,
                painelEdicao,
                "Editar tarefa", JOptionPane.OK_CANCEL_OPTION);

            if (resultado == JOptionPane.OK_OPTION) {
            String novoTexto = campoTexto.getText().trim();
            String novaPrioridade = (String) campoPrioridade.getSelectedItem();
            String novoPrazo = campoPrazo.getText().trim();
            

            if (gerenciador.editar(tarefa, novoTexto, novaPrioridade,novoPrazo)){
                tarefaTexto.setText(
                tarefa.isConcluida()
                    ? "✓ " + tarefa.getTexto()
                    : tarefa.getTexto());

            labelPrioridade.setText("Prioridade: " + tarefa.getPrioridade());
            labelPrazo.setText("Prazo: " + tarefa.getPrazo());

            listaTarefas.revalidate();
            listaTarefas.repaint();
            }

            else{
                JOptionPane.showMessageDialog(null,"Não foi possível editar a tarefa. Verifique o texto e o prazo");
            }
        }
    });

        JPanel painelBotoes = new JPanel();

        painelBotoes.add(botaoEditar);
        painelBotoes.add(botaoExcluir);

        painel.add(painelBotoes, BorderLayout.EAST);

        painel.add(informacoes, BorderLayout.CENTER);
        

        informacoes.add(concluida);
        informacoes.add(tarefaTexto);
        informacoes.add(labelPrioridade);
        informacoes.add(labelPrazo);

        return painel;
    }
}
