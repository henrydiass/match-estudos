package domain.entities;

import interfaces.Subscriber;

public class Estudante implements Subscriber {
    private int id;
    private String nome;

    @Override
    public void notificar(String materia) {
        System.out.println(nome + " Novo match de estudos " + materia);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
