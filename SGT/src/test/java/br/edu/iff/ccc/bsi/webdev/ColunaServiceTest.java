package br.edu.iff.ccc.bsi.webdev;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.edu.iff.ccc.bsi.webdev.entities.Coluna;

import br.edu.iff.ccc.bsi.webdev.repository.ColunaRepository;
import br.edu.iff.ccc.bsi.webdev.repository.TarefaRepository;
import br.edu.iff.ccc.bsi.webdev.repository.QuadroRepository;

import br.edu.iff.ccc.bsi.webdev.service.ColunaService;
import br.edu.iff.ccc.bsi.webdev.service.TarefaService;
import br.edu.iff.ccc.bsi.webdev.service.QuadroService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ColunaServiceTest {

  @InjectMocks
  private ColunaService colunaService;

  @Mock
  private ColunaRepository colunaRepository;

  @Mock
  private TarefaRepository tarefaRepository;

  @Mock
  private TarefaService tarefaService;

  @Mock
  private QuadroRepository quadroRepository;

  @Mock
  private QuadroService quadroService;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testCreateColuna() {
    Coluna coluna = new Coluna();
    when(colunaRepository.save(coluna)).thenReturn(coluna);

    Coluna saveColuna = colunaService.createColuna(coluna);

    assertNotNull(saveColuna);
    assertEquals(coluna, saveColuna);
    verify(colunaRepository, times(1)).save(coluna);
  }

  @Test
  public void testFindColunaById() {
    Long id = 1L;
    Coluna coluna = new Coluna();
    when(colunaRepository.findById(id)).thenReturn(Optional.of(coluna));

    Optional<Coluna> result = colunaService.findColunaById(id);

    assertTrue(result.isPresent());
    assertEquals(coluna, result.get());
    verify(colunaRepository, times(1)).findById(id);
  }

  @Test
  void testFindAllColunas() {

    when(colunaRepository.findAll()).thenReturn(List.of(new Coluna()));

    List<Coluna> coluna = colunaService.findAllColunas();

    assertNotNull(coluna);
    assertEquals(1, coluna.size());
    verify(colunaRepository, times(1)).findAll();
  }

  @Test
  public void testDeleteColuna() {
    Long id = 1L;

    colunaService.deleteColuna(id);

    verify(colunaRepository, times(1)).deleteById(id);
  }

  @Test
  public void testFindByOrdemInQuadro() {
    // Dados de teste
    Long quadroId = 1L;
    int ordem = 2;
    Coluna coluna1 = new Coluna();
    Coluna coluna2 = new Coluna();
    List<Coluna> colunas = Arrays.asList(coluna1, coluna2);

    // Configura o comportamento do mock
    when(colunaRepository.findByOrdemInQuadro(ordem, quadroId)).thenReturn(colunas);

    // Chama o método a ser testado
    List<Coluna> result = colunaService.findByOrdemInQuadro(ordem, quadroId);

    // Verifica o resultado
    assertNotNull(result);
    assertEquals(2, result.size());
    assertTrue(result.contains(coluna1));
    assertTrue(result.contains(coluna2));

    // Verifica se o método do repositório foi chamado
    verify(colunaRepository).findByOrdemInQuadro(ordem, quadroId);
  }

  @Test
  public void testFindByQuadroId() {

    when(colunaRepository.findByQuadroId(anyLong())).thenReturn(List.of(new Coluna()));

    List<Coluna> coluna = colunaService.findByQuadroId(56L);

    assertNotNull(coluna);
    assertEquals(1, coluna.size());
    verify(colunaRepository, times(1)).findByQuadroId(56L);
  }

  @Test
  public void testFindByNome() {
    Coluna coluna = new Coluna();
    coluna.setNome("Coluna de Teste");

    when(colunaRepository.findByNome("Coluna de Teste")).thenReturn(List.of(coluna));

    List<Coluna> colunaNome = colunaService.findByNome("Coluna de Teste");

    assertThat(colunaNome).isNotNull();
    assertThat(colunaNome).contains(coluna);

  }
}
