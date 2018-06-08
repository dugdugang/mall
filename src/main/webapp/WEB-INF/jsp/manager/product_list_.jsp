<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <!--[if lt IE 9]>
    <script type="text/javascript" src="../../../manager/lib/html5shiv.js"></script>
    <script type="text/javascript" src="../../../manager/lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="../../../manager/static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="../../../manager/static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css" href="../../../manager/lib/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="../../../manager/static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="../../../manager/static/h-ui.admin/css/style.css"/>
    <!--[if IE 6]>
    <script type="text/javascript" src="../../../manager/lib/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>商品列表</title>

    <script>
        $(function () {
            alert("ssss");
        })
    </script>
</head>
<body>

<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 商品管理 <span
        class="c-gray en">&gt;</span> 商品列表(${pageinfo.total}) <a class="btn btn-success radius r"
                                                                 style="line-height:1.6em;margin-top:3px"
                                                                 href="javascript:location.replace(location.href);"
                                                                 title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i></a></nav>
<form action="/products" method="post">
    <div class="page-container">
        <div>
            <%--<button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button>--%>
            <span class="l"><a href="javascript:;" onclick="datadel()"
                               class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 删除</a> <a
                    class="btn btn-primary radius" data-title="添加" data-href="article-add.html"
                    onclick="Hui_admin_tab(this)"
                    href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加</a></span>
            <span style="margin-left: 5px">显示</span>
            <span class="select-box inline">

		<select name="rows" class="select">
			<option value="0">10</option>
			<option value="1">25</option>
			<option value="2">50</option>
            <option value="3">100</option>

		</select>
		</span>
            <span>条</span>
            <span class="select-box inline">
		<select name="classify" class="select">
			<option value="0">商品筛选</option>
			<option value="1">分类一</option>
			<option value="2">分类二</option>
		</select>
		</span>
            <span style="flort: right">
                <input type="text" name="" id="" placeholder=" " style="width:250px" class="input-text">
        <button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i></button>
            </span>

        </div>

        <div class="mt-20">
            <table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
                <thead>
                <tr class="text-c">
                    <th width="25"><input type="checkbox" name="" value=""></th>
                    <th width="80">编号</th>
                    <th>名称</th>
                    <th width="80">商品分类</th>
                    <th width="80">销售价</th>
                    <th width="120">成本价</th>
                    <th width="75">库存</th>
                    <th width="60">是否上架</th>
                    <th width="120">创建日期</th>
                    <th width="120">操作</th>
                </tr>
                </thead>

                <tbody>

                <c:forEach items="${pageinfo.list}" var="product">
                    <tr class="text-c">
                        <td><input type="checkbox" value="" name=""></td>
                        <td>${product.sn}</td>
                        <td>${product.name}</td>
                        <td>${product.categoryName}</td>
                        <td>${product.marketPrice}</td>
                        <td>${product.price}</td>
                        <td>${product.scoreCount}</td>
                        <td>${product.isTop}</td>
                        <td><fmt:formatDate value="${product.createDate}" type="both"></fmt:formatDate></td>
                        <td class="f-14 td-manage"><a style="text-decoration:none"
                                                      class="ml-5"
                                                      onClick="article_edit('编辑','article-add.html','10001')"
                                                      href="javascript:;"
                                                      title="编辑"><i
                                class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5"
                                                                         onClick="article_del(this,'10001')"
                                                                         href="javascript:;" title="删除"><i
                                class="Hui-iconfont">&#xe6e2;</i></a></td>

                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</form>

<div style="text-align: center">


    <a href="/products?page=0&rows=${pageinfo.pageSize}">首页</a></li>

    <li><a href="/products?page=${pageinfo.pageNum>1?pageinfo.pageNum:(pageinfo.pageNum-1)}&rows=${pageinfo.pageSize}">上一页</a>
    </li>
    <li><a href="/products?page=1&rows=${pageinfo.pageNum-2}">1</a>
    </li>

    <li><a href="/products?page=1&rows=${pageinfo.pageNum-1}">2</a></li>
    <li><a href="/products?page=1&rows=${pageinfo.pageNum}"></a>3</li>
    <li><a href="/products?page=1&rows=${pageinfo.pageNum+1}">4</a></li>
    <li><a href="/products?page=1&rows=${pageinfo.pageNum+2}">5</a></li>

    <li><a href="/products?page=1&rows=${pageinfo.pageNum<pageinfo.total?pageinfo.pageNum:pageinfo.pageNum+1}">下一页</a>
    </li>
    <li><a href="/products?page=${pageinfo.pages}&rows=${pageinfo.pageSize}">尾页</a></li>

</div>
<div class="page"></div>


<jsp:include page="footer.jsp"></jsp:include>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="../../../manager/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="../../../manager/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="../../../manager/lib/laypage/1.2/laypage.js"></script>

</body>
</html>