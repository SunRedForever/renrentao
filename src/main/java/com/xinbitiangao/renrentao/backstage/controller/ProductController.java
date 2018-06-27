package com.xinbitiangao.renrentao.backstage.controller;

import com.xinbitiangao.renrentao.common.utils.PageLayuiTableVO;
import com.xinbitiangao.renrentao.common.entity.ProductEntity;
import com.xinbitiangao.renrentao.backstage.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品层
 * Created by 黄大胖子
 * 2018/6/21 14:33
 */
@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * 分页查询
     *
     * @return
     */
    @RequestMapping("/findPageList")
    public PageLayuiTableVO<ProductEntity> findPageList(Integer limit, Integer page) {
        return productService.findPageList(page - 1, limit);
    }

}
