package br.senai.sc.dao;

import br.senai.sc.model.Company;
import br.senai.sc.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class CompanyDAOTest {

    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    public static void main(String[] args) {

        factory = Persistence.createEntityManagerFactory("Jpa_Aula");
        entityManager = factory.createEntityManager();

//        insertCompany();
//        alterCompany();
//        deleteCompany();
//        findCompany();
//        listCompanyUser();
        listCompanies();

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

    public static void listCompanyUser(){
        entityManager.getTransaction().begin();
        Company company = entityManager.find(Company.class, 1);

        List<User> usuarios = company.getUsers();

        for(User user : usuarios){
            System.out.println("-------------------------------");
            System.out.println(user.getFullName());
            System.out.println(user.getEmail());
            System.out.println("-------------------------------");
        }

        entityManager.getTransaction().commit();
    }

    private static void listCompanies(){

        Query query = entityManager.createNamedQuery("Company.listAllOrderByName");

        List<Company> companies = query.getResultList();

        for (Company company : companies){
            System.out.println(company.getName());
        }

    }
}
