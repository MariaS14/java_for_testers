package model;

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

    /*public ContactData withPhoto(String photo) {
        return new ContactData(photo,this.id, this.firstname, this.lastname);
    }*/

    public ContactData withPhone(String phone) {
        return new ContactData(this.id, this.firstname, this.lastname, phone);
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


