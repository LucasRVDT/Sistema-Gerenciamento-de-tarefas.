package br.edu.iff.ccc.bsi.webdev;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.edu.iff.ccc.bsi.webdev.entities.Quadro;

import br.edu.iff.ccc.bsi.webdev.repository.QuadroRepository;
import br.edu.iff.ccc.bsi.webdev.repository.UsuarioRepository;

import br.edu.iff.ccc.bsi.webdev.service.QuadroService;
import br.edu.iff.ccc.bsi.webdev.service.UsuarioService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuadroServiceTest {

  @InjectMocks
  private QuadroService quadroService;

  @Mock
  private QuadroRepository quadroRepository;
  
  @Mock
  private UsuarioRepository usuarioRepository;

  @Mock
  private UsuarioService usuarioService;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void findByNomeContaining() {
    Quadro quadro = new Quadro();
    quadro.setNome("Quadro de Teste");

    when(quadroRepository.findByNomeContaining("Quadro de Teste")).thenReturn(List.of(quadro));

    List<Quadro> quadroNome = quadroService.findByNomeContaining("Quadro de Teste");

    assertThat(quadroNome).isNotNull();
    assertThat(quadroNome).contains(quadro);

  }
  @Test
  public void testSave() {
      Quadro quadro = new Quadro();
      when(quadroRepository.save(quadro)).thenReturn(quadro);

      Quadro savedQuadro = quadroService.save(quadro);

      assertNotNull(savedQuadro);
      assertEquals(quadro, savedQuadro);
      verify(quadroRepository, times(1)).save(quadro); 
  }

 @Test
    public void testFindById() {
        Long id = 1L;
        Quadro quadro = new Quadro();
        when(quadroRepository.findById(id)).thenReturn(Optional.of(quadro));

        Optional<Quadro> result = quadroService.findById(id);


        assertTrue(result.isPresent());
        assertEquals(quadro, result.get());
        verify(quadroRepository, times(1)).findById(id);
    }

     @Test
    public void testFindByNomeContaining() {

        String nome = "Projeto";
        List<Quadro> quadros = new ArrayList<>();
        quadros.add(new Quadro());
        when(quadroRepository.findByNomeContaining(nome)).thenReturn(quadros);

        List<Quadro> result = quadroService.findByNomeContaining(nome);


        assertNotNull(result);
        assertEquals(1, result.size());
        verify(quadroRepository, times(1)).findByNomeContaining(nome);
    }

    @Test
     void testFindAll() {
  
        when(quadroRepository.findAll()).thenReturn(List.of(new Quadro()));

        List<Quadro> quadro = quadroService.findAll();

        assertNotNull(quadro);
        assertEquals(1, quadro.size());
        verify(quadroRepository, times(1)).findAll();
    }

    @Test
    public void testDeleteById() {
        Long id = 1L;

        quadroService.deleteById(id);

        verify(quadroRepository, times(1)).deleteById(id);
    }

    @Test
    public void testFindByUsuarioId() {

       when(quadroRepository.findByUsuarioId(anyLong())).thenReturn(List.of(new Quadro()));

        List<Quadro> quadro = quadroService.findByUsuarioId(56L);

        assertNotNull(quadro);
        assertEquals(1, quadro.size());
        verify(quadroRepository, times(1)).findByUsuarioId(56L);
    }

}
