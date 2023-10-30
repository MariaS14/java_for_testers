package model;

public record ContactData (String firstname, String lastname, String mobile) {

    public ContactData(){
        this("","","");
    }

    public ContactData withFirstname(String firstname) {
        return new ContactData(firstname, this.lastname,this.mobile);
        //возвращаем объект где хедер и футер такие же, а имя другое
    }
    public ContactData withLastname(String lastname) {
        return new ContactData(this.firstname, lastname, this.mobile);
    }
    public ContactData withMobile(String mobile) {
        return new ContactData(this.firstname, this.lastname, mobile);
    }
}