package com.example.financlick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Movimentacao extends AppCompatActivity {

    private ListView lvMovimentacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimentacao);

        lvMovimentacao = (ListView) findViewById( R.id.lvMovimentacao );

        lvMovimentacao.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,long id) {
                tratarSelecao( position );
            }
        });
    }

    protected void tratarSelecao( int position ) {
        if(position == 0){
            Intent telaNewRevenue = new Intent(this, NewRevenue.class);
            startActivity(telaNewRevenue);
        }
        if(position == 1){
            Intent telaNewExpense = new Intent(this, NewExpense.class);
            startActivity(telaNewExpense);
        }
    }
}