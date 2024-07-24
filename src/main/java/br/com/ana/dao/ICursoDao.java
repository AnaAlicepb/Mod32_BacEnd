/**
 * 
 */
package br.com.ana.dao;

import java.util.List;

import br.com.ana.domain.Curso;


public interface ICursoDao {

	public Curso cadastrar(Curso curso);

	public void excluir(Curso cur);

	public List<Curso> buscarTodos();
}