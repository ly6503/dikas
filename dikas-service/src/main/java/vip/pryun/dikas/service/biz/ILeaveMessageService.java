package vip.pryun.dikas.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import vip.pryun.dikas.domain.LeaveMessageBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cjzlx
 * @since 2019-05-29
 */
public interface ILeaveMessageService extends IService<LeaveMessageBean> {
    /**
     * 添加留言信息
     * @param messageBean 留言bean对象
     * @return 添加结果
     */
    Boolean saveMessage(LeaveMessageBean messageBean);
}
