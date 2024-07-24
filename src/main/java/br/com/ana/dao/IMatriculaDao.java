/**
 * 
 */
package br.com.ana.dao;

import java.util.List;

import br.com.ana.domain.Curso;
import br.com.ana.domain.Matricula;


public interface IMatriculaDao {

	Matricula cadastrar(Matricula mat);
	
	Matricula buscarPorCodigoCurso(String codigoCurso);
	
	Matricula buscarPorCurso(Curso curso);
	
	Matricula buscarPorCodigoCursoCriteria(String codigoCurso);
	
	Matricula buscarPorCursoCriteria(Curso curso);
	
	List<Matricula> buscarTodos();
	
	void excluir(Matricula matricula);
}