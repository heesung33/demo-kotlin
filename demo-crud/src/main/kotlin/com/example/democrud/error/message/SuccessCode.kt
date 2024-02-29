package com.example.democrud.error.message

enum class SuccessCode(

    // 조회 성공 코드 (HTTP Response: 200 OK)
    val status: Int,
    // 성공 코드의 '코드 값'을 반환한다.
    val code: String,
    // 성공 코드의 '코드 메시지'를 반환한다.s
    val message: String
) {
    // 삭제 성공 코드 (HTTP Response: 200 OK)
    DELETE_SUCCESS(200, "200", "DELETE SUCCESS"),

    // 조회 성공 코드 (HTTP Response: 200 OK)
    SELECT_SUCCESS(200, "200", "SELECT SUCCESS"),

    // 수정 성공 코드 (HTTP Response: 201 Created)
    UPDATE_SUCCESS(204, "204", "UPDATE SUCCESS"),

    // 삽입 성공 코드 (HTTP Response: 201 Created)
    INSERT_SUCCESS(201, "201", "INSERT SUCCESS")
    ; // End
}