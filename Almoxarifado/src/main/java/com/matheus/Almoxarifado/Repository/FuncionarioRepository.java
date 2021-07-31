package com.matheus.Almoxarifado.Repository;

import com.matheus.Almoxarifado.Model.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioModel,Integer> {
    List<FuncionarioModel> findByNomeContaining(String nome);
    List<FuncionarioModel> findByCargoContaining(String cargo);
    }

