package br.com.ana.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.ana.domain.Produto;

public class ProdutoDao implements IProdutoDao {

    private EntityManagerFactory entityManagerFactory;

    public ProdutoDao() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
    }

    @Override
    public Produto cadastrar(Produto produto) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();

        entityManager.close();
        return produto;
    }

    @Override
    public Produto buscar(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Produto produto = entityManager.find(Produto.class, id);
        entityManager.close();
        return produto;
    }

    @Override
    public Produto alterar(Produto produto) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        produto = entityManager.merge(produto);
        entityManager.getTransaction().commit();

        entityManager.close();
        return produto;
    }

    @Override
    public void excluir(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Produto produto = entityManager.find(Produto.class, id);
        if (produto != null) {
            entityManager.remove(produto);
        }
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    @Override
    public void limparBanco() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Produto").executeUpdate();
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
