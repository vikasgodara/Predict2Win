package com.hello_world.vikas.predict2win;

import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Signup extends AppCompatActivity
{

    private FirebaseAuth mAuth;
    private static final String TAG = "EmailPassword";
    private EditText mEmailField;
    private EditText mPasswordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button b1= (Button) findViewById(R.id.fbbutton);
        b1.getBackground().setAlpha(0);
        Button b2= (Button) findViewById(R.id.googlebutton);
        b2.getBackground().setAlpha(0);
        GradientDrawable gd = new GradientDrawable();
        gd.setCornerRadius(4);
        gd.setStroke(1, 0xFF000000);
        b1.setBackgroundDrawable(gd);
        b2.setBackgroundDrawable(gd);

        mAuth = FirebaseAuth.getInstance();

        mEmailField = (EditText) findViewById(R.id.email);

        mPasswordField = (EditText) findViewById(R.id.existingUserPasswordEditText);



    }
    private void createAccount(String email, String password) {

        Log.d(TAG, "createAccount:" + email);

        if (!validateForm()) {

            return;

        }



        // [START create_user_with_email]

        mAuth.createUserWithEmailAndPassword(email, password)

                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override

                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            // Sign in success, update UI with the signed-in user's information

                            Log.d(TAG, "createUserWithEmail:success");

                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(Signup.this, "Account Created",

                                    Toast.LENGTH_SHORT).show();



                        } else {

                            // If sign in fails, display a message to the user.

                            Log.w(TAG, "createUserWithEmail:failure", task.getException());

                            Toast.makeText(Signup.this, "Authentication failed.",

                                    Toast.LENGTH_SHORT).show();



                        }



                        // [START_EXCLUDE]



                        // [END_EXCLUDE]

                    }

                });

        // [END create_user_with_email]

    }

    private void signIn(String email, String password) {

        Log.d(TAG, "signIn:" + email);

        if (!validateForm()) {

            return;

        }






        // [START sign_in_with_email]

        mAuth.signInWithEmailAndPassword(email, password)

                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override

                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            // Sign in success, update UI with the signed-in user's information

                            Log.d(TAG, "signInWithEmail:success");

                            FirebaseUser user = mAuth.getCurrentUser();



                        } else {

                            // If sign in fails, display a message to the user.

                            Log.w(TAG, "signInWithEmail:failure", task.getException());

                            Toast.makeText(Signup.this, "Authentication failed.",

                                    Toast.LENGTH_SHORT).show();



                        }



                        // [START_EXCLUDE]

                        if (!task.isSuccessful()) {

                            Toast.makeText(Signup.this, "Authentication failed.",

                                    Toast.LENGTH_SHORT).show();
                        }


                        // [END_EXCLUDE]

                    }

                });

        // [END sign_in_with_email]

    }



    private void sendEmailVerification() {

        // Disable button



        // Send verification email

        // [START send_email_verification]

        final FirebaseUser user = mAuth.getCurrentUser();

        user.sendEmailVerification()

                .addOnCompleteListener(this, new OnCompleteListener<Void>() {

                    @Override

                    public void onComplete(@NonNull Task<Void> task) {

                        // [START_EXCLUDE]

                        // Re-enable button




                        if (task.isSuccessful()) {

                            Toast.makeText(Signup.this,

                                    "Verification email sent to " + user.getEmail(),

                                    Toast.LENGTH_SHORT).show();

                        } else {

                            Log.e(TAG, "sendEmailVerification", task.getException());

                            Toast.makeText(Signup.this,

                                    "Failed to send verification email.",

                                    Toast.LENGTH_SHORT).show();

                        }

                        // [END_EXCLUDE]

                    }

                });

        // [END send_email_verification]

    }



    private boolean validateForm() {

        boolean valid = true;



        String email = mEmailField.getText().toString();

        if (TextUtils.isEmpty(email)) {

            mEmailField.setError("Required.");

            valid = false;

        } else {

            mEmailField.setError(null);

        }



        String password = mPasswordField.getText().toString();

        if (TextUtils.isEmpty(password)) {

            mPasswordField.setError("Required.");

            valid = false;

        } else {

            mPasswordField.setError(null);

        }



        return valid;

    }







    public void CreateAccount(View v) {

        int i = v.getId();

        createAccount(mEmailField.getText().toString(), mPasswordField.getText().toString());

        /*} else if (i == R.id.email_sign_in_button) {

            signIn(mEmailField.getText().toString(), mPasswordField.getText().toString());

        } else if (i == R.id.sign_out_button) {

            signOut();

        } else if (i == R.id.verify_email_button) {

            sendEmailVerification();

        }*/

    }

}

