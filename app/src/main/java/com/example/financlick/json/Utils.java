package com.example.financlick.json;

import org.json.JSONException;
import org.json.JSONObject;

public class Utils{
    public CambioObj getInformacao(String end){
        String json;
        CambioObj retorno;
        json = Network.getJSONFromAPI(end);
        retorno = parseJson(json);

        return retorno;
    }

    private CambioObj parseJson(String json){
        try {
            CambioObj cambio = new CambioObj();
            JSONObject jsonObj = new JSONObject(json);

            JSONObject USD = jsonObj.getJSONObject("USDBRL");
            cambio.setCompraUSD(USD.getString("bid"));
            cambio.setVendaUSD(USD.getString("ask"));

            JSONObject EUR = jsonObj.getJSONObject("EURBRL");
            cambio.setCompraEUR(EUR.getString("bid"));
            cambio.setVendaEUR(EUR.getString("ask"));

            return cambio;
        }
        catch (JSONException e){
            e.printStackTrace();
            return null;
        }
    }

}
