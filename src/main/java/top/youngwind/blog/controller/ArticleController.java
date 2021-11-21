package top.youngwind.blog.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
@CrossOrigin(origins = "*")
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
    public ResultVO<Article> add(@RequestBody Article article, @RequestParam(value = "categoryId", required = false) Integer categoryId) {
        System.out.println("categoryId"+categoryId);
        System.out.println(article.toString());
        return new ResultVO<>(ResultVOEnum.SUCCESS, articleService.add(article, categoryId));
    }

    @Operation(summary = "根据分类Id查询其下的所有文章")
    @GetMapping("/category/{categoryId}")
    public ResultVO<List<Article>> findCategoryId(@PathVariable("categoryId") Integer categoryId) {
        return new ResultVO<>(ResultVOEnum.SUCCESS, articleService.findAllByCategoryId(categoryId));
    }
}