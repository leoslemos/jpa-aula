package br.senai.sc.dao;

import br.senai.sc.model.Company;
import br.senai.sc.model.User;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class UserDAOTest {

    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    public static void main(String[] args) {

        factory = Persistence.createEntityManagerFactory("Jpa_Aula");
        entityManager = factory.createEntityManager();

       insertUser();
//        editUser();
//        deleteUser();
//        findUser();
//        listAllUserByName();
//        listAllUserByEmailDesc();
//        listUserById();

        entityManager.close();
        factory.close();

    }

    public static void insertUser(){

        entityManager.getTransaction().begin();

        User newUser1 = new User();

        newUser1.setFullName("Sebastião Salgado Doce");
        newUser1.setEmail("sebastiaosalgadodoce@gmail.com");
        newUser1.setPassword("sebastiaosalgadodoce");

        Company findCompany1 = entityManager.find(Company.class, 1);
        newUser1.setCompany(findCompany1);

        entityManager.persist(newUser1);

        User newUser2 = new User();
        newUser2.setFullName("Leão Rolando Pedreira");
        newUser2.setEmail("leaoroalandopedreira@gmail.com");
        newUser2.setPassword("leaoroalandopedreira");

        Company findCompany2 = entityManager.find(Company.class, 1);
        newUser2.setCompany(findCompany2);

        entityManager.persist(newUser2);


        entityManager.getTransaction().commit();

    }

    public static void editUser(){

        entityManager.getTransaction().begin();

        User newUser = entityManager.find(User.class, 3);

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

    public static void listAllUserByName() {

        Query query = entityManager.createNamedQuery("User.findAllUserOrByName");

        List<User> users = query.getResultList();

        System.out.println("Resultado da Query User.findAllUserOrByName");
        for (User user : users){
            System.out.println("-------------------------------------------");
            System.out.println(user.getFullName());
            System.out.println(user.getEmail());
            System.out.println("-------------------------------------------");
        }
    }

    public static void listAllUserByEmailDesc() {

        Query query = entityManager.createNamedQuery("User.FindAllUserOrderByEmailDesc");

        List<User> users = query.getResultList();

        System.out.println("Resultado da Query User.FindAllUserOrderByEmailDesc");
        for (User user : users){
            System.out.println("-------------------------------------------");
            System.out.println(user.getEmail());
            System.out.println(user.getFullName());
            System.out.println("-------------------------------------------");
        }
    }

    public static void listUserById(){

        Query query = entityManager.createNamedQuery("User.findByIdUser");
        query.setParameter("iduser", 3);

        User user = (User) query.getSingleResult();

        System.out.println(user.getFullName());
    }

}
