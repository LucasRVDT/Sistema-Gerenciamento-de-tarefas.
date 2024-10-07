package br.edu.iff.ccc.bsi.webdev.controller.apirest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
import br.edu.iff.ccc.bsi.webdev.mapper.UsuarioMapper;
import br.edu.iff.ccc.bsi.webdev.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import br.edu.iff.ccc.bsi.webdev.RepresentationModels.UsuarioModel;

@RestController
@RequestMapping("/v01/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Operation(summary = "Seleciona todos os usuários")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Usuários encontrados", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = UsuarioModel.class))
        }),
        @ApiResponse(responseCode = "400", description = "Requisição inválida", content = @Content),
        @ApiResponse(responseCode = "404", description = "Usuários não encontrados", content = @Content)
    })
    @GetMapping("/list")
    public List<UsuarioModel> getListUsuario() {
        return usuarioService.findAll().stream()
                .map(UsuarioMapper::toModel)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Seleciona usuário por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Usuário encontrado", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = UsuarioModel.class))
        }),
        @ApiResponse(responseCode = "400", description = "Requisição inválida", content = @Content),
        @ApiResponse(responseCode = "404", description = "Usuário não encontrado", content = @Content)
    })
    @GetMapping("/id/{id}")
    public UsuarioModel findById(@Parameter(description = "ID do usuário para busca unitária") 
                                  @PathVariable long id) {
        Usuario usuario = usuarioService.findById(id).orElseThrow(() -> new TarefaNotFoundException());
        return UsuarioMapper.toModel(usuario);
    }

    @Operation(summary = "Salva o usuário")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Usuário salvo", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = UsuarioModel.class))
        }),
        @ApiResponse(responseCode = "400", description = "Requisição inválida", content = @Content)
    })
    @PostMapping("/save")
    public UsuarioModel saveUsuario(@RequestBody Usuario usuario) {
        Usuario savedUsuario = usuarioService.save(usuario);
        return UsuarioMapper.toModel(savedUsuario);
    }

    @Operation(summary = "Deleta um usuário")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Usuário deletado", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = UsuarioModel.class))
        }),
        @ApiResponse(responseCode = "400", description = "Requisição inválida", content = @Content)
    })
    @DeleteMapping("/delete/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteById(id);
    }

    @Operation(summary = "Seleciona usuário por username")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Usuário encontrado", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = UsuarioModel.class))
        }),
        @ApiResponse(responseCode = "400", description = "Requisição inválida", content = @Content),
        @ApiResponse(responseCode = "404", description = "Usuário não encontrado", content = @Content)
    })
    @GetMapping("/username/{username}")
    public UsuarioModel getUsuarioByUsername(@PathVariable String username) {
        Usuario usuario = usuarioService.findByUsername(username)
                .orElseThrow(() -> new TarefaNotFoundException("Usuário não encontrado pelo username: " + username));
        return UsuarioMapper.toModel(usuario);
    }

    @Operation(summary = "Seleciona usuário por email")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Usuário encontrado", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = UsuarioModel.class))
        }),
        @ApiResponse(responseCode = "400", description = "Requisição inválida", content = @Content),
        @ApiResponse(responseCode = "404", description = "Usuário não encontrado", content = @Content)
    })
    @GetMapping("/email/{email}")
    public Optional<UsuarioModel> getUsuarioByEmail(@PathVariable String email) {
        Optional<Usuario> usuario = usuarioService.findByEmail(email);
        return usuario.map(UsuarioMapper::toModel);
    }
}
