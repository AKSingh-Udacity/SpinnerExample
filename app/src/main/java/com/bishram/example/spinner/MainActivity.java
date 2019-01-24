package com.bishram.example.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner spinnerName = findViewById(R.id.spinner_name);
        final Spinner spinnerStatus = findViewById(R.id.spinner_status);

        final String[] names = {"--- Select an item ---"};

        final String[] status = {"--- Select an item ---", "Status 00", "Status 01", "Status 02"};

        final List<String> namesList = new ArrayList<>(Arrays.asList(names));

        final List<String> statusList = new ArrayList<>(Arrays.asList(status));

        namesList.add("Item #00");
        namesList.add("Item #01");
        namesList.add("Item #02");
        namesList.add("Item #03");
        namesList.add("Item #04");

        ArrayAdapter<String> adapterName = new ArrayAdapter<>(this, R.layout.spinner_item, namesList);

        final ArrayAdapter<String> adapterStatus = new ArrayAdapter<>(this, R.layout.spinner_item, statusList);

        adapterName.setDropDownViewResource(R.layout.spinner_item_drop_down);

        spinnerName.setAdapter(adapterName);

        spinnerName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = spinnerName.getSelectedItem().toString();

                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();

                if (text.equals(names[0])) {
                    spinnerStatus.setEnabled(false);
                    statusList.clear();
                    statusList.add(status[0]);
                    adapterStatus.notifyDataSetChanged();
                } else {
                    spinnerStatus.setEnabled(true);
                    statusList.clear();
                    statusList.addAll(Arrays.asList(status));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Todo: Update your code here.
            }
        });

        adapterStatus.setDropDownViewResource(R.layout.spinner_item_drop_down);

        spinnerStatus.setAdapter(adapterStatus);
    }
}
