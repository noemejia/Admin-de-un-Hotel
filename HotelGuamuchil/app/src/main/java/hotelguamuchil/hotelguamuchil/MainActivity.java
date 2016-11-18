package hotelguamuchil.hotelguamuchil;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUsuario, etContraseña;
    CrearTablaUsuarios ct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void eventoAcceder(View v){
       /* Intent intento = new Intent();
        intento.setClass(this, Reporte.class);
        startActivity(intento);*/

        etUsuario = (EditText)findViewById(R.id.etUsuario);
        etContraseña = (EditText)findViewById(R.id.etContraseña);

        ct = new CrearTablaUsuarios(this);

        String usuario = etUsuario.getText().toString();
        String contraseña = etContraseña.getText().toString();

        String usu, cont;

        Cursor c = ct.ConsultarUsuarios();

        while(c.moveToNext()) {

            usu="";
            cont="";

            int id = c.getColumnIndex(TablaUsuarios.ID_USUARIO);

            int NombreUsuario = c.getColumnIndex(TablaUsuarios.NOMBRE_USUARIO);
            String usuari = c.getString(NombreUsuario);
            usu = usuari;

            int Contraseña = c.getColumnIndex(TablaUsuarios.CONTRASEÑA);
            String contra = c.getString(Contraseña);
            cont = contra;

            if (usuario.equals(usu) && contraseña.equals(cont)){
            //if (etUsuario.getText().toString().equals("Noe") || etContraseña.getText().toString().equals("1234")){
                Intent intento = new Intent();
                intento.setClass(this, Reporte.class);
                startActivity(intento);

                break;
            }
            else{
                Toast.makeText(this,"El usuario no existe o los datos son incorrectos. ", Toast.LENGTH_SHORT).show();
                Limpiar();
            }
        }
    }

    public void NuevoUsuario(View v){
        Intent intento = new Intent();
        intento.setClass(this, NuevoUsuario.class);
        startActivity(intento);
    }

    public void Limpiar(){
        etContraseña.setText(null);
        etUsuario.setText(null);
    }
}
