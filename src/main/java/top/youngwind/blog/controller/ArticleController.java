package top.youngwind.blog.controller;

import io.swagger.annotations.Api;
import io.swagger.models.auth.In;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.youngwind.blog.entity.Article;
import top.youngwind.blog.enums.ResultVOEnum;
import top.youngwind.blog.service.ArticleService;
import top.youngwind.blog.vo.ResultVO;

import java.util.List;

@Api(tags = "博客文章")
@RestController
@RequestMapping("/article")
public class ArticleController {
    private ArticleService articleService;

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Operation(summary = "查询")
    @GetMapping("/{id}")
    public ResultVO<Article> findById(@PathVariable("id") Integer id) {
        return new ResultVO<>(ResultVOEnum.SUCCESS, articleService.findById(id).orElse(null));
    }

    @Operation(summary = "查询全部")
    @GetMapping("/all")
    public ResultVO<List<Article>> findAll() {
        return new ResultVO<>(ResultVOEnum.SUCCESS, articleService.findAll());
    }

    @Operation(summary = "删除")
    @DeleteMapping("/{id}")
    public ResultVO<Integer> delete(@PathVariable("id") Integer id) {
        articleService.deleteById(id);
        return new ResultVO<>(ResultVOEnum.SUCCESS, id);
    }

    @Operation(summary = "修改")
    @PutMapping("/modify")
    public ResultVO<Article> modify(@RequestBody Article article) {
        return new ResultVO<>(ResultVOEnum.SUCCESS, articleService.save(article));
    }

    @Operation(summary = "添加")
    @PostMapping("/add")
    public ResultVO<Article> add(@RequestBody Article article) {
        return new ResultVO<>(ResultVOEnum.SUCCESS, articleService.add(article));

    }

}
