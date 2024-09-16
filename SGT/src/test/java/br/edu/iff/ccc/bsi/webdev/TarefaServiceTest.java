package br.edu.iff.ccc.bsi.webdev;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.edu.iff.ccc.bsi.webdev.entities.Tarefa;
import br.edu.iff.ccc.bsi.webdev.repository.TarefaRepository;
import br.edu.iff.ccc.bsi.webdev.service.TarefaService;

class TarefaServiceTest {

    @Mock
    private TarefaRepository tarefaRepository;

    @InjectMocks
    private TarefaService tarefaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindTarefasByStatus() {
        // Arrange
        String status = "Concluída";
        Tarefa tarefa1 = new Tarefa();
        tarefa1.setStatus("Concluída");

        Tarefa tarefa2 = new Tarefa();
        tarefa2.setStatus("Concluída");

        List<Tarefa> tarefasMock = Arrays.asList(tarefa1, tarefa2);

        when(tarefaRepository.findByStatus(status)).thenReturn(tarefasMock);

        // Act
        List<Tarefa> tarefas = tarefaService.findTarefasByStatus(status);

        // Assert
        assertThat(tarefas).isNotNull();
        assertEquals(2, tarefas.size());
        assertEquals("Concluída", tarefas.get(0).getStatus());
        verify(tarefaRepository, times(1)).findByStatus(status);
    }
  }