function loadData() {
    $('#dg').datagrid({
        url:"/EasyUI/getUser",
        method: "GET",
        pageSize:10,
        pageNumber:1,
        pageList:[10,20,50],
        page:20,
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
                }
            ]
        ],
        pagination: true,
    });
}

onload = loadData
