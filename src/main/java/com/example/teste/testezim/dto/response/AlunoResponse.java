package com.example.teste.testezim.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoResponse {
    private Long id;
    private String nome;
    private String materia;
    private String classe;
}

