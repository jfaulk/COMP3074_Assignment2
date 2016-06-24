package ca.jamesfaulk.comp3074_assignment2;

import android.provider.BaseColumns;

public final class PresenterContract {

    public PresenterContract() { }

    public static abstract class PresenterEntry implements BaseColumns {
        public static final String TABLE_NAME = "presenters";
        public static final String COLUMN_NAME_ID = "_id";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_AFFILIATION = "affiliation";
        public static final String COLUMN_NAME_EMAIL = "email";
        public static final String COLUMN_NAME_BIO = "bio";

    }
}
