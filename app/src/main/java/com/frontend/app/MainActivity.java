package com.frontend.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.frontend.app.util.JsonResponse;
import com.frontend.app.util.JsonRequest;
import com.frontend.app.util.RetrofitAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getUser(new JsonRequest(1));
            }
        });
    }

    // 회원 조회 예시
    private void getUser(JsonRequest data) {
        RetrofitAPI serviceApi = null;
        serviceApi.userJoin(data).enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                JsonResponse result = response.body();
                //서버로부터의 응답을 위에서 정의한 JoinResponse객체에 담는다.
                // getMessage를 통해 성공시 서버로부터 회원가입 성공이라는 메시지를 받음
                Log.i("result", result.toString());
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                Log.e("get user up Error", t.getMessage());
                t.printStackTrace();
            }
        });
    }
}