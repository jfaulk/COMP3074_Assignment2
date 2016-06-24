package ca.jamesfaulk.comp3074_assignment2;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class PresenterDetailCursorAdapter extends CursorAdapter {
    public PresenterDetailCursorAdapter(Context context, Cursor cursor, int flags) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.detail_presenter, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView name = (TextView)view.findViewById(R.id.detailName);
        TextView affiliation = (TextView)view.findViewById(R.id.detailAffiliation);
        TextView email = (TextView)view.findViewById(R.id.detailEmail);
        TextView bio = (TextView)view.findViewById(R.id.bioDetail);
        String nameBody = cursor.getString(cursor.getColumnIndexOrThrow(PresenterContract.PresenterEntry.COLUMN_NAME_NAME));
        String affiliationBody = cursor.getString(cursor.getColumnIndexOrThrow(PresenterContract.PresenterEntry.COLUMN_NAME_AFFILIATION));
        String emailBody = cursor.getString(cursor.getColumnIndexOrThrow(PresenterContract.PresenterEntry.COLUMN_NAME_EMAIL));
        String bioBody = cursor.getString(cursor.getColumnIndexOrThrow(PresenterContract.PresenterEntry.COLUMN_NAME_BIO));

        name.setText(nameBody);
        affiliation.setText(affiliationBody);
        email.setText(emailBody);
        bio.setText(bioBody);
    }
}