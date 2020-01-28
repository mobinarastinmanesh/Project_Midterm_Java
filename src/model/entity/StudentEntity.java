package model.entity;

public class StudentEntity {

    //الکوی طراحی builder
    private Long sid;//عددی
    private String name;
    private String father_name;
    private String melli_code;
    private String birth_day;
    private String field;
    private String avg;
    private String maghta_tahsil;

    public Long getSid() {
        return sid;
    }

    public String getName() {
        return name;
    }

    public String getFather_name() {
        return father_name;
    }

    public String getMelli_code() {
        return melli_code;
    }

    public String getBirth_day() {
        return birth_day;
    }

    public String getField() {
        return field;
    }

    public String getAvg() {
        return avg;
    }

    public String getMaghta_tahsil() {
        return maghta_tahsil;
    }

    public StudentEntity setSid(long sid) {
        this.sid = sid;
        return this;
    }

    public StudentEntity setName(String name) {

        this.name = name;
        return this;
    }

    public StudentEntity setFather_name(String father_name) {
        this.father_name = father_name;
        return this;
    }

    public StudentEntity setMelli_code(String melli_code) {
        this.melli_code = melli_code;
        return this;
    }

    public StudentEntity setBirth_day(String birth_day) {
        this.birth_day = birth_day;
        return this;
    }

    public StudentEntity setField(String field) {
        this.field = field;
        return this;
    }

    public StudentEntity setAvg(String avg) {
        this.avg = avg;
        return this;
    }

    public StudentEntity setMaghta_tahsil(String maghta_tahsil) {
        this.maghta_tahsil = maghta_tahsil;
        return this;
    }
}
