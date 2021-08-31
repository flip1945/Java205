<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="footer">
	<p class="company-info">
		신촌맥주 주식회사<span>|</span>대표이사 한잔<br>본사 : 서울특별시 마포구 백범로 23 (서울특별시
		마포구 신수동 63-14)<br>사업자등록번호 : 214-85-24928 <span>|</span>통신판매업신고번호
		: 제 2020-서울신촌-0101 호<br>개인정보보호책임자 한잔 <span>|</span>고객센터 :
		02-707-1480,<a href="mailto:sinchonbeer@gmail.com">sinchonbeer@gmail.com</a>
	</p>
	<p class="copyright">
		<br>COPYRIGHT 2021@ SINCHON BEER COMPANY
	</p>
</div>

<script>
	$("#payAllCheck").click(function() {
		$(".check").prop('checked', $(this).prop('checked'));
	});

	const x = window.matchMedia("(min-width: 990px)")

	x.addListener(function(a) {
		$('#collapsibleNavbar').removeClass('show');
	});
</script>

<!-- JS files -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>