<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%-- <%@ include file="/WEB-INF/views/layout/header.jsp" %> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>board</title>
<script src="https://cdn.ckeditor.com/ckeditor5/18.0.0/classic/ckeditor.js"></script>
<!-- <script src="//cdn.ckeditor.com/4.14.0/standard/ckeditor.js"></script> -->
<script type="text/javascript">
	$(document).on('click', '#btnSave', function(e) {
			e.preventDefault();
			$("#form").submit();
		});

	$(document).on('click', '#btnList', function(e) {
			e.preventDefault();
			location.href = "${pageContext.request.contextPath}/board/getBoardList";
		});
	$(document).ready(function() {
			var mode = '<c:out value="${mode}" />';
			if (mode == 'edit') {
					//입력 폼 셋팅
					$("#reg_id").prop('readonly', true);
					$("input:hidden[name='bid']").val('<c:out value="${boardContent.bid}"/>');
					$("input:hidden[name='mode']").val('<c:out value="${mode}" />');
					$("#reg_id").val('<c:out value="${boardContent.reg_id}" />');
					$("#title").val('<c:out value="${boardContent.title}" />' );
					$("#content").val('<c:out value="${boardContent.content}" />');
					$('#tag').val('<c:out value="${boardContent.tag}" />');
				}
		});
</script>
</head>
<body>
	<article>
		<div class="container" role="main">
			<h2>board Form</h2>
			<form:form action="${pageContext.request.contextPath }/board/saveBoard" name="form" id="form" method="post"
				modelAttribute="boardVO">
				<form:hidden path="bid"/>
				<input type="hidden" name="mode" />
				
				<div class="mb-3">
					<label for="title">제목</label>
					<form:input path="title" type="text" class="form-control" id="title" placeholder="제목을 입력해주세요" />
				</div>
				
				<div class="mb-3">
					<label for="reg_id">작성자</label>
					<form:input path="reg_id" type="text" class="form-control" id="reg_id" placeholder="이름을 입력해주세요" />
				</div>
				
				<div class="mb-3">
					<label for="content">내용</label>
					<%-- <form:input path="content" type="text" class="form-control" id="content" placeholder="내용을 입력해주세요" /> --%>
					<textarea name="content" id="content"></textarea>
				</div>
				
				<div class="mb-3">
					<label for="tag">TAG</label>
					<form:input path="tag" type="text" class="form-control" id="tag" placeholder="태그를 입력해주세요" />
				</div>
			</form:form>
			<div>
				<button type="button" class="btn btn-sm btn-primary" id="btnSave">저장</button>
				<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
			</div>
		</div>
	</article>
</body>
<script src="${pageContext.request.contextPath}/resources/common/js/ckeditor.js"></script>
</html>