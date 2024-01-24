package com.example.thuchanh1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    protected EditText edtTen;
    protected EditText edtSdt;
    protected RadioButton rdbNam;
    protected RadioButton rdbNu;
    protected Spinner spnQue;
    protected Button btnAdd;
    protected ListView lstSv;

    protected ArrayList listSV;
    protected ArrayList listQUE;
    protected ArrayAdapter adapter;
    /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1,listSV);*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTen = findViewById(R.id.edtTen);
        edtSdt = findViewById(R.id.edtSdt);
        rdbNam = findViewById(R.id.rdbNam);
        rdbNu = findViewById(R.id.rdbNu);
        spnQue = findViewById(R.id.spnQue);
        btnAdd = findViewById(R.id.btnAdd);
        lstSv = findViewById(R.id.lstSv);

        listQUE = new ArrayList();
        listQUE.add("Hà Nội");
        listQUE.add("Nam Định");
        listQUE.add("Hà Nam");
        adapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,listQUE);
        spnQue.setAdapter(adapter);

        listSV = new ArrayList();
        listSV.add("Nguyễn Văn An-Nam-0963113494-Hà Nội");
        listSV.add("Trần Thị Bích-Nữ-0963113494-Nam Định");
        listSV.add("Mai Văn Chiến-Nam-0963113494-Hà Nam");
        adapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,listSV);
        lstSv.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = edtTen.getText().toString()+" - ";
                if(rdbNam.isChecked()){
                    x+="nam - ";

                }
                else if(rdbNu.isChecked()){
                    x+=" nu - ";
                }
                x+=edtSdt.getText().toString()+" - "+spnQue.getSelectedItem().toString();
                listSV.add(x);
                adapter.notifyDataSetChanged();
            }
        });
        edtSdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String input = s.toString();
                if(input.length()!=10 ||!TextUtils.isDigitsOnly(input)){
                    edtSdt.setError("Số điện thoại phải có 10 chữ số!");
                }else{
                    edtSdt.setError(null);
                }
            }
        });
    }
}