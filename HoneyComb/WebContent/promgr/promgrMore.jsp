<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE >

<html>
<head>
<title>promgr more</title>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script>
	
/* $(function() {
	
	 $('#chkList_lab').click(function(){
		
		if($('#chkList_lab').) {
			$('#chklist_lab').css("display", "none");
			$('#chkList_modText').css("display", "");
			$('#chkList_modBtn').css("display", "");
			$('#chkList_delBtn').css("display", "");
			$('#exit_list').css("display", "");
		}
		
	});
	 
	$(document).click(function(){
			
		if($('#chkList_lab').css("display") == "none") {
			$('#chkList_lab').css("display", "");
			$('#chkList_modText').css("display", "none");				
			$('#chkList_modBtn').css("display", "none");
			$('#chkList_delBtn').css("display", "none");
			$('#exit_list').css("display", "none");
		}
		
	});
	 
}); */


	function hidden_input(lab, text, modbtn, delbtn, exit) { // 수정, 삭제
		
		if(document.getElementById(lab).hidden == false ) {
			document.getElementById(lab).hidden = true;
			document.getElementById(text).hidden = false;
			document.getElementById(modbtn).hidden = false;
			document.getElementById(delbtn).hidden = false;
			document.getElementById(exit).hidden = false;
		}
	
	}
	
	function appear_input(lab, text, modbtn, delbtn, exit) { // 수정, 삭제
		
		if(document.getElementById(lab).hidden == true ) {
			document.getElementById(lab).hidden = false;
			document.getElementById(text).hidden = true;
			document.getElementById(modbtn).hidden = true;
			document.getElementById(delbtn).hidden = true;
			document.getElementById(exit).hidden = true;
		} 
	
	}

	function addProject() { // project 생성
		url = "/HoneyComb/promgr/promgrAddForm.promgr";
		window
				.open(
						url,
						"post",
						"toolbar=no ,width=550 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");
	}
	
	function delProject(promgr_num) { // 프로젝트 삭제
			
			url = "/HoneyComb/promgr/promgrDel.promgr?promgr_num="+promgr_num;
			window
					.open(
							url,
							"post",
							"toolbar=no ,width=1 ,height=1,directories=no,status=yes,scrollbars=no,menubar=no");
	}
	
	function memberEditor(promgr_num) { // 참여자 관리
		url = "/HoneyComb/promgr/promgrMemberEditorForm.promgr?mem_num="+${my_mem_num}+"&promgr_num="+promgr_num;
		window
				.open(
						url,
						"post",
						"toolbar=no ,width=550 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");
	}
	
	function AddChkList(promgr_num) { // checklist 생성
		url = "/HoneyComb/promgr/PromgrChkListAddForm.promgr?promgr_num="+promgr_num;
		window
				.open(
						url,
						"post",
						"toolbar=no ,width=450 ,height=80,directories=no,status=yes,scrollbars=yes,menubar=no");
	}
	
	function ModChkList(promgr_num, title_num) { // checklist명 수정
		url = "/HoneyComb/promgr/PromgrChkListMod.promgr?promgr_num="+promgr_num+"&chklist_title="+title_num;
		window
				.open(
						url,
						"post",
						"toolbar=no ,width=1 ,height=1,directories=no,status=yes,scrollbars=no,menubar=no");
	}
	
	function DelChkList(promgr_num, title_num) { // checklist 삭제
		url = "/HoneyComb/promgr/PromgrChkListDel.promgr?promgr_num="+promgr_num+"&chklist_title="+title_num;
		window
				.open(
						url,
						"post",
						"toolbar=no ,width=1 ,height=1,directories=no,status=yes,scrollbars=no,menubar=no");
	}
	
	function AddItem(promgr_num, title_num) { // checkitem 생성
		
		url = "/HoneyComb/promgr/PromgrChkListAddItemForm.promgr?promgr_num="+promgr_num+"&chklist_title="+title_num;
		window
				.open(
						url,
						"post",
						"toolbar=no ,width=450 ,height=80,directories=no,status=yes,scrollbars=yes,menubar=no");
	}
	
	function ModItem(promgr_num, item_num) { // checkitem명 수정
		
		url = "/HoneyComb/promgr/PromgrChkListDelItem.promgr?promgr_num="+promgr_num+"&chklist_item="+item_num;
		window
				.open(
						url,
						"post",
						"toolbar=no,width=1,height=1,directories=no,status=yes,scrollbars=no,menubar=no");
	}
	
	function DelItem(promgr_num, item_num) { // checkitem 삭제
		
		url = "/HoneyComb/promgr/PromgrChkListDelItem.promgr?promgr_num="+promgr_num+"&chklist_item="+item_num;
		window
				.open(
						url,
						"post",
						"toolbar=no,width=1,height=1,directories=no,status=yes,scrollbars=no,menubar=no");
	}
	function cloudInsert(promgr_num){
		url = "/HoneyComb/cloudview/uploadForm.jsp?promgr_num="+promgr_num;
		window.open(url,
				"post",
				"toolbar=no ,width=450 ,height=80,directories=no,status=yes,scrollbars=yes,menubar=no");
	}
	
	
	
