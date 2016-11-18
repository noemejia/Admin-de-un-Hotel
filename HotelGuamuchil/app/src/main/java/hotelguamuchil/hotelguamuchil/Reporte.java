package hotelguamuchil.hotelguamuchil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Reporte extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte);
    }

    public void Registro(View v){
        Intent intento = new Intent();
        intento.setClass(this, Registro.class);
        startActivity(intento);
    }

    public void Reporte(View v){
        Intent intento = new Intent();
        intento.setClass(this, MenuRegistros.class);
        startActivity(intento);
    }
}
