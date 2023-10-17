package Listener;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example2.recyclerview.HomePage;
import com.example2.recyclerview.MainActivity;

public class MyListener implements View.OnClickListener {
    private MainActivity mainActivity;
    private EditText editTextUsername;
    private EditText editTextPassword;

    public MyListener(MainActivity mainActivity, EditText editTextUsername, EditText editTextPassword) {
        this.mainActivity = mainActivity;
        this.editTextUsername = editTextUsername;
        this.editTextPassword = editTextPassword;


    }

    @Override
    public void onClick(View v) {
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();
        if (username.isEmpty() && password.isEmpty()) {
            editTextUsername.setError("Please provide username");
            editTextPassword.setError("Please provide password");
            editTextUsername.requestFocus();
            editTextPassword.requestFocus();

        } else if (username.isEmpty()) {
            editTextUsername.setError("Please provide username");
            editTextUsername.requestFocus();
        } else if (password.isEmpty()) {
            editTextPassword.setError("Please provide password");
            editTextPassword.requestFocus();
        } else {
            String arr[] = username.split("@", 2);
            if (password.equals("999")) {
                Intent intent = new Intent(mainActivity, HomePage.class);
                intent.putExtra("username", arr[0]);
                mainActivity.startActivity(intent);
                Toast.makeText(mainActivity, "Logged In", Toast.LENGTH_SHORT).show();


            } else
                Toast.makeText(mainActivity, "Password is Incorrect", Toast.LENGTH_SHORT).show();


        }

    }
}
