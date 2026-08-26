public class Tarefa {
    private String texto;
    private String prioridade;
    private String prazo;
    private boolean concluida;

    public Tarefa(String texto, String prioridade, String prazo ){
        this.texto = texto;
        this.prioridade = prioridade;
        this.prazo = prazo;
        this.concluida = false;
    }

    public String getTexto(){
        return texto;
    }

    public void setTexto(String texto){
        this.texto = texto;
    }

    public String getPrioridade(){
        return prioridade;
    }

    public void setPrioridade(String prioridade){
        this.prioridade = prioridade;
    }

    public String getPrazo(){
        return prazo;
    }

    public void setPrazo(String prazo){
        this.prazo = prazo;
    }

    public boolean isConcluida(){
        return concluida;
    }

    public void setConcluida(boolean concluida){
        this.concluida = concluida;
    }


}
