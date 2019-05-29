package vip.pryun.dikas;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 *
 * </p>
 *
 * @author 7yan1h
 * @since 2019-05-27
 */
@TableName("student")
public class StudentBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StudentBean{" +
                "name=" + name +
                "}";
    }
}
