package hotelguamuchil.hotelguamuchil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NuevoUsuario extends AppCompatActivity {

    EditText etNuevoUsuario, etContraseña, etRepContraseña, etCodigo;
    CrearTablaUsuarios ct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_usuario);
    }

    public void AgregarUsuario(View v){

        etNuevoUsuario = (EditText)findViewById(R.id.etNuevoUsuario);
        etContraseña = (EditText)findViewById(R.id.etContraseña);
        etRepContraseña = (EditText)findViewById(R.id.etRepContraseña);

        String cont1 = etContraseña.getText().toString();
        String cont2 = etRepContraseña.getText().toString();

        if (cont1.equals(cont2)){

                ct = new CrearTablaUsuarios(this);

                long res = ct.agregarUsuario(etNuevoUsuario.getText().toString(), etContraseña.getText().toString());

                Toast.makeText(this, "Los datos se guardaron satisfactoriamente en la BD.", Toast.LENGTH_LONG).show();
                etContraseña.setText(null);
                etRepContraseña.setText(null);
                etNuevoUsuario.setText(null);
        }
        else {
            Toast.makeText(this,"La contraseña no coincide.", Toast.LENGTH_LONG).show();

            etContraseña.setText(null);
            etRepContraseña.setText(null);
        }
    }
}
