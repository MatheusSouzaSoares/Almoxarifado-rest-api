package com.matheus.Almoxarifado.Model;

import javax.persistence.*;

@Entity(name = "Funcionario")
public class FuncionarioModel {
    @Id
    @Column (nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column (nullable = false, length = 50)
    private String nome;
    @Column (nullable = false, length = 50)
    private String cargo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
