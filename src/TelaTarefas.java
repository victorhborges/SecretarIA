
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
    
public class TelaTarefas {
    private GerenciadorTarefas gerenciador;

    public TelaTarefas(){
        gerenciador = new GerenciadorTarefas();
    }

    public JPanel criar() {

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

        JLabel resumo = new JLabel("Total: 0, Concluídas: 0, Pendentes 0");

        botaoAdicionar.addActionListener(e -> {
            String tarefa = campoTarefa.getText().trim();

            String prioridade = (String) campoPrioridade.getSelectedItem();

            String prazo = campoPrazo.getText().trim();

            if (prazo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Digite um prazo!");
                return;
            }

            if(!gerenciador.podeUsarPrazo(prazo)){
                JOptionPane.showMessageDialog(null,"Prazo inválido ou anterior a data atual!");
                return;
            }

            Tarefa novaTarefa = new Tarefa(tarefa, prioridade, prazo);
                
            if(!gerenciador.adicionar(novaTarefa)){
                JOptionPane.showMessageDialog(null,"Não foi possível adicionar uma nova tarefa!");
                return;
            }

            atualizarResumo(resumo, gerenciador);

            JPanel painelTarefa = TarefaPainel.criar(novaTarefa, listaTarefas, gerenciador, resumo);

            listaTarefas.add(painelTarefa);

            campoTarefa.setText("");
            campoPrazo.setText("");

            listaTarefas.revalidate();
            listaTarefas.repaint();
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

    public static void atualizarResumo (JLabel resumo, GerenciadorTarefas gerenciador){
        resumo.setText(gerenciador.getResumo());
    }
}