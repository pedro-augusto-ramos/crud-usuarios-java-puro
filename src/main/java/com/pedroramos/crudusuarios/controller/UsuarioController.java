package com.pedroramos.crudusuarios.controller;

import com.pedroramos.crudusuarios.entity.Usuario;
import com.pedroramos.crudusuarios.exceptions.NoUsersFoundException;
import com.pedroramos.crudusuarios.exceptions.UserNotFoundException;
import com.pedroramos.crudusuarios.exceptions.UserNotSavedException;
import com.pedroramos.crudusuarios.service.UsuarioService;

import java.util.Collections;
import java.util.List;

public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    // POST
    public void criarUsuario (Usuario usuario){
        try {
            service.salvarUsuario(usuario);
            System.out.println("201 - Created");
        } catch (UserNotSavedException e) {
            System.out.println(e.getMessage());
            System.out.println("400 - Bad Request");
        }
    }

    // GET
    public List<Usuario> listarTodosUsuarios (){
        List<Usuario> listarUsuarios = Collections.emptyList();
        try {
            listarUsuarios = service.buscarTodos();
            System.out.println("200 - OK");
        } catch (NoUsersFoundException e){
            System.out.println(e.getMessage());
            System.out.println("404 - Not Found");
        }
        return listarUsuarios;
    }

    // GET - ID
    public Usuario listarUsuarioPorId (Long id){
        Usuario usuario = new Usuario();
        try {
            usuario = service.buscarPorId(id);
            System.out.println("200 - OK");
        } catch (UserNotFoundException e){
            System.out.println(e.getMessage());
            System.out.println("404 - Not Found");
        }
        return usuario;
    }

    // PUT - ID
    public void atualizarUsuarioPorId (Long id, Usuario usuario){
        try {
            service.atualizarPorId(id, usuario);
            System.out.println("204 - No Content");
        } catch (UserNotFoundException e){
            System.out.println(e.getMessage());
            System.out.println("404 - Not Found");
        }
    }

    // DELETE - ID
    public void deletarUsuarioPorId (Long id) {
        try {
            service.deletarPorId(id);
            System.out.println("200 - OK");
        } catch (UserNotFoundException e){
            System.out.println("404 - Not Found");
        }
    }

}
