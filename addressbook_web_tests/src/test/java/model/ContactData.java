package model;

public record ContactData(
        String id,
        String firstname,
        String lastname,
        String phone,
        String photo,
        String home,
        String work,
        String address,
        String secondary) {

    public ContactData() {
        this("", "", "", "","", "", "", "", "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstname, this.lastname, this.phone,this.photo, this.home, this.work, this.address, this.secondary);
    }

    public ContactData withFirstName(String firstname) {
        return new ContactData(this.id, firstname, this.lastname, this.phone,this.photo, this.home, this.work, this.address, this.secondary);
    }

    public ContactData withLastName(String lastname) {
        return new ContactData(this.id, this.firstname, lastname, this.phone,this.photo, this.home, this.work, this.address, this.secondary);
    }


    public ContactData withPhone(String phone) {
        return new ContactData(this.id, this.firstname, this.lastname, phone,this.photo, this.home, this.work, this.address, this.secondary);
    }
    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstname, this.lastname, this.phone, photo, this.home, this.work, this.address, this.secondary);
    }
    public ContactData withHome(String home) {
        return new ContactData(this.id, this.firstname, this.lastname, this.phone, photo, home, this.work, this.address, this.secondary);
    }
    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstname, this.lastname, this.phone, photo, this.home, this.work, address, this.secondary);
    }
    public ContactData withWork(String work) {
        return new ContactData(this.id, this.firstname, this.lastname, this.phone, photo, this.home, work, this.address, this.secondary);
    }
    public ContactData withSecondary(String phone2) {
        return new ContactData(this.id, this.firstname, this.lastname, this.phone, photo, this.home, this.work, this.address, phone2);
    }
}




/*
public record ContactData(String id, String firstName, String lastname, String phone,String photo){
public ContactData() {
    this("", "", "", "","");
}
    public ContactData withId(String id) {
        return new ContactData(id, this.firstName, this.lastname, this.phone,this.photo);
    }

    public ContactData withFirstName(String firstname) {
        return new ContactData(this.id, firstname, this.lastname, this.phone,this.photo);
    }

    public ContactData withLastName(String lastname) {
        return new ContactData(this.id, this.firstName, lastname, this.phone, this.photo);
    }


    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstName, this.lastname, this.phone, photo);
    }

    public ContactData withPhone(String phone) {
        return new ContactData(this.id, this.firstName, this.lastname, phone,this.photo);
    }
}*/

/* правильный код для создания кон
public record ContactData(String id, String firstname, String lastname, String phone) {

    public ContactData() {
        this("", "", "", "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstname, this.lastname, this.phone);
    }

    public ContactData withFirstName(String firstname) {
        return new ContactData(this.id, firstname, this.lastname, this.phone);
    }

    public ContactData withLastName(String lastname) {
        return new ContactData(this.id, this.firstname, lastname, this.phone);
    }


    public ContactData withPhone(String phone) {
        return new ContactData(this.id, this.firstname, this.lastname, phone);
    }
}
 */