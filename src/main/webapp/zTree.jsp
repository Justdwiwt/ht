<%@ page language="java" pageEncoding="UTF-8" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link rel="stylesheet" href="${ctx}/staticfile/components/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <script type="text/javascript" src="${ctx}/staticfile/components/zTree/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="${ctx}/staticfile/components/zTree/js/jquery.ztree.core-3.5.min.js"></script>
    <script type="text/javascript" src="${ctx}/staticfile/components/zTree/js/jquery.ztree.excheck-3.5.min.js"></script>
    <SCRIPT type="text/javascript">

        // zTree配置文件
        var setting = {
            check: {
                enable: true
            },
            data: {
                simpleData: {
                    enable: true
                }
            }
        };

        var zNodes = [
            {id: "1", pId: "1", name: "tom", checked: "true/false"},
            {id: "2", pId: "2", name: "tom", checked: "true/false"},
            {id: "3", pId: "2", name: "tom", checked: "true/false"},
            {id: "4", pId: "2", name: "tom", checked: "true/false"},
            {id: "5", pId: "1", name: "tom", checked: "true/false"}
        ]

        $(document).ready(function () {
            $.fn.zTree.init($("#htZtree"), setting, zNodes);

            var zTreeObj = $.fn.zTree.getZTreeObj("htZtree");
            zTreeObj.expandAll(true);		//展开所有树节点
        });


    </SCRIPT>

</head>

<body>
<h1>Ztree入门教例</h1>
<div style="padding:30px;">
    <ul id="htZtree" class="ztree"></ul>
</div>

</div>


</form>
</body>
</html>

