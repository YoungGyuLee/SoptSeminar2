package com.yg.a2ndseminarr

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    var inputId : EditText? = null
    //id를 입력하는 EditText
    var inputPwd : EditText? = null
    //비밀번호를 입력하는 EditText
    var loginBtn : Button? = null
    //로그인 버튼
    var signUpBtn : Button? = null
    //회원가입 버튼
    var id : String? = null
    //다른 액티비티로부터 전달된 id값을 받는 String 변수
    var pwd : String? = null
    //다른 액티비티로부터 전달된 비밀번호(pwd)값을 받는 String 변수
    var name : String? = null
    //다른 액티비티로부터 전달된 이름값을 받는 String 변수
    var major : String? = null
    //다른 액티비티로부터 전달된 전공값을 받는 String 변수

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initActivity()

        loginBtn!!.setOnClickListener {
            if (intent.extras==null){
                //intent가 비어 있다는 것은 가입조차 상태
                Toast.makeText(applicationContext, "등록된 정보가 없습니다.", Toast.LENGTH_SHORT).show()
            }else{
                //비어있지 않다는 것은 가입은 한 상태

                id = intent.getStringExtra("id")
                //가입했을 때 입력한 아이디

                pwd = intent.getStringExtra("pwd")
                //가입했을 때 입력한 비밀번호

                name = intent.getStringExtra("name")
                //가입했을 때 입력한 이름

                major = intent.getStringExtra("major")
                //가입했을 때 입력한 전공

                if(!inputId!!.text.toString().equals(id)){
                    Toast.makeText(applicationContext, "id를 확인해주세요.", Toast.LENGTH_SHORT).show()
                    //editText에 입력한 아이디와 가입했을 때 입력한 아이디가 맞는지 확인 후 다르면 메시지 띄우기
                } else if(!inputPwd!!.text.toString().equals(pwd)){
                    Toast.makeText(applicationContext, "비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
                    //editText에 입력한 비밀번호와 가입했을 때 입력한 비밀번호가 맞는지 확인 후 다르면 메시지 띄우기
                } else{
                    //editText에 입력한 아이디 비밀번호들이 가입했을 때 입력한 id, 패스워드와 일치

                    val intent = Intent(applicationContext, ResultActivity::class.java)
                    intent!!.putExtra("id", id)
                    intent!!.putExtra("pwd", pwd)
                    intent!!.putExtra("name", name)
                    intent!!.putExtra("major", major)
                    startActivity(intent)
                    //회원가입에서 가입력한 정보를 가시고 결과 페이지로
                }
            }
        }

        signUpBtn!!.setOnClickListener {
            val intent = Intent(applicationContext, SignActivity::class.java)
            startActivity(intent)
        }
    }

    fun initActivity(){
        inputId = findViewById(R.id.login_id_edit) as EditText
        inputPwd = findViewById(R.id.login_pwd_edit) as EditText
        loginBtn = findViewById(R.id.login_login_btn) as Button
        signUpBtn = findViewById(R.id.login_sign_btn) as Button
        //액티비티에서 사용할 뷰들을 연결하는 과정
    }
}
