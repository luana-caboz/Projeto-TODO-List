package com.example.TODO_List.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TODO_List.Model.Categoria;

public interface CategoriaRepository extends JpaRepository <Categoria, Long> {

}