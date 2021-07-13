// 회원의 정보 : 아이디, 비밀번호, 이름
// Member -> 생성자 함수를 정의

function Member(id, pw, name) {
    this.userID = id;
    this.userPW = pw;
    this.userName = name;
}

// 객체가 가지는 메소드는 공통으로 사용 -> prototype
Member.prototype.makeHTML = function() {
    return '[ id: ' + this.userID + ', pw: ' + this.userPW + ', name: ' + this.userName + ']'
}

// 회원 정보를 저장하는 배열
var members = [];

// localStorage에 저장
// 배열 -> JSON(문자열) -> localStorage 저장
// 저장, 수정, 삭제 시에 localStorage에 저장



// 사용자가 입력한 정보를 가지고 Member 객체를 생성
// submit 이벤트 연결

$(document).ready(() => {

    // localStrorage에 저장된 데이터가 있는지 확인
    // 데이터가 없으면 null 반환
    if (localStorage.getItem('members')) {
        members = JSON.parse(localStorage.getItem('members'));
    }

    // 테이블 세팅
    setList();

    $('#regForm').submit(function() {
        // 아이디 공백 입력 확인
        if ($('#userID').val().trim().length < 1) {
            $('#userID + .msg').html('아이디 입력 필수');
            $('#userID + .msg').css('display', 'block');
            return false;
        }
        
        // 이메일 입력 확인
        var email = /\w+@[a-zA-Z]+.[a-zA-Z]+$/g;
        if (!email.test($('#userID').val().trim())) {
            $('#userID + .msg').html('이메일 형식 입력 필수');
            $('#userID + .msg').css('display', 'block');
            return false;
        }

        // 비밀번호 공백 입력 확인
        if ($('#userPW').val().trim().length < 1) {
            $('#userPW + .msg').html('비밀번호 입력 필수');
            $('#userPW + .msg').css('display', 'block');
            return false;
        }

        // 비밀번호 숫자 입력 확인
        var numbers = /[0-9]/g;
        if (!numbers.test($('#userPW').val())) {
            $('#userPW + .msg').html('숫자 1글자 이상 포함 필수');
            $('#userPW + .msg').css('display', 'block');
            return false;
        }

        // 비밀번호 특수문자 확인
        var specialCharacter = /[^a-zA-Z0-9]/g;
        if (!specialCharacter.test($('#userPW').val())) {
            $('#userPW + .msg').html('특문 1글자 이상 포함 필수');
            $('#userPW + .msg').css('display', 'block');
            return false;
        }

        // 비밀번호 확인 공백 입력 확인
        if ($('#rePW').val().trim().length < 1) {
            $('#rePW + .msg').html('비밀번호 확인 입력 필수');
            $('#rePW + .msg').css('display', 'block');
            return false;
        }

        // 비밀번호, 비밀번호 확인 일치 여부 체크
        if ($('#userPW').val().trim() != $('#rePW').val().trim()) {
            $('#rePW + .msg').html('비밀번호 불일치');
            $('#rePW + .msg').css('display', 'block');
            return false;
        }

        // 사용자 이름 공백 입력 확인
        if ($('#userName').val().trim().length < 2) {
            $('#userName + .msg').html('이름 두 글자 이상 입력 필수');
            $('#userName + .msg').css('display', 'block');
            return false;
        }

        // 사용자 이름 한글 확인
        var name = /^[가-힣]+$/g;
        if (!name.test($('#userName').val())) {
            $('#userName + .msg').html('올바른 한글 이름 입력 필수');
            $('#userName + .msg').css('display', 'block');
            return false;
        }

        // 객체 생성
        // var member = new Member(userID.value, userPW.value, userName.value);
        // console.log(member.makeHTML());

        // 배열에 사용자 정보를 추가
        members.push(new Member($('#userID').val(), $('#userPW').val(), $('#userName').val()));

        alert('등록됐습니다.');
        console.log('회원리스트 :', members);

        //form 초기화
        this.reset();
        setList();
        return false;
    });

    $('#userID').on('focus', () => {
        $('#userID + .msg').css('display', 'none');
    });

    $('#userPW').on('focus', () => {
        $('#userPW + .msg').css('display', 'none');
    });

    $('#rePW').on('focus', () => {
        $('#rePW + .msg').css('display', 'none');
    });

    $('#userName').on('focus', () => {
        $('#userName + .msg').css('display', 'none');
    });
});

