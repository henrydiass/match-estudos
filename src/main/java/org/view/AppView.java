package org.view;

import controllers.ApplicationController;
import domain.entities.Estudante;
import interfaces.TopicoView;

public class AppView {
    public static void main(String[] args) {
        ApplicationController controller = new ApplicationController();
        //Utiliza uma interface para declarar os tópicos; não expondo metodos desnecessariamente
        TopicoView topico = controller.criarTopico(1, "Algebra Linear");

        Estudante e1 = new Estudante();
        e1.setId(1);
        e1.setNome("Jose");

        Estudante e2 = new Estudante();
        e2.setId(2);
        e2.setNome("Alice");

        Estudante e3 = new Estudante();
        e3.setId(3);
        e3.setNome("Jean");

        // Sempre que um novo aluno demonstrar interesse por uma materia --
        // os outros alunos serão notificados
        controller.cadastrarInteresse(e1, "Algebra Linear");
        controller.cadastrarInteresse(e2, "Algebra Linear");
        controller.cadastrarInteresse(e3, "Algebra Linear");

    }
}