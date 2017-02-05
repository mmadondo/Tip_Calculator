package malvernmadondo.tip_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//declaring variables
  EditText etBill;
   EditText etNumPeople;
    TextView tvTotalTip;
    TextView tvTipPerPerson;
    CheckBox cbService;
    RadioButton rb1, rb2, rb3, rb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize variables
        etBill = (EditText) findViewById(R.id.editTextBill);
        etNumPeople = (EditText) findViewById(R.id.editTextNumPeople);
        tvTotalTip = (TextView) findViewById(R.id.textViewTotalTip);
        tvTipPerPerson = (TextView) findViewById(R.id.textViewTipPP);
        cbService = (CheckBox) findViewById(R.id.checkBoxService);
    }

    public void onClickButtonCalc(View view) {
Double bill = Double.parseDouble(etBill.getText().toString());
        //Double numPeople = Double.parseDouble(etNumPeople.getText().toString()); //This works with TextBox
        Integer numPeople = 1; //default number of people

        if(rb1.isChecked()){
            numPeople = 1;
        }
        else if(rb2.isChecked()){
            numPeople = 2;
        }
        else if(rb3.isChecked()){
            numPeople = 3;
        }
        else if(rb4.isChecked()){
            numPeople = 4;
        }
        Double totalTip;
       if(cbService.isChecked()){
           totalTip = bill * 0.2; //for outstanding services
       }else{
           totalTip = bill * 0.1; //for regular services
       }

        Double tipPerson = totalTip/numPeople;

        tvTotalTip.setText("Total bill " + etBill.toString());
        tvTipPerPerson.setText("Total bill " + tipPerson.toString());
    }
}
