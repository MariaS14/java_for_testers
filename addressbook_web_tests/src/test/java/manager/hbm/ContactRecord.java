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

    @Column(name = "deprecated")
    public Date deprecated = null;

    public String email = "";
    public String middlename = "";
    public String nickname = "";
    public String company = "";
    public String title = "";
    public String work = "";
    public String fax = "";
    public String email2 = "";
    public String email3 = "";
    public String im = "";
    public String im2 = "";
    public String im3 = "";
    public String homepage = "";
    public int bday = 0;
    public String bmonth = "";
    public String byear = "";
    public int aday = 0;
    public String amonth = "";
    public String ayear = "";
    public String address2 = "";
    public String phone2 = "";
    public String notes = "";
    public String home = "";
    public String address = "";


    @ManyToMany//если каждый контакт мог бы входить только в одну группу мы бы использовали ManyToOne
    @JoinTable(name = "address_in_groups",//таблица соединяющая
            joinColumns = @JoinColumn(name = "id"),//указывает на группу
            inverseJoinColumns = @JoinColumn(name ="group_id"))//указывает на контакт

    public List<GroupRecord> group; // это свойство описывает связь с объектами типа ContactRecord, связанные объекты - достыет Хибернет

    public ContactRecord() {
    }

    public ContactRecord(int id,String firstname,String lastname,String phone) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
    }

}






























/* , String email , String middlename , String nickname
        , String company
        , String title
        , String work
        , String fax
        , String email2
        , String email3
        , String im
        , String im2
        , String im3
        , String homepage
        , String bday
        , String bmonth
        , String byear
        , String aday
        , String amonth
        , String ayear
        , String address2
        , String phone2
        , String notes
        , String home
        , String address ) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this. email = "";
        this. middlename = "";
        this. nickname = "";
        this. company = "";
        this. title = "";
        this. work = "";
        this. fax = "";
        this. email2 = "";
        this. email3 = "";
        this. im = "";
        this. im2 = "";
        this. im3 = "";
        this. homepage = "";
        this. bday = 0;
        this. bmonth = "";
        this. byear = "";
        this. aday = 0;
        this. amonth = "";
        this. ayear = "";
        this. address2 = "";
        this. phone2 = "";
        this. notes = "";
        this. home = "";
        this. address = "";
    }

}*/