package br.senai.sc.dao;

import br.senai.sc.model.Company;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CompanyDAOTest {

    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    public static void main(String[] args) {

        factory = Persistence.createEntityManagerFactory("Jpa_Aula");
        entityManager = factory.createEntityManager();

//        insertCompany();
//        alterCompany();
//        deleteCompany();
        findCompany();

        entityManager.close();
        factory.close();

    }

    private static void insertCompany(){

        entityManager.getTransaction().begin();

        Company newCompany = new Company();

        newCompany.setName("Mc Facvela");

        entityManager.persist(newCompany);
        entityManager.getTransaction().commit();
    }

    private static void alterCompany(){

        entityManager.getTransaction().begin();

        Company alterCompany = entityManager.find(Company.class, 1);

        alterCompany.setName("Mc'Favela");

        entityManager.merge(alterCompany);
        entityManager.getTransaction().commit();
    }

    private static void deleteCompany(){

        entityManager.getTransaction().begin();

        Company deleteCompany = entityManager.find(Company.class, 1);

        entityManager.remove(deleteCompany);
        entityManager.getTransaction().commit();
    }

    private static void findCompany(){

        entityManager.getTransaction().begin();

        Company findCompany = entityManager.find(Company.class, 1);

        entityManager.getTransaction().commit();

        System.out.println("Dados Retornados:");
        System.out.println("Código Empresa - " + findCompany.getIdCompany());
        System.out.println("Nome Empresa - " + findCompany.getName());
    }
}
