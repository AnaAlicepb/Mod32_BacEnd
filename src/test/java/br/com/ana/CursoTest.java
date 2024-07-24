/**
 * 
 */
package br.com.ana;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.ana.dao.CursoDao;
import br.com.ana.dao.ICursoDao;
import br.com.ana.domain.Curso;


public class CursoTest {

	private ICursoDao cursoDao;
	
	public CursoTest() {
		cursoDao = new CursoDao();
	}

	@Test
	public void cadastrar() {
		Curso curso = new Curso();
		curso.setCodigo("A2");
		curso.setDescricao("CURSO TESTE2");
		curso.setNome("Curso de Java Backend");
		curso = cursoDao.cadastrar(curso);
		
		assertNotNull(curso);
		assertNotNull(curso.getId());
	}
}