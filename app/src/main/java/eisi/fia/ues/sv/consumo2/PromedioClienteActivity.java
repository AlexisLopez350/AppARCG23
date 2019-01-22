package eisi.fia.ues.sv.consumo2;

import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.JsonReader;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.io.InputStreamReader;

@SuppressLint("NewApi")
public class PromedioClienteActivity extends Activity {

    TextView t1Txt;
    TextView t2Txt;
    TextView t3Txt;
    TextView h1Txt;
    TextView h2Txt;
    TextView h3Txt;
    TextView hr1Txt;
    TextView hr2Txt;
    Button btn1;

    private final String urlExterno = "https://lq12001-pdm115-2018.000webhostapp.com/ARC.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promedio_cliente);

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

        btn1 = (Button) findViewById(R.id.button1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consultarPromedioExterno();
            }
        });

        consultarPromedioExterno();
    }

    public void consultarPromedioExterno() {
        String url = urlExterno;

        try {
            String saldoPromedioJSON = ControladorServicio.obtenerRespuestaPeticion(
                    url, this);

            JSONObject json = new JSONObject(saldoPromedioJSON);

            t1Txt.setText(
                    json.getString("t1"));
            t2Txt.setText(
                    json.getString("t2"));
            t3Txt.setText(
                    json.getString("t3"));
            h1Txt.setText(
                    json.getString("h1"));
            h2Txt.setText(
                    json.getString("h2"));
            h3Txt.setText(
                    json.getString("h3"));
            hr1Txt.setText(
                    json.getString("hr1"));
            hr2Txt.setText(
                    json.getString("hr2"));
        }
        catch (Exception e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG)
                    .show();
        }

    }

}
