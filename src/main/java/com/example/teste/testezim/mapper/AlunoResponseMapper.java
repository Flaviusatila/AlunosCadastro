package com.example.teste.testezim.mapper;

import com.example.teste.testezim.dto.response.AlunoResponse;
import com.example.teste.testezim.models.Aluno;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlunoResponseMapper {

    AlunoResponse toDto(Aluno aluno);
    Aluno toModel(AlunoResponse alunoRequest);

}
