package top.youngwind.blog.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.youngwind.blog.entity.Category;
import top.youngwind.blog.enums.ResultVOEnum;
import top.youngwind.blog.service.CategoryService;
import top.youngwind.blog.vo.ResultVO;

import java.sql.SQLException;
import java.util.List;

@Api(tags = "博客分类")
@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Operation(summary = "查询")
    @GetMapping("/{id}")
    public ResultVO<Category> findById(@PathVariable("id") Integer id) {
        return new ResultVO<>(ResultVOEnum.SUCCESS, categoryService.findById(id).orElse(null));
    }

    @Operation(summary = "查询全部")
    @GetMapping("/all")
    public ResultVO<List<Category>> findAll() {
        return new ResultVO<>(ResultVOEnum.SUCCESS, categoryService.findAll());
    }

    @RequiresPermissions("删除")
    @Operation(summary = "删除")
    @DeleteMapping("/{id}")
    public ResultVO<Integer> delete(@PathVariable("id") Integer id) {
        categoryService.deleteById(id);
        return new ResultVO<>(ResultVOEnum.SUCCESS, id);
    }

    @RequiresPermissions("修改")
    @Operation(summary = "修改")
    @PutMapping("/modify")
    public ResultVO<Category> modify(@RequestBody Category category) {
        return new ResultVO<>(ResultVOEnum.SUCCESS, categoryService.save(category));
    }

    @RequiresPermissions("添加")
    @Operation(summary = "添加")
    @PostMapping("/add")
    public ResultVO<Category> add(@RequestBody Category category) {
        return new ResultVO<>(ResultVOEnum.SUCCESS, categoryService.add(category));
    }


}