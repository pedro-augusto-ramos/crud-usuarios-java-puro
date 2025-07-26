package com.pedroramos.crudusuarios.repository;

import com.pedroramos.crudusuarios.entity.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UsuarioRepository {

    private final List<Usuario> usuarios = new ArrayList<>();
    private Long id = 1L;

    public void save (Usuario usuario){
        usuario.setId(id++);
        usuarios.add(usuario);
    }

    public List<Usuario> findAll (){
        return usuarios;
    }

    public Usuario findById (Long id){
        for(Usuario usuario : usuarios){
            if (Objects.equals(usuario.getId(), id)){
                return usuario;
            }
        }
        return null;
    }

    public void deleteById (Long id){
        usuarios.removeIf(usuario -> existsById(id));
    }

    public boolean existsById (Long id){
        for(Usuario usuario : usuarios){
            if(Objects.equals(usuario.getId(), id)){
                return true;
            }
        }
        return false;
    }

}
