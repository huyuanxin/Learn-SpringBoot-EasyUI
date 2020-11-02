function loadData(){
    $('#dg').datagrid({
        url:'/User/getAllUser',
        columns:[[
            {field:'Uid',title:'Uid',width:100},
            {field:'UserName',title:'姓名',width:100},
            {field:'Password',title:'密码',width:100,align:'right'}
        ]]
    });
}

function reloadData(){
    $('#dg').datagrid('reload');
}

onload=loadData
