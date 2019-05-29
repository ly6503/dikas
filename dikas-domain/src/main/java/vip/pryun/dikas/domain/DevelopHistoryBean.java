package vip.pryun.dikas.domain;

import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;

/**
 * <p>
 * 发展历程
 * </p>
 *
 * @author 7yan1h
 * @since 2019-05-29
 */
@TableName("develop_history")
public class DevelopHistoryBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    /**
     * 活动日期
     */
    private LocalDateTime actionDt;

    /**
     * 内容
     */
    private String content;

    public LocalDateTime getActionDt() {
        return actionDt;
    }

    public void setActionDt(LocalDateTime actionDt) {
        this.actionDt = actionDt;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "DevelopHistoryBean{" +
                "actionDt=" + actionDt +
                ", content=" + content +
                "}";
    }
}
