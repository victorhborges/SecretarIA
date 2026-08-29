import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class GerenciadorCompromissos {
    private List<Compromisso> compromissos;

    public GerenciadorCompromissos(){
        compromissos = new ArrayList<>();
    }

    public boolean adicionar(Compromisso compromisso){
        if (compromisso == null){
            return false;
        }

        compromissos.add(compromisso);
        return true;
    }

    public void remover(Compromisso compromisso){
        compromissos.remove(compromisso);
    }

    public List<Compromisso> buscarPorData(LocalDate data){
        List<Compromisso> resultado = new ArrayList<>();

        for (Compromisso compromisso: compromissos) {
            if(compromisso.getData().equals(data)){
                resultado.add(compromisso);
            }
        }

        return resultado;
    }

    public int getTotal(){
        return compromissos.size();
    }
}
