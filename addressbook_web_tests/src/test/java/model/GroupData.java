package model;

//record сокращенная форма классов для моделирования данных
public record GroupData(String id, String name, String header, String footer) {

    public GroupData() {
        this("", "", "", "");
    }

    public GroupData withId(String Id) {
        return new GroupData(id, this.name, this.header, this.footer);
    }


    public GroupData withName(String name) {
        return new GroupData(this.id, name, this.header, this.footer);
        //возвращаем объект где хедер и футер такие же, а имя другое
    }

    public GroupData withHeader(String header) {
        return new GroupData(this.id, this.name, header, this.footer);
    }

    public GroupData withFooter(String footer) {
        return new GroupData(this.id, this.name, this.header, footer);
    }
}