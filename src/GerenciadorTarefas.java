import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class GerenciadorTarefas {
    private List <Tarefa> tarefas;

    public GerenciadorTarefas(){
        tarefas = new ArrayList<>();
    }

    public boolean podeAdicionar(Tarefa tarefa){
        return tarefa !=null && tarefa.getTexto() != null && !tarefa.getTexto().trim().isEmpty();
    }

    public boolean podeUsarPrazo(String prazo){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try{
            LocalDate data = LocalDate.parse(prazo, formato);
            LocalDate hoje = LocalDate.now();

            return !data.isBefore(hoje);
        }
        catch(DateTimeParseException erro){
            return false;
        }
    }

    public boolean adicionar( Tarefa tarefa){
        if(!podeAdicionar(tarefa)){
            return false;
        }

        tarefas.add(tarefa);
        return true;
    }

    public void remover(Tarefa tarefa){
        tarefas.remove(tarefa);
    }

    public int getTotal(){
        return tarefas.size();
    }

    public int getConcluidas(){
        int concluidas = 0;

        for (Tarefa tarefa : tarefas){
            if(tarefa.isConcluida()){
                concluidas++;
            }
        }
        return concluidas;
    }

    public int getPendentes(){
        return getTotal() - getConcluidas();
    }

    public String getResumo(){
        return ("Total: " + getTotal() + "|Concluídas: " + getConcluidas() + "|Pendentes:" + getPendentes());
    }
}
