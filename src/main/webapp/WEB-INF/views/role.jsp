<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <script src = "http://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>Title</title>
</head>

<script>
var service ='http://localhost:8080/role';
// async:false  not use in production
var RestGetAll = function () {
    $.ajax({
        type: 'GET',
        url: service + '/all',
        dataType: 'json',
        accept: 'json',
        contentType: 'application/json;utf-8',
        async: false,
        success: function (result) {
            $('#response').html(JSON.stringify(result))
        },
        error: function (jqXHR, testStatus, errorThrown) {
            $('#response').html(JSON.stringify(jqXHR))
        }
    });
};

var RestGet = function (id) {
    $.ajax({
        type: 'GET',
        url: service + '/get/' + id,
        dataType: 'json',
        accept: 'json',
        contentType: 'application/json;utf-8',
        async: false,
        success: function (result) {
            $('#response').html(JSON.stringify(result))
        },
        error: function (jqXHR, testStatus, errorThrown) {
            $('#response').html(JSON.stringify(jqXHR))
        }
    });
};

var RestPost = function (name, description) {
    var JSONObject = {
        'name': name,
        'description': description
    };
    $.ajax({
        type: 'POST',
        url: service + '/add/',
        dataType: 'json',
        data: JSON.stringify(JSONObject),
        accept: 'json',
        contentType: 'application/json;utf-8',
        async: false,
        success: function (result) {
            $('#response').html(JSON.stringify(result))
        },
        error: function (jqXHR, testStatus, errorThrown) {
            $('#response').html(JSON.stringify(jqXHR))
        }
    });
};

var RestDelete = function (id) {
    $.ajax({
        type: 'DELETE',
        url: service + '/delete/' + id,
        dataType: 'json',
        accept: 'json',
        contentType: 'application/json;utf-8',
        async: false,
        success: function (result) {
            $('#response').html(JSON.stringify(result))
        },
        error: function (jqXHR, testStatus, errorThrown) {
            $('#response').html(JSON.stringify(jqXHR))
        }
    });
};

var RestPut = function (id, name, description) {
    var JSONObject = {
        'id': id,
        'name': name,
        'description': description
    };
    $.ajax({
        type: 'PUT',
        url: service + '/update/',
        dataType: 'json',
        data: JSON.stringify(JSONObject),
        accept: 'json',
        contentType: 'application/json;utf-8',
        async: false,
        success: function (result) {
            $('#response').html(JSON.stringify(result))
        },
        error: function (jqXHR, testStatus, errorThrown) {
            $('#response').html(JSON.stringify(jqXHR))
        }
    });
};

</script>

<body>
<h1>Horse API</h1>
<!--"table" in bootstrap.min.css-->
<table class="table">
    <tr>
        <th>Request Type</th>
        <th>URL</th>
        <th>Value</th>
    </tr>
    <tr>
        <td>Get all horses - <code><strong>GET</strong></code></td>
        <td>/horse/all</td>
        <td>
            <button type="button" onClick="RestGetAll()">try</button>
        </td>
    </tr>
    <tr>
        <td>Get horse by id - <code><strong>GET</strong></code></td>
        <td>/horse/get/id</td>
        <td>
            id: <input id="getRoleId" value="1"/>
            <button type="button" onClick="RestGet($('#getRoleId').val())">try</button>
        </td>
    </tr>
    <tr>
        <td>Add new horse - <code><strong>POST</strong></code></td>
        <td>/horse/add</td>
        <td>
            name: <input id="roleNameForAdd" value=""/>
            description: <input id="roleDescForAdd" value=""/>
            <button type="button" onClick="RestPost($('#roleNameForAdd').val(), $('#roleDescForAdd').val())">try</button>
        </td>
    </tr>
    <tr>
        <td>Delete horse by id - <code><strong>DELETE</strong></code></td>
        <td>/horse/delete/id</td>
        <td>
            id: <input id="deleteRoleId" value="1"/>
            <button type="button" onClick="RestDelete($('#deleteRoleId').val())">try</button>
        </td>
    </tr>
    <tr>
        <td>update horse - <code><strong>PUT</strong></code></td>
        <td>/horse/update</td>
        <td>
            id: <input id="roleIdForUpdate" value=""/>
            name: <input id="roleNameForUpdate" value=""/>
            description: <input id="roleDescForUpdate" value=""/>
            <button type="button" onClick="RestPut($('#roleIdForUpdate').val(), $('#roleNameForUpdate').val(), $('#roleDescForUpdate').val())">try</button>
        </td>
    </tr>
</table>
<div class="panel-default">
    <div class="page-heading">
        <strong>RESPONSE</strong>
    </div>
    <div class="panel-body" id="response"> <!--#response in ajax-->
    </div>
</div>
</body>
</html>
