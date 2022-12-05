package com.example.financlick;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.financlick.json.CambioObj;
import com.example.financlick.json.Utils;

public class MainScreen extends AppCompatActivity {

    private TextView compraUSD;
    private TextView vendaUSD;
    private TextView compraEUR;
    private TextView vendaEUR;
    private ProgressDialog load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        compraUSD = (TextView)findViewById(R.id.textView34);
        vendaUSD = (TextView)findViewById(R.id.textView30);
        compraEUR= (TextView)findViewById(R.id.textView35);
        vendaEUR = (TextView)findViewById(R.id.textView31);

        findViewById(R.id.fab).setOnClickListener(view -> telaMovimentacao());

    }

    public void telaMovimentacao () {
        Intent telaMovimentacao = new Intent(this, Movimentacao.class);
        startActivity(telaMovimentacao);
    }

    public void acionaSync(View view){
        GetJson download = new GetJson();
        download.execute();
    }

    private class GetJson extends AsyncTask<Void, Void, CambioObj> {

        @Override
        protected void onPreExecute(){
            load = ProgressDialog.show(MainScreen.this,
                    "Por favor Aguarde ...", "Recuperando Informações do Servidor...");
        }

        @Override
        protected CambioObj doInBackground(Void... params) {
            Utils util = new Utils();
            return util.getInformacao("https://economia.awesomeapi.com.br/json/last/USD-BRL,EUR-BRL");
        }

        @Override
        protected void onPostExecute(CambioObj cambio){
            compraUSD.setText(cambio.getCompraUSD());
            vendaUSD.setText(cambio.getVendaUSD());
            compraEUR.setText(cambio.getCompraEUR());
            vendaEUR.setText(cambio.getVendaEUR());

            load.dismiss();
        }
    }

}



