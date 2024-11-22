package main.java.org.example.menu;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class AccountsActivity extends AppCompatActivity {

    private ListView accountsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);

        accountsListView = findViewById(R.id.accountsListView);

        // Получаем список аккаунтов из базы данных
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        List<String> accounts = dbHelper.getAllAccounts();

        // Настройка адаптера для отображения аккаунтов
        AccountsAdapter adapter = new AccountsAdapter(this, accounts);
        accountsListView.setAdapter(adapter);
    }
}