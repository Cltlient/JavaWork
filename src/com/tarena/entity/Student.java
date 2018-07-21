package com.tarena.entity;

public class Student {
    private int stu_id;
    private int stu_no;
    private String stu_name;
    private String stu_grade;
    private String stu_sex;
    /**
     * @return the stu_id
     */
    public int getStu_id() {
        return stu_id;
    }
    /**
     * @param stu_id the stu_id to set
     */
    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }
    /**
     * @return the stu_no
     */
    public int getStu_no() {
        return stu_no;
    }
    /**
     * @param stu_no the stu_no to set
     */
    public void setStu_no(int stu_no) {
        this.stu_no = stu_no;
    }
    public Student(int stu_no) {
        super();
        this.stu_no = stu_no;
    }
    /**
     * @return the stu_name
     */
    public String getStu_name() {
        return stu_name;
    }
    /**
     * @param stu_name the stu_name to set
     */
    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }
    /**
     * @return the stu_grade
     */
    public String getStu_grade() {
        return stu_grade;
    }
    /**
     * @param stu_grade the stu_grade to set
     */
    public void setStu_grade(String stu_grade) {
        this.stu_grade = stu_grade;
    }
    /**
     * @return the stu_sex
     */
    public String getStu_sex() {
        return stu_sex;
    }
    /**
     * @param stu_sex the stu_sex to set
     */
    public void setStu_sex(String stu_sex) {
        this.stu_sex = stu_sex;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Student [stu_id=" + stu_id + ", stu_no=" + stu_no
                + ", stu_name=" + stu_name + ", stu_grade=" + stu_grade
                + ", stu_sex=" + stu_sex + "]";
    }
    public Student(int stu_id, int stu_no, String stu_name, String stu_grade,
            String stu_sex) {
        super();
        this.stu_id = stu_id;
        this.stu_no = stu_no;
        this.stu_name = stu_name;
        this.stu_grade = stu_grade;
        this.stu_sex = stu_sex;
    }
    public Student(int stu_no, String stu_name, String stu_grade, String stu_sex) {
        this.stu_no = stu_no;
        this.stu_name = stu_name;
        this.stu_grade = stu_grade;
        this.stu_sex = stu_sex;
    }
    public Student() {
        super();
    }


    
}
