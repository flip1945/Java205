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

window.onload = () => {

    // localStrorage에 저장된 데이터가 있는지 확인
    // 데이터가 없으면 null 반환
    if (localStorage.getItem('members')) {
        members = JSON.parse(localStorage.getItem('members'));
    }

    // 테이블 세팅
    setList();

    // 사용자가 입력한 값
    var userID = document.querySelector('#userID');
    var userPW = document.querySelector('#userPW');
    var rePW = document.querySelector('#rePW');
    var userName = document.querySelector('#userName');

    // regForm 캐스팅
    var regForm = document.getElementById('regForm');
    regForm.onsubmit = function() {

        if (userID.value.trim().length < 1) {
            document.querySelector('#userID + .msg').innerHTML = '필수항목입니다.';
            document.querySelector('#userID + .msg').style.display = 'block';
            return false;
        }

        if (userPW.value.trim().length < 1) {
            document.querySelector('#userPW + .msg').innerHTML = '필수항목입니다.';
            document.querySelector('#userPW + .msg').style.display = 'block';
            return false;
        }

        if (rePW.value.trim().length < 1) {
            document.querySelector('#rePW + .msg').innerHTML = '필수항목입니다.';
            document.querySelector('#rePW + .msg').style.display = 'block';
            return false;
        }

        // 비밀번호, 비밀번호 확인 일치 여부 체크
        if (userPW.value.trim() != rePW.value.trim()) {
            document.querySelector('#rePW + .msg').innerHTML = '비밀번호가 일치하지 않습니다..';
            document.querySelector('#rePW + .msg').style.display = 'block';
            return false;
        }

        // 사용자 이름 정보
        if (userName.value.trim().length < 1) {
            document.querySelector('#userName + .msg').innerHTML = '필수항목입니다.';
            document.querySelector('#userName + .msg').style.display = 'block';
            return false;
        }

        // 객체 생성
        // var member = new Member(userID.value, userPW.value, userName.value);
        // console.log(member.makeHTML());

        // 배열에 사용자 정보를 추가
        members.push(new Member(userID.value, userPW.value, userName.value));

        alert('등록됐습니다.');
        console.log('회원리스트 :', members);

        //form 초기화
        this.reset();
        setList();
        return false;
    }

    userID.addEventListener('focus', function() {
        document.querySelector('#userID + .msg').style.display = 'none';
    });

    userPW.addEventListener('focus', function() {
        document.querySelector('#userPW + .msg').style.display = 'none';
    });

    rePW.addEventListener('focus', function() {
        document.querySelector('#rePW + .msg').style.display = 'none';
        rePW.value = '';
    });

    userName.addEventListener('focus', function() {
        document.querySelector('#userName + .msg').style.display = 'none';
    });
}

var member = new Member();

function setList() {
    // table의 tbody를 캐스팅
    var list = document.querySelector('#list');

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
    list.innerHTML = tbody;
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
    // alert(index + '번 인덱스의 요소를 수정합니다.');
    document.querySelector('#editFormArea').style.display = 'block';

    // 전달받은 인덱스 값으로 members 배열의 객체 하나를 얻을 수 있다.
    var editID = document.querySelector('#editID');
    var editPW = document.querySelector('#editPW');
    var editRePW = document.querySelector('#editRePW');
    var editName = document.querySelector('#editName');
    var editIndex = document.querySelector('#editIndex');

    editID.value = members[index].userID;
    editPW.value = members[index].userPW;
    editRePW.value = members[index].userPW;
    editName.value = members[index].userName;
    editIndex.value = index;

    document.querySelector('#editForm').onsubmit = function() {
        // var member = new Member(editID.value, editPW.value, editName.value);
        var chk = confirm('수정하시겠습니까?')

        if (!chk) {
            return false;
        }

        if (editPW.value != editRePW.value) {
            alert('비밀번호와 비밀번호 확인이 일치하지 않습니다.');
            return false;
        }

        members[editIndex.value].userPW = editPW.value;
        members[editIndex.value].userName = editName.value;

        setList();

        alert('수정됐습니다.');
        
        document.querySelector('#editFormArea').style.display = 'none';
        return false;
    }
}

function editMemberClose() {
    document.querySelector('#editFormArea').style.display = 'none';
}