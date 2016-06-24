package ca.jamesfaulk.comp3074_assignment2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SurveyActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
        Button submitSurvey = (Button) findViewById(R.id.submitSurveyBtn);
        submitSurvey.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText color = (EditText)findViewById(R.id.colorTxt);
        EditText food = (EditText)findViewById(R.id.foodTxt);
        EditText why = (EditText)findViewById(R.id.whyTxt);

        List<String> results = new ArrayList<>();
        results.add(color.getText().toString());
        results.add(food.getText().toString());
        results.add(why.getText().toString());
        writeFile(results);
        startMainActivity();
    }

    public void writeFile(List<String> results) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd'_'HHmm");
        String timestamp = dateFormat.format(new Date());
        try {
            FileOutputStream outputStream = openFileOutput(timestamp + "_" + "tSurveyAnswers.txt", Context.MODE_PRIVATE);
            for (String result : results) {
                outputStream.write(result.getBytes());
                outputStream.write(System.getProperty("line.separator").getBytes());
            }
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
