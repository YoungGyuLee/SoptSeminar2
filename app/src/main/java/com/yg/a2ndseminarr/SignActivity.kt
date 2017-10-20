package com.yg.a2ndseminarr

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText

class SignActivity : AppCompatActivity() {

    var inputId : EditText? = null
    var inputPwd : EditText? = null
    var inputName : EditText? = null
    var inputMajor : EditText? = null
    var submitBtn : Button? = null
    var resetBtn : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)

        initActivity()

        submitBtn!!.setOnClickListener {
            val intent = Intent(applicationContext, LoginActivity::class.java)
            intent.putExtra("id", inputId!!.text.toString())
            intent.putExtra("pwd", inputPwd!!.text.toString())
            intent.putExtra("name", inputName!!.text.toString())
            intent.putExtra("major", inputMajor!!.text.toString())
            startActivity(intent)
            //각 EditText에 입력한 내용들을 LoginActivity로 전달
        }

        resetBtn!!.setOnClickListener {
            inputId!!.text.clear()
            inputPwd!!.text.clear()
            inputName!!.text.clear()
            inputMajor!!.text.clear()
            //각 EditText 비우기
        }

    }

    fun initActivity(){
        inputId = findViewById(R.id.sign_id_edit) as EditText
        inputPwd = findViewById(R.id.sign_pwd_edit) as EditText
        inputName = findViewById(R.id.sign_name_edit) as EditText
        inputMajor = findViewById(R.id.sign_major_edit) as EditText
        submitBtn = findViewById(R.id.sign_submit_btn) as Button
        resetBtn = findViewById(R.id.sign_reset_btn) as Button
        //액티비티에서 사용할 뷰들을 연결하는 과정
    }
}
