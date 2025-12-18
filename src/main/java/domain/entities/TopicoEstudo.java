package domain.entities;

import interfaces.Publisher;
import interfaces.Subscriber;
import interfaces.TopicoView;

import java.sql.Timestamp;
import java.util.*;

public class TopicoEstudo implements Publisher, TopicoView {
    private int id;
    private String materia;
    private String local;
    private Timestamp horario;
    private Set<Subscriber> subs;

    public TopicoEstudo() {
        subs = new HashSet<>();
    }

    @Override
    public void subscribe(Subscriber sub) {
        if (sub == null) return;
        boolean added = subs.add(sub);
        if (!added) return;

        if (subs.size() > 1) {
            sub.notificar(this.materia);
        }
    }

    @Override
    public void unsubscribe(Subscriber sub) {
        if (sub == null) return;
        subs.remove(sub);
    }

    @Override
    public void notificar() {
        for (Subscriber sub : new ArrayList<>(subs)) {
            sub.notificar(this.materia);
        }
    }

    @Override public int getId() { return id; }
    @Override public String getMateria() { return materia; }
    @Override public String getLocal() { return local; }
    @Override public Timestamp getHorario() { return horario; }

    public void setId(int id) { this.id = id; }
    public void setMateria(String materia) { this.materia = materia; }
    public void setLocal(String local) { this.local = local; }
    public void setHorario(Timestamp horario) { this.horario = horario; }


}
