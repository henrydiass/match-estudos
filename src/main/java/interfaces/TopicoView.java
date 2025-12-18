package interfaces;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

public interface TopicoView {
    int getId();
    String getMateria();
    String getLocal();
    Timestamp getHorario();
}
