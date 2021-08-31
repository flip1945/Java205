<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>신촌맥주 양조장 투어 예약</title>

<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
</head>

<body>

	<!-- Header 영역 -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>

	<!-- Content 영역 -->
	<div class="my-5 text-center">
		<h2 class="font-weight-bold">결제하기</h2>
	</div>

	<div class="container">
		<form action="">
			<div class="row justify-content-center">
				<div class="col-lg-6">
					<div class="tip-off">
						<h6>주문 상품 정보</h6>
						<div>
							<a href="">
								<div class="product-info-wrap" style="width: 100px;">
									<img
										src="https://cdn.imweb.me/thumbnail/20210412/b5995e864cc65.jpg"
										width="90" height="90" alt="주문상품 이미지">
								</div>
								<div class="product-info-wrap m-4">
									<div>
										<div class="pb-2">제주에서 만난 찹쌀 김부각(4ea)</div>
										<div class="small pb-2">1개</div>
										<div class="font-weight-bold">12,100원</div>
									</div>
								</div>
							</a>
						</div>
					</div>

					<div class="tip-off">
						<h6>주문자 정보</h6>
						<div class="position-relative">
							<div class="text-15 mb-1">채호연</div>
							<div class="text-14 text-gray font-weight-bold mb-1">
								01050954426</div>
							<div class="text-14 text-gray font-weight-bold mb-1">
								coghdus1016@naver.com</div>

							<a onclick="void(0);" href="javascript:"
								class="btn-sinchon btn btn-sm-padding text-13 btn_top_right"
								id="btn-orderer-edit" role="button"> 수정 </a>
						</div>
					</div>

					<div class="tip-off">
						<h6>배송 정보</h6>

						<div>
							<div class="form-check">
								<label class="form-check-label"> <input type="checkbox"
									class="form-check-input"> <span class="small">
										주문자 정보와 동일 </span>
								</label>
							</div>

							<div class="row">
								<div class="col pr-1 mt-2">
									<input type="text" class="form-control" id="delvname"
										placeholder="수령인" name="delvName">
								</div>

								<div class="col pl-1 mt-2">
									<input type="tel" class="form-control" id="delvcall"
										placeholder="연락처" name="delvCall">
								</div>
							</div>

							<div class="row">
								<div class="col-3 mt-2">
									<input type="tel" class="form-control bg-white"
										placeholder="우편번호" name="delvAddressCode" value="18342"
										readonly>
								</div>

								<div class="col-3 btn-tools mt-2">
									<a href="" class="text-13 text-center d-block btn">주소찾기</a>
								</div>

								<div class="col-12 mt-2">
									<input type="text" class="form-control bg-white"
										name="delvAddress" value="경기 화성시 융건로 99 (기안동, 기안마을풍성신미주아파트)"
										readonly>
								</div>

								<div class="col-12 mt-2">
									<input type="text" class="form-control"
										name="delvAddressDetail" value="116동 302호">
								</div>
							</div>

							<div class="form-check mt-2">
								<label class="form-check-label"> <input type="checkbox"
									class="form-check-input"> <span class="small">
										배송지 목록에 추가 </span>
								</label>
							</div>
						</div>

						<div class="row mt-4">
							<div class="col-12">
								<p class="text-13">배송메모</p>

								<div class="form-group">
									<select name="delvMemo" id="delvMemo"
										class="form-control text-14">
										<option value="">배송메모를 선택해 주세요.</option>
										<option value="배송 전에 미리 연락 바랍니다.">배송 전에 미리 연락 바랍니다.</option>
										<option value="부재시 경비실에 맡겨주세요.">부재시 경비실에 맡겨주세요.</option>
										<option value="부재시 전화나 문자를 남겨주세요.">부재시 전화나 문자를 남겨주세요.</option>
										<option value="직접입력">직접입력</option>
									</select>
								</div>
							</div>
						</div>
					</div>

					<div class="tip-off">
						<h6>쿠폰</h6>
						<p class="text-14">쿠폰</p>

						<div class="row">

							<div class="col-8">
								<input title="쿠폰" class="form-control bg-white" name="useCoupon"
									placeholder="보유쿠폰 0장" readonly>
							</div>

							<div class="col-4">
								<a href="javascript:" class="btn-sinchon btn-coupon btn text-13"
									id="btn-orderer-edit" role="button"> 쿠폰적용 </a>
							</div>

						</div>
					</div>
				</div>

				<div class="col-lg-4">
					<div class="tip-off">
						<h6>최종 결제금액</h6>

						<div class="row border-bottom">
							<div class="col-6">
								<p class="text-gray text-left text-14 mb-1">상품가격</p>
								<p class="text-gray text-left text-14 mb-3">배송비</p>
							</div>

							<div class="col-6">
								<p class="text-right text-14 mb-1">12,100원</p>
								<p class="text-right text-14 mb-3">무료</p>
							</div>
						</div>

						<div class="row mt-3">
							<div class="col-6">
								<p class="text-14 text-left mb-0">총 결제금액(1개)</p>
							</div>

							<div class="col-6">
								<p class="text-14 text-right font-weight-bold text-sinchon mb-0">12,100원</p>
							</div>

						</div>
					</div>

					<div class="tip-off">
						<h6>결제 방법</h6>

						<div class="row payTypeWrap mb-3">
							<div class="col-6">
								<div class="form-check">
									<label class="form-check-label text-14" for="card"> <input
										type="radio" name="payType" id="card" value="card"
										class="form-check-input">신용카드
									</label>
								</div>
							</div>

							<div class="col-6">
								<div class="form-check">
									<label class="form-check-label text-14" for="kakaopay">
										<input type="radio" name="payType" id="kakaopay"
										value="kakaopay" class="form-check-input">카카오페이
									</label>
								</div>
							</div>
						</div>
					</div>

					<div class="tip-off mb-0">
						<div class="form-group mb-0">
							<label> <input type="checkbox" id="payAllCheck"
								class="check"> <span class="text-14 pl-1">전체 동의</span>
							</label> <label class="pl-4"> <input type="checkbox"
								id="payAgree" class="check"> <span class="text-14 pl-1">구매조건
									확인 및 결제 진행에 동의</span>
							</label>
						</div>
					</div>
					<button type="submit"
						class="btn btn-lg btn-block btn-pay text-16 font-weight-bold">결제하기</button>
				</div>
			</div>
		</form>
	</div>

	<!-- Footer 영역 -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp" %>
</body>
</html>