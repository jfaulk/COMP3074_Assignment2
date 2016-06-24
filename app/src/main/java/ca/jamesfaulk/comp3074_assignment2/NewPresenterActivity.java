package ca.jamesfaulk.comp3074_assignment2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewPresenterActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_presenter);
        Button submitBtn = (Button)findViewById(R.id.submitNewPresenterBtn);
        submitBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText name = (EditText)findViewById(R.id.nameTxt);
        EditText affiliation = (EditText)findViewById(R.id.affiliationTxt);
        EditText email = (EditText)findViewById(R.id.emailTxt);
        EditText bio = (EditText)findViewById(R.id.bioTxt);

        PresenterDbHelper presenterDbHelper = new PresenterDbHelper(this);
        if (presenterDbHelper.insertPresenter(name.getText().toString(), affiliation.getText().toString(), email.getText().toString(), bio.getText().toString())) {
            startMainActivity();
        }
    }

    public void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
