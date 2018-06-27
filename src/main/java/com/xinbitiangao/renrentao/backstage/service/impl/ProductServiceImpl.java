package com.xinbitiangao.renrentao.backstage.service.impl;

import com.xinbitiangao.renrentao.common.utils.PageLayuiTableVO;
import com.xinbitiangao.renrentao.common.entity.ProductEntity;
import com.xinbitiangao.renrentao.common.repository.ProductRepository;
import com.xinbitiangao.renrentao.backstage.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 商品实现类
 * Created by 黄大胖子
 * 2018/5/6 20:24
 */
@Service
@Transactional(readOnly = true)
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    /**
     * 分页查询列表
     *
     * @param page
     * @param limit
     * @return
     */
    public PageLayuiTableVO<ProductEntity> findPageList(Integer page, Integer limit) {
        Pageable pageable = new PageRequest(page, limit);
        List<ProductEntity> pes = productRepository.findAll(pageable).getContent();
        long count = productRepository.count();
        PageLayuiTableVO<ProductEntity> pltvo = new PageLayuiTableVO<ProductEntity>().setCode(0).setMsg("加载成功！").setCount(count).setData(pes);
        return pltvo;
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void productImport(MultipartFile file) throws Exception {
        //Excel文件
        HSSFWorkbook book = new HSSFWorkbook(file.getInputStream());
        //  文件里第几个选项卡
        HSSFSheet sheet = book.getSheetAt(0);
        //循环每一行
        for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
            HSSFRow row = sheet.getRow(i);

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            String productId = row.getCell(0).getStringCellValue();
            String productName = row.getCell(1).getStringCellValue();
            String productImgAddress = row.getCell(2).getStringCellValue();
            String productDetailsAddress = row.getCell(3).getStringCellValue();
            String productCategory = row.getCell(4).getStringCellValue();
            String productTaokeAddress = row.getCell(5).getStringCellValue();
            BigDecimal productPrice = new BigDecimal(row.getCell(6).getStringCellValue());
            int productSales = Integer.valueOf(row.getCell(7).getStringCellValue());
            double productRate = Double.valueOf(row.getCell(8).getStringCellValue());
            BigDecimal productRbrokerage = new BigDecimal(row.getCell(9).getStringCellValue());
            String productSellerWangwang = row.getCell(10).getStringCellValue();
            String productSellerId = row.getCell(11).getStringCellValue();
            String productSellerShopName = row.getCell(12).getStringCellValue();
            String platform = row.getCell(13).getStringCellValue();
            String discountCouponId = row.getCell(14).getStringCellValue();
            int discountCouponGross = Integer.valueOf(row.getCell(15).getStringCellValue());
            int discountCouponResidue = Integer.valueOf(row.getCell(16).getStringCellValue());
            String discountCouponSum = row.getCell(17).getStringCellValue();
            Date discountCouponStartTime = df.parse(row.getCell(18).getStringCellValue());
            Date discountCouponOverTime = df.parse(row.getCell(19).getStringCellValue());
            String discountCouponAddress = row.getCell(20).getStringCellValue();
            String productDiscountCouponAddress = row.getCell(21).getStringCellValue();

            ProductEntity productEntity = new ProductEntity().setProductId(productId).setProductName(productName)
                    .setProductImgAddress(productImgAddress).setProductDetailsAddress(productDetailsAddress).setProductCategory(productCategory)
                    .setProductTaokeAddress(productTaokeAddress).setProductPrice(productPrice).setProductSales(productSales).setProductRate(productRate)
                    .setProductRbrokerage(productRbrokerage).setProductSellerWangwang(productSellerWangwang).setProductSellerId(productSellerId)
                    .setProductSellerShopName(productSellerShopName).setPlatform(platform).setDiscountCouponId(discountCouponId).setDiscountCouponGross(discountCouponGross)
                    .setDiscountCouponResidue(discountCouponResidue).setDiscountCouponSum(discountCouponSum).setDiscountCouponStartTime(discountCouponStartTime)
                    .setDiscountCouponOverTime(discountCouponOverTime).setDiscountCouponAddress(discountCouponAddress).setProductDiscountCouponAddress(productDiscountCouponAddress);
            ProductEntity save = productRepository.save(productEntity);
            log.info("【一键导入】{}", save);
        }

    }
}