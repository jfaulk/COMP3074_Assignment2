package ca.jamesfaulk.comp3074_assignment2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UsernameActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String PREFS_NAME = "comp3074_assignment2_username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_username);

        if (hasUsername()) {
            startMainActivity();
        }
        Button beginBtn = (Button) findViewById(R.id.beginBtn);
        beginBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        EditText usernameTxt = (EditText)findViewById(R.id.enterUsernameTxt);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("username", usernameTxt.getText().toString());
        editor.commit();
        startMainActivity();
    }

    public void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public Boolean hasUsername() {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        if(settings.getString("username", null) == null) {
            return false;
        }
        else {
            return true;
        }
    }
}
