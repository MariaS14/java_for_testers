package manager.hbm;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "addressbook")



public class ContactRecord {


    @Id
    public int id;

    @Column(name = "firstname")
    public String firstname;

    @Column(name = "lastname")
    public String lastname;

    @Column(name = "mobile")
    public String phone;

    @Column(name = "title")
    public String title;
    @Column(name = "nickname")
    public String nickname;
    @Column(name = "middlename")
    public String middlename;
    @Column(name = "company")
    public String company;
    @Column(name = "address")
    public String address;
    @Column(name = "deprecated")
    public Date deprecated = new Date();

    @ManyToMany
    @JoinTable(name = "address_in_groups",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name ="group_id"))

    public List<GroupRecord> groups;

    public ContactRecord() {
    }

    public ContactRecord(int id, String firstname, String lastname, String phone, String title, String nickname, String middlename, String company, String address) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.title = title;
        this.nickname = nickname;
        this.middlename = middlename;
        this.company = company;
        this.address = address;
    }

}
