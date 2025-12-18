package domain.services;

import domain.entities.Estudante;
import domain.entities.TopicoEstudo;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class MatchService {
    private Set<TopicoEstudo> topicos = new HashSet<>();

    public MatchService() {
    }

    public boolean criarTopico(TopicoEstudo topico) {
        return topicos.add(topico);
    }

    public boolean inscreverEstudante(Estudante estudante, String materia) {
        Optional<TopicoEstudo> opt = topicos.stream()
                .filter(t -> materia.equals(t.getMateria()))
                .findFirst();

        if (opt.isEmpty()) {
            System.out.println("A materia " + materia + " não esta cadastrada!");
            return false;
        }

        TopicoEstudo topico = opt.get();
        topico.subscribe(estudante);
        System.out.println("Estudante " + estudante.getNome() + " inscrito na materia: " + topico.getMateria());
        return true;
    }

    public boolean unsubEstudante(Estudante estudante, String materia) {
        Optional<TopicoEstudo> opt = topicos.stream()
                .filter(t -> materia.equals(t.getMateria()))
                .findFirst();

        if (opt.isEmpty()) {
            System.out.println("A materia " + materia + " não esta cadastrada!");
            return false;
        }

        TopicoEstudo topico = opt.get();
        topico.unsubscribe(estudante);
        System.out.println("Estudante " + estudante.getNome() + " removido na materia: " + topico.getMateria());
        return true;
    }


}
