package model;

/*public record ContactData(String id, String firstname, String lastname, String phone,String photo) {

    public ContactData() {
        this("", "", "", "","");
    }
    public ContactData withId(String id) {
        return new ContactData(id, this.firstname, this.lastname, this.phone,this.photo);
    }

    public ContactData withFirstName(String firstName) {
        return new ContactData(this.id, firstName, this.lastname, this.phone,this.photo);
    }

    public ContactData withLastName(String lastname) {
        return new ContactData(this.id, this.firstname, lastname, this.phone,this.photo);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(photo,this.id, this.firstname, this.lastname, this.phone);
    }

    public ContactData withPhone(String phone) {
        return new ContactData(this.id, this.firstname, this.lastname, phone,this.photo);
    }
}*/





public record ContactData(String id, String firstname, String lastname, String phone){
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


