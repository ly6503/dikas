package vip.pryun.dikas.admin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vip.pryun.dikas.admin.vo.NewsSaveVO;
import vip.pryun.dikas.admin.vo.NewsVO;
import vip.pryun.dikas.common.enums.Msg;
import vip.pryun.dikas.common.mybatis.dto.QueryParam;
import vip.pryun.dikas.common.mybatis.utils.WrapperUtils;
import vip.pryun.dikas.common.object.Result;
import vip.pryun.dikas.common.object.UnifyUser;
import vip.pryun.dikas.common.util.bean.BeanMapper;
import vip.pryun.dikas.common.util.bean.BeanUtils;
import vip.pryun.dikas.domain.NewsBean;
import vip.pryun.dikas.service.biz.INewsService;

import javax.validation.constraints.NotNull;

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

    @PostMapping("/saveNews")
    @ApiOperation(value = "添加新闻")
    public Result<Boolean> saveNews(@RequestBody @Validated NewsSaveVO vo) {
        NewsBean bean = BeanMapper.map(vo, NewsBean.class);
        bean.setType(1);
        BeanUtils.addEntryInfo(bean, new UnifyUser(1L, "admin"));
        return newResult(newsService.save(bean), Msg.A40002);
    }

    @PostMapping("/saveHangye")
    @ApiOperation(value = "添加行业动态")
    public Result<Boolean> saveHangye(@RequestBody @Validated NewsSaveVO vo) {
        NewsBean bean = BeanMapper.map(vo, NewsBean.class);
        bean.setType(2);
        BeanUtils.addEntryInfo(bean, new UnifyUser(1L, "admin"));
        return newResult(newsService.save(bean), Msg.A40002);
    }

    @DeleteMapping("/deleteById")
    @ApiOperation(value = "删除新闻/行业动态", notes = "根据id删除")
    @ApiImplicitParam(name = "id", required = true, dataType = "Long")
    public Result<Boolean> deleteById(@RequestParam @NotNull Long id) {
        return newResult(newsService.removeById(id), Msg.A40003);
    }
}
