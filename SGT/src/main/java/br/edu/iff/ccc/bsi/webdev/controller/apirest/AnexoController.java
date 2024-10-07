package br.edu.iff.ccc.bsi.webdev.controller.apirest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.ccc.bsi.webdev.RepresentationModels.AnexoModel;
import br.edu.iff.ccc.bsi.webdev.entities.Anexo;
import br.edu.iff.ccc.bsi.webdev.mapper.AnexoMapper;
import br.edu.iff.ccc.bsi.webdev.service.AnexoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/v01/anexo")
public class AnexoController {

    @Autowired
    private AnexoService anexoService;

    @Autowired
    private AnexoMapper anexoMapper;

    @Operation(summary = "Lista todos os anexos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de anexos encontrada"),
        @ApiResponse(responseCode = "404", description = "Anexos não encontrados")
    })
    @GetMapping("/list")
    public List<AnexoModel> getListAnexos() {
        List<Anexo> anexos = anexoService.findAll();
        return anexos.stream()
                     .map(anexoMapper::toModel)
                     .toList();
    }

    @Operation(summary = "Seleciona um anexo por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Anexo encontrado"),
        @ApiResponse(responseCode = "404", description = "Anexo não encontrado")
    })
    @GetMapping("/id/{id}")
    public EntityModel<AnexoModel> getColunaById(@PathVariable Long id) {
        Anexo anexo = anexoService.findById(id)
                .orElseThrow(() -> new RuntimeException("Anexo não encontrado"));
        
        AnexoModel anexoModel = anexoMapper.toModel(anexo);
        
        // Adicionando links HATEOAS
        Link linkToAll = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getListAnexos()).withRel("all-anexos");
        anexoModel.add(linkToAll);
        
        return EntityModel.of(anexoModel);
    }

    @Operation(summary = "Cria ou atualiza um anexo")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Anexo salvo com sucesso"),
        @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @PostMapping("/save")
    public AnexoModel saveColuna(@RequestBody Anexo anexo) {
        Anexo savedAnexo = anexoService.save(anexo);
        return anexoMapper.toModel(savedAnexo);
    }

    @Operation(summary = "Deleta um anexo por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Anexo deletado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Anexo não encontrado")
    })
    @DeleteMapping("/delete/{id}")
    public void deleteColuna(@PathVariable Long id) {
        anexoService.deleteById(id);
    }
}
