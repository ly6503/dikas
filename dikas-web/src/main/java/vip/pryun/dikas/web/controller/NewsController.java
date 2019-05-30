package vip.pryun.dikas.web.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.pryun.dikas.common.object.Result;
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
public class NewsController extends BaseController {

    @Autowired
    private INewsService newsService;

    @GetMapping("/page")
    @ApiOperation(value = "新闻分页", notes = "分页和模糊查询")
    public Result<NewsVO> page(){
        return null;
    }
}
