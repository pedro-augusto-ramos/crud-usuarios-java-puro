package com.pedroramos.crudusuarios.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.pedroramos.crudusuarios.controller.UsuarioController;
import com.pedroramos.crudusuarios.entity.Usuario;
import com.pedroramos.crudusuarios.repository.UsuarioRepository;
import com.pedroramos.crudusuarios.service.UsuarioService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        UsuarioRepository repository = new UsuarioRepository();
        UsuarioService service = new UsuarioService(repository);
        UsuarioController controller = new UsuarioController(service);
        Scanner sc = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        int opcao;

        do {
            // Escolha de opção de operação CRUD -(criar, ler, atualizar, deletar)
            System.out.println("0 - Sair ");
            System.out.println("1 - Cadastro de Usuario ");
            System.out.println("2 - Buscar todos os Usuarios");
            System.out.println("3 - Buscar Usuario Por Id");
            System.out.println("4 - Atualizar Usuario por Id");
            System.out.println("5 - Remover o Usuario pelo Id");
            System.out.print("Escolha a opção: ");
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao){
                case 1:
                    System.out.println("Create - POST");
                    String postUser = reader.readLine();
                    Usuario novoUsuario = mapper.readValue(postUser, Usuario.class);
                    controller.criarUsuario(novoUsuario);
                    break;
                case 2:
                    System.out.println("READ - GET");
                    List<Usuario> usuarios = controller.listarTodosUsuarios();
                    System.out.println(mapper.writeValueAsString(usuarios));
                    break;
                case 3:
                    System.out.println("READ - GET - ID");
                    Long idGet = sc.nextLong();
                    Usuario usuarioAchado = controller.listarUsuarioPorId(idGet);
                    System.out.println(mapper.writeValueAsString(usuarioAchado));
                    break;
                case 4:
                    System.out.println("UPDATE - PUT - ID");
                    Long idPut = sc.nextLong();
                    String putUser = reader.readLine();
                    Usuario usuarioAtualizado = mapper.readValue(putUser, Usuario.class);
                    controller.atualizarUsuarioPorId(idPut, usuarioAtualizado);
                    break;
                case 5:
                    System.out.println("DELETE - DELETE - ID");
                    Long idDelete = sc.nextLong();
                    controller.deletarUsuarioPorId(idDelete);
                    break;
            }
        } while (opcao != 0);

        sc.close();
        reader.close();
    }
}