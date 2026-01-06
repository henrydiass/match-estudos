package domain.exceptions;

public class MateriaNotFoundException extends RuntimeException {
    public MateriaNotFoundException(String materia) {
        super("A materia `" + materia + "` nao foi encontrada");
    }
}
