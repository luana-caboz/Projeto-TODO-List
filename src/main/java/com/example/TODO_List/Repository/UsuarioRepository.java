package com.example.TODO_List.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TODO_List.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
