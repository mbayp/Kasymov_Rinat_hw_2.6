package com.example.kasymov_rinat_hw_26;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextView welcomeTextView;
    private TextView doEnterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.edit_text_one);
        passwordEditText = findViewById(R.id.edit_text_two);
        loginButton = findViewById(R.id.button);
        welcomeTextView = findViewById(R.id.welcome);
        doEnterTextView = findViewById(R.id.do_enter);

        // Добавляем слушателей текста для EditText'ов
        emailEditText.addTextChangedListener(textWatcher);
        passwordEditText.addTextChangedListener(textWatcher);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Проверка логина и пароля
                if (email.equals("admin") && password.equals("admin")) {
                    // Верно введенные данные
                    Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();

                    // Скрыть тексты и EditText
                    welcomeTextView.setVisibility(View.VISIBLE);
                    doEnterTextView.setVisibility(View.GONE);
                    emailEditText.setVisibility(View.GONE);
                    passwordEditText.setVisibility(View.GONE);
                    loginButton.setVisibility(View.GONE);
                } else {
                    // Неверные данные
                    Toast.makeText(MainActivity.this, "Неправильный логин и пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // Не используется
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // При изменении текста в любом из EditText'ов
            updateButtonColor();
        }

        @Override
        public void afterTextChanged(Editable s) {
            // Не используется
        }
    };

    private void updateButtonColor() {
        // Получаем текст из обоих EditText'ов
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        // Условие: если оба EditText'а не пустые, меняем цвет фона кнопки на оранжевый
        if (!email.isEmpty() && !password.isEmpty()) {
            loginButton.setBackgroundTintList(getResources().getColorStateList(R.color.orange)); // Предполагается, что у вас есть соответствующая разметка цвета в colors.xml
        } else {
            loginButton.setBackgroundTintList(getResources().getColorStateList(R.color.gray)); // Предполагается, что у вас есть соответствующая разметка цвета в colors.xml
        }
    }
}