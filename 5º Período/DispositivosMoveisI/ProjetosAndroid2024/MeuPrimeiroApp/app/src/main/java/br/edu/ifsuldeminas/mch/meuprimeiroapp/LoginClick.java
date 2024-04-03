package br.edu.ifsuldeminas.mch.meuprimeiroapp;

import android.view.View;
import android.widget.Toast;

public class LoginClick implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        Toast toast = Toast.makeText(view.getContext(), R.string.login_sucesfull, Toast.LENGTH_LONG);
        toast.show();
    }
}
