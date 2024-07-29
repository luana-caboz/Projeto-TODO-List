package com.example.TODO_List.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TODO_List.Model.Historico;

public interface HistoricoRepository extends JpaRepository <Historico, Long> {

}
