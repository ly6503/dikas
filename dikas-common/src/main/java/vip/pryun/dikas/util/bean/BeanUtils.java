package vip.pryun.dikas.util.bean;



import vip.pryun.dikas.BaseBean;
import vip.pryun.dikas.object.UnifyUser;

import java.util.Collection;
import java.util.Date;

public class BeanUtils {
    /**
     * 添加更新人信息
     *
     * @param bean    bean
     * @param optUser optUser
     * @return BaseBean
     */
    public static void addUpdateInfo(BaseBean bean, UnifyUser optUser) {
        bean.setUpdateDt(new Date());
        bean.setUpdateId(optUser.getId());
        bean.setUpdateName(optUser.getUsername());
    }

    /**
     * 批量添加更新人信息
     *
     * @param beans
     * @param optUser
     * @return BaseBean
     */
    public static void addUpdateInfo(Collection<? extends BaseBean> beans, UnifyUser optUser) {
        beans.forEach(baseBean -> addUpdateInfo(baseBean, optUser));
    }

    /**
     * 添加创建人信息
     *
     * @param baseBean  baseBean
     * @param unifyUser UnifyUser
     * @return BaseBean
     */
    public static void addEntryInfo(BaseBean baseBean, UnifyUser unifyUser) {
        baseBean.setEntryId(unifyUser.getId());
        baseBean.setEntryName(unifyUser.getUsername());
        baseBean.setEntryDt(new Date());
    }

    /**
     * 批量添加创建人信息
     *
     * @param beans
     * @param optUser
     * @return BaseBean
     */
    public static void addEntryInfo(Collection<? extends BaseBean> beans, UnifyUser optUser) {
        beans.forEach(baseBean -> addEntryInfo(baseBean, optUser));
    }
}
