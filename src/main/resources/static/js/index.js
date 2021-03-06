function loadData() {
    $('#dg').datagrid({
        url: "/EasyUI/getUser",
        method: "GET",
        pageSize: 10,
        pageNumber: 1,
        pageList: [10, 20, 50],
        singleSelect: false,
        toolbar: [
            {
                text: '删除',
                iconCls: 'icon-remove',
                handler: function () {
                    deleteSelectedUser();
                }
            },
            {
                text: '添加',
                iconCls: 'icon-add',
                handler: function () {
                    addUser()
                }
            }
        ],
        columns: [
            [
                {
                    field: 'cks',
                    checkbox: true
                },
                {
                    field: 'Uid',
                    title: 'Uid',
                    width: 100,
                    formatter: function (value, row) {
                        return row.Uid
                    }
                },
                {
                    field: 'UserName',
                    title: '姓名',
                    width: 100,
                    formatter: function (value, row) {
                        return row.UserName
                    }
                },
                {
                    field: 'Password',
                    title: '密码',
                    width: 100,
                    align: 'right',
                    formatter: function (value, row) {
                        return row.Password
                    }
                },
                {
                    title: "操作",
                    field: '_operate',
                    formatter: function (value, row, index) {
                        return '<Button onclick="deleteUser(' + index + ')">删除</Button>'
                    }
                },
            ]
        ],
        pagination: true,
    });
}

function deleteUser(index) {
    var row = $('#dg').datagrid('getData').rows[index];
    $.messager.confirm('删除', '选中的信息是否删除?', function (r) {
        if (r) {

            $.ajax({
                type: "Delete",
                url: "/User/deleteUserByUid?id=" + row.Uid,
            })
        }
        $('#dg').datagrid('reload');
    })
}

function deleteSelectedUser() {
    var rows = $('#dg').datagrid('getChecked');
    var ids = [];
    if (rows.length > 0) {
        $.each(rows, function (idx, row) {
            ids.push(row.Uid);
        });
        $.messager.confirm('删除', '选中的信息是否删除?', function (r) {
            if (r) {
                $.ajax({
                    url: "/User/deleteMultiUserByUid",
                    method: "Delete",
                    dataType: "json",
                    contentType: 'application/json',
                    data: JSON.stringify(ids),
                    traditional: true,
                    success: function () {
                        $("#dg").datagrid('reload');
                    }
                })
            }
        })
    }
}

function saveUser() {
    $('#saveUserForm').form({
        url: '/User/addNewUserByRequestParam',
        onSubmit: function () {
            return $('#saveUserForm').form('validate');
        },
        success: function (data) {
            console.log(data);
            $.messager.show({
                title: '保存提示',
                msg: '保存用户信息成功',
                timeout: 5000,
                shoeType: 'slide'
            });
            $('#da').dialog('close');
            $("#dg").datagrid('reload');
        }
    });
    $('#saveUserForm').form('submit');
}

function addUser() {
    $('#da').dialog({
        width: 600,
        height: 400,
        title: '添加用户信息',
        iconCls: 'icon-man',
        href: '/saveUser',
        buttons: [
            {
                text: '保存信息',
                iconCls: 'icon-save',
                handler: function () {
                    saveUser()
                }
            },
            {
                text: '取消',
                iconCls: 'icon-cancel',
                handler: function () {
                    $('#da').dialog('close');
                }
            }]
    });
}

window.onload = function () {
    loadData()
}