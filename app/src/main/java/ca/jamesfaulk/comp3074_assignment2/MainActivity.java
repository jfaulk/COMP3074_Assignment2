package ca.jamesfaulk.comp3074_assignment2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    public static final String PREFS_NAME = "comp3074_assignment2_username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        TextView welcomeTxt = (TextView)findViewById(R.id.welcomeTxt);
        welcomeTxt.setText("Welcome, " + settings.getString("username", null));
        Button startSurvey = (Button) findViewById(R.id.startSurveyBtn);
        Button addPresenter = (Button) findViewById(R.id.addPresenterBtn);
        Button viewPresenters = (Button) findViewById(R.id.viewPresentersBtn);
        addPresenter.setOnClickListener(this);
        startSurvey.setOnClickListener(this);
        viewPresenters.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.startSurveyBtn: startSurveyActivity();
                break;
            case R.id.addPresenterBtn: startAddPresenterActivity();
                break;
            case R.id.viewPresentersBtn: startViewPresenterActivity();
                break;
        }
    }

    public void startSurveyActivity() {
        Intent intent = new Intent(this, SurveyActivity.class);
        startActivity(intent);
    }

    public void startAddPresenterActivity() {
        Intent intent = new Intent(this, NewPresenterActivity.class);
        startActivity(intent);
    }

    public void startViewPresenterActivity() {
        Intent intent = new Intent(this, ViewPresenterActivity.class);
        startActivity(intent);
    }
}
