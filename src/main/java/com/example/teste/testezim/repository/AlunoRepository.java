package com.example.teste.testezim.repository;

import com.example.teste.testezim.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno,Long> {
    Aluno findByName(String nome);
}
