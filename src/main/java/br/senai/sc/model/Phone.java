package br.senai.sc.model;

import javax.persistence.*;

@Entity
@Table(name = "phone")
@NamedQueries({
        @NamedQuery(name = "Phone.FindPhoneByCodArea", query = "SELECT p FROM Phone p where p.number like :codArea")
})
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPhone;
    private String number;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public Integer getIdPhone() {
        return idPhone;
    }

    public void setIdPhone(Integer idPhone) {
        this.idPhone = idPhone;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
