package ca.jamesfaulk.comp3074_assignment2;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

public class ViewPresenterDetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_presenter_detail);
        Bundle bundle = getIntent().getExtras();
        //long id = savedInstanceState.getLong("id", 1);

        PresenterDbHelper presenterDbHelper = new PresenterDbHelper(this);
        SQLiteDatabase db = presenterDbHelper.getWritableDatabase();
        Cursor presenterDetailCursor = db.rawQuery("SELECT * FROM presenters WHERE _id = " + bundle.getLong("id"), null);

        ListView details = (ListView)findViewById(R.id.detailListView);
        PresenterDetailCursorAdapter presenterDetailCursorAdapter = new PresenterDetailCursorAdapter(this, presenterDetailCursor, 0);
        details.setAdapter(presenterDetailCursorAdapter);
    }
}
