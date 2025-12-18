package controllers;

import domain.entities.Estudante;
import domain.entities.TopicoEstudo;
import domain.services.MatchService;
import interfaces.TopicoView;

public class ApplicationController {
    private MatchService matchService = new MatchService();

    public ApplicationController() {
    }

    public TopicoView criarTopico(int id, String materia) {
        TopicoEstudo t = new TopicoEstudo();
        t.setId(id);
        t.setMateria(materia);

        matchService.criarTopico(t);
        return t;
    }

    public boolean cadastrarInteresse(Estudante estudante, String materia) {
        if (estudante == null || materia.isEmpty()) return false;

        return matchService.inscreverEstudante(estudante, materia);
    }
}
