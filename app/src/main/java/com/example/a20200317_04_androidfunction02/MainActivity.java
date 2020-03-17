package com.example.a20200317_04_androidfunction02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.a20200317_04_androidfunction02.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.dialbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                다른화면으로 이동 intnent
//                => 우리가 만든게 아니라, 안드로이드가 제공하는 화면으로 이동.
//                전화걸기 화면

//              전화번호가 뭐라고 입력되어있는지 받아오자
//                받아온 전화번호를 호출

                String inputNum = binding.inputEdt.getText().toString();
                Log.d("입력한번호", inputNum);

//                문자를 숫자로
                String phoneUri = String.format("tel:%s",inputNum);

                Uri uri = Uri.parse(phoneUri);
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });

        binding.callbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                현재까지 배운것만으론 실행 불가(권한 획득을 못함)

                Uri uri = Uri.parse("tel:01012345678");
                Intent intent = new Intent(Intent.ACTION_CALL, uri);
                startActivity(intent);
            }
        });

    }
}
