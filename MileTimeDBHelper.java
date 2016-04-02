package ebookfrenzy.com;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mikeh_000 on 4/2/2016.
 */


public class MileTimeDBHelper extends SQLiteOpenHelper {

    public static final String MILE_TABLE_NAME = "MileTime";
    public static final String PRIMARY_KEY_NAME = "id";
    public static final String COL1_NAME = "time";
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "MileTime.db";
    private static final String TABLE_SPECIFICATIONS =
            // form: "CREATE TABLE Exercises(id INTEGER PRIMARY KEY, time INTEGER)"
            "CREATE TABLE " + MILE_TABLE_NAME + "(" +
                    PRIMARY_KEY_NAME + " INTEGER PRIMARY KEY, " + COL1_NAME + " INTEGER)";

    public MileTimeDBHelper(Context context) {
        // A database exists, named DATABASE_NAME, with TABLE_SPECIFICATIONS
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_SPECIFICATIONS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + MILE_TABLE_NAME);
        onCreate(db);
    }
}
