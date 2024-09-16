package br.edu.iff.ccc.bsi.webdev;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.edu.iff.ccc.bsi.webdev.entities.Usuario;
import br.edu.iff.ccc.bsi.webdev.repository.UsuarioRepository;
import br.edu.iff.ccc.bsi.webdev.service.UsuarioService;

import static org.assertj.core.api.Assertions.assertThat;

public class UsuarioServiceTest {

    @InjectMocks
    private UsuarioService usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
  public void testSave() {
      Usuario usuario = new Usuario();
      when(usuarioRepository.save(usuario)).thenReturn(usuario);

      Usuario saveUsuario = usuarioService.save(usuario);

      assertNotNull(saveUsuario);
      assertEquals(usuario, saveUsuario);
      verify(usuarioRepository, times(1)).save(usuario); 
  }

 @Test
    public void testFindById() {
        Long id = 1L;
        Usuario usuario = new Usuario();
        when(usuarioRepository.findById(id)).thenReturn(Optional.of(usuario));

        Optional<Usuario> result = usuarioService.findById(id);


        assertTrue(result.isPresent());
        assertEquals(usuario, result.get());
        verify(usuarioRepository, times(1)).findById(id);
    }
    // Teste para findByUsername
    @Test
    public void testFindByUsername() {
        Usuario usuario = new Usuario();
        usuario.setUsername("user123");
        when(usuarioRepository.findByUsername("user123")).thenReturn(Optional.of(usuario));

        Optional<Usuario> usuarioUsername = usuarioService.findByUsername("user123");

        assertTrue(usuarioUsername.isPresent());
        assertEquals("user123", usuarioUsername.get().getUsername());
        verify(usuarioRepository, times(1)).findByUsername("user123");
        assertThat(usuarioUsername).contains(usuario);
    }

    // Teste para findByEmail
    @Test
    public void testFindByEmail() {
        Usuario usuario = new Usuario();
        usuario.setEmail("user@example.com");
        when(usuarioRepository.findByEmail("user@example.com")).thenReturn(Optional.of(usuario));

        Optional<Usuario> usuarioEmail = usuarioService.findByEmail("user@example.com");

        assertTrue(usuarioEmail.isPresent());
        assertEquals("user@example.com", usuarioEmail.get().getEmail());
        verify(usuarioRepository, times(1)).findByEmail("user@example.com");
        assertThat(usuarioEmail).contains(usuario);
    }

    @Test
     void testFindAll() {
        // Arrange
  
        when(usuarioRepository.findAll()).thenReturn(List.of(new Usuario()));

        // Act
        List<Usuario> usuario = usuarioService.findAll();

        // Assert
        assertNotNull(usuario);
        assertEquals(1, usuario.size());
        verify(usuarioRepository, times(1)).findAll();
    }

    @Test
    public void testDeleteById() {
        // Arrange
        Long id = 1L;

        // Act
        usuarioService.deleteById(id);

        // Assert
        verify(usuarioRepository, times(1)).deleteById(id);
    }
}

