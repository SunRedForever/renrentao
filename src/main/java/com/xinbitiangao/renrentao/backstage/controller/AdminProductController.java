package com.xinbitiangao.renrentao.backstage.controller;

import com.xinbitiangao.renrentao.backstage.service.ProductService;
import com.xinbitiangao.renrentao.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by 黄大胖子
 * 2018/6/25 9:51
 */
@RestController
@RequestMapping("/admin/product")
@Slf4j
public class AdminProductController {
    @Autowired
    private ProductService productService;

    /**
     * 一键导入功能
     *
     * @return
     */
    @RequestMapping("/import")
    public R productImport(@RequestParam("file") MultipartFile file) {
        try {
            productService.productImport(file);
        } catch (Exception e) {
            return R.error();
        }
        return R.ok();
    }
}
