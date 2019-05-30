package vip.pryun.dikas.service.biz.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import vip.pryun.dikas.domain.LeaveMessageBean;
import vip.pryun.dikas.persistence.dao.LeaveMessageDao;
import vip.pryun.dikas.service.biz.ILeaveMessageService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cjzlx
 * @since 2019-05-29
 */
@Service
public class LeaveMessageServiceImpl extends ServiceImpl<LeaveMessageDao, LeaveMessageBean> implements ILeaveMessageService {

}
