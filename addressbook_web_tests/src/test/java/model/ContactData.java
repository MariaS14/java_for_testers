package model;

public record ContactData(String name, String lastname, String phone) {

    public ContactData() {
        this("", "", "");
    }

    public ContactData withName(String name) {
        return new ContactData(name, this.lastname, this.phone);
    }

    public ContactData withLastname(String lastname) {
        return new ContactData(this.name, lastname, this.phone);
    }

    public ContactData withPhone(String phone) {
        return new ContactData(this.name, this.lastname, phone);
    }
}