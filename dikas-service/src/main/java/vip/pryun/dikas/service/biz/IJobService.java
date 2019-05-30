package vip.pryun.dikas.service.biz;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import vip.pryun.dikas.common.mybatis.dto.QueryParam;
import vip.pryun.dikas.domain.JobBean;

import java.util.List;

/**
 * <p>
 * 职务表 服务类
 * </p>
 *
 * @author cjzlx
 * @since 2019-05-29
 */
public interface IJobService extends IService<JobBean> {
    /**
     * 获取招聘职务分页列表
     * @param param 查询参数
     * @return 分页数据
     */
    IPage<JobBean> pageList(QueryParam param);
}
