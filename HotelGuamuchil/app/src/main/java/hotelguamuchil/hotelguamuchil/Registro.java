package hotelguamuchil.hotelguamuchil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    EditText etNombre, etDias;
    RadioButton rbUno, rbDos, rbTres, rbCuatro, rbCinco;
    TextView tvSubTotal, tvDescuento, tvTotal;
    CrearTabla ct;
    int dias;
    float Tarifa=0;
    float SubTotal=0;
    float Total=0;
    float descuento=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }

    public void Calcular(View v){
        etDias = (EditText)findViewById(R.id.etDias);
        tvDescuento = (TextView)findViewById(R.id.tvDescuento);
        tvSubTotal = (TextView)findViewById(R.id.tvSubTotal);
        tvTotal = (TextView)findViewById(R.id.tvTotal);

        int dias = Integer.parseInt(etDias.getText().toString());
        //int dias2 = Integer.parseInt(etDias.getText().toString());
        if (etDias.getText().toString().equals(null)){
            Toast.makeText(this,"Debes ingrear los dias.", Toast.LENGTH_SHORT).show();
        }else{

            Tarifa = Tarifa();

            if (dias > 5 ){
                SubTotal = Tarifa * dias;
                Tarifa = SubTotal * 0.10f;
                descuento = Tarifa;
                Total = SubTotal - descuento;
            }else if (dias > 10 ){
                SubTotal = Tarifa * dias;
                Tarifa = SubTotal * 0.15f;
                descuento = Tarifa;
                Total = SubTotal - descuento;
            }else if (dias > 15 ){
                SubTotal = Tarifa * dias;
                Tarifa = SubTotal * 0.20f;
                descuento = Tarifa;
                Total = SubTotal - descuento;
            }else if (dias <= 5){
                SubTotal = Tarifa * dias;
                Tarifa = SubTotal * 0.0f;
                descuento = Tarifa;
                Total = SubTotal - descuento;
            }

            tvSubTotal.setText(SubTotal + "");
            tvDescuento.setText(descuento+"");
            tvTotal.setText(Total+"");
        }
    }
        int tipo=0;


    public float Tarifa(){
        rbUno = (RadioButton)findViewById(R.id.rbUno);
        rbDos = (RadioButton)findViewById(R.id.rbDos);
        rbTres = (RadioButton)findViewById(R.id.rbTres);
        rbCuatro = (RadioButton)findViewById(R.id.rbCuatro);
        rbCinco = (RadioButton)findViewById(R.id.rbCinco);

        float tarifa=0;

        if(rbUno.isChecked()){
            tarifa = 120;
            tipo =1;
        }else if (rbDos.isChecked()){
            tarifa = 155;
            tipo =2;
        }else if (rbTres.isChecked()){
            tarifa = 210;
            tipo =3;
        }else if (rbCuatro.isChecked()){
            tarifa = 285;
            tipo =4;
        }else if (rbCinco.isChecked()){
            tarifa = 400;
            tipo =5;
        }
        return tarifa;
    }

    public void Guardar(View v){

        etNombre = (EditText)findViewById(R.id.etNombre);
        etDias = (EditText)findViewById(R.id.etDias);
        float tarifa = Tarifa();
        tvSubTotal = (TextView) findViewById(R.id.tvSubTotal);
        tvDescuento = (TextView)findViewById(R.id.tvDescuento);
        tvTotal = (TextView)findViewById(R.id.tvTotal);

            ct = new CrearTabla(this);

            long result = ct.agregarHuesped(etNombre.getText().toString(), Integer.parseInt(etDias.getText().toString()), tarifa,
                    Float.parseFloat(tvSubTotal.getText().toString()), Float.parseFloat(tvDescuento.getText().toString()),
                    Float.parseFloat(tvTotal.getText().toString()));


            Toast.makeText(this, "Los datos se guardaron satisfactoriamente en la BD", Toast.LENGTH_LONG).show();

            etNombre.setText(null);
            etDias.setText(null);
            tvSubTotal.setText(null);
            tvDescuento.setText(null);
            tvTotal.setText(null);

            Intent intento = new Intent();
            intento.setClass(this, Reporte.class);
            startActivity(intento);

           // Toast.makeText(this, "Los datos NO se guardaron en la BD. ", Toast.LENGTH_LONG).show();
    }
}
