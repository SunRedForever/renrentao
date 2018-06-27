//JavaScript代码区域
layui.use(['element', 'upload', 'table'], function () {
    var element = layui.element,
        $ = layui.jquery,
        upload = layui.upload,
        table = layui.table;

    //指定允许上传的文件类型
    upload.render({
        elem: '#coupon_xls'
        , url: '/admin/product/import'
        , exts: 'xls|xlsx'
        , accept: 'file' //普通文件
        , done: function (res) {
            console.log(res)
        }
    });


    //第一个实例
    table.render({
        elem: '#product'
        , height: 700
        , url: '/product/findPageList' //数据接口
        , page: true //开启分页
        , limit: 15
        , limits: [15, 30, 45, 60, 75, 90, 100]
        , cols: [[ //表头
            {field: 'productId', title: 'ID', sort: true}
            , {field: 'productName', title: '商品名称'}
            , {
                field: 'productImgAddress',
                title: '商品略缩图',
                templet: '<div><img src="{{d.productImgAddress}}"></div>',
                style: 'height:48px;width:48px;line-height:48px!important;'
            }
            , {field: 'productCategory', title: '商品分类'}
            , {field: 'productPrice', title: '商品价格', sort: true}
            , {field: 'productSellerWangwang', title: '商品店铺名'}
            , {field: 'discountCouponSum', title: '优惠卷详情', sort: true}
            , {field: 'productRate', title: '佣金', sort: true}
            , {field: 'discountCouponStartTime', title: '开始日期', sort: true}
            , {field: 'discountCouponOverTime', title: '结束日期', sort: true}
        ]]
    });

});