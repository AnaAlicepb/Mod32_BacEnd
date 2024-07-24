package br.com.ana.dao;

import br.com.ana.domain.Produto;

public interface IProdutoDao {
    Produto cadastrar(Produto produto);
    Produto buscar(Long id);
    Produto alterar(Produto produto);
    void excluir(Long id);
    void limparBanco();
}
