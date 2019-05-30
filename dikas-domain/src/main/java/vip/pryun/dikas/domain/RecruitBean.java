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
@TableName("recruit")
public class RecruitBean extends BaseBean {

    private static final long serialVersionUID = 1L;

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

    public String getAge() {
        return age;
    }

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

    public String getGenderRange() {
        return genderRange;
    }

    public void setGenderRange(String genderRange) {
        this.genderRange = genderRange;
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


    @Override
    public String toString() {
        return "RecruitBean{" +
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
