package br.edu.iff.ccc.bsi.webdev.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;


@Entity
@Table(name = "tb_usuarios")
public class Usuario implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull(message = "O campo username não pode ser nulo.")
    @Column(name = "username", nullable = false)
    private String username;
    
    @NotNull(message = "O campo email não pode ser nulo.")
    @Email(message = " Digite um e-mail valido")
    @Column(unique = true, name = "email", nullable = false)
    private String email;
    
    @NotNull(message = "O campo senha não pode ser nulo.")
    @Size(min = 8, message = "A senha deve ter no minimo 8 caracteres.")
    @Column(name = "senha", nullable = false)
    private String senha;

	@OneToMany(mappedBy = "usuario")
    private List<Quadro> quadros;

    public Usuario(Long id) {
        super();
        this.id = id;
    }
    
    public Usuario() {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Quadro> getQuadros() {
		return quadros;
	}

	public void setQuadros(List<Quadro> quadros) {
		this.quadros = quadros;
	}
}
