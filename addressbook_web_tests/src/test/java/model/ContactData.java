package model;

public record ContactData(String id, String name, String lastname, String phone) {

    public ContactData() {
        this("", "", "", "");
    }
    public ContactData withId(String id) {
        return new ContactData(id, this.name, this.lastname, this.phone);
    }

    public ContactData withName(String name) {
        return new ContactData(this.id, name, this.lastname, this.phone);
    }

    public ContactData withLastName(String lastname) {
        return new ContactData(this.id, this.name, lastname, this.phone);
    }

    public ContactData withPhone(String phone) {
        return new ContactData(this.id, this.name, this.lastname, phone);
    }
}