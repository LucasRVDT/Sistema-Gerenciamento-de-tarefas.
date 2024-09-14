package br.edu.iff.ccc.bsi.webdev;

import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.edu.iff.ccc.bsi.webdev.entities.Quadro;
import br.edu.iff.ccc.bsi.webdev.repository.QuadroRepository;
import br.edu.iff.ccc.bsi.webdev.service.QuadroService;

import static org.assertj.core.api.Assertions.assertThat;

public class QuadroServiceTest {

  @InjectMocks
  private QuadroService quadroService;

  @Mock
  private QuadroRepository quadroRepository;

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
}
