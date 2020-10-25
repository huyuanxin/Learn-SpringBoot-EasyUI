# 元鑫的SSM学习项目 CURD

## 完成度
* [x] CURD HTTP REQUEST
* [x] Multi CURD HTTP REQUEST 

## 请求方式:请使用请求工具进行请求
    getAllUser:
        GET : http://localhost:8080/User/getAllUser
        
    getUserByUid:
        GET : http://localhost:8080/User/getUserByUid?id=value value(long)
        
    getUserNameByUid:
        GET : http://localhost:8080/User/getUserNameByUid?id=value value(long)
    
    deleteUserByUid:
        DELETE : http://localhost:8080/User/deleteUserByUid?id=value value(long)
        
    updateUserByRequestParam:
        PUT : http://localhost:8080/User/deleteUserByUid?id=value0&username=value1&password=value2 value0(long) value1&value2(String)
        
    addNewUserByRequestParam:
        POST : http://localhost:8080/User/addNewUserByRequestParam?username=value0&password=value1 value0&value1(String)

### 以下均为RequestBody

#### Headers :

| Key          | Value        |
| ------------ | ------------ |
| Content-Type | Content-Type |



updateUserByRequestBody
    PUT : http://localhost:8080/User/updateUserByRequestBody
	Body:

```json
// return 0
{
    "UserName":"value",
    "Password":"value"
}

// return 0
{
    "UserName":"value"
}

// return 0
{
    "Password":"value"
}

// return 0
{
    
}

// return 1
{
    "Uid":7,
    "UserName":"value",
    "Password":"value"
}

// return 1
{
    "Uid":7,
    "UserName":"value"
}

// return 1
{
    "Uid":7,
    "Password":"value"
}

```



addNewUserByRequestBody
    POST : http://localhost:8080/User/addNewUserByRequestBody

​	Body:

```json
// return 0
{
    "UserName":"value"
}

// return 0
{
    "Password":"value"
}

// return 0
{
    
}

// return 1
{
    "UserName":"value",
    "Password":"value"
}
```



insetMultiUser
    POST : http://localhost:8080/User/insetMultiUser

​	Body:

```json
// return 0
[
    {
        "UserName":"123"
    }
]

// return 0
[
    {
        "Password":"123"
    }
]

// return 0
[
    
]

// return 1
[
    {
        "UserName":"value"
    },
    {
        "UserName":"value",
        "Password":"value"
    }
]

// return 1
[
    {
        "Password":"value"
    },
    {
        "UserName":"value",
        "Password":"value"
    }
]

// return 2
[
    {
        "UserName":"value",
        "Password":"value"
    },
    {
        "UserName":"value",
        "Password":"value"
    }
]
```



deleteMultiUserByUid
    DELETE : http://localhost:8080/User/deleteMultiUserByUid

​	DataBase:

| Uid  | UserName | Password |
| ---- | -------- | -------- |
| 1    | line1    | line1    |
| 2    | line2    | line2    |

​    Body:

```json
// return 0
[
    -1,0
]

// return 0
[
    3,4
]

// return 1
[
    1,3
]

// return 1
[
    2,3
]

// return 2
[
    1,2
]
```


​        

updateMultiUser:

​	PUT :  http://localhost:8080/User/updateMultiUser

​	DataBase:

| Uid  | UserName | Password |
| ---- | -------- | -------- |
| 1    | line1    | line1    |
| 2    | line2    | line2    |



​	Body:

```json
// return 0
[
    {
        "Uid":3
    }
]

// return 0
[
    {
        "Uid":1
    }
]

// return 0
[
    {

    }
]

// return 0
[
    {
        "UserName":"value"
    }
]

// return 0
[
    {
        "Password":"value"
    }
]

//return 0
[
    {
        "Uid":3,
        "UserName":"value"
    }
]

// return 0
[
    {
        "Uid":3,
        "UserName":"value"
    }
]

// return 1
[
    {
        "Uid":1,
        "UserName":"value"
    }
]

// return 1
[
    {
        "Uid":1,
        "Password":"value"
    }
]

// return 1
[
    {
        "Uid":1,
        "Password":"value"
    },
    {
        "Uid":1,
        "Password":"value"
    }
]

// return 1
[
    {
        "Uid":1,
        "Password":"value"
    },
    {
        "Uid":2,
        "Password":"value"
    }
]

// return 1
[
    {
        "Uid":1,
        "UserName":"value",
        "Password":"value"
    },
    {
        "Uid":2,
        "UserName":"value",
        "Password":"value"
    }
]
```

