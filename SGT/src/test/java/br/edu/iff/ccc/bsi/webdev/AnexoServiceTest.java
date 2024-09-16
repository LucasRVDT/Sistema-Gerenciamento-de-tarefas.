package br.edu.iff.ccc.bsi.webdev;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.edu.iff.ccc.bsi.webdev.entities.Anexo;

import br.edu.iff.ccc.bsi.webdev.repository.AnexoRepository;
import br.edu.iff.ccc.bsi.webdev.repository.TarefaRepository;

import br.edu.iff.ccc.bsi.webdev.service.AnexoService;
import br.edu.iff.ccc.bsi.webdev.service.TarefaService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnexoServiceTest {

  @InjectMocks
  private AnexoService anexoService;

  @Mock
  private AnexoRepository anexoRepository;
  
  @Mock
  private TarefaRepository tarefaRepository;

  @Mock
  private TarefaService tarefaService;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }


  @Test
  public void testSave() {
      Anexo anexo = new Anexo();
      when(anexoRepository.save(anexo)).thenReturn(anexo);

      Anexo saveanexo = anexoService.save(anexo);

      assertNotNull(saveanexo);
      assertEquals(anexo, saveanexo);
      verify(anexoRepository, times(1)).save(anexo); 
  }

 @Test
    public void testFindById() {
        Long id = 1L;
        Anexo anexo = new Anexo();
        when(anexoRepository.findById(id)).thenReturn(Optional.of(anexo));

        Optional<Anexo> result = anexoService.findById(id);

        assertTrue(result.isPresent());
        assertEquals(anexo, result.get());
        verify(anexoRepository, times(1)).findById(id);
    }

    @Test
     void testFindAll() {
  
        when(anexoRepository.findAll()).thenReturn(List.of(new Anexo()));

        List<Anexo> anexo = anexoService.findAll();

        assertNotNull(anexo);
        assertEquals(1, anexo.size());
        verify(anexoRepository, times(1)).findAll();
    }

    @Test
    public void testDeleteById() {
        Long id = 1L;

        anexoService.deleteById(id);

        verify(anexoRepository, times(1)).deleteById(id);
    }

    @Test
    public void testFindByTarefa() {

       when(anexoRepository.findByTarefa(anyLong())).thenReturn(List.of(new Anexo()));

        List<Anexo> anexo = anexoService.findByTarefa(56L);

        assertNotNull(anexo);
        assertEquals(1, anexo.size());
        verify(anexoRepository, times(1)).findByTarefa(56L);
    }
}
