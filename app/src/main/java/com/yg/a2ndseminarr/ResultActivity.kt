package com.yg.a2ndseminarr

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    var info : TextView? = null
    var id : String? = null
    var pwd : String? = null
    var name : String? = null
    var major : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        intiActivity()

        info!!.text = id + "\n" + pwd + "\n" + name + "\n" + major
        //info에 띄울 정보들 입력. \n은 엔터(Enter)를 의미한다
    }

    fun intiActivity(){
        info = findViewById(R.id.result_info_text) as TextView
        id = intent.getStringExtra("id")
        //가입했을 때 입력한 아이디

        pwd = intent.getStringExtra("pwd")
        //가입했을 때 입력한 비밀번호

        name = intent.getStringExtra("name")
        //가입했을 때 입력한 이름

        major = intent.getStringExtra("major")
        //가입했을 때 입력한 전공

        //액티비티에서 쓰일 뷰와 정보들 연결 및 초기화 과정
    }
}
