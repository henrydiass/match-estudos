package domain.services;

import domain.entities.Estudante;
import domain.entities.TopicoEstudo;
import domain.exceptions.MateriaNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchServiceTest {
    private MatchService service;
    private TopicoEstudo topico;
    private final String materia = "Matematica";


    @BeforeEach
    void setUp() {
        service = new MatchService();
        topico = new TopicoEstudo();
    }

    @Test
    void criarTopico() {
        // Arrange

        // Act
        boolean topico1 = service.criarTopico(topico);
        boolean topico2 = service.criarTopico(topico);
        // Assert
        assertTrue(topico1, "A primeira insercao deve retornar true");
        assertFalse(topico2, "Inserir o mesmo topico deve retornar false");
    }

    @Test
    void inscreverEstudante_sucesso() {
        // Act
        topico.setMateria(materia);
        service.criarTopico(topico);

        // Arrange e Assert
        Estudante estudante = new Estudante();
        estudante.setNome("Maria");

        assertTrue(service.inscreverEstudante(estudante, materia), "Inscricao deve retornar true quando topico existe");
    }

    @Test
    void unsubEstudante_sucesso() {
        // Act
        topico.setMateria(materia);
        service.criarTopico(topico);

        // Arrange e Assert
        Estudante estudante = new Estudante();
        estudante.setNome("Joao");

        service.inscreverEstudante(estudante, materia);
        assertTrue(service.unsubEstudante(estudante, materia), "Remocao deve retornar true quando estudante estava inscrito");
    }

    @Test
    void inscreverEstudante() {
        // Arrange
        Estudante estudante = new Estudante();
        estudante.setNome("Joao");

        // Act e Assert
        MateriaNotFoundException exception = assertThrows(
                MateriaNotFoundException.class,
                () -> service.inscreverEstudante(estudante, materia)
        );

        assertTrue(exception.getMessage().contains("Matematica"));
        assertTrue(exception.getMessage().contains("A materia `Matematica` nao foi encontrada"));
    }

    @Test
    void unsubEstudante() {
        // Arrange
        Estudante estudante = new Estudante();

        // Act e Assert
        boolean topicoCriado = service.criarTopico(topico);

        MateriaNotFoundException exception = assertThrows(
                MateriaNotFoundException.class,
                () -> service.unsubEstudante(estudante, materia)
        );
    }
}