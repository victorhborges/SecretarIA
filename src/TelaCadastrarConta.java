
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaCadastrarConta {

    public static void abrir() {
        JFrame janela = new JFrame();

        janela.setTitle("SecretarIA - Cadastrar Conta");
        janela.setSize(500, 400);
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janela.setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("CADASTRAR CONTA");

        JLabel labelNewUser = new JLabel("Insira seu nome de usuário:");
        JTextField campoNewUser = new JTextField();

        JLabel labelNewSenha = new JLabel("Escolha uma senha:");
        JPasswordField campoSenha = new JPasswordField(20);

        JLabel labelConfirmar = new JLabel("Confirme a senha inserida:");
        JPasswordField campoConfirmar = new JPasswordField(20);

        JButton botaoCriar = new JButton("Criar Conta");

        botaoCriar.addActionListener(e -> {
            String novoUser = campoNewUser.getText();
            String novaSenha = new String(campoSenha.getPassword());
            String confirmarSenha = new String(campoConfirmar.getPassword());

            if (novoUser.isEmpty() || novaSenha.isEmpty() || confirmarSenha.isEmpty()) {
                JOptionPane.showMessageDialog(janela, "Por favor, preencha todos os campos.");
            }
            else if (!novaSenha.equals(confirmarSenha)){
                JOptionPane.showMessageDialog(janela,"As senhas não coincidem!");
            }

            else {
                Usuario.login = novoUser;
                Usuario.senha = novaSenha;
                JOptionPane.showMessageDialog(janela, "Conta criada com sucesso!");

                janela.dispose();
            }
        });

        painel.add(titulo);

        painel.add(labelNewUser);
        painel.add(campoNewUser);

        painel.add(labelNewSenha);
        painel.add(campoSenha);

        painel.add(labelConfirmar);
        painel.add(campoConfirmar);

        painel.add(botaoCriar);

        janela.add(painel);
        janela.setVisible(true);

    }
}
