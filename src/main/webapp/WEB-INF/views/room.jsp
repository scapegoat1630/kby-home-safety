<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>娆㈣繋</title>
</head>
<body>
<div class="form">
    <form  action="/room/setRoomStatus">
        <table  style="font-size:14px;">
            <tr>
                <td width="100" height="30">用户名</td>
                <td height="30"><input type="text"  name="username" /></td>
            </tr>
            <tr>
                <td width="100" height="30">房间类型</td>
                <td height="30">
                    <select name="roomType">
                        <option value="1">客厅</option>
                        <option value="2">厨房</option>
                        <option value="3">卧室</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td width="100" height="30">温度：</td>
                <td height="30"><input type="text" name="temperature" /></td>
            </tr>
            <tr>
                <td width="100" height="30">湿度：</td>
                <td height="30"><input type="text"  name="humidity" /></td>
            </tr>
            <tr>
                <td width="100" height="30">烟雾浓度：</td>
                <td height="30"><input type="text"   name="smoke" /></td>
            </tr>
            <tr>
                <td width="100" height="30">是否向用户发送防盗警：</td>
                <td height="30"><input type="radio"   name="userEnteredAlarm"/></td>
            </tr>
            <tr>
                <td height="30" colspan=2 align="center">
                    <input type="reset" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="submit" />
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>