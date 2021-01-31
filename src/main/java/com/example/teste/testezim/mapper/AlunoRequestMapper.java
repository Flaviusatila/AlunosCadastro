package com.example.teste.testezim.mapper;

import com.example.teste.testezim.dto.request.AlunoRequest;
import com.example.teste.testezim.models.Aluno;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlunoRequestMapper {
    AlunoRequest toDto(Aluno aluno);
    Aluno toModel(AlunoRequest alunoRequest);
}
