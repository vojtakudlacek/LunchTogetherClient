package lunch_together.purkynova.com.lunchtogetherclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import lunch_together.purkynova.com.lunchtogetherclient.model.Model;

/**
 * @author Vojtěch Kudláček
 */
public class LoginActivity extends AppCompatActivity {
    private EditText nickEditText;
    private EditText passwordEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        nickEditText = (EditText) findViewById(R.id.loginActivity_editTextnickName);
        passwordEditText = (EditText) findViewById(R.id.loginActivity_editTextPassword);
    }

    public void onClickLogin(View view) {
        int userID;
        String email = nickEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        Model commModel = new Model();

        if(!(email.equals("") || password.equals("")))
        {
            userID = commModel.login(email,password);
            if (userID != -1)
            {
                Intent listIntent = new Intent(this,EventListActivity.class); //Edit to listActivity
                listIntent.putExtra("id",userID);
                startActivity(listIntent);
                finish();
            }else
            {
                Toast.makeText(this,"Heslo nebo email nebyli zadány správně",Toast.LENGTH_LONG).show();
            }
        }else
        {
            Toast.makeText(this,"Všechna pole musí být vyplněna",Toast.LENGTH_LONG).show();
        }
    }

    public void onClickRegister_activityLogin(View view) {
        Intent registerIntent = new Intent(this,RegisterActivity.class);
        startActivity(registerIntent); //starting RegisterActivity

    }
}
