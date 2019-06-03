package vip.pryun.dikas.service.biz;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import vip.pryun.dikas.common.mybatis.dto.QueryParam;
import vip.pryun.dikas.domain.RecruitBean;

/**
 * <p>
 * 职务表 服务类
 * </p>
 *
 * @author cjzlx
 * @since 2019-05-29
 */
public interface IRecruitService extends IService<RecruitBean> {
    /**
     * 获取招聘职务分页列表
     * @param param 查询参数
     * @return 分页数据
     */
    IPage<RecruitBean> pageList(QueryParam param);

    Boolean saveRecruit(RecruitBean recruitBean);
}
