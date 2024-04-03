package br.edu.ifsuldeminas.mch.meuprimeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonLogin;
    private EditText userName, userPW;

    private static String USER = "Leo", PW = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Acessar elementos
        buttonLogin = findViewById(R.id.buttonLogin);
        userName = findViewById(R.id.editTextUser);
        userPW = findViewById(R.id.editTextNumberPassword);

        // Chamar o onClickListener
        //buttonLogin.setOnClickListener(new LoginClick());
        buttonLogin.setOnClickListener(view -> {

            // Recuperando login e senha como string
            String userNameStr = userName.getText().toString();
            String userPWStr = userPW.getText().toString();

            if (userNameStr.equals("")) {
                Toast toast = Toast.makeText(view.getContext(), R.string.login_user_name_empty, Toast.LENGTH_LONG);
                toast.show();
                return;
            }

            if (userPWStr.equals("")) {
                Toast toast = Toast.makeText(view.getContext(), R.string.login_user_pw_empty, Toast.LENGTH_LONG);
                toast.show();
                return;
            }

            // há usuário e senha -> verificar se estão corretos
            if (userNameStr.equals(USER) && userPWStr.equals(PW)) {
                Toast toast = Toast.makeText(view.getContext(), R.string.login_sucesfull, Toast.LENGTH_LONG);
                toast.show();
            } else {
                Toast toast = Toast.makeText(view.getContext(), R.string.login_user_wrong, Toast.LENGTH_LONG);
                toast.show();
            }
        });

        // Passar uma  view.onClickListener

        // Implementar uma subclasse da view.onClickListener

    }

    public void forgotPW(View view) {
        Toast toast = Toast.makeText(view.getContext(), R.string.login_forgot_pw_message, Toast.LENGTH_LONG);
        toast.show();
    }
}