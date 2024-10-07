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

import br.edu.iff.ccc.bsi.webdev.RepresentationModels.TarefaModel;
import br.edu.iff.ccc.bsi.webdev.entities.Tarefa;
import br.edu.iff.ccc.bsi.webdev.exceptions.TarefaNotFoundException;
import br.edu.iff.ccc.bsi.webdev.mapper.TarefaMapper;
import br.edu.iff.ccc.bsi.webdev.service.TarefaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/v01/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @Operation(summary = "Seleciona todas as tarefas")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Tarefas encontradas", content = { 
            @Content(mediaType = "application/json", schema = @Schema(implementation = Tarefa.class))
        }),
        @ApiResponse(responseCode = "400", description = "Requisição inválida", content = @Content), 
        @ApiResponse(responseCode = "404", description = "Tarefas não encontradas", content = @Content) 
    })
    @GetMapping("/list")
    public List<TarefaModel> getListTarefas() {
        return tarefaService.findAll().stream()
            .map(TarefaMapper::toModel)
            .collect(Collectors.toList());
    }

    @Operation(summary = "Seleciona tarefa por ID")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Tarefa encontrada", content = { 
            @Content(mediaType = "application/json", schema = @Schema(implementation = Tarefa.class))
        }),
        @ApiResponse(responseCode = "400", description = "Requisição inválida", content = @Content), 
        @ApiResponse(responseCode = "404", description = "Tarefa não encontrada", content = @Content) 
    })
    @GetMapping("/id/{id}")
    public TarefaModel findById(@Parameter(description = "ID da tarefa para busca unitária") 
      @PathVariable long id) {
        Tarefa tarefa = tarefaService.findById(id).orElseThrow(() -> new TarefaNotFoundException());
        return TarefaMapper.toModel(tarefa);
    }

    @Operation(summary = "Salva a tarefa")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Tarefa salva", content = { 
            @Content(mediaType = "application/json", schema = @Schema(implementation = Tarefa.class))
        }),
        @ApiResponse(responseCode = "400", description = "Requisição inválida", content = @Content) 
    })
    @PostMapping("/save")
    public TarefaModel saveTarefa(@RequestBody Tarefa tarefa) {
        Tarefa savedTarefa = tarefaService.save(tarefa);
        return TarefaMapper.toModel(savedTarefa);
    }

    @Operation(summary = "Deleta uma tarefa")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Tarefa deletada", content = { 
            @Content(mediaType = "application/json", schema = @Schema(implementation = Tarefa.class))
        }),
        @ApiResponse(responseCode = "400", description = "Requisição inválida", content = @Content) 
    })
    @DeleteMapping("/delete/{id}")
    public void deleteTarefa(@PathVariable Long id) {
        tarefaService.deleteById(id);
    }
}
