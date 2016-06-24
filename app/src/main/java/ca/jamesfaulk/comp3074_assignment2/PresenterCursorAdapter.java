package ca.jamesfaulk.comp3074_assignment2;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class PresenterCursorAdapter extends CursorAdapter {
    public PresenterCursorAdapter(Context context, Cursor cursor, int flags) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_presenter, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView name = (TextView)view.findViewById(R.id.name);
        String body = cursor.getString(cursor.getColumnIndexOrThrow(PresenterContract.PresenterEntry.COLUMN_NAME_NAME));
        name.setText(body);
    }
}