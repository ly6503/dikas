package vip.pryun.dikas.biz.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import vip.pryun.dikas.StudentBean;
import vip.pryun.dikas.biz.IStudentService;
import vip.pryun.dikas.dao.StudentDao;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 7yan1h
 * @since 2019-05-27
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao, StudentBean> implements IStudentService {

}
