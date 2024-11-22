package main.java.org.example.accounts;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import static main.java.org.example.database.DatabaseHelper.*;

public void addAccount(String accountName, String login, String password) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put(COLUMN_ACCOUNT_NAME, accountName);
    values.put(COLUMN_ACCOUNT_LOGIN, login);
    values.put(COLUMN_ACCOUNT_PASSWORD, password);
    db.insert(TABLE_ACCOUNTS, null, values);
}
