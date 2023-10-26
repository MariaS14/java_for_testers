package model;

//record сокращенная форма классов для моделирования данных
public record GroupData(String name, String header, String footer) {

    public GroupData(){
        this("","","");
    }

    public GroupData withName(String name) {
        return new GroupData(name, this.header, this.footer);
        //возвращаем объект где хедер и футер такие же, а имя другое
    }
    public GroupData withHeader(String header) {
        return new GroupData(this.name, header, this.footer);
    }
    public GroupData withFooter(String footer) {
        return new GroupData(this.name, this.header, footer);
    }
}