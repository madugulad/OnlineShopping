<div class="col-lg-3">

	<h1 class="my-4">Shop Name</h1>
	
	
	<c:forEach items="${categories}" var="cat">
		<a href="${contextRoot}/show/category/${cat.id}/products" class="list-group-item" id="${cat.name}">${cat.name}</a> 
	</c:forEach>

</div>