package com.example.teste.testezim.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoRequest {
    private String nome;
    private String materia;
    private String classe;
}
