package com.example.bai1.repo;

import com.example.bai1.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class ProductRepo implements IProductRepo {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Product> showAllProduct() {
        TypedQuery<Product> productTypedQuery = entityManager.createQuery("select  p from  Product as p ", Product.class);
        List<Product> list = productTypedQuery.getResultList();
        return list;
    }

    @Override
    public void addProduct(Product product) {
        entityManager.persist(product);

    }

    @Override
    public void updateProduct(Product product) {
entityManager.merge(product);
    }

    @Override
    public void deleteProduct(Integer id) {
entityManager.remove(getProduct(id));
    }

    @Override
    public Product getProduct(Integer id) {
        TypedQuery<Product> query = entityManager.createQuery("select p from Product p where p.id=:id", Product.class);
        query.setParameter("id",id);
        return query.getSingleResult();

    }

    @Override
    public List<Product> searchProduct(String nameProduct) {
        TypedQuery<Product> query = entityManager.createQuery("select p from Product p where p.name like :name", Product.class);
       query.setParameter("name","%"+nameProduct+"%");
        return query.getResultList();
    }
}
