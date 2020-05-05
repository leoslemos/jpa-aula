package br.senai.sc.dao;

import br.senai.sc.model.Company;
import br.senai.sc.model.User;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserDAOTest {

    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    public static void main(String[] args) {

        factory = Persistence.createEntityManagerFactory("Jpa_Aula");
        entityManager = factory.createEntityManager();

        insertUser();
//        editUser();
//        deleteUser();
        findUser();

        entityManager.close();
        factory.close();

    }

    public static void insertUser(){

        entityManager.getTransaction().begin();

        User newUser = new User();

        newUser.setFullName("Bispo de Paris");
        newUser.setEmail("bispodeparis@gmail.com");
        newUser.setPassword("deparisbispo");

        Company findCompany = entityManager.find(Company.class, 1);
        newUser.setCompany(findCompany);

        entityManager.persist(newUser);
        entityManager.getTransaction().commit();

    }

    public static void editUser(){

        entityManager.getTransaction().begin();

        User newUser = entityManager.find(User.class, 2);

        newUser.setFullName("Inocêncio Coitadinho");
        newUser.setEmail("inocenciocoitadinho@gmail.com");
        newUser.setPassword("coitadinhoinocencio");

        entityManager.merge(newUser);
        entityManager.getTransaction().commit();
    }

    public static void deleteUser(){

        entityManager.getTransaction().begin();

        User newUser = entityManager.find(User.class, 2);

        entityManager.remove(newUser);
        entityManager.getTransaction().commit();
    }

    public static void findUser(){

        entityManager.getTransaction().begin();

        User findUser = entityManager.find(User.class, 1);

        System.out.println("Nome: " + findUser.getFullName());
        System.out.println("E-mail: " + findUser.getEmail());
        System.out.println("Senha: " + findUser.getPassword());
        System.out.println("Empresa: " + findUser.getCompany().getName());

        entityManager.getTransaction().commit();
    }

}
