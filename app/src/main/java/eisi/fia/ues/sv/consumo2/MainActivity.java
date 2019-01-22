package eisi.fia.ues.sv.consumo2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity {
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        }

public void lanzarActividad(View v){

        Intent i = null;

        switch(v.getId()) {

                case R.id.button_promedio:
                        i = new Intent(this, PromedioClienteActivity.class);
                        break;
                case R.id.button_estadisticas:
                        i = new Intent(this, EstadisticasActivity.class);
                        break;
        }
        if(i!=null)
        startActivity(i);
        }
        }