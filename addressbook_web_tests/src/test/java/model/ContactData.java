package model;


public record ContactData(String id, String firstname, String lastname, String phone) {

    public ContactData() {
        this("", "", "", "");
    }
    public ContactData withId(String id) {
        return new ContactData(id, this.firstname, this.lastname, this.phone);
    }

    public ContactData withFirstName(String firstName) {
        return new ContactData(this.id, firstName, this.lastname, this.phone);
    }

    public ContactData withLastName(String lastname) {
        return new ContactData(this.id, this.firstname, lastname, this.phone);
    }

    /*public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.name, this.lastname, this.phone);
    }*/

    public ContactData withPhone(String phone) {
        return new ContactData(this.id, this.firstname, this.lastname, phone);
    }
}


/*public record ContactData(String id, String name, String lastname, String phone,String photo){
public ContactData() {
    this("", "", "", "","");
}
    public ContactData withId(String id) {
        return new ContactData(id, this.name, this.lastname, this.phone,this.photo);
    }

    public ContactData withFirstName(String name) {
        return new ContactData(this.id, name, this.lastname, this.phone, this.photo);
    }

    public ContactData withLastName(String lastname) {
        return new ContactData(this.id, this.name, lastname, this.phone, this.photo);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.name, this.lastname, this.phone, photo);
    }

    public ContactData withPhone(String phone) {
        return new ContactData(this.id, this.name, this.lastname, phone,this.photo);
    }
}*/
