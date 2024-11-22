package menu;


import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText usernameEditText, emailEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Инициализация полей ввода
        usernameEditText = findViewById(R.id.username);
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);

        // Регистрация пользователя
        findViewById(R.id.registerButton).setOnClickListener(v -> registerUser());
    }

    private void registerUser() {
        String username = usernameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        // Хэшируем пароль перед сохранением
        try {
            String hashedPassword = DatabaseHelper.hashPassword(password);
            DatabaseHelper dbHelper = new DatabaseHelper(this);
            dbHelper.addUser(username, email, hashedPassword);
            Toast.makeText(this, "Регистрация успешна!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Ошибка при регистрации", Toast.LENGTH_SHORT).show();
        }
    }
}