package br.senai.sc.dao;

import br.senai.sc.model.Phone;
import br.senai.sc.model.User;
import sun.dc.path.PathError;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class PhoneDAOTest {

    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory("Jpa_Aula");
        entityManager = factory.createEntityManager();

//        insert();
        findPhoneCodArea();

        entityManager.close();
        factory.close();

    }

    public static void insert(){
        entityManager.getTransaction().begin();

        Phone phone = new Phone();
        phone.setNumber("(48) 9 9988 7777");
        User user = entityManager.find(User.class, 2);
        phone.setUser(user);

        entityManager.persist(phone);

        entityManager.getTransaction().commit();

    }

    public static void findPhoneCodArea(){

        Query queryPhone = entityManager.createNamedQuery("Phone.FindPhoneByCodArea");
        queryPhone = queryPhone.setParameter("codArea", "(48)" + "%");

        List<Phone> phones = queryPhone.getResultList();

        for (Phone phone : phones){
            System.out.println(phone.getNumber() + " - " + phone.getUser().getFullName());
        }

    }
}
