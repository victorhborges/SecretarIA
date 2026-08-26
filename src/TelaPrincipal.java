import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaPrincipal {
    public static void abrir(){

        JFrame janela = new JFrame();

        janela.setTitle("SecretarIA - Principal");
        janela.setSize(800,500);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);


        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BorderLayout());

        JPanel menuLat = new JPanel();
        menuLat.setPreferredSize(new Dimension(180,0));

        JPanel conteudo = new JPanel();

        JLabel titulo = new JLabel ("Bem vindo ao SecretarIA!");

        conteudo.add(titulo);

        JButton botaoTarefas = new JButton("Tarefas");
        botaoTarefas.addActionListener(e ->{
            conteudo.removeAll();

            conteudo.add(TelaTarefas.criar());

            conteudo.revalidate();
            conteudo.repaint();
        });

        JButton botaoAgenda = new JButton("Agenda");
        botaoAgenda.addActionListener(e ->{
            conteudo.removeAll();

            JLabel tituloAgenda = new JLabel("AGENDA");

            conteudo.add(tituloAgenda);

            conteudo.revalidate();
            conteudo.repaint();
        });

        JButton botaoConfig = new JButton("Configurações");
        botaoConfig.addActionListener(e ->{
            conteudo.removeAll();
        
            JLabel tituloConfig = new JLabel("CONFIGURAÇÕES");

            conteudo.add(tituloConfig);

            conteudo.revalidate();
            conteudo.repaint();
        });

        
        menuLat.add(botaoTarefas);
        menuLat.add(botaoAgenda);
        menuLat.add(botaoConfig);


        painelPrincipal.add(menuLat, BorderLayout.WEST);
        painelPrincipal.add(conteudo, BorderLayout.CENTER);
        
        janela.add(painelPrincipal);

        janela.setVisible(true);

    }
}
