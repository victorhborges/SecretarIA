
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaAgenda {

    private LocalDate mesAtual = LocalDate.of(2026, 8, 1);

    public JPanel criar() {

        JPanel painel = new JPanel(new BorderLayout());
        JPanel gradeDias = new JPanel(new GridLayout(6, 7));

        JLabel titulo = new JLabel("AGENDA");

        JLabel dataSelecionada= new JLabel("Nenhum dia selecionado!");

        JPanel cabecalho = new JPanel(new FlowLayout());

        DateTimeFormatter formatoMes = DateTimeFormatter.ofPattern("MMMM yyyy", new Locale("pt","BR"));

        JLabel mesAno = new JLabel(mesAtual.format(formatoMes));

        JButton botaoAnterior = new JButton("<");

        botaoAnterior.addActionListener(e -> {
            mesAtual = mesAtual.minusMonths(1);
            mesAno.setText(mesAtual.format(formatoMes));
            atualizarCalendario(gradeDias, dataSelecionada);

            dataSelecionada.setText("Nenhum dia selecionado!");
        });

        JButton botaoProximo = new JButton(">");
        botaoProximo.addActionListener(e -> {
            mesAtual = mesAtual.plusMonths(1);
            mesAno.setText(mesAtual.format(formatoMes));
            atualizarCalendario(gradeDias, dataSelecionada);

            dataSelecionada.setText("Nenhum dia selecionado!");
        });

        JPanel diasSemana = new JPanel(new GridLayout(1, 7));

        JButton segunda = new JButton("Seg");
        JButton terca = new JButton("Ter");
        JButton quarta = new JButton("Qua");
        JButton quinta = new JButton("Qui");
        JButton sexta = new JButton("Sex");
        JButton sabado = new JButton("Sab");
        JButton domingo = new JButton("Dom");

        segunda.setEnabled(false);
        terca.setEnabled(false);
        quarta.setEnabled(false);
        quinta.setEnabled(false);
        sexta.setEnabled(false);
        sabado.setEnabled(false);
        domingo.setEnabled(false);

        diasSemana.add(segunda);
        diasSemana.add(terca);
        diasSemana.add(quarta);
        diasSemana.add(quinta);
        diasSemana.add(sexta);
        diasSemana.add(sabado);
        diasSemana.add(domingo);

        atualizarCalendario(gradeDias, dataSelecionada);

        JPanel calendario = new JPanel(new BorderLayout());

        JPanel areaInferior = new JPanel(new BorderLayout());

        cabecalho.add(botaoAnterior);
        cabecalho.add(mesAno);
        cabecalho.add(botaoProximo);

        calendario.add(cabecalho, BorderLayout.NORTH);
        calendario.add(diasSemana, BorderLayout.CENTER);
        calendario.add(areaInferior, BorderLayout.SOUTH);

        areaInferior.add(gradeDias, BorderLayout.CENTER);
        areaInferior.add(dataSelecionada, BorderLayout.SOUTH);
        

        painel.add(titulo, BorderLayout.NORTH);
        painel.add(calendario, BorderLayout.CENTER);

        return painel;
    }

    private void atualizarCalendario(JPanel gradeDias, JLabel dataSelecionada) {

        gradeDias.removeAll();

        int quantidadeDias = mesAtual.lengthOfMonth();
        int primeiroDia = mesAtual.getDayOfWeek().getValue();

        LocalDate hoje = LocalDate.now();

        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (int i = 1; i < primeiroDia; i++) {
            gradeDias.add(new JButton(""));
        }

        for (int dia = 1; dia <= quantidadeDias; dia++) {
            JButton botaoDia= new JButton(String.valueOf(dia));
            LocalDate dataDoBotao = mesAtual.withDayOfMonth(dia);

            if(dataDoBotao.equals(hoje)){
                botaoDia.setBorder(BorderFactory.createEtchedBorder());
            }

            botaoDia.addActionListener(e -> {
                String dataFormatada = dataDoBotao.format(formatoData);
                dataSelecionada.setText("Dia selecionado: " + dataFormatada);

            });


            gradeDias.add(botaoDia);
        }

        gradeDias.revalidate();
        gradeDias.repaint();
    }
}
