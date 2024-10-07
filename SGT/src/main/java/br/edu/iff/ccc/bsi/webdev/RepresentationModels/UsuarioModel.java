package br.edu.iff.ccc.bsi.webdev.RepresentationModels;

import java.util.List;
import org.springframework.hateoas.RepresentationModel;
import br.edu.iff.ccc.bsi.webdev.entities.Quadro;

public class UsuarioModel extends RepresentationModel<UsuarioModel> {
    private Long id;
    private String username;
    private String email;
    private List<Quadro> quadros;

    public UsuarioModel(Long id, String username, String email, List<Quadro> quadros) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.quadros = quadros;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public List<Quadro> getQuadros() {
        return quadros;
    }
}
