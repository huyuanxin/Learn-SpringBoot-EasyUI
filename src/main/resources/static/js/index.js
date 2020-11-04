

function loadData() {
    $('#dg').datagrid({
        url:"/EasyUI/getUser",
        method: "GET",
        pageSize:10,
        pageNumber:1,
        pageList:[10,20,50],
        columns: [
            [
                {
                    field: 'Uid',
                    title: 'Uid',
                    width: 100,
                    formatter: function (value, row, index) {
                        return row.Uid
                    }
                },
                {
                    field: 'UserName',
                    title: '姓名',
                    width: 100,
                    formatter: function (value, row, index) {
                        return row.UserName
                    }
                },
                {
                    field: 'Password',
                    title: '密码',
                    width: 100,
                    align: 'right',
                    formatter: function (value, row, index) {
                        return row.Password
                    }
                },
                {
                    title: "操作",
                    field:'_operate',
                    formatter:function (value, row, index) {
                        const rowIndex = index + 1;
                        return '<Button onclick="deleteUser('+rowIndex+')">删除</Button>'
                    }
                }
            ]
        ],
        pagination: true,
    });
}

function deleteUser(index){
    var row = $('#dg').datagrid('getData').rows[index-1];
    $.messager.confirm('删除', '选中的信息是否删除?', function(r) {
        if(r){

            $.ajax({
                type:"Delete",
                url:"/User/deleteUserByUid?id="+row.Uid,
            })
        }
        $('#dg').datagrid('reload');
    })
}

onload = loadData
