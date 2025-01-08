package br.com.wayon.anagram.api.dto.palavra;

/*
 *  Usar records como parâmetros de request em Java pode ser uma prática muito útil,
 *  especialmente nas versões mais recentes do Java.
 *  Os records são projetados para classes que são usadas principalmente para
 *  transportar dados, tornando-as perfeitas para objetos de request
 */

public record PalavraRequest(String descricao) {
}
