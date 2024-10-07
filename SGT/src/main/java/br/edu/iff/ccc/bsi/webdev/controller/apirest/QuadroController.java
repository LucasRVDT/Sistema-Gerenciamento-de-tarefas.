package br.edu.iff.ccc.bsi.webdev.controller.apirest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.ccc.bsi.webdev.entities.Quadro;
import br.edu.iff.ccc.bsi.webdev.mapper.QuadroMapper;
import br.edu.iff.ccc.bsi.webdev.RepresentationModels.QuadroModel;
import br.edu.iff.ccc.bsi.webdev.service.QuadroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/v01/quadro")
public class QuadroController {

    @Autowired
    private QuadroService quadroService;

    @Operation(summary = "Lista todos os quadros")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de quadros encontrada", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Quadro.class))
        }),
        @ApiResponse(responseCode = "404", description = "Quadros não encontrados", content = @Content)
    })
    @GetMapping("/list")
    public List<QuadroModel> getListQuadros() {
        List<Quadro> quadros = quadroService.findAll();
        return quadros.stream()
            .map(QuadroMapper::toModel)
            .collect(Collectors.toList());
    }

    @Operation(summary = "Seleciona um quadro por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Quadro encontrado", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Quadro.class))
        }),
        @ApiResponse(responseCode = "404", description = "Quadro não encontrado", content = @Content)
    })
    @GetMapping("/id/{id}")
    public QuadroModel getQuadroById(@Parameter(description = "ID do quadro para busca unitária")
                                             @PathVariable Long id) {
        Quadro quadro = quadroService.findById(id).orElseThrow(() -> new RuntimeException("Quadro não encontrado"));
        
        // Usando o mapper para converter o Quadro em QuadroModel
        return QuadroMapper.toModel(quadro);
    }

    @Operation(summary = "Cria ou atualiza um quadro")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Quadro salvo com sucesso", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Quadro.class))
        }),
        @ApiResponse(responseCode = "400", description = "Requisição inválida", content = @Content)
    })
    @PostMapping("/save")
    public QuadroModel saveQuadro(@RequestBody Quadro quadro) {
        Quadro savedQuadro = quadroService.save(quadro);
        // Retorna o QuadroModel utilizando o mapper
        return QuadroMapper.toModel(savedQuadro);
    }

    @Operation(summary = "Deleta um quadro por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Quadro deletado com sucesso", content = @Content),
        @ApiResponse(responseCode = "404", description = "Quadro não encontrado", content = @Content)
    })
    @DeleteMapping("/delete/{id}")
    public void deleteQuadro(@PathVariable Long id) {
        quadroService.deleteById(id);
    }

    @Operation(summary = "Seleciona quadros por nome")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Quadros encontrados", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Quadro.class))
        }),
        @ApiResponse(responseCode = "404", description = "Quadros não encontrados", content = @Content)
    })
    @GetMapping("/nome/{nome}")
    public List<QuadroModel> getQuadrosByNome(@PathVariable String nome) {
        List<Quadro> quadros = quadroService.findByNomeContaining(nome);
        // Usando o mapper para converter a lista de Quadros para QuadroModels
        return quadros.stream()
            .map(QuadroMapper::toModel)
            .collect(Collectors.toList());
    }

    @Operation(summary = "Seleciona quadros por ID de usuário")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Quadros encontrados", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Quadro.class))
        }),
        @ApiResponse(responseCode = "404", description = "Quadros não encontrados", content = @Content)
    })
    @GetMapping("/usuario/{usuarioId}")
    public List<QuadroModel> getQuadrosByUsuarioId(@PathVariable Long usuarioId) {
        List<Quadro> quadros = quadroService.findByUsuarioId(usuarioId);
        // Usando o mapper para converter a lista de Quadros para QuadroModels
        return quadros.stream()
            .map(QuadroMapper::toModel)
            .collect(Collectors.toList());
    }
}
