<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
    <!-- Force latest IE rendering engine or ChromeFrame if installed -->
    <!--[if IE]>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <![endif]-->
    <meta charset="utf-8">
    <title>图片上传</title>
</head>
<body>
<div class="container">
    <form id="fileupload" action="${pageContext.request.contextPath}/user/uploadUserImage" method="POST" enctype="multipart/form-data">


        <table  style="font-size:14px;">
            <tr>
                <td width="100" height="30">头像：</td>
                <td height="30">
                    <input type="file" name="imagePath" multiple />
                </td>
            </tr>
            <tr>
                <td width="100" height="30">用户id</td>
                <td height="30">
                    <input type="text" name="accessKey" multiple />
                </td>
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