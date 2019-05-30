package vip.pryun.dikas.domain;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 职务表
 * </p>
 *
 * @author cjzlx
 * @since 2019-05-29
 */
@TableName("job")
public class JobBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    /**
     * 职位名称
     */
    private String jobName;

    /**
     * 职位状态（0：空缺，1不缺）
     */
    private Integer jobStatus;

    /**
     * 年龄范围
     */
    private String age;

    /**
     * 性别
     */
    private String jobGender;

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

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
    public Integer getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(Integer jobStatus) {
        this.jobStatus = jobStatus;
    }
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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

    public String getJobGender() {
        return jobGender;
    }

    public void setJobGender(String jobGender) {
        this.jobGender = jobGender;
    }

    @Override
    public String toString() {
        return "JobBean{" +
                "jobName='" + jobName + '\'' +
                ", jobStatus=" + jobStatus +
                ", age='" + age + '\'' +
                ", jobGender='" + jobGender + '\'' +
                ", major='" + major + '\'' +
                ", pay='" + pay + '\'' +
                ", needNumber=" + needNumber +
                ", education='" + education + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
