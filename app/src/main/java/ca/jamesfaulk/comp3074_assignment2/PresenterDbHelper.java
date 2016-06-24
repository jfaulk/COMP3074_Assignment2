package ca.jamesfaulk.comp3074_assignment2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PresenterDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Presenters.db";
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE = "CREATE TABLE " +
            PresenterContract.PresenterEntry.TABLE_NAME + " (" +
            PresenterContract.PresenterEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
            PresenterContract.PresenterEntry.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
            PresenterContract.PresenterEntry.COLUMN_NAME_AFFILIATION + TEXT_TYPE + COMMA_SEP +
            PresenterContract.PresenterEntry.COLUMN_NAME_EMAIL + TEXT_TYPE + COMMA_SEP +
            PresenterContract.PresenterEntry.COLUMN_NAME_BIO + TEXT_TYPE + ")";

    private static final String SQL_DELETE = "DROP TABLE IF EXISTS " +
            PresenterContract.PresenterEntry.TABLE_NAME;

    public PresenterDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE);
        onCreate(db);
    }

    public boolean insertPresenter(String name, String affiliation, String email, String bio) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(PresenterContract.PresenterEntry.COLUMN_NAME_NAME, name);
        contentValues.put(PresenterContract.PresenterEntry.COLUMN_NAME_AFFILIATION, affiliation);
        contentValues.put(PresenterContract.PresenterEntry.COLUMN_NAME_EMAIL, email);
        contentValues.put(PresenterContract.PresenterEntry.COLUMN_NAME_BIO, bio);
        db.insert(PresenterContract.PresenterEntry.TABLE_NAME, null, contentValues);
        return true;
    }
}
