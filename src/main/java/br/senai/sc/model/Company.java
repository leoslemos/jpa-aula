package br.senai.sc.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
@NamedQueries({
        @NamedQuery(name = "Company.listAll", query = "SELECT c FROM Company c"),
        @NamedQuery(name = "Company.listAllOrderByName", query = "SELECT c FROM Company c ORDER BY c.name"),
})
public class Company {

    @Id
    @Column(name = "id_company")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCompany;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private List<User> users;

    private String name;

    public Integer getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
