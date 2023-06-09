package com.trybe.acc.java.sistemadevotacao;

public class PessoaEleitora extends Pessoa {

  private String cpf;

  public PessoaEleitora(String nome, String cpf) {
    setNome(nome);
    this.cpf = cpf;
  }

  @Override
  public String getNome() {
    return this.nome;
  }

  @Override
  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
}
