package nikitaverma.example.com.calculator;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import nikitaverma.example.com.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setMainActivityModelView(new MainActivityModelView());
     //   activityMainBinding.spinner1.setPrompt("R.string.choose_enter_data_length_type");

     //   activityMainBinding.getItem().setSelectedItemPosition(4); // this will change spinner selection.
     //   System.out.println(getResources().getStringArray(R.array.length)[activityMainBinding.getMainActivityModelView().getSelectedItemPosition()]);

    }

}
