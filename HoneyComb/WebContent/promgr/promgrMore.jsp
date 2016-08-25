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

	function HiddenList(btn_group) { // 수정, 삭제
		
		if(document.getElementById(btn_group).style.display == "block") {
			document.getElementById(btn_group).style.display = "none"
		}
	
	}
	
	function AppearList(btn_group) { // 수정, 삭제
	
		if(document.getElementById(btn_group).style.display == "none") {
			document.getElementById(btn_group).style.display = "block"
		}
	
	}
	
	function HiddenFile(session_mem_num, file_mem_num, btn_group) { // 수정, 삭제
		
		if(session_mem_num == file_mem_num) {
		
			if(document.getElementById(btn_group).style.display == "block") {
				document.getElementById(btn_group).style.display = "none"
			}
			
		}
	
	}
	
	function AppearFile(session_mem_num, file_mem_num, btn_group) { // 수정, 삭제
	
		if(session_mem_num == file_mem_num) {
		
			if(document.getElementById(btn_group).style.display == "none") {
				document.getElementById(btn_group).style.display = "block"
			}
			
		}
	
	}
	
	function HiddenComment(session_mem_num, comment_mem_num, btn_group) { // 수정, 삭제
		
		if(session_mem_num == comment_mem_num) {
			
			if(document.getElementById(btn_group).style.display == "block") {
				document.getElementById(btn_group).style.display = "none"
			}
			
		}
	
	}

	function AppearComment(session_mem_num, comment_mem_num, btn_group) { // 수정, 삭제

		if(session_mem_num == comment_mem_num) {
			
			if(document.getElementById(btn_group).style.display == "none") {
				document.getElementById(btn_group).style.display = "block"
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
						"toolbar=no ,width=400 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");
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
	
	function DelItem(promgr_num, list_num, item_num) { // checkitem 삭제
		
		url = "/HoneyComb/promgr/promgrChkItemDel.promgr?promgr_num="+promgr_num+"&list_num="+list_num+"&item_num="+item_num;
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

</head>
<body>

	<div class="row">

		<div class="col-md-9">

			<b>PROJECT MANAGER <span class="badge">${promgr_count}</span></b>
			<input type="button" class="btn btn-primary btn-xs" style="margin-left: 10px;"
				value="프로젝트생성" onclick="addProject()">

		</div>
		
		<div class="col-md-1"></div>

		<div class="col-md-1">
		
			<input type="button" class="btn btn-primary btn-xs" value="뒤로가기"
				onclick="location.href='/HoneyComb/index.jsp'">
		
		</div>

	</div>

	<div class="row" style="margin-top: 7px;">
	
		<div class="col-md-1"></div>

		<div class="container col-md-10">

			<c:if test="${promgr_count == 0}">
				<div class="row">
					<div class="col-md-12 text-center">프로젝트가 없습니다.</div>
				</div>
			</c:if>

			<c:if test="${promgr_count > 0}">

				<dl class="list-group col-md-12">

					<c:forEach var="article" items="${articleList}">

						<dt class="list-group-item row" style="background-color: #e9ebee;">
							<span class="col-md-8">
								${article.promgr_name}
							</span>
							<span class="col-md-4 text-right">
								<input type="button" class="btn btn-primary btn-xs" 
									value="프로젝트삭제" onclick="delProject(${article.promgr_num})">
							</span>
						</dt>

						<dd class="list-group-item row" style="overflow-y: auto;">
						
							<div id="content_view" class="col-md-9">
								
								<div id="promgr_ing" class="row">
									<div class="progress">
	    								<div class="progress-bar" role="progressbar" aria-valuenow="${article.promgr_ing}" aria-valuemin="0" aria-valuemax="100" style="width:${article.promgr_ing}%">
	     									 ${article.promgr_ing}%
									    </div>
									</div>
								</div>
									
								<div class="row">
									MEMBER : 
									<c:forEach var="mem_name" items="${article.mem_name_arr}">
										<span class="label label-default">${mem_name}</span>
									</c:forEach>
								</div>
									
								<div class="row">DATE : ${article.promgr_date}</div>
									
								<div class="row">DESCRIPTION : ${article.promgr_content}</div>
									
								<div class="row">
								
									<div id="content_chklist">

										<c:forEach var="view" items="${article.chklist_view}">
	
											<div id="${view.list_num}" style="margin-top: 10px;">
	
												<div id="chklist_${view.list_num}">
													
													<label id="chkList_lab_${view.list_num}"
														ondblclick="AppearList('list_btn_group_${view.list_num}')">
														${view.list_name}
													</label>
														
													<div class="btn-group" id="list_btn_group_${view.list_num}" style="display: none;">
													 
														<input type="button" class="btn btn-default btn-xs" value="MOD"  
															onclick="ModChkList(${view.list_num})">
															
														<input type="button" class="btn btn-default btn-xs" value="DEL"  
															onclick="DelChkList(${article.promgr_num}, ${view.list_num})">
															
														<input type="button" class="btn btn-default btn-xs" value="X" 
															onclick="HiddenList('list_btn_group_${view.list_num}')">
													
													</div>
														
												</div>
	
												<div id="chklist_ing">
													
													<div class="progress">
					    								<div class="progress-bar" role="progressbar" aria-valuenow="${view.list_ing}" aria-valuemin="0" aria-valuemax="100" style="width:${view.list_ing}%">
					     									 ${view.list_ing}%
													    </div>
													</div>
													
												</div>
	
												<form role="form" method="post" name="chkItemform" >
	
													<c:forEach var="bean" items="${view.item_bean}">
														
														<div id="chkitem_${bean.chklist_item_num}">
														
															<c:if test="${bean.chklist_item_chk == 1}">
																<input type="checkbox" name="chkitem" id="${bean.chklist_item_num}"
																	onchange="ChangeCheckedItem(${article.promgr_num}, ${view.list_num}, ${bean.chklist_item_num})" checked="checked" />
															</c:if>
																
															<c:if test="${bean.chklist_item_chk == 0}">
																<input type="checkbox" name="chkitem" id="${bean.chklist_item_num}"
																	onchange="ChangeCheckedItem(${article.promgr_num}, ${view.list_num}, ${bean.chklist_item_num})" />
															</c:if>
															
															<label id="chkItem_lab_${bean.chklist_item_num}"
																ondblclick="AppearList('item_btn_group_${bean.chklist_item_num}')">
																${bean.chklist_item_name}
															</label>
																
															<div class="btn-group" id="item_btn_group_${bean.chklist_item_num}" style="display: none;">
															 
																<input type="button" class="btn btn-default btn-xs" value="MOD"  
																	onclick="ModItem(${bean.chklist_item_num})">
																	
																<input type="button" class="btn btn-default btn-xs" value="DEL"  
																	onclick="DelItem(${article.promgr_num}, ${view.list_num}, ${bean.chklist_item_num})">
																	
																<input type="button" class="btn btn-default btn-xs" value="X" 
																	onclick="HiddenList('item_btn_group_${bean.chklist_item_num}')">
															
															</div>
														
														</div>
														
													</c:forEach>
	
												</form>
	
												<input type="button" class="btn btn-default btn-xs" value="add item"
													onclick="AddItem(${article.promgr_num}, ${view.list_num})" />
			
											</div>
	
										</c:forEach>
	
									</div>
								
								</div>
								
								<div class="row">
								
									<div id="content_file" style="margin-top: 10px;">
									
										<c:forEach var="view" items="${article.file_view}">
		
											<div id="${view.file_num}">
											
												<label id="file_lab_${view.file_num}"
													ondblclick="AppearFile(${my_mem_num}, ${view.mem_num},'item_btn_group_${bean.chklist_item_num}')">
													${bean.chklist_item_name}
												</label>
															
												<input type="button" class="btn btn-default btn-xs" value="down"
													onclick="DownFile('${view.file_name}', '${view.file_path}')">
													
												<div class="btn-group" id="file_btn_group_${view.file_num}" style="display: none;">
															 
													<input type="button" class="btn btn-default btn-xs" value="DEL"  
														onclick="DelFile('${article.promgr_num}', '${view.file_path}')">
																	
													<input type="button" class="btn btn-default btn-xs" value="X" 
														onclick="HiddenFile(${my_mem_num}, ${view.mem_num},'file_btn_group_${view.file_num}')">
															
												</div>
			
											</div>
				
										</c:forEach>
										
									</div>
								
								</div>
								
							</div>
								
							<div id="content_editor"class="col-md-3">
								
								<div class="btn-group-vertical">
							
									<input type="button" class="btn btn-primary btn-xs"
										value="MEMBERS" onclick="memberEditor(${article.promgr_num})">
										
									<input type="button" class="btn btn-primary btn-xs"
										value="CHECKLIST" onclick="AddChkList(${article.promgr_num})">
										
									<input type="button" class="btn btn-primary btn-xs"
										value="FILE" onclick="AddFile(${article.promgr_num})">
									
								</div>	
								
							</div>
							
							<div class="row">
									
								<div id="content_comment" class="col-md-12" style="margin-top: 20px;">
									
									<div style="margin-bottom: 5px;">
										<input type="button" class="btn btn-default btn-xs" value="add comment" onclick="AddComment(${article.promgr_num})" />
									</div>
									
									<c:forEach var="item" items="${article.comment_view}">
											
										<div id="${item.comment_num}">
										
											<label id="comment_lab_${item.comment_num}" class="col-md-12" 
												ondblclick="AppearComment(${my_mem_num}, ${item.mem_num}, 'comment_btn_group_${item.comment_num}')">
												
												<div class="col-md-7">
													<span class="badge">${item.mem_name}</span>
													${item.comment_content}
												</div>
												<div class="col-md-5 text-center">${item.comment_date}</div>
												
											</label>
											
											<div class="btn-group" id="comment_btn_group_${item.comment_num}" style="display: none;">
															 
												<input type="button" class="btn btn-default btn-xs" value="MOD"  
													onclick="ModComment(${item.comment_num})">
																		
												<input type="button" class="btn btn-default btn-xs" value="DEL"  
													onclick="DelComment(${article.promgr_num}, ${item.comment_num})">
																		
												<input type="button" class="btn btn-default btn-xs" value="X" 
													onclick="HiddenComment(${my_mem_num}, ${item.mem_num}, 'comment_btn_group_${item.comment_num}')">
																
											</div>
											
										</div>
											
									</c:forEach>
									
								</div>
									
							</div>
						
						</dd>

					</c:forEach>

				</dl>

			</c:if>

		</div>
		
		<div class="col-md-1"></div>

	</div>

	<div class="row">
		
		<div class="col-md-12 text-center">
		
			<c:if test="${promgr_count > 0}">

				<c:set var="pageCount"
					value="${promgr_count / pageSize + (promgr_count % pageSize == 0 ? 0 : 1)}" />
	
				<fmt:parseNumber var="result" value="${currentPage / pageSize}"
					integerOnly="true" />
	
				<c:set var="startPage" value="${result * pageSize + 1}" />
	
				<c:set var="endPage" value="${startPage + pageSize - 1}" />
	
				<c:if test="${endPage > pageCount}">
					<c:set var="endPage" value="${pageCount}" />
				</c:if>
	
				<ul class="pagination pagination-sm">
				
					<c:if test="${startPage > pageSize}">
						<li>
							<a href="/HoneyComb/promgr/promgrMore.promgr?pageNum=${startPage - pageSize}">이전</a>
						</li>
					</c:if>
				
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<li>
							<a href="/HoneyComb/promgr/promgrMore.promgr?pageNum=${i}">${i}</a>
						</li>
					</c:forEach>
					
					<c:if test="${endPage < pageCount}">
						<li>
							<a href="/HoneyComb/promgr/promgrMore.promgr?pageNum=${startPage + pageSize}">다음</a>
						</li>
					</c:if>
				
				</ul>
	
			</c:if>
		
		</div>
		
	</div>

</body>
</html>