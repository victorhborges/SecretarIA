
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class TelaRecuperarSenha {

    public static void abrir() {
        JFrame janela = new JFrame();

        janela.setTitle("SecretarIA - Recuperar Senha");
        janela.setSize(500, 400);
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janela.setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("RECUPERAR SENHA");

        JLabel labelNewSenha = new JLabel("Digite sua nova senha:");
        JPasswordField campoSenha = new JPasswordField();

        JLabel labelConfirmar = new JLabel("Confirme sua nova senha:");
        JPasswordField campoConfirmar = new JPasswordField();

        JButton botaoAlterar = new JButton("Alterar Senha");

        botaoAlterar.addActionListener(e -> {
            String novaSenha = new String(campoSenha.getPassword());
            String confirmarSenha = new String(campoConfirmar.getPassword());

            if (novaSenha.isEmpty() || confirmarSenha.isEmpty()) {
                JOptionPane.showMessageDialog(janela, "Por favor, preencha todos os campos.");
            } else if (!novaSenha.equals(confirmarSenha)) {
                JOptionPane.showMessageDialog(janela, "As senhas não coincidem! Tente novamente.");
            } else {
                Usuario.senha = novaSenha;
                JOptionPane.showMessageDialog(janela, "Senha alterada com sucesso!");
            }

        });

        painel.add(titulo);

        painel.add(labelNewSenha);
        painel.add(campoSenha);

        painel.add(labelConfirmar);
        painel.add(campoConfirmar);

        painel.add(botaoAlterar);

        janela.add(painel);
        janela.setVisible(true);

    }
}
