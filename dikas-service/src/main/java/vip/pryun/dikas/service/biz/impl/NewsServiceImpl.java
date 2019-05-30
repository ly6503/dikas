package vip.pryun.dikas.service.biz.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import vip.pryun.dikas.domain.NewsBean;
import vip.pryun.dikas.persistence.dao.NewsDao;
import vip.pryun.dikas.service.biz.INewsService;

/**
 * <p>
 * 新闻和动态 服务实现类
 * </p>
 *
 * @author LiuYin
 * @since 2019-05-30
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsDao, NewsBean> implements INewsService {

}
