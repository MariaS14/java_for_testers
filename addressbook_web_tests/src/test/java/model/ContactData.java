package model;

public record ContactData(String id, String firstname, String lastname, String phone, String photo, String title, String nickname, String middlename, String company, String address) {
    public ContactData() {
        this("", "", "", "", "", "", "", "", "", "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstname, this.lastname, this.phone, this.photo,this.middlename, this.address, this.nickname, this.company, this.title);
    }

    public ContactData withFirstName(String firstname) {
        return new ContactData(this.id, firstname, this.lastname, this.phone, this.photo,this.middlename, this.address, this.nickname, this.company, this.title);
    }

    public ContactData withLastName(String lastname) {
        return new ContactData(this.id, this.firstname, lastname, this.phone, this.photo,this.middlename, this.address, this.nickname, this.company, this.title);
    }

    public ContactData withMiddlename(String middlename) {
        return new ContactData(this.id, this.firstname, this.lastname, this.phone, this.photo, middlename, this.nickname, this.address, this.company,this.title);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstname, this.lastname, this.phone, this.photo, this.middlename, address, this.nickname, this.company,this.title);
    }

    public ContactData withNickname(String nickname) {
        return new ContactData(this.id, this.firstname, this.lastname, this.phone, this.photo, this.middlename, this.address, nickname, this.company,this.title);
    }

    public ContactData withCompany(String company) {
        return new ContactData(this.id, this.firstname, this.lastname, this.phone, this.photo, this.middlename, this.address, this.nickname, company,this.title);
    }

    public ContactData withTitle(String title) {
        return new ContactData(this.id, this.firstname, this.lastname, this.phone, this.photo, this.middlename, this.address, this.nickname, this.company,title);
    }


    public ContactData withPhone(String phone) {
        return new ContactData(this.id, this.firstname, this.lastname, phone, this.photo,this.middlename, this.address, this.nickname, this.company, this.title);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstname, this.lastname, this.phone, photo,this.middlename, this.address, this.nickname, this.company, this.title);
    }
}


/*public record ContactData(String id, String firstname, String lastname, String phone, String photo, String middlename, String nickname, String address, String company) {

    public ContactData() {
        this("", "", "", "","","","","","");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstname, this.lastname, this.phone,this.photo,this.middlename,this.nickname,this.address, this.company);
    }

    public ContactData withFirstName(String firstname) {
        return new ContactData(this.id, firstname, this.lastname, this.phone,this.photo,this.middlename,this.nickname,this.address, this.company);
    }

    public ContactData withLastName(String lastname) {
        return new ContactData(this.id, this.firstname, lastname, this.phone,this.photo,this.middlename,this.nickname,this.address, this.company);
    }
    public ContactData withMiddlename (String middlename) {
        return new ContactData(this.id, this.firstname, this.lastname, this.phone,this.photo, middlename,this.nickname,this.address, this.company);
    }

    public ContactData withAddress (String address) {
        return new ContactData(this.id, this.firstname, this.lastname, this.phone,this.photo, this.middlename,address, this.nickname, this.company);
    }
    public ContactData withNickname (String nickname) {
        return new ContactData(this.id, this.firstname, this.lastname, this.phone,this.photo, this.middlename, this.address, nickname, this.company);
    }

    public ContactData withCompany (String company) {
        return new ContactData(this.id, this.firstname, this.lastname, this.phone,this.photo, this.middlename, this.address, this.nickname,company);
    }


    public ContactData withPhone(String phone) {
        return new ContactData(this.id, this.firstname, this.lastname, phone,this.photo,this.middlename,this.nickname,this.address, this.company);
    }
    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstname, this.lastname, this.phone, photo,this.middlename,this.nickname,this.address, this.company);
    }
}
*/



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


