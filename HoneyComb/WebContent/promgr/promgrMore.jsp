<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE >

<html>
<head>
<title>promgr more</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script>

	function HiddenList(modbtn, delbtn, exit) { // 수정, 삭제

		if(document.getElementById(exit).hidden == true ) {
			document.getElementById(modbtn).hidden = false;
			document.getElementById(delbtn).hidden = false;
			document.getElementById(exit).hidden = false;
		}
	
	}
	
	function AppearList(modbtn, delbtn, exit) { // 수정, 삭제
		
		if(document.getElementById(exit).hidden == false ) {
			document.getElementById(modbtn).hidden = true;
			document.getElementById(delbtn).hidden = true;
			document.getElementById(exit).hidden = true;
		} 
	
	}
	
	function HiddenComment(session_mem_num, comment_mem_num, modbtn, delbtn, exit) { // 수정, 삭제

		if(session_mem_num == comment_mem_num) {
			
			if(document.getElementById(exit).hidden == true ) {
				document.getElementById(modbtn).hidden = false;
				document.getElementById(delbtn).hidden = false;
				document.getElementById(exit).hidden = false;
			}
			
		}
		
	}
	
	function AppearComment(session_mem_num, comment_mem_num, modbtn, delbtn, exit) { // 수정, 삭제
		
		if(session_mem_num == comment_mem_num) {
			
			if(document.getElementById(exit).hidden == false ) {
				document.getElementById(modbtn).hidden = true;
				document.getElementById(delbtn).hidden = true;
				document.getElementById(exit).hidden = true;
			} 
			
		}
	
	}
	
	function HiddenFile(session_mem_num, file_mem_num, delbtn, exit) { // 수정, 삭제
		
		if(session_mem_num == file_mem_num) {
			
			if(document.getElementById(exit).hidden == true ) {
				document.getElementById(delbtn).hidden = false;
				document.getElementById(exit).hidden = false;
			}
			
		}
		
	}
	
	function AppearFile(session_mem_num, file_mem_num, delbtn, exit) { // 수정, 삭제
		
		if(session_mem_num == file_mem_num) {
			
			if(document.getElementById(exit).hidden == false ) {
				document.getElementById(delbtn).hidden = true;
				document.getElementById(exit).hidden = true;
			} 
			
		}
	
	}
	
	function addProject() { // project 생성
		url = "/HoneyComb/promgr/promgrAddForm.promgr?";
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
		url = "/HoneyComb/promgr/promgrChkListAddForm.promgr?promgr_num="+promgr_num;
		window
				.open(
						url,
						"post",
						"toolbar=no,width=450,height=80,directories=no,status=yes,scrollbars=yes,menubar=no");
	}
	
	function ModChkList(list_num) { // checklist명 수정
		
		url = "/HoneyComb/promgr/promgrChkListModForm.promgr?list_num="+list_num;
		window
				.open(
						url,
						"post",
						"toolbar=no,width=450,height=80,directories=no,status=yes,scrollbars=no,menubar=no");
	}
	
	function DelChkList(promgr_num, list_num) { // checklist 삭제
		url = "/HoneyComb/promgr/promgrChkListDel.promgr?promgr_num="+promgr_num+"&list_num="+list_num;
		window
				.open(
						url,
						"post",
						"toolbar=no ,width=1 ,height=1,directories=no,status=yes,scrollbars=no,menubar=no");
	}
	
	function AddItem(promgr_num, list_num) { // checkitem 생성
		
		url = "/HoneyComb/promgr/promgrChkItemAddForm.promgr?promgr_num="+promgr_num+"&list_num="+list_num;
		window
				.open(
						url,
						"post",
						"toolbar=no ,width=450 ,height=80,directories=no,status=yes,scrollbars=yes,menubar=no");
	}
	
	function ModItem(item_num) { // checkitem명 수정
		
		url = "/HoneyComb/promgr/promgrChkItemModForm.promgr?item_num="+item_num;
		window
				.open(
						url,
						"post",
						"toolbar=no,width=450,height=80,directories=no,status=yes,scrollbars=no,menubar=no");
	}
	
	function DelItem(promgr_num, item_num) { // checkitem 삭제
		
		url = "/HoneyComb/promgr/promgrChkItemDel.promgr?promgr_num="+promgr_num+"&item_num="+item_num;
		window
				.open(
						url,
						"post",
						"toolbar=no,width=1,height=1,directories=no,status=yes,scrollbars=no,menubar=no");
	}
	
	function AddComment(promgr_num) { // comment 생성
		url = "/HoneyComb/promgr/promgrCommentAddForm.promgr?promgr_num="+promgr_num;
		window
				.open(
						url,
						"post",
						"toolbar=no ,width=550 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");
	}
	
	function ModComment(comment_num) { // comment 생성
		url = "/HoneyComb/promgr/promgrCommentModForm.promgr?comment_num="+comment_num;
		window
				.open(
						url,
						"post",
						"toolbar=no ,width=550 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");
	}
	
	function DelComment(promgr_num, comment_num) { // comment 삭제
		
		url = "/HoneyComb/promgr/promgrCommentDel.promgr?promgr_num="+promgr_num+"&comment_num="+comment_num;
		window
				.open(
						url,
						"post",
						"toolbar=no,width=1,height=1,directories=no,status=yes,scrollbars=no,menubar=no");
	}
	
	function ChangeCheckedItem(promgr_num, list_num, item_num){
		
		if(document.getElementById(item_num).checked == true) {
			
			url = "/HoneyComb/promgr/promgrChkItemChangeChecked.promgr?promgr_num="+promgr_num+"&list_num="+list_num+"&item_num="+item_num+"&checked=1";
			window
					.open(
							url,
							"post",
							"toolbar=no,width=1,height=1,directories=no,status=yes,scrollbars=no,menubar=no");
			
		} 
		
		if(document.getElementById(item_num).checked == false) {
			
			url = "/HoneyComb/promgr/promgrChkItemChangeChecked.promgr?promgr_num="+promgr_num+"&list_num="+list_num+"&item_num="+item_num+"&checked=0";
			window
					.open(
							url,
							"post",
							"toolbar=no,width=1,height=1,directories=no,status=yes,scrollbars=no,menubar=no");
			
		}
		
	}
	
	function AddFile(promgr_num){
		url = "/HoneyComb/cloudview/uploadForm.jsp?promgr_num="+promgr_num;
		window.open(url,
				"post",
				"toolbar=no ,width=450 ,height=80,directories=no,status=yes,scrollbars=yes,menubar=no");
	}
	
 	function DownFile(file_name, file_path){
 		document.location.href="/HoneyComb/cloud/cloudDownItem.cloud?file_name="+file_name+"&file_path="+file_path;
	}
	
	function DelFile(promgr_num, file_path){ // file 삭제
		
		url = "/HoneyComb/cloud/cloudDeleteItem.cloud?promgr_num="+promgr_num+"&file_path="+file_path;
		window
				.open(
						url,
						"post",
						"toolbar=no,width=1,height=1,directories=no,status=yes,scrollbars=no,menubar=no");
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
								
									<div id="promgr_ing">
									
										<div class="progress">
	    									<div class="progress-bar" role="progressbar" aria-valuenow="${article.promgr_ing}" aria-valuemin="0" aria-valuemax="100" style="width:${article.promgr_ing}%">
	     										 ${article.promgr_ing}%
										    </div>
										</div>
									
									</div>
									
									<div>
										참여자 :
										<c:forEach var="mem_name" items="${article.mem_name_arr}">
											${mem_name}
										</c:forEach>
									</div>
									
									<div>시작일 : ${article.promgr_date}</div>
									
									<div>내용 : ${article.promgr_content}</div>
									
									<div id="content_chklist" align="left">

										<c:forEach var="view" items="${article.chklist_view}">

											<div id="${view.list_num}">

												<div id="chklist_${view.list_num}">
												
													<label id="chkList_lab_${view.list_num}"
														ondblclick="HiddenList('chkList_modBtn_${view.list_num}', 'chkList_delBtn_${view.list_num}', 'exit_list_${view.list_num}')">${view.list_name} (${view.list_num})</label>
													
													<input type="button" id="chkList_modBtn_${view.list_num}" value="mod" 
														onclick="ModChkList(${view.list_num})" hidden="true">
													
													<input type="button" id="chkList_delBtn_${view.list_num}" value="del"
														onclick="DelChkList(${article.promgr_num}, ${view.list_num})" hidden="true">
													
													<input type="button" id="exit_list_${view.list_num}" value="X"
														onclick="AppearList('chkList_modBtn_${view.list_num}', 'chkList_delBtn_${view.list_num}', 'exit_list_${view.list_num}')" hidden="true">
												
												</div>

												<div id="chklist_ing">
												
													<div class="progress">
				    									<div class="progress-bar" role="progressbar" aria-valuenow="${view.list_ing}" aria-valuemin="0" aria-valuemax="100" style="width:${view.list_ing}%">
				     										 ${view.list_ing}%
													    </div>
													</div>
												
												</div>

												<form method="post" name="chkItemform" >

													<c:forEach var="bean" items="${view.item_bean}">
														
														<div>
															<c:if test="${bean.chklist_item_chk == 1}">
																<input type="checkbox" name="chkitem" id="${bean.chklist_item_num}"
																	onchange="ChangeCheckedItem(${article.promgr_num}, ${view.list_num}, ${bean.chklist_item_num})" checked="checked" />
															</c:if>
															
															<c:if test="${bean.chklist_item_chk == 0}">
																<input type="checkbox" name="chkitem" id="${bean.chklist_item_num}"
																	onchange="ChangeCheckedItem(${article.promgr_num}, ${view.list_num}, ${bean.chklist_item_num})" />
															</c:if>
														
															<label id="chkItem_lab_${bean.chklist_item_num}"
																ondblclick="HiddenList('chkItem_modBtn_${bean.chklist_item_num}', 'chkItem_delBtn_${bean.chklist_item_num}', 'exit_item_${bean.chklist_item_num}')">${bean.chklist_item_name} (${bean.chklist_item_num})</label>
															
															<input type="button" id="chkItem_modBtn_${bean.chklist_item_num}" value="mod" 
																onclick="ModItem(${bean.chklist_item_num})" hidden="true" />
															
															<input type="button" id="chkItem_delBtn_${bean.chklist_item_num}" value="del"
																onclick="DelItem(${article.promgr_num}, ${bean.chklist_item_num})" hidden="true" />
															
															<input type="button" id="exit_item_${bean.chklist_item_num}" value="X"
															onclick="AppearList('chkItem_modBtn_${bean.chklist_item_num}', 'chkItem_delBtn_${bean.chklist_item_num}', 'exit_item_${bean.chklist_item_num}')" hidden="true">
														</div>
														
													</c:forEach>

												</form>

												<input type="button" value="add item"
													onclick="AddItem(${article.promgr_num}, ${view.list_num})" />
		
											</div>

										</c:forEach>

									</div>
									
									<div id="content_file" align="left">
									
										<c:forEach var="view" items="${article.file_view}">
	
											<div id="${view.file_num}">
		
												<div>
															
													<label id="file_lab_${view.file_num}"
														ondblclick="HiddenFile(${my_mem_num}, ${view.mem_num}, 'file_delBtn_${view.file_num}', 'exit_file_${view.file_num}')">[${view.file_num}] ${view.file_name} (${view.mem_name})</label>
																
													<input type="button" id="file_downBtn_${view.file_num}" value="down"
														onclick="DownFile('${view.file_name}', '${view.file_path}')">
																
													<input type="button" id="file_delBtn_${view.file_num}" value="del"
														onclick="DelFile('${article.promgr_num}', '${view.file_path}')" hidden="true">
																
													<input type="button" id="exit_file_${view.file_num}" value="X"
														onclick="AppearFile(${my_mem_num}, ${view.mem_num}, 'file_delBtn_${view.file_num}', 'exit_file_${view.file_num}')" hidden="true">
															
												</div>
															
											</div>
			
										</c:forEach>
									
									</div>

									<div id="content_comment" align="left">
								
										<c:forEach var="item" items="${article.comment_view}">
										
											<div id="${item.comment_num}">
											
												<label id="comment_lab_${item.comment_num}"
													ondblclick="HiddenComment(${my_mem_num}, ${item.mem_num}, 'comment_modBtn_${item.comment_num}', 'commnet_delBtn_${item.comment_num}', 'exit_comment_${item.comment_num}')">
													[${item.comment_num}] ${item.mem_name} : ${item.comment_content} (${item.comment_date})
												</label>
																			
												<input type="button" id="comment_modBtn_${item.comment_num}" value="mod" 
													onclick="ModComment(${item.comment_num})" hidden="true" />
																
												<input type="button" id="commnet_delBtn_${item.comment_num}" value="del"
													onclick="DelComment(${article.promgr_num}, ${item.comment_num})" hidden="true" />
																			
												<input type="button" id="exit_comment_${item.comment_num}" value="X"
													onclick="AppearComment(${my_mem_num}, ${item.mem_num}, 'comment_modBtn_${item.comment_num}', 'commnet_delBtn_${item.comment_num}', 'exit_comment_${item.comment_num}')" hidden="true">
																		
											</div>
										
										</c:forEach>
									
										<input type="button" value="add comment" onclick="AddComment(${article.promgr_num})" />
	
									</div>
								
									<div id="content_editor" align="right">
									
										<input type="button" value="member"
											onclick="memberEditor(${article.promgr_num})" /> <br /> 
											
										<input type="button" value="checklist"
											onclick="AddChkList(${article.promgr_num})" /> <br />
											
										<input type="button" value="file" 
											onclick="AddFile(${article.promgr_num})"/>
											
									</div>

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