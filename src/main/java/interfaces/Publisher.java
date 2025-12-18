package interfaces;

import domain.entities.Estudante;

public interface Publisher {
    void subscribe(Subscriber sub);
    void unsubscribe(Subscriber sub);
    void notificar();
}
