package br.edu.iff.ccc.bsi.webdev;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
//findTarefasCreatedAfter

    @Test
  public void testSave() {
      Tarefa tarefa = new Tarefa();
      when(tarefaRepository.save(tarefa)).thenReturn(tarefa);

      Tarefa saveTarefa = tarefaService.save(tarefa);

      assertNotNull(saveTarefa);
      assertEquals(tarefa, saveTarefa);
      verify(tarefaRepository, times(1)).save(tarefa); 
  }

 @Test
    public void testFindById() {
        Long id = 1L;
        Tarefa tarefa = new Tarefa();
        when(tarefaRepository.findById(id)).thenReturn(Optional.of(tarefa));

        Optional<Tarefa> result = tarefaService.findById(id);


        assertTrue(result.isPresent());
        assertEquals(tarefa, result.get());
        verify(tarefaRepository, times(1)).findById(id);
    }

    @Test
     void testFindAll() {
  
        when(tarefaRepository.findAll()).thenReturn(List.of(new Tarefa()));

        List<Tarefa> tarefa = tarefaService.findAll();

        assertNotNull(tarefa);
        assertEquals(1, tarefa.size());
        verify(tarefaRepository, times(1)).findAll();
    }

    @Test
    public void testDeleteById() {
        Long id = 1L;

        tarefaService.deleteById(id);

        verify(tarefaRepository, times(1)).deleteById(id);
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
    
 @Test
    public void testFindTarefasCreatedAfter() {
        // Arrange
        LocalDate data = LocalDate.of(2023, 9, 1);
        
        // Cria uma lista de tarefas simuladas
        Tarefa tarefa1 = new Tarefa();
        tarefa1.setTitulo("Tarefa 1");
        tarefa1.setDataCriacao(LocalDate.of(2023, 9, 2));
        
        Tarefa tarefa2 = new Tarefa();
        tarefa2.setTitulo("Tarefa 2");
        tarefa2.setDataCriacao(LocalDate.of(2023, 9, 5));

        List<Tarefa> tarefasEsperadas = List.of(tarefa1, tarefa2);

        // Simula o comportamento do repositório
        when(tarefaRepository.findTarefasCreatedAfter(data)).thenReturn(tarefasEsperadas);

        // Act
        List<Tarefa> resultado = tarefaService.findTarefasCreatedAfter(data);

        // Assert
        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals("Tarefa 1", resultado.get(0).getTitulo());
        assertEquals("Tarefa 2", resultado.get(1).getTitulo());
        verify(tarefaRepository, times(1)).findTarefasCreatedAfter(data);
    }
  }
