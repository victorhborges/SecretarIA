
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
    
public class TelaTarefas {

    public static JPanel criar() {

        JPanel painel = new JPanel(new BorderLayout());

        JPanel painelCabecalho = new JPanel(new BorderLayout());

        JLabel titulo = new JLabel("TAREFAS");

        JPanel painelAdicionar = new JPanel(new FlowLayout());

        JTextField campoTarefa = new JTextField(20);
        String[] prioridades = {"Baixa", "Média", "Alta"};
        JComboBox<String> campoPrioridade = new JComboBox<>(prioridades);

        JTextField campoPrazo = new JTextField(10);
        campoPrazo.setToolTipText("Ex: 24/08/2026");

        JButton botaoAdicionar = new JButton("Adicionar");

        JPanel listaTarefas = new JPanel();
        listaTarefas.setLayout(new BoxLayout(listaTarefas, BoxLayout.Y_AXIS));
        List<Tarefa> tarefas = new ArrayList<>();

        JLabel resumo = new JLabel("Total: 0, Concluídas: 0, Pendentes 0");

        botaoAdicionar.addActionListener(e -> {
            String tarefa = campoTarefa.getText().trim();

            if (tarefa.isEmpty()) {

                JOptionPane.showMessageDialog(null, "Digite uma tarefa!");

                return;
            }

            String prioridade = (String) campoPrioridade.getSelectedItem();

            String prazo = campoPrazo.getText().trim();
            if (prazo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Digite um prazo!");

                return;
            }

            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            try {
                LocalDate data = LocalDate.parse(prazo, formato);
                LocalDate hoje = LocalDate.now();
                if (data.isBefore(hoje)) {
                    JOptionPane.showMessageDialog(null, "O prazo não pode ser anterior a data atual!");

                    return;
                }

                Tarefa novaTarefa = new Tarefa(tarefa, prioridade, prazo);
                tarefas.add(novaTarefa);
                atualizarResumo(resumo, tarefas);
                JPanel painelTarefa = TarefaPainel.criar(novaTarefa, listaTarefas, tarefas);

                listaTarefas.add(painelTarefa);

                campoTarefa.setText("");
                campoPrazo.setText("");

                listaTarefas.revalidate();
                listaTarefas.repaint();

            } catch (DateTimeParseException erro) {
                JOptionPane.showMessageDialog(null, "Data inválida! Use o formato dd/MM/yyyy");

            }
        });
        

        painel.add(painelCabecalho, BorderLayout.NORTH);
        painel.add(listaTarefas, BorderLayout.CENTER);

        painelAdicionar.add(campoTarefa);
        painelAdicionar.add(campoPrioridade);
        painelAdicionar.add(campoPrazo);
        painelAdicionar.add(botaoAdicionar);

        painelCabecalho.add(titulo, BorderLayout.NORTH);
        painelCabecalho.add(resumo, BorderLayout.CENTER);
        painelCabecalho.add(painelAdicionar, BorderLayout.SOUTH);

        return painel;
    }

    private static void atualizarResumo (JLabel resumo, List<Tarefa>tarefas){
        int total = tarefas.size();
        int concluidas = 0;

        for(Tarefa tarefa : tarefas){
            if (tarefa.isConcluida()){
                concluidas++;
            }
        }

        int pendentes = total - concluidas;
        resumo.setText("Total: " + total + "| Concluídas: " + concluidas  + "| Pendentes: " + pendentes);
    }
}