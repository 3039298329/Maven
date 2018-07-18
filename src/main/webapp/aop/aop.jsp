<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function(){
        //初始化表格
        $('#aop').edatagrid({
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            pagination: true,
            url:'${pageContext.request.contextPath}/aop/findAllAop',
            columns:[[
                {field:'name',title:'操作人',width:80,align:'center',editor:'text'},
                {field:'time',title:'所属时间',width:100,sortable:true,align:'center',editor:'text'},
                {field:'thing',title:'所做的操作',width:80,align:'right',align:'center',sortable:true,editor:'text'},
                {field:'result',title:'得到的结果',width:80,align:'right',align:'center',sortable:true,editor:'text'}
            ]],
        })
    });

</script>


<table id="aop" >

</table>


