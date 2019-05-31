package vip.pryun.dikas.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.pryun.dikas.common.mybatis.dto.QueryParam;
import vip.pryun.dikas.common.mybatis.utils.WrapperUtils;
import vip.pryun.dikas.common.object.Result;
import vip.pryun.dikas.domain.NewsBean;
import vip.pryun.dikas.service.biz.INewsService;
import vip.pryun.dikas.web.vo.NewsVO;

/**
 * <p>
 * 新闻和动态 前端控制器
 * </p>
 *
 * @author LiuYin
 * @since 2019-05-30
 */
@RestController
@RequestMapping("/web/dikas/news")
@Api(tags = "新闻和动态")
public class NewsController extends BaseController {

    @Autowired
    private INewsService newsService;

    @PostMapping("/page")
    @ApiOperation(value = "新闻分页", notes = "分页和模糊查询")
    public Result<IPage<NewsVO>> page(@RequestBody @Validated QueryParam<NewsVO> queryParam) {
        QueryWrapper<NewsBean> wrapper = WrapperUtils.getWrapper(queryParam);
        IPage<NewsBean> page = newsService.page(newPage(queryParam), wrapper);
        return newResult(page, NewsVO.class);
    }
}
