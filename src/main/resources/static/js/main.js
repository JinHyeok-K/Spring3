

function date_create(){
    alert("저장");

    let name = $("#name").val();
    let phone = $("#phone").val();
    let memo = $("#memo").val();

    $.ajax({ // 비동기
        url:"create",  // 1. 통신 경로
        method:"post", // 2. 통신 방식
        data : { "name": name, "phone": phone, "memo": memo}, // 3. 통신 데이터
        success: function(re){ // 4. 통신 응답(결과)
            alert("RestFul create 통신");
        }
    });

}

function date_read(){
    alert("호출");

    $.ajax({
            url:"read",
            method : "get",
            success: function(re){
                alert("RestFul read 통신"+re);

                console.log(re);

            }
        });

}

function date_update(){
    alert("수정");

    $.ajax({
            url:"update",
            method : "put",
            success: function(re){
                alert("RestFul update 통신");
            }
        });
}

function date_delete(){
    alert("삭제");

    $.ajax({
            url:"delete",
            method : "delete",
            success: function(re){
                alert("RestFul delete 통신");
            }
        });
}