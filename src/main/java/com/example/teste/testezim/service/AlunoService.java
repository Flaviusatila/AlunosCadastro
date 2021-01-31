package com.example.teste.testezim.service;

import com.example.teste.testezim.dto.request.AlunoRequest;
import com.example.teste.testezim.dto.response.AlunoResponse;
import com.example.teste.testezim.mapper.AlunoRequestMapper;
import com.example.teste.testezim.mapper.AlunoResponseMapper;
import com.example.teste.testezim.models.Aluno;
import com.example.teste.testezim.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
public class AlunoService {

    @Autowired
    private AlunoResponseMapper mapperResponse;
    @Autowired
    private AlunoRequestMapper  mapperRequest;
    @Autowired
    private AlunoRepository repository;

    public AlunoResponse salvar(AlunoRequest alunoRequest){
        Aluno aluno = mapperRequest.toModel(alunoRequest);
        repository.save(aluno);
        return mapperResponse.toDto(aluno);
    }

    public List<AlunoResponse> listar(){
        List<Aluno> alunos = repository.findAll();

        return alunos
                .stream()
                .map(aluno -> {
                    return mapperResponse.toDto(aluno);
                }).collect(Collectors.toList());
    }

    public AlunoResponse procuraId(Long id) throws Exception {
        Aluno aluno = repository.findById(id).
                orElseThrow(() ->
                    new Exception("Nao Aluno não encontrado")
                );
        return mapperResponse.toDto(aluno);
    }

    public void deletaAluno(Long id) throws Exception {
        Aluno aluno = repository.findById(id).
                        orElseThrow(() ->
                                new Exception("Nao Aluno não encontrado")
                        );
        repository.delete(aluno);
    }

    public AlunoResponse atulizaAluno(AlunoRequest alunoRequest){
        Aluno aluno = repository.findByName(alunoRequest.getNome());

        aluno.setNome(alunoRequest.getNome());
        aluno.setMateria(alunoRequest.getMateria());
        aluno.setClasse(alunoRequest.getClasse());
        return mapperResponse.toDto(repository.save(aluno));
    }

    public AlunoResponse inserirMateriaAluno(Long id,String materia) throws Exception {
        Aluno aluno = repository.findById(id).
                        orElseThrow(() ->
                                new Exception("Nao Aluno não encontrado")
                        );
        aluno.setMateria(materia);
        return mapperResponse.toDto(repository.save(aluno));
    }

    public AlunoResponse removerMateriaAluno(Long id) throws Exception {
        Aluno aluno = repository.findById(id).
                orElseThrow(() ->
                        new Exception("Nao Aluno não encontrado")
                );
        aluno.setMateria(null);
        return mapperResponse.toDto(repository.save(aluno));
    }
}
