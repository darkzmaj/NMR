package com.zmaj.nmr;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class LoginActivity extends AppCompatActivity {

    private EditText pin;
    private TextView info;
    private Button Login;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pin = (EditText)findViewById(R.id.editText);
        // info = (TextView)findViewById(R.id.textView);
        Login = (Button) findViewById(R.id.btnLogin);
//bitno samo 'new onCl' i autocomplete ce da odradi za login
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(pin.getText().toString());

            }
        });


    }
    private void validate(String pin){
        if(pin.equals("1234")){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }


}
