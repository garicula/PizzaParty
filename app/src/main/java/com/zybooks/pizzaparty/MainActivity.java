// Garrick Morley
// ISYS 221-001
// Assignment #1 - Pizza Application
// Due: 09/19/2021

package com.zybooks.pizzaparty;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private final static String TAG = "MainActivity";
    public static int slices;


    private EditText mNumAttendEditText;
    private TextView mNumPizzasTextView;
    public RadioGroup mHowHungryRadioGroup, mPizzaSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d(TAG, "onCreate was called");
        // Assign the widgets to fields
        mNumAttendEditText = findViewById(R.id.num_attend_edit_text);
        mNumPizzasTextView = findViewById(R.id.num_pizzas_text_view);
        mHowHungryRadioGroup = findViewById(R.id.hungry_radio_group);

        // size radio group modification
        mPizzaSize = findViewById(R.id.size_radio_group);
    }

    public void calculateClick(View view) {

        // Get how many are attending the party
        int numAttend;
        try {
            String numAttendStr = mNumAttendEditText.getText().toString();
            numAttend = Integer.parseInt(numAttendStr);
        } catch (NumberFormatException ex) {
            numAttend = 0;
        }

        // Get hunger level selection
        int checkedId = mHowHungryRadioGroup.getCheckedRadioButtonId();
        PizzaCalculator.HungerLevel hungerLevel = PizzaCalculator.HungerLevel.RAVENOUS;
        if (checkedId == R.id.light_radio_button) {
            hungerLevel = PizzaCalculator.HungerLevel.LIGHT;
        } else if (checkedId == R.id.medium_radio_button) {
            hungerLevel = PizzaCalculator.HungerLevel.MEDIUM;
        }

        // Get slices per pizza
        int sizeCheckedId = mPizzaSize.getCheckedRadioButtonId();
        if (sizeCheckedId == R.id.small_radio_button)
        {
            slices = 4;
        }
        else if (sizeCheckedId == R.id.mediumSize_radio_button)
        {
            slices = 6;
        }
        else if (sizeCheckedId == R.id.large_radio_button)
        {
            slices = 8;
        }

        // Get the number of pizzas needed
        PizzaCalculator calc = new PizzaCalculator(numAttend, hungerLevel, slices);
        int totalPizzas = calc.getTotalPizzas();



        // Place totalPizzas into the string resource and display
        String totalText = getString(R.string.total_pizzas, totalPizzas);
        mNumPizzasTextView.setText(totalText);

    }
}


