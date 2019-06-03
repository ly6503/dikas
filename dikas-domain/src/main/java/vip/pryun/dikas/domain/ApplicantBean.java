package vip.pryun.dikas.domain;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 求职者表
 * </p>
 *
 * @author cjzlx
 * @since 2019-05-29
 */
@TableName("applicant")
public class ApplicantBean extends BaseBean {

    private static final long serialVersionUID = 1L;

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

    /**
     * 审批状态
     */
    private Integer approvalStatus;

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

    public Integer getApplicantGender() {
        return applicantGender;
    }

    public void setApplicantGender(Integer applicantGender) {
        this.applicantGender = applicantGender;
    }

    public Integer getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Integer approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    @Override
    public String toString() {
        return "ApplicantBean{" +
                "applicantName='" + applicantName + '\'' +
                ", applicantAge=" + applicantAge +
                ", applicantGender=" + applicantGender +
                ", applicantMajor='" + applicantMajor + '\'' +
                ", salary='" + salary + '\'' +
                ", education='" + education + '\'' +
                ", jobName=" + jobName +
                ", description='" + description + '\'' +
                ", approvalStatus='" + approvalStatus + '\'' +
                '}';
    }
}
