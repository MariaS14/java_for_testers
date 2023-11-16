package manager.hbm;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "group_list")

public class GroupRecord {


    @Id
    @Column(name = "group_id")

    public int id;

    @Column(name = "group_name")
    public String name;
    @Column(name = "group_header")

    public String header;
    @Column(name = "group_footer")

    public String footer;

    public Date deprecated = new Date();

    @ManyToMany//если каждый контакт мог бы входить только в одну группу мы бы использовали ManyToOne
    @JoinTable(name = "address_in_groups",//таблица соединяющая
            joinColumns = @JoinColumn(name = "group_id"),//указывает на группу
    inverseJoinColumns = @JoinColumn(name ="id"))//указывает на контакт

    public List<ContactRecord> contacts; // это свойство описывает связь с объектами типа ContactRecord, связанные объекты - достыет Хибернет



    public GroupRecord() {
    }
    public GroupRecord(int id,String name,String header,String footer) {
        this.id = id;
        this.name = name;
        this.header = header;
        this.footer = footer;
    }

}