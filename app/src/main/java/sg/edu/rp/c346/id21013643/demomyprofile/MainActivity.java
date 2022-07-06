package sg.edu.rp.c346.id21013643.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText etName, etGPA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etGPA = findViewById(R.id.editTextGPA);
        etName = findViewById(R.id.editTextName);

    }

    @Override
    protected void onPause() {
        super.onPause();

        String strName = etName.getText().toString();
        float gpa = Float.parseFloat(etGPA.getText().toString());

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        SharedPreferences.Editor prefsEdit = prefs.edit();

        prefsEdit.putString("Name", strName);
        prefsEdit.putFloat("GPA", gpa);

        prefsEdit.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        String strName = prefs.getString("Name", "John");
        float gpa = prefs.getFloat("gpa", 0);

        etName.setText(strName);
        etGPA.setText(gpa + "");

    }
}