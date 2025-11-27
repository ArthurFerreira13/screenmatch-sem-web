package br.com.alura.screenmatch.service;

public interface IConverterDados {

  <T> T obterDadosJson(String json, Class<T> classe);
}
