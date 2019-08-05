package day18;

public class Hero {
    private int id;
    private String sno;
    private String sname;
    private String ssex;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", age=" + age +
                '}';
    }
}
