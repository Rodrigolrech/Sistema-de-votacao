package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class GerenciamentoVotacao {
  private ArrayList<PessoaCandidata> pessoasCandidatas;
  private ArrayList<PessoaEleitora> pessoasEleitoras;
  private ArrayList<String> cpfComputado;
  int totalVotos;

  /**
   * Metodo para Gerenciar as Votacoes.
   */
  public GerenciamentoVotacao() {

    pessoasEleitoras = new ArrayList<>();
    pessoasCandidatas = new ArrayList<>();
    cpfComputado = new ArrayList<>();
    totalVotos = 0;
  }

  /**
   * Metodo para Cadastrar Pessoa Candidata.
   */
  public void cadastrarPessoaCandidata(String nome, int numero) {
    boolean exist = false;
    for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
      if (pessoaCandidata.getNumero() == numero) {
        exist = true;
      }
    }
    if (exist) {
      System.out.println("Número pessoa candidata já utilizado!");
    } else {
      PessoaCandidata pc = new PessoaCandidata(nome, numero);
      pessoasCandidatas.add(pc);
    }
  }

  /**
   * Metodo para Cadastrar Pessoa Eleitora.
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    boolean exist = false;
    for (PessoaEleitora pessoaEleitora : pessoasEleitoras) {
      if (Objects.equals(pessoaEleitora.getCpf(), cpf)) {
        exist = true;
        break;
      }
    }
    if (exist) {
      System.out.println("Pessoa eleitora já cadastrada!");
    } else {
      PessoaEleitora pe = new PessoaEleitora(nome, cpf);
      pessoasEleitoras.add(pe);
    }
  }

  /**
   * Metodo para Computar Votos.
   */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    boolean exist = false;
    for (String cpf : cpfComputado) {
      if (Objects.equals(cpfPessoaEleitora, cpf)) {
        exist = true;
        break;
      }
    }
    if (exist) {
      System.out.println("Pessoa eleitora já votou!");
    } else {
      for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
        if (pessoaCandidata.getNumero() == numeroPessoaCandidata) {
          pessoaCandidata.receberVoto();
          cpfComputado.add(cpfPessoaEleitora);
          totalVotos++;
        }
      }
    }
  }

  /**
   * Metodo para Mostrar Resultados.
   */
  public void mostrarResultado() {
    if (totalVotos == 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado");
    } else {
      for (PessoaCandidata pc : pessoasCandidatas) {
        String stringBuild =
            new StringBuilder()
                .append("Nome: ")
                .append(pc.getNome())
                .append(" - ")
                .append(pc.getVotos())
                .append(" votos ( ")
                .append(String.format("%.1f", calcularPorcentagemVotos(pc)))
                .append("% )")
                .toString();
        System.out.println(stringBuild);
      }
    }
    String stringBuilderTotal =
        new StringBuilder().append("Total de votos: ").append(totalVotos).toString();
    System.out.println(stringBuilderTotal);
  }

  /**
   * Metodo para Calcular Porcentagem dos Votos.
   */
  private double calcularPorcentagemVotos(PessoaCandidata pc) {
    return Math.round(((double) pc.getVotos() / (double) totalVotos) * 100);
  }
}
