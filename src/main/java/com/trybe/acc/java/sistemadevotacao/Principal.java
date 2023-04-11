package com.trybe.acc.java.sistemadevotacao;

import java.util.Scanner;

public class Principal {

  /**
   * Metodo Main.
   */
  public static void main(String[] args) {
    System.out.println("----------- Bem-vindo ao Sistema de Votação -----------");
    GerenciamentoVotacao gv = new GerenciamentoVotacao();
    Scanner scanner = new Scanner(System.in);
    boolean cadastrarPessoaCandidata;
    do {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      int cadastrar = scanner.nextInt();
      if (cadastrar == 1) {
        cadastrarPessoaCandidata = true;
        System.out.println("Entre com o nome da pessoa candidata:");
        String nome = scanner.next();
        System.out.println("Entre com o número da pessoa candidata:");
        int numero = scanner.nextInt();
        gv.cadastrarPessoaCandidata(nome, numero);
      } else {
        cadastrarPessoaCandidata = false;
      }
    } while (cadastrarPessoaCandidata);
    System.out.println("");
    System.out.println("----------- Cadastre as pessoas eleitoras -----------");
    boolean cadastrarPessoaEleitora;

    do {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      int cadastrarEleitor = scanner.nextInt();
      if (cadastrarEleitor == 1) {
        cadastrarPessoaEleitora = true;
        System.out.println("Entre com o nome da pessoa eleitora:");
        String nomeEleitor = scanner.next();
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpf = scanner.next();
        gv.cadastrarPessoaEleitora(nomeEleitor, cpf);
      } else {
        cadastrarPessoaEleitora = false;
      }
    } while (cadastrarPessoaEleitora);

    System.out.println("");
    System.out.println("----------- Votação iniciada! -----------");
    boolean continuarVotacao;
    do {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");
      int opcao = scanner.nextInt();
      if (opcao == 1) {
        continuarVotacao = true;
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpf2 = scanner.next();
        System.out.println("Entre com o número da pessoa candidata:");
        int numeroCandidato = scanner.nextInt();
        gv.votar(cpf2, numeroCandidato);
      } else if (opcao == 2) {
        continuarVotacao = true;
        gv.mostrarResultado();
      } else {
        continuarVotacao = false;
        gv.mostrarResultado();
      }
    } while (continuarVotacao);
  }
}
