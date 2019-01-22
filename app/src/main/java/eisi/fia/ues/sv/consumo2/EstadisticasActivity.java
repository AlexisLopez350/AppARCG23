package eisi.fia.ues.sv.consumo2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EstadisticasActivity extends Activity {

    TextView t1Txt;
    TextView t2Txt;
    TextView t3Txt;
    TextView h1Txt;
    TextView h2Txt;
    TextView h3Txt;
    TextView hr1Txt;
    TextView hr2Txt;
    TextView t12Txt;
    TextView t22Txt;
    TextView t32Txt;
    TextView h12Txt;
    TextView h22Txt;
    TextView h32Txt;
    TextView hr12Txt;
    TextView hr22Txt;
    EditText fecha1;
    EditText fecha2;
    EditText hora;
    Button btn1;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        t1Txt = (TextView) findViewById(R.id.edit_text_t1);
        t2Txt = (TextView) findViewById(R.id.edit_text_t2);
        t3Txt = (TextView) findViewById(R.id.edit_text_t3);
        h1Txt = (TextView) findViewById(R.id.edit_text_h1);
        h2Txt = (TextView) findViewById(R.id.edit_text_h2);
        h3Txt = (TextView) findViewById(R.id.edit_text_h3);
        hr1Txt = (TextView) findViewById(R.id.edit_text_hr1);
        hr2Txt = (TextView) findViewById(R.id.edit_text_hr2);
        t12Txt = (TextView) findViewById(R.id.edit_text_t12);
        t22Txt = (TextView) findViewById(R.id.edit_text_t22);
        t32Txt = (TextView) findViewById(R.id.edit_text_t32);
        h12Txt = (TextView) findViewById(R.id.edit_text_h12);
        h22Txt = (TextView) findViewById(R.id.edit_text_h22);
        h32Txt = (TextView) findViewById(R.id.edit_text_h32);
        hr12Txt = (TextView) findViewById(R.id.edit_text_hr12);
        hr22Txt = (TextView) findViewById(R.id.edit_text_hr22);
        fecha1 = findViewById(R.id.editFecha1);
        fecha2 = findViewById(R.id.editFecha2);
        hora = findViewById(R.id.editHora);

        btn1 = (Button) findViewById(R.id.button);

        /*btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consultarPromedioExterno();
            }
        });

        consultarPromedioExterno();*/
    }

    public void consultarPromedioExterno(View v) {
        String url =  "https://lq12001-pdm115-2018.000webhostapp.com/ARC_comparar.php?fecha1="+fecha1.getText().toString()+"&fecha2="+fecha2.getText().toString()+"&hora="+hora.getText().toString()+"";

        try {
            String saldoPromedioJSON = ControladorServicio.obtenerRespuestaPeticion(url, this);

            JSONArray json = new JSONArray(saldoPromedioJSON);

            //JSONArray jsonArray = json.getJSONArray(saldoPromedioJSON);
           /*for (int i = 0; i < json.length(); i++)
            {
                try {
                    JSONObject jsonObjectHijo = json.getJSONObject(i);
                    t1Txt.setText(
                            jsonObjectHijo.getString("t1"));
                    t2Txt.setText(
                            jsonObjectHijo.getString("t2"));
                    t3Txt.setText(
                            jsonObjectHijo.getString("t3"));
                    h1Txt.setText(
                            jsonObjectHijo.getString("h1"));
                    h2Txt.setText(
                            jsonObjectHijo.getString("h2"));
                    h3Txt.setText(
                            jsonObjectHijo.getString("h3"));
                    hr1Txt.setText(
                            jsonObjectHijo.getString("hr1"));
                    hr2Txt.setText(
                            jsonObjectHijo.getString("hr2"));
                } catch (JSONException e) {
                    Log.e("Parser JSON", e.toString());
                }
            }*/

            t1Txt.setText(
                    json.getJSONObject(0).getString("t1"));
            t2Txt.setText(
                    json.getJSONObject(0).getString("t2"));
            t3Txt.setText(
                    json.getJSONObject(0).getString("t3"));
            h1Txt.setText(
                    json.getJSONObject(0).getString("h1"));
            h2Txt.setText(
                    json.getJSONObject(0).getString("h2"));
            h3Txt.setText(
                    json.getJSONObject(0).getString("h3"));
            hr1Txt.setText(
                    json.getJSONObject(0).getString("hr1"));
            hr2Txt.setText(
                    json.getJSONObject(0).getString("hr2"));

            t12Txt.setText(
                    json.getJSONObject(1).getString("t1"));
            t22Txt.setText(
                    json.getJSONObject(1).getString("t2"));
            t32Txt.setText(
                    json.getJSONObject(1).getString("t3"));
            h12Txt.setText(
                    json.getJSONObject(1).getString("h1"));
            h22Txt.setText(
                    json.getJSONObject(1).getString("h2"));
            h32Txt.setText(
                    json.getJSONObject(1).getString("h3"));
            hr12Txt.setText(
                    json.getJSONObject(1).getString("hr1"));
            hr22Txt.setText(
                    json.getJSONObject(1).getString("hr2"));
        }
        catch (Exception e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG)
                    .show();
        }

    }

}







