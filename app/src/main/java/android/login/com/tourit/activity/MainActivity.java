package android.login.com.tourit.activity;

import android.app.Activity;
import android.content.Intent;
import android.login.com.tourit.R;
import android.login.com.tourit.model.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @BindView(R.id.location_spinner)
    Spinner mLocationSpinner;

    @BindView(R.id.section_select)
    RadioGroup mSectionSelect;

    @BindView(R.id.search_quary_amount)
    EditText mAmountEt;

    private Location mLocation;
    private String mSection;
    @OnClick(R.id.search_btn)
    public void onClickSearch(View view){
        if (!mAmountEt.getText().toString().isEmpty()) {
            Intent intent = new Intent(this, SearchResultActivity.class);
            intent.putExtra(SearchResultActivity.AMOUNT, Long.parseLong(mAmountEt.getText().toString()));

            mSection = ((RadioButton)findViewById(mSectionSelect.getCheckedRadioButtonId())).getText().toString();
            intent.putExtra(SearchResultActivity.SECTION, mSection);
            intent.putExtra(SearchResultActivity.LOCATION, mLocation.toString());
            startActivity(intent);
            finish();
        } else {
            mAmountEt.setError("Please fill the amount field");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        final List<Location> locations = new ArrayList<>();
        ArrayAdapter<Location> dataAdapter = new ArrayAdapter<Location>(this,
                android.R.layout.simple_spinner_item, locations);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mLocationSpinner.setAdapter(dataAdapter);


        mLocationSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mLocation = locations.get(position);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        ButterKnife.bind(this);
    }
}
