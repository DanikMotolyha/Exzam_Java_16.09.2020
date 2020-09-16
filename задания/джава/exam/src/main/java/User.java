public class User {
    private String name = "";
    private String surname = "";
    private String id = "";
    private String subject = "";
    private String mark = "";

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public String getMark() {
        return mark;
    }

    public User(String name, String surname, String id, String subject, String mark) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.subject = subject;
        this.mark = mark;
    }
}
