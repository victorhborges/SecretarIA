
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaLogin {

    public static void abrir() {
        JFrame janela = new JFrame();

        janela.setTitle("SecretarIA");
        janela.setSize(800, 500);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);

        JPanel painel = new JPanel();

        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Bem-vindo ao SecretarIA!");

        JLabel tituloLogin = new JLabel("LOGIN");
        JLabel labelLogin = new JLabel("Digite seu login:");
        JTextField campoLogin = new JTextField();

        JLabel tituloSenha = new JLabel("SENHA");
        JLabel labelSenha = new JLabel("Digite sua senha:");
        JPasswordField campoSenha = new JPasswordField();

        JButton botaoEntrar = new JButton("Entrar");
        botaoEntrar.addActionListener(e -> {
            String login = campoLogin.getText();
            String senha = new String(campoSenha.getPassword());

            if (login.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(janela, "Por favor, preencha todos os campos.");
            } else if (login.equals(Usuario.login) && senha.equals(Usuario.senha)) {
                TelaPrincipal.abrir();
                janela.dispose();
            } else {
                JOptionPane.showMessageDialog(janela, "Login ou senha incorretos! Tente novamente.");
            }

        });

        JButton botaoRecuperar = new JButton("Recuperar Senha");
        botaoRecuperar.addActionListener(e -> {
            TelaRecuperarSenha.abrir();
        });

        JButton botaoCadastrar = new JButton("Cadastrar Conta");
        botaoCadastrar.addActionListener(e -> {
            TelaCadastrarConta.abrir();
        });

        janela.add(painel);

        painel.add(titulo);
        painel.add(tituloLogin);

        painel.add(labelLogin);
        painel.add(campoLogin);
        painel.add(tituloSenha);
        painel.add(labelSenha);
        painel.add(campoSenha);
        
        painel.add(botaoEntrar);
        painel.add(botaoRecuperar);
        painel.add(botaoCadastrar);

        janela.setVisible(true);
    }
}
