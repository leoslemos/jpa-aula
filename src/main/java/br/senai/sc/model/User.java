package br.senai.sc.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(name = "User.findAllUserOrByName", query = "SELECT u FROM User u ORDER BY u.fullName"),
        @NamedQuery(name = "User.FindAllUserOrderByEmailDesc", query = "SELECT u FROM User u ORDER BY u.email DESC"),
        @NamedQuery(name = "User.findByIdUser", query = "SELECT u FROM User u where u.idUser = :iduser")
})
public class User {

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;

    private String fullName;

    private String email;

    private String password;

    @ManyToOne
    @JoinColumn(name = "id_company")
    private Company company;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Phone> phones;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}
