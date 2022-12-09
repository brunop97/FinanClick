package com.example.financlick;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class NewExpense extends AppCompatActivity {
    private TextView expenseDescription, expenseValue, expenseDate, expenseCategory, expenseAmount;
    private Switch expenseFixed, expenseRecurrent;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_expense);

        expenseDescription = findViewById(R.id.expenseDescription);
        expenseValue = findViewById(R.id.expenseValue);
        expenseDate = findViewById(R.id.expenseDate);
        expenseCategory = findViewById(R.id.expenseCategory);
        expenseFixed = findViewById(R.id.expenseFixed);
        expenseRecurrent = findViewById(R.id.expenseRecurrent);
        expenseAmount = findViewById(R.id.expenseAmount);
    }

    public void addExpense(View view) {
        Map<String, Object> expense = new HashMap<>();
        expense.put("description", expenseDescription.getText().toString());
        expense.put("value", Double.parseDouble(expenseValue.getText().toString()));
        expense.put("date", expenseDate.getText().toString());
        expense.put("category", expenseCategory.getText().toString());
        expense.put("fixed", expenseFixed.isChecked());
        expense.put("recurrent", expenseRecurrent.isChecked());
        expense.put("amount", Integer.parseInt(expenseAmount.getText().toString()));

        db.collection("expenses").add(expense).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                mainScreen();
                Toast.makeText(getApplicationContext(), "Despesa adicionada com sucesso", Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Erro ao adicionar despesa", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void mainScreen () {
        Intent telaMainScreen = new Intent(this, MainScreen.class);
        startActivity(telaMainScreen);
    }
}
