package vip.pryun.dikas.web.vo;

import java.io.Serializable;

/**
 * @author CJ
 * @date 2019/5/30 15:01
 * @note
 */
public class ApplicantSaveVO implements Serializable {
    private static final long serialVersionUID = 5461099116143693038L;
    /**
     * 应聘者姓名
     */
    private String applicantName;

    /**
     * 应聘者年龄
     */
    private Integer applicantAge;

    /**
     * 应聘者性别
     */
    private Integer applicantGender;

    /**
     * 应聘者专业
     */
    private String applicantMajor;

    /**
     * 期望薪酬
     */
    private String salary;

    /**
     * 学历
     */
    private String education;

    /**
     * 应聘职务名称
     */
    private Long jobName;

    /**
     * 描述
     */
    private String description;

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public Integer getApplicantAge() {
        return applicantAge;
    }

    public void setApplicantAge(Integer applicantAge) {
        this.applicantAge = applicantAge;
    }

    public Integer getApplicantGender() {
        return applicantGender;
    }

    public void setApplicantGender(Integer applicantGender) {
        this.applicantGender = applicantGender;
    }

    public String getApplicantMajor() {
        return applicantMajor;
    }

    public void setApplicantMajor(String applicantMajor) {
        this.applicantMajor = applicantMajor;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Long getJobName() {
        return jobName;
    }

    public void setJobName(Long jobName) {
        this.jobName = jobName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ApplicantSaveVO{" +
                "applicantName='" + applicantName + '\'' +
                ", applicantAge=" + applicantAge +
                ", applicantGender=" + applicantGender +
                ", applicantMajor='" + applicantMajor + '\'' +
                ", salary='" + salary + '\'' +
                ", education='" + education + '\'' +
                ", jobName=" + jobName +
                ", description='" + description + '\'' +
                '}';
    }
}
