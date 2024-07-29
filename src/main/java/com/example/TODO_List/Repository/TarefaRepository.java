package com.example.TODO_List.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TODO_List.Model.Tarefa;

public interface TarefaRepository extends JpaRepository <Tarefa, Long> {

}
