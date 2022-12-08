package com.example.financlick;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class NewRevenue extends AppCompatActivity {
    private TextView revenueDescription, revenueValue, revenueDate, revenueCategory, revenueAmount;
    private Switch revenueFixed, revenueRecurrent;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_revenue);

        revenueDescription = findViewById(R.id.revenueDescription);
        revenueValue = findViewById(R.id.revenueValue);
        revenueDate = findViewById(R.id.revenueDate);
        revenueCategory = findViewById(R.id.revenueCategory);
        revenueFixed = findViewById(R.id.revenueFixed);
        revenueRecurrent = findViewById(R.id.revenueRecurrent);
        revenueAmount = findViewById(R.id.revenueAmount);
    }

    public void addRevenue(View view) {
        Map<String, Object> revenue = new HashMap<>();
        revenue.put("description", revenueDescription.getText().toString());
        revenue.put("value", Double.parseDouble(revenueValue.getText().toString()));
        revenue.put("date", revenueDate.getText().toString());
        revenue.put("category", revenueCategory.getText().toString());
        revenue.put("fixed", revenueFixed.isChecked());
        revenue.put("recurrent", revenueRecurrent.isChecked());
        revenue.put("amount", Integer.parseInt(revenueAmount.getText().toString()));

        db.collection("revenues").add(revenue).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(getApplicationContext(), "Receita adicionada com sucesso", Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Erro ao adicionar receita", Toast.LENGTH_LONG).show();
            }
        });
    }
}