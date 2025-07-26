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
        } catch (UserNotSavedException e) {
            System.out.println(e.getMessage());
        }
    }

    // GET
    public List<Usuario> listarTodosUsuarios (){
        List<Usuario> listarUsuarios = Collections.emptyList();
        try {
            listarUsuarios = service.buscarTodos();
        } catch (NoUsersFoundException e){
            System.out.println(e.getMessage());
        }
        return listarUsuarios;
    }

    // GET - ID
    public Usuario listarUsuarioPorId (Long id){
        Usuario usuario = new Usuario();
        try {
            usuario = service.buscarPorId(id);
        } catch (UserNotFoundException e){
            System.out.println(e.getMessage());
        }
        return usuario;
    }

    // PUT - ID
    public void atualizarUsuarioPorId (Long id, Usuario usuario){
        try {
            service.atualizarPorId(id, usuario);
        } catch (UserNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    // DELETE - ID
    public void deletarUsuarioPorId (Long id) {
        try {
            service.deletarPorId(id);
        } catch (UserNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

}
