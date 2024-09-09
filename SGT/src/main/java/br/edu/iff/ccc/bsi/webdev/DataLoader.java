package br.edu.iff.ccc.bsi.webdev;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import br.edu.iff.ccc.bsi.webdev.entities.*;
import br.edu.iff.ccc.bsi.webdev.repository.*;

@Component
public class DataLoader {

	/*
    @Bean
    CommandLineRunner loadData(UsuarioRepository usuarioRepo, QuadroRepository quadroRepo, 
                                ColunaRepository colunaRepo, TarefaRepository tarefaRepo, 
                                AnexoRepository anexoRepo) {
        return args -> {
            // Limpar todos os dados das tabelas antes de carregar novos dados
            anexoRepo.deleteAll();
            tarefaRepo.deleteAll();
            colunaRepo.deleteAll();
            quadroRepo.deleteAll();
            usuarioRepo.deleteAll();

            // Criando usuários
            Usuario user1 = new Usuario();
            user1.setUsername("lucas123");
            user1.setEmail("lucas@gmail.com");
            user1.setSenha("senha123");

            Usuario user2 = new Usuario();
            user2.setUsername("gabriel123");
            user2.setEmail("gabriel@gmail.com");
            user2.setSenha("senha456");

            usuarioRepo.saveAll(Arrays.asList(user1, user2));

            // Criando quadros
            Quadro quadro1 = new Quadro();
            quadro1.setNome("Quadro de Desenvolvimento");
            quadro1.setDescricao("Quadro para organizar tarefas do time de desenvolvimento.");
            quadro1.setUsuario(user1);
            quadro1.setStatus("A");
            quadro1.setDataCriacao(LocalDateTime.now());

            Quadro quadro2 = new Quadro();
            quadro2.setNome("Quadro de Marketing");
            quadro2.setDescricao("Organização das campanhas de marketing.");
            quadro2.setUsuario(user2);
            quadro2.setStatus("A");
            quadro2.setDataCriacao(LocalDateTime.now());
            
            quadroRepo.saveAll(Arrays.asList(quadro1, quadro2));

            // Criando colunas
            Coluna colunaToDo = new Coluna();
            colunaToDo.setNome("To Do");
            colunaToDo.setOrdem(1);
            colunaToDo.setQuadro(quadro1);

            Coluna colunaInProgress = new Coluna();
            colunaInProgress.setNome("In Progress");
            colunaInProgress.setOrdem(2);
            colunaInProgress.setQuadro(quadro1);

            Coluna colunaDone = new Coluna();
            colunaDone.setNome("Done");
            colunaDone.setOrdem(3);
            colunaDone.setQuadro(quadro1);

            Coluna colunaMarketingToDo = new Coluna();
            colunaMarketingToDo.setNome("To Do Marketing");
            colunaMarketingToDo.setOrdem(1);
            colunaMarketingToDo.setQuadro(quadro2);

            colunaRepo.saveAll(Arrays.asList(colunaToDo, colunaInProgress, colunaDone, colunaMarketingToDo));

            // Criando tarefas
            Tarefa tarefa1 = new Tarefa();
            tarefa1.setTitulo("Implementar Autenticação");
            tarefa1.setDescricao("Desenvolver a funcionalidade de login e registro.");
            tarefa1.setDataCriacao(LocalDateTime.now());
            tarefa1.setStatus("To Do");
            tarefa1.setResponsavel(user1);
            tarefa1.setPrioridade("alta");
            tarefa1.setColuna(colunaToDo);

            Tarefa tarefa2 = new Tarefa();
            tarefa2.setTitulo("Criar Campanha de E-mail");
            tarefa2.setDescricao("Desenvolver material para campanha de e-mail marketing.");
            tarefa2.setDataCriacao(LocalDateTime.now());
            tarefa2.setStatus("In Progress");
            tarefa2.setResponsavel(user2);
            tarefa2.setPrioridade("alta");
            tarefa2.setColuna(colunaMarketingToDo);

            tarefaRepo.saveAll(Arrays.asList(tarefa1, tarefa2));

            // Criando anexos
            Anexo anexo1 = new Anexo();
            anexo1.setNome("Especificação Técnica");
            anexo1.setUrl("https://docs.google.com/specs.pdf");
            anexo1.setTarefa(tarefa1);

            Anexo anexo2 = new Anexo();
            anexo2.setNome("Template de E-mail");
            anexo2.setUrl("https://drive.google.com/template-email.pdf");
            anexo2.setTarefa(tarefa2);

            anexoRepo.saveAll(Arrays.asList(anexo1, anexo2));

            System.out.println("Dados iniciais carregados com sucesso!");
        };
    }
*/
}
