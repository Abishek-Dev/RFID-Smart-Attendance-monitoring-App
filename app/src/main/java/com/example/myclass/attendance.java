package com.example.myclass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class attendance extends AppCompatActivity {

    private RecyclerView recyclerView;
    WritableWorkbook workbook;
    Button Daonloaad;
    personAdapter
            adapter; // Create Object of the Adapter class
    DatabaseReference mbase; // Create object of the
    // Firebase Realtime Database
    String Name="ABK";
    List<DataModal> paymentUsersList;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        // Create a instance of the database and get
        // its reference
        mbase
                = FirebaseDatabase.getInstance().getReference("Attendance");
        Log.d("In", String.valueOf(mbase));

        recyclerView = findViewById(R.id.recycler1);
        Daonloaad=(Button)findViewById(R.id.export);

        // To display the Recycler view linearly
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this));

        Daonloaad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                        checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
                {
                    requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                }
                else
                {
                    //your code
                    createExcelSheet();
                }

            }
        });
        paymentUsersList = new ArrayList<>();

        // It is a class provide by the FirebaseUI to make a
        // query in the database to fetch appropriate data
        FirebaseRecyclerOptions<DataModal> options
                = new FirebaseRecyclerOptions.Builder<DataModal>()
                .setQuery(mbase, DataModal.class)
                .build();
        // Connecting object of required Adapter class to
        // the Adapter class itself
        adapter = new personAdapter(options);
        // Connecting Adapter class with the Recycler view*/
        recyclerView.setAdapter(adapter);
    }

    void createExcelSheet() {
        //File futureStudioIconFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), fileName);

        String csvFile = "ExcelsheetName.xls";
        java.io.File futureStudioIconFile = new java.io.File(Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                + "/" + csvFile);
        WorkbookSettings wbSettings = new WorkbookSettings();
        wbSettings.setLocale(new Locale("en", "EN"));
        try {
            workbook = Workbook.createWorkbook(futureStudioIconFile, wbSettings);
            createFirstSheet();
//            createSecondSheet();
            //closing cursor
            workbook.write();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void createFirstSheet() {
        try {
            mbase.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        DataModal pays = new DataModal();
                        pays.setName(snapshot.child("Name").getValue().toString());
                        pays.setCount(Integer.valueOf(snapshot.child("count").getValue().toString()));
                        pays.setRegisterNo(snapshot.child("RegisterNo").getValue().toString());
                        pays.setDate(snapshot.child("date").getValue().toString());
                        pays.setClassandSec(snapshot.child("ClassandSec").getValue().toString());

                        Log.d("User", "Name: " + pays.getName());
                        Log.d("User", "RegNo: " + pays.getRegisterNo());
                        Log.d("User", "Date: " + pays.getDate());

                        paymentUsersList.add(pays);
                    }
//                    try {
//                        createUserReport(paymentUsersList);
//                    } catch (FileNotFoundException | WriteException e) {
//                        e.printStackTrace();
//                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            WritableSheet sheet = workbook.createSheet("sheet1", 0);
            // column and row title
            sheet.addCell(new Label(0, 0, "Name"));
            sheet.addCell(new Label(1, 0, "RegisterNo"));
            sheet.addCell(new Label(2, 0, "ClassandSec"));
            sheet.addCell(new Label(3, 0, "Attendance"));
            sheet.addCell(new Label(4, 0, "Date"));
            for (int i = 0; i < paymentUsersList.size(); i++) {
                DataModal pay = paymentUsersList.get(i);
                String id = String.valueOf(i + 1);
                String name = pay.getName();
                String registerNo = pay.getRegisterNo();
                String classandsec = pay.getClassandSec();
                String count = String.valueOf(pay.getCount());
                String date = pay.getDate();
                String attend="";

                int c=Integer.parseInt(count);
                if(c%2==0){
                    attend="Absent";
                }
                else {
                    attend="Present";
                }

                Log.d("In loop of ", "createreport: " + registerNo);

                sheet.addCell(new Label(0, i + 1, name));
                sheet.addCell(new Label(1, i + 1, registerNo));
                sheet.addCell(new Label(2, i + 1, classandsec));
                sheet.addCell(new Label(3, i + 1, attend));
                sheet.addCell(new Label(4, i + 1, date));

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*private void createUserReport(List<DataModal> paymentUsersList) throws FileNotFoundException, WriteException {

         paymentUsersList = new ArrayList<>();


        paymentUsersList.add(new DataModal(Name,"firstName1","middleName1",5));
        paymentUsersList.add(new DataModal("mr","firstName1","middleName1",8));
        paymentUsersList.add(new DataModal("mr","firstName1","middleName1",10));
        //Excel sheet name. 0 (number)represents first sheet
        WritableSheet sheet = workbook.createSheet("sheet1", 0);
        // column and row title
        sheet.addCell(new Label(0, 0, "Name"));
        sheet.addCell(new Label(1, 0, "RegisterNo"));
        sheet.addCell(new Label(2, 0, "Date"));
        //sheet.addCell(new Label(3, 0, "lastName"));

        for (int i = 0; i < paymentUsersList.size(); i++) {
            DataModal pay = paymentUsersList.get(i);
            String id = String.valueOf(i + 1);
            String name = pay.getName();
            String sname = pay.getRegisterNo();
            String phone = pay.getDate();

            Log.d("In loop of ", "createreport: " + sname);

            sheet.addCell(new Label(0, i + 1, name));
            sheet.addCell(new Label(1, i + 1, sname));
            sheet.addCell(new Label(2, i + 1, phone));

        }
    }*/

    // Function to tell the app to start getting
    // data from database on starting of the activity
    @Override protected void onStart()
    {
        super.onStart();
        adapter.startListening();
    }

    // Function to tell the app to stop getting
    // data from database on stoping of the activity
    @Override protected void onStop()
    {
        super.onStop();
        adapter.stopListening();
    }
}
