package br.edu.iff.ccc.bsi.webdev.controller.apirest;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.ccc.bsi.webdev.entities.Usuario;
import br.edu.iff.ccc.bsi.webdev.exceptions.TarefaNotFoundException;
import br.edu.iff.ccc.bsi.webdev.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;


@RestController
@RequestMapping("/v01/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@Operation(summary = "Seleciona todas as usuarios")
	@ApiResponses(value = { 
	@ApiResponse(responseCode = "200", description = "Usuarios encontradas", content = { 
		@Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class))
	}),
	@ApiResponse(responseCode = "400", description = "Requisição inválida", content = @Content), 
	@ApiResponse(responseCode = "404", description = "usuarios não encontradas", content = @Content) })
	@GetMapping("/list")
	public List<Usuario> getListUsuario() {
		return usuarioService.findAll();
	}
	
	@Operation(summary = "Seleciona usuario por ID")
	@ApiResponses(value = { 
	@ApiResponse(responseCode = "200", description = "Usuario encontrada", content = { 
		@Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class))
	}),
	@ApiResponse(responseCode = "400", description = "Requisição inválida", content = @Content), 
	@ApiResponse(responseCode = "404", description = "Usuario não encontrada", content = @Content) })
	@GetMapping("/id/{id}")
	public Usuario findById(@Parameter(description = "ID da usuario para busca unitária") 
	  @PathVariable long id) {
	    return usuarioService.findById(id).orElseThrow(() -> new TarefaNotFoundException());
	}

	@Operation(summary = "Salva a usuario")
	@ApiResponses(value = { 
	@ApiResponse(responseCode = "200", description = "Usuario salva", content = { 
		@Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class))
	}),
	@ApiResponse(responseCode = "400", description = "Requisição inválida", content = @Content) })
	@PostMapping("/save")
	public Object saveUsuario(@RequestBody Usuario usuario) {
		return usuarioService.save(usuario);
	}

	@Operation(summary = "Deleta uma usuario")
	@ApiResponses(value = { 
	@ApiResponse(responseCode = "200", description = "Usuario deletada", content = { 
		@Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class))
	}),
	@ApiResponse(responseCode = "400", description = "Requisição inválida", content = @Content) })
	@DeleteMapping("/delete")
	public void deleteUsuario(@PathVariable Long id) {
		usuarioService.deleteById(id);
	}
    @Operation(summary = "Seleciona usuario por username")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario encontrada", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class))
            }),
            @ApiResponse(responseCode = "400", description = "Requisição inválida", content = @Content),
            @ApiResponse(responseCode = "404", description = "Usuario não encontrada", content = @Content) })

    @GetMapping("/username/{username}")
    public Optional<Usuario> getUsuarioByUsername(@PathVariable String username) {
        return usuarioService.findByUsername(username);
    }

    @Operation(summary = "Seleciona usuario por email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario encontrada", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class))
            }),
            @ApiResponse(responseCode = "400", description = "Requisição inválida", content = @Content),
            @ApiResponse(responseCode = "404", description = "Usuario não encontrada", content = @Content)
    })
    @GetMapping("/email/{email}")
    public Optional<Usuario> getUsuarioByEmail(@PathVariable String email) {
        return usuarioService.findByEmail(email);
    }
}
