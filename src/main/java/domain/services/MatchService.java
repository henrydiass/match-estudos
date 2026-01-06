package domain.services;

import domain.entities.Estudante;
import domain.entities.TopicoEstudo;
import domain.exceptions.MateriaNotFoundException;

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
        TopicoEstudo topico = topicos.stream()
                .filter(t -> materia.equals(t.getMateria()))
                .findFirst()
                .orElseThrow(() -> new MateriaNotFoundException(materia));

        topico.subscribe(estudante);
        System.out.println("Estudante " + estudante.getNome() + " inscrito na materia: " + topico.getMateria());
        return true;
    }

    public boolean unsubEstudante(Estudante estudante, String materia) {
        TopicoEstudo topico = topicos.stream()
                .filter(t -> materia.equals(t.getMateria()))
                .findFirst()
                .orElseThrow(() -> new MateriaNotFoundException(materia));

        topico.unsubscribe(estudante);
        System.out.println("Estudante " + estudante.getNome() + " removido na materia: " + topico.getMateria());
        return true;
    }


}
