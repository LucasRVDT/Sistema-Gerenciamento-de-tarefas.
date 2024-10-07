import java.time.LocalDateTime;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import br.edu.iff.ccc.bsi.webdev.entities.Coluna;
import br.edu.iff.ccc.bsi.webdev.entities.Usuario;

public class QuadroModel extends RepresentationModel<QuadroModel> {
    Long id;
    String nome;
    String descricao;
    LocalDateTime dataCriacao;
    String status;
    Usuario usuario;
    List<Coluna> colunas;
    List<Usuario> membros;

}
