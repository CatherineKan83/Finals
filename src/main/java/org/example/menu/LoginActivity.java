package main.java.org.example.menu;

import main.java.org.example.database.*;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import javax.naming.Context;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Инициализация полей ввода
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);

        // Авторизация пользователя
        findViewById(R.id.loginButton).setOnClickListener(v -> loginUser());
    }

    private void loginUser() {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        DatabaseHelper dbHelper = new DatabaseHelper((Context) this);

        try {
            // Хэшируем введенный пароль
            String hashedPassword = DatabaseHelper.hashPassword(password);
            boolean isAuthenticated = dbHelper.authenticateUser(username, hashedPassword);

            if (isAuthenticated) {
                Toast.makeText(this, "Вход успешен!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Неверный логин или пароль", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Ошибка при аутентификации", Toast.LENGTH_SHORT).show();
        }
    }
}