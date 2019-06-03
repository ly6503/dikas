package vip.pryun.dikas.web.vo;

import java.io.Serializable;

/**
 * @author CJ
 * @date 2019/5/29 21:46
 * @note
 */
public class RecruitVO implements Serializable {
    private static final long serialVersionUID = -4314978094539604120L;
    /**
     * 职位名称
     */
    private String recruitName;

    /**
     * 职位状态（0：空缺，1不缺）
     */
    private Integer recruitStatus;

    /**
     * 年龄范围
     */
    private String age;

    /**
     * 性别
     */
    private String genderRange;

    /**
     * 专业
     */
    private String major;

    /**
     * 薪酬待遇
     */
    private String pay;

    /**
     * 招聘人数
     */
    private Integer needNumber;

    /**
     * 学历
     */
    private String education;

    /**
     * 条件描述
     */
    private String description;

    public String getRecruitName() {
        return recruitName;
    }

    public void setRecruitName(String recruitName) {
        this.recruitName = recruitName;
    }

    public Integer getRecruitStatus() {
        return recruitStatus;
    }

    public void setRecruitStatus(Integer recruitStatus) {
        this.recruitStatus = recruitStatus;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGenderRange() {
        return genderRange;
    }

    public void setGenderRange(String genderRange) {
        this.genderRange = genderRange;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public Integer getNeedNumber() {
        return needNumber;
    }

    public void setNeedNumber(Integer needNumber) {
        this.needNumber = needNumber;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "RecruitVO{" +
                "recruitName='" + recruitName + '\'' +
                ", recruitStatus=" + recruitStatus +
                ", age='" + age + '\'' +
                ", genderRange='" + genderRange + '\'' +
                ", major='" + major + '\'' +
                ", pay='" + pay + '\'' +
                ", needNumber=" + needNumber +
                ", education='" + education + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
