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
        String secondary, String email, String email2, String email3, String address2) {

    public ContactData() {
        this("", "", "", "","", "", "", "", "", "", "", "", "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstname, this.lastname, this.phone,this.photo, this.home, this.work, this.address, this.secondary, this.email, this.email2, this.email3, this.address2);
    }

    public ContactData withFirstName(String firstname) {
        return new ContactData(this.id, firstname, this.lastname, this.phone,this.photo, this.home, this.work, this.address, this.secondary, this.email, this.email2, this.email3, this.address2);
    }

    public ContactData withLastName(String lastname) {
        return new ContactData(this.id, this.firstname, lastname, this.phone,this.photo, this.home, this.work, this.address, this.secondary, this.email, this.email2, this.email3, this.address2);
    }


    public ContactData withPhone(String phone) {
        return new ContactData(this.id, this.firstname, this.lastname, phone,this.photo, this.home, this.work, this.address, this.secondary, this.email, this.email2, this.email3, this.address2);
    }
    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstname, this.lastname, this.phone, photo, this.home, this.work, this.address, this.secondary, this.email, this.email2, this.email3, this.address2);
    }
    public ContactData withHome(String home) {
        return new ContactData(this.id, this.firstname, this.lastname, this.phone, photo, home, this.work, this.address, this.secondary, this.email, this.email2, this.email3, this.address2);
    }
    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstname, this.lastname, this.phone, photo, this.home, this.work, address, this.secondary, this.email, this.email2, this.email3, this.address2);
    }
    public ContactData withWork(String work) {
        return new ContactData(this.id, this.firstname, this.lastname, this.phone, photo, this.home, work, this.address, this.secondary, this.email, this.email2, this.email3, this.address2);
    }
    public ContactData withSecondary(String phone2) {
        return new ContactData(this.id, this.firstname, this.lastname, this.phone, photo, this.home, this.work, this.address, phone2, this.email, this.email2, this.email3, this.address2);
    }
    public ContactData withEmail(String email) {
        return new ContactData(this.id, this.firstname, this.lastname, this.phone, photo, this.home, this.work, this.address, this.secondary, email, this.email2, this.email3, this.address2);
    }
    public ContactData withEmail2(String email2) {
        return new ContactData(this.id, this.firstname, this.lastname, this.phone, photo, this.home, this.work, this.address, this.secondary, email, email2, this.email3, this.address2);
    }
    public ContactData withEmail3(String email3) {
        return new ContactData(this.id, this.firstname, this.lastname, this.phone, photo, this.home, this.work, this.address, this.secondary, this.email, this.email2, email3, this.address2);
    }
    public ContactData withAddress2(String address2) {
        return new ContactData(this.id, this.firstname, this.lastname, this.phone, photo, this.home, this.work, address2,this.address, this.secondary, this.email, this.email2, this.email3);
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