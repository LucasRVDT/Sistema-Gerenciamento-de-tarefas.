package br.edu.iff.ccc.bsi.webdev.RepresentationModels;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import br.edu.iff.ccc.bsi.webdev.entities.Quadro;

public class UsuarioModel extends RepresentationModel<UsuarioModel> {
    Long id;
    String username;
    String email;
    String senha;
    List<Quadro> quadros;

    public UsuarioModel(Long id, String username, String email, String senha, List<Quadro> quadros) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.senha = senha;
        this.quadros = quadros;
    }
}
