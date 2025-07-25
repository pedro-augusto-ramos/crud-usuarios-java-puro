package com.pedroramos.crudusuarios.service;

import com.pedroramos.crudusuarios.entity.Usuario;
import com.pedroramos.crudusuarios.exceptions.NoUsersFoundException;
import com.pedroramos.crudusuarios.exceptions.UserNotFoundException;
import com.pedroramos.crudusuarios.exceptions.UserNotSavedException;
import com.pedroramos.crudusuarios.repository.UsuarioRepository;

import java.util.List;

public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void salvarUsuario (Usuario usuario){
        if(usuario.getIdade() != null || usuario.getEmail() != null || usuario.getNome() != null ){
            repository.save(usuario);
        } else {
            throw new UserNotSavedException("Não foi possível salvar o usuário, houve um erro em seus atributos.");
        }
    }

    public List<Usuario> buscarTodos (){
        if(repository.findAll().isEmpty()){
            throw new NoUsersFoundException("Nao existe usuarios no repository");
        }
        return repository.findAll();
    }

    public Usuario buscarPorId (Long id){
        if(!repository.existsById(id)){
            throw new UserNotFoundException("Usuario com id" + id + "não foi encontrado");
        }
        return repository.findById(id);
    }

    public void atualizarPorId (Long id, Usuario usuario){
        if(repository.existsById(id)){
            Usuario usuarioAntigo = repository.findById(id);
            usuarioAntigo.setNome(usuario.getNome());
            usuarioAntigo.setEmail(usuario.getEmail());
            usuarioAntigo.setIdade(usuario.getIdade());
            repository.save(usuarioAntigo);
        } else {
            throw new UserNotFoundException("Usuario com id" + id + "não foi encontrado");
        }
    }

    public void deletarPorId (Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        } else {
            throw new UserNotFoundException("Usuario com id" + id + "não foi encontrado");
        }
    }

}
