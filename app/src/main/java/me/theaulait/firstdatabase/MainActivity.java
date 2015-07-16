package me.theaulait.firstdatabase;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends ActionBarActivity {
    String username, userpass, confpass;
    Context mContext = this;
    @Bind(R.id.userName) EditText mUserName;
    @Bind(R.id.password) EditText mPassword;
    @Bind(R.id.confirmPassword) EditText mConfirmPass;
    @Bind(R.id.register) Button mRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        ButterKnife.bind(this);

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = mUserName.getText().toString();
                userpass = mPassword.getText().toString();
                confpass = mConfirmPass.getText().toString();
                if(!(userpass.equals(confpass))){
                    Toast.makeText(getBaseContext(), "Password does not match.", Toast.LENGTH_LONG).show();
                    mUserName.setText("");
                    mPassword.setText("");
                    mConfirmPass.setText("");
                } else{
                    DatabaseOperation DB = new DatabaseOperation(mContext);
                    DB.insertInfo(DB, username, userpass);
                    Toast.makeText(getBaseContext(), "Successful registration!", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