var member = new Member();

function setList() {
    localStorage.setItem('members', JSON.stringify(members));

    var tbody = '<tr>';
    tbody += '    <th>순번(index)</th>';
    tbody += '    <th>아이디</th>';
    tbody += '    <th>비밀번호</th>';
    tbody += '    <th>이름</th>';
    tbody += '    <th>관리</th>';
    tbody += '</tr>';

    if (members.length < 1) {
        tbody += '<tr>';
        tbody += '    <td colspan="5">데이터가 존재하지 않습니다.</td>';
        tbody += '</tr>';
    } else {
        for (var i = 0; i < members.length; i++) {
            tbody += '<tr>';
            tbody += '    <td>' + i + '</td>'
            tbody += '    <td>' + members[i].userID + '</td>'
            tbody += '    <td>' + members[i].userPW + '</td>'
            tbody += '    <td>' + members[i].userName + '</td>'
            tbody += '    <td>' + '<a href="javascript:editMember(' + i + ')">수정</a> / <a href=javascript:deleteMember(' + i + ')>삭제</a>' + '</td>'
            tbody += '</tr>';
        }
    }
    $('#list').html(tbody);
}

// 배열의 요소 삭제
function deleteMember(index) {
    // alert(index + '번 인덱스의 요소를 삭제합니다.');
    var chk = confirm('삭제하시겠습니까?');

    if (chk) {
        members.splice(index, 1);
        setList();
        alert('삭제됐습니다.');
    }
}

// 배열의 요소 수정
function editMember(index) {
    $('#editFormArea').css('display', 'block');

    $('#editID').val(members[index].userID);
    $('#editPW').val(members[index].userPW);
    $('#editRePW').val(members[index].userPW);
    $('#editName').val(members[index].userName);
    $('#editIndex').val(index);

    $('#editForm').submit(function() {
        // var member = new Member(editID.value, editPW.value, editName.value);
        var chk = confirm('수정하시겠습니까?')

        if (!chk) {
            return false;
        }

        // 비밀번호 숫자 입력 확인
        var numbers = /[0-9]/g;
        if (!numbers.test($('#editPW').val())) {
            alert('비밀번호에 숫자를 1개 이상 입력하세요.');
            return false;
        }

        // 비밀번호 특수문자 확인
        var specialCharacter = /[^a-zA-Z0-9]/g;
        if (!specialCharacter.test($('#editPW').val())) {
            alert('비밀번호에 특수문자를 1개 이상 입력하세요.');
            return false;
        }

        // 비밀번호, 비밀번호 확인 일치 확인
        if ($('#editPW').val() != $('#editRePW').val()) {
            alert('비밀번호와 비밀번호 확인이 일치하지 않습니다.');
            return false;
        }

        // 사용자 이름 공백 입력 확인
        if ($('#editName').val().trim().length < 2) {
            alert('이름은 최소 2글자 이상 입력해주세요.');
            return false;
        }

        // 사용자 이름 한글 확인
        var name = /^[가-힣]+$/g;
        if (!name.test($('#editName').val())) {
            alert('올바른 한글 이름을 입력해주세요.');
            return false;
        }

        members[$('#editIndex').val()].userPW = $('#editPW').val();
        members[$('#editIndex').val()].userName = $('#editName').val();

        setList();

        alert('수정됐습니다.');
        
        $('#editFormArea').css('display', 'none');
        return false;
    });
}

function editMemberClose() {
    $('#editFormArea').css('display', 'none');
}