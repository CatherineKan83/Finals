package main.java.org.example.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;

import static android.os.Build.VERSION_CODES.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Инфляция меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    // Обработка выбора пунктов меню
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_register:
                // Переход на экран регистрации
                Intent intentRegister = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intentRegister);
                return true;

            case R.id.action_login:
                // Переход на экран логина
                Intent intentLogin = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intentLogin);
                return true;

            case R.id.action_accounts:
                // Переход на экран управления аккаунтами
                Intent intentAccounts = new Intent(MainActivity.this, AccountsActivity.class);
                startActivity(intentAccounts);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}