<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>차트 파일 업로드</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"
         integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
         crossorigin="anonymous"></script>
<style type="text/css">
body {
    width: 1000px;
    height: 1000px;
}

.table-rows {
	width: 100%;
	height: 100%;
}

table {
    margin: auto;
    border-collapse: collapse;
    border: 1px solid black;
}

input {
    width: 100%;
}
</style>

<script>
function formReset() {
    document.getElementById("form-id").reset();
}

function formChk() {
    let title = document.getElementById("title").value;
    if(title == "") {
        alert("제목을 입력해주세요");
        return false;
    }
    
    let content = document.getElementById("content").value;
    if(content == "") {
        alert("내용을 입력해주세요");
        return false;
    }
    
    let files = document.getElementsByName("files")[0].files;
    if(files.length == 0) {
    	alert("첨부파일을 업로드해주세요.");
        return false;
    }
    
    document.getElementById("form-id").submit();
}
</script>
</head>
<body>

<div class="table-rows">
    <form action="/chart/pie" method="post" enctype="multipart/form-data" id="form-id">
        <table>
            <caption>글 쓰 기</caption>
            <colgroup>
                <col width="10%">
                <col width="90%">
            </colgroup>
            <tr>
                <th>Title</th>
                <td><input type="text" name="title" id="title"></td>
            </tr>
            <tr>
                <th>Content</th>
                <td><textarea name="content" id="content" rows="10" cols="100"></textarea></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center;">
                    <input type="file" name="files" id="files" multiple="multiple">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div style="float: right;">
                        <button type="button" onclick="formReset();">취소</button>
                        <button type="button" onclick="formChk();">저장</button>
                    </div>
                </td>
            </tr>
        </table>
    </form>
</div>


</body>
</html>