package ca.jamesfaulk.comp3074_assignment2;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ViewPresenterActivity extends Activity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_presenter);

        PresenterDbHelper presenterDbHelper = new PresenterDbHelper(this);
        SQLiteDatabase db = presenterDbHelper.getWritableDatabase();
        Cursor presenterCursor = db.rawQuery("SELECT * FROM presenters", null);

        ListView items = (ListView)findViewById(R.id.listView);
        PresenterCursorAdapter presenterCursorAdapter = new PresenterCursorAdapter(this, presenterCursor, 0);
        items.setAdapter(presenterCursorAdapter);
        items.setOnItemClickListener(this);
        

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(view.getContext(), ViewPresenterDetailActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}