</script>

<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

dl {
	width: 750px;
	margin: 50px auto;
}

dl dt {
	background: #7CADB6;
	border-bottom: 1px solid #FFFFFF;
	cursor: pointer;
}

dl dd {
	border: 1px solid #7CADB6;
	border-top: none;
	height: 300px;
	overflow-y: scroll;
}

#content {
	float: center;
	height: 70%;
}

#content_view {
	width: 75%;
	float: left;
	text-align: left;
	float: left;
	float: left;
}

#content_editor {
	width: 25%;
	float: right;
}

#content_comment {
	height: 30%;
}
</style>

</head>
<body>

	<div align="center">

		<b>프로젝트 목록 (전체 프로젝트 : ${promgr_count})</b>

		<div align="right">
			<a onclick="addProject()">프로젝트 생성</a>
		</div>

		<c:if test="${promgr_count == 0}">
			<div align="center">프로젝트가 없습니다.</div>
		</c:if>

		<c:if test="${promgr_count > 0}">

			<div id="container" align="center">

				<dl>

					<!-- 프로젝트 전체 리스트 -->
					<c:forEach var="article" items="${articleList}">

						<dt>
							<div>
								프로젝트 명 : ${article.promgr_name} (${article.promgr_num}) <input
									type="button" value="del"
									onclick="delProject(${article.promgr_num})" />
							</div>

						</dt>

						<dd>
							<div id="content">

								<div id="content_view">
									<div>
										참여자 :
										<c:forEach var="mem_name" items="${article.mem_name_arr}">
													${mem_name}
												</c:forEach>

									</div>
									<div>시작일 : ${article.promgr_date}</div>
									<div>내용 : ${article.promgr_content}</div>
									<div>

										<c:forEach var="view" items="${article.chklist_view}">

											<div id="${view.title_num}">

												<div>
												
													<%-- <label id="chkList_lab">${view.title_name}(${view.title_num})</label>
													<input type="text" id="chkList_modText" value="${view.title_name}"/>
													<input type="button" id="chkList_modBtn" value="modList"
														onclick="ModChkList(${article.promgr_num}, ${view.title_num})">
													<input type="button" id="chkList_delBtn" value="deList"
														onclick="DelChkList(${article.promgr_num}, ${view.title_num})">
													<input type="button" id="exit_list" value="X"> --%>
												
													<label id="chkList_lab_${view.title_num}"
														onclick="hidden_input('chkList_lab_${view.title_num}', 'chkList_modText_${view.title_num}', 'chkList_modBtn_${view.title_num}', 'chkList_delBtn_${view.title_num}', 'exit_list_${view.title_num}')">${view.title_name}(${view.title_num})</label>
													<input type="text" id="chkList_modText_${view.title_num}" value="${view.title_name}" hidden="true" />
													<input type="button" id="chkList_modBtn_${view.title_num}" value="modList"
														onclick="ModChkList(${article.promgr_num}, ${view.title_num})" hidden="true">
													<input type="button" id="chkList_delBtn_${view.title_num}" value="deList"
														onclick="DelChkList(${article.promgr_num}, ${view.title_num})" hidden="true">
													<input type="button" id="exit_list_${view.title_num}" value="X"
														onclick="appear_input('chkList_lab_${view.title_num}', 'chkList_modText_${view.title_num}', 'chkList_modBtn_${view.title_num}', 'chkList_delBtn_${view.title_num}', 'exit_list_${view.title_num}')" hidden="true">
												
												</div>

												<div>[진행상황 그래프]</div>

												<form method="post" name="chkItemform"
													action="/HoneyComb/promgr/PromgrChkListAddItemAction.promgr?promgr_num=${article.promgr_num}&chklist_title=${view.title_name}"
													onsubmit="return writeSave()">

													<c:forEach var="bean" items="${view.item_bean}">
														<div>
															<input type="checkbox" name="chkitem" value="${bean.item_num}" />
															
															<label id="chkItem_lab_${bean.item_num}"
																onclick="hidden_input('chkItem_lab_${bean.item_num}', 'chkItem_modText_${bean.item_num}', 'chkItem_modBtn_${bean.item_num}', 'chkItem_delBtn_${bean.item_num}', 'exit_item_${bean.item_num}')">${bean.item_name}(${bean.item_num})</label>
															
															<input type="text" id="chkItem_modText_${bean.item_num}" value="${bean.item_name}" hidden="true" />
															
															<input type="button" id="chkItem_modBtn_${bean.item_num}" value="modItem"
																onclick="ModItem(${article.promgr_num}, ${bean.item_num})" hidden="true">
															
															<input type="button" id="chkItem_delBtn_${bean.item_num}" value="delItem"
																onclick="DelItem(${article.promgr_num}, ${bean.item_num})" hidden="true">
															
															<input type="button" id="exit_item_${bean.item_num}" value="X"
															onclick="appear_input('chkItem_lab_${bean.item_num}', 'chkItem_modText_${bean.item_num}', 'chkItem_modBtn_${bean.item_num}', 'chkItem_delBtn_${bean.item_num}', 'exit_item_${bean.item_num}')" hidden="true">
														</div>
													</c:forEach>

												</form>

												<input type="button" value="add item"
													onclick="AddItem(${article.promgr_num}, ${view.title_num})" />

											</div>

										</c:forEach>

									</div>

								</div>

								<div id="content_editor">
									<input type="button" value="member"
										onclick="memberEditor(${article.promgr_num})" /> <br /> <input
										type="button" value="checklist"
										onclick="AddChkList(${article.promgr_num})" /> <br /> <input
										type="button" value="file" onclick="cloudInsert(${article.promgr_num})"/>
								</div>
								
							</div>

							<div id="content_comment">[comment]</div>

						</dd>

					</c:forEach>
				</dl>
			</div>

		</c:if>

		<c:if test="${promgr_count > 0}">

			<c:set var="pageCount"
				value="${promgr_count / pageSize + ( promgr_count % pageSize == 0 ? 0 : 1)}" />

			<fmt:parseNumber var="result" value="${currentPage / pageSize}"
				integerOnly="true" />

			<c:set var="startPage" value="${result * pageSize + 1}" />

			<c:set var="endPage" value="${startPage + pageSize - 1}" />

			<c:if test="${endPage > pageCount}">
				<c:set var="endPage" value="${pageCount}" />
			</c:if>

			<c:if test="${startPage > pageSize}">
				<a
					href="/HoneyComb/promgr/promgrMore.promgr?pageNum=${startPage - pageSize}">[이전]</a>
			</c:if>

			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<a href="/HoneyComb/promgr/promgrMore.promgr?pageNum=${i}">[${i}]</a>
			</c:forEach>

			<c:if test="${endPage < pageCount}">
				<a
					href="/HoneyComb/promgr/promgrMore.promgr?pageNum=${startPage + pageSize}">[다음]</a>
			</c:if>

		</c:if>

	</div>

</body>
</html>