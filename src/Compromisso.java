import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Compromisso {

    private String descricao;
    private LocalDate data;
    private LocalTime horario;

    public Compromisso(String descricao, LocalDate data, LocalTime horario){
        this.descricao = descricao;
        this.data = data;
        this.horario = horario;
    }

    public String getDescricao(){
        return descricao;
    }

    public LocalDate getData(){
        return data;
    }

    public LocalTime getHorario(){
        return horario;
    }

    @Override
    public String toString(){
        DateTimeFormatter formatoHorario = DateTimeFormatter.ofPattern("HH:mm");
        return horario.format(formatoHorario) + "-" + descricao;
    }
}

