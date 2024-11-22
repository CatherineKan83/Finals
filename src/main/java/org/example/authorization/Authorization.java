package main.java.org.example.authorization;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import static main.java.org.example.database.DatabaseHelper.*;

public boolean authenticateUser(String username, String password) {
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.query(TABLE_USERS, new String[]{COLUMN_USERNAME, COLUMN_PASSWORD},
            COLUMN_USERNAME + "=? AND " + COLUMN_PASSWORD + "=?", new String[]{username, password},
            null, null, null);
    boolean isAuthenticated = cursor.getCount() > 0;
    cursor.close();
    return isAuthenticated;
}