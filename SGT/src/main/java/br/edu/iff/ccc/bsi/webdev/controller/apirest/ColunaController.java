package br.edu.iff.ccc.bsi.webdev.controller.apirest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.ccc.bsi.webdev.RepresentationModels.ColunaModel;
import br.edu.iff.ccc.bsi.webdev.entities.Coluna;
import br.edu.iff.ccc.bsi.webdev.mapper.ColunaMapper;
import br.edu.iff.ccc.bsi.webdev.service.ColunaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/v01/coluna")
public class ColunaController {

    @Autowired
    private ColunaService colunaService;

    @Autowired
    private ColunaMapper colunaMapper;

    @Operation(summary = "Lista todas as colunas")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de colunas encontrada", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Coluna.class))
        }),
        @ApiResponse(responseCode = "404", description = "Colunas não encontradas", content = @Content)
    })
    @GetMapping("/list")
    public List<ColunaModel> getListColunas() {
        List<Coluna> colunas = colunaService.findAllColunas();
        return colunas.stream()
                      .map(colunaMapper::toModel)
                      .toList();
    }

    @Operation(summary = "Seleciona uma coluna por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Coluna encontrada", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Coluna.class))
        }),
        @ApiResponse(responseCode = "404", description = "Coluna não encontrada", content = @Content)
    })
    @GetMapping("/id/{id}")
    public ColunaModel getColunaById(@Parameter(description = "ID da coluna para busca unitária")
                                              @PathVariable Long id) {
        Coluna coluna = colunaService.findColunaById(id)
                                      .orElseThrow(() -> new RuntimeException("Coluna não encontrada"));

        ColunaModel resource = colunaMapper.toModel(coluna); 
        WebMvcLinkBuilder linkToAll = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getListColunas());
        resource.add(linkToAll.withRel("all-colunas"));
        return resource;
    }

    @Operation(summary = "Cria ou atualiza uma coluna")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Coluna salva com sucesso", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Coluna.class))
        }),
        @ApiResponse(responseCode = "400", description = "Requisição inválida", content = @Content)
    })
    @PostMapping("/save")
    public ColunaModel saveColuna(@RequestBody Coluna coluna) {
        Coluna savedColuna = colunaService.createColuna(coluna);
        return colunaMapper.toModel(savedColuna);
    }

    @Operation(summary = "Deleta uma coluna por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Coluna deletada com sucesso", content = @Content),
        @ApiResponse(responseCode = "404", description = "Coluna não encontrada", content = @Content)
    })
    @DeleteMapping("/delete/{id}")
    public void deleteColuna(@PathVariable Long id) {
        colunaService.deleteColuna(id);
    }

    @Operation(summary = "Seleciona colunas por nome")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Colunas encontradas", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Coluna.class))
        }),
        @ApiResponse(responseCode = "404", description = "Colunas não encontradas", content = @Content)
    })
    @GetMapping("/nome/{nome}")
    public List<ColunaModel> getColunasByNome(@PathVariable String nome) {
        List<Coluna> colunas = colunaService.findByNome(nome);
        return colunas.stream()
                      .map(colunaMapper::toModel) 
                      .toList();
    }

    @Operation(summary = "Seleciona colunas por ID de quadro")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Colunas encontradas", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Coluna.class))
        }),
        @ApiResponse(responseCode = "404", description = "Colunas não encontradas", content = @Content)
    })
    @GetMapping("/quadro/{quadroId}")
    public List<ColunaModel> getColunasByQuadroId(@PathVariable Long quadroId) {
        List<Coluna> colunas = colunaService.findByQuadroId(quadroId);
        return colunas.stream()
                      .map(colunaMapper::toModel)
                      .toList();
    }
}
