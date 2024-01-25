package com.demo.kr.demoemail.service


interface MailService {

    fun sendSimpleMail(to:String, subject:String, content:String)
}