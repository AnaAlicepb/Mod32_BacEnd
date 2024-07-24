package br.com.ana;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.ana.dao.IProdutoDao;
import br.com.ana.dao.ProdutoDao;
import br.com.ana.domain.Produto;

public class ProdutoTest {
    private IProdutoDao produtoDao;

    public ProdutoTest() {
        produtoDao = new ProdutoDao();
    }

    @Before
    public void setUp() {
        produtoDao = new ProdutoDao();
    }

    @After
    public void tearDown() {
        produtoDao.limparBanco();
    }

    @Test
    public void cadastrar() {
        Produto produto = new Produto();
        produto.setCodigo("Carro");
        produto.setNome("BMW");
        produto.setValor(504.950);
        produto = produtoDao.cadastrar(produto);

        assertNotNull(produto);
        assertNotNull(produto.getId());
    }

    @Test
    public void buscar() {
        Produto produto = new Produto();
        produto.setCodigo("Carro");
        produto.setNome("BMW");
        produto.setValor(504.950);
        produto = produtoDao.cadastrar(produto);

        Produto produtoBuscado = produtoDao.buscar(produto.getId());

        assertNotNull(produtoBuscado);
        assertEquals(produto.getNome(), produtoBuscado.getNome());
    }

    @Test
    public void alterar() {
        Produto produto = new Produto();
        produto.setCodigo("Carro");
        produto.setNome("BMW");
        produto.setValor(504.950);
        produto = produtoDao.cadastrar(produto);

        produto.setNome("Audi");
        produto.setValor(600.000);
        Produto produtoAlterado = produtoDao.alterar(produto);

        assertNotNull(produtoAlterado);
        assertEquals("Audi", produtoAlterado.getNome());
        assertEquals(600.000, produtoAlterado.getValor(), 0);
    }

    @Test
    public void excluir() {
        Produto produto = new Produto();
        produto.setCodigo("Carro");
        produto.setNome("BMW");
        produto.setValor(504.950);
        produto = produtoDao.cadastrar(produto);

        produtoDao.excluir(produto.getId());

        Produto produtoExcluido = produtoDao.buscar(produto.getId());
        assertNull(produtoExcluido);
    }
}
