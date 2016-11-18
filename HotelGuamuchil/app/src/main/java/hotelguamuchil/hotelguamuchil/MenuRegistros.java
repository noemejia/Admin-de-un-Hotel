package hotelguamuchil.hotelguamuchil;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MenuRegistros extends AppCompatActivity {
    TextView tvNombre, tvDias, tvTarifa, tvSubTotal, tvDescuento, tvTotal,
    tvTipo1, tvTipo2, tvTipo3, tvTipo4, tvTipo5, tvTotalHuespedes, tvTotalDias;
    CrearTabla ct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_registros);

    //public void Mostrar() {
        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvDias = (TextView) findViewById(R.id.tvDias);
        tvTarifa = (TextView) findViewById(R.id.tvTarifa);
        tvSubTotal = (TextView) findViewById(R.id.tvSubTotal);
        tvDescuento = (TextView) findViewById(R.id.tvDescuento);
        tvTotalHuespedes = (TextView)findViewById(R.id.tvTotalHuespedes);
        tvTotalDias = (TextView)findViewById(R.id.tvTotalDiasOcup);
        tvTotal = (TextView) findViewById(R.id.tvTotal);
        tvTipo1 = (TextView) findViewById(R.id.tvTipo1);
        tvTipo2 = (TextView) findViewById(R.id.tvTipo2);
        tvTipo3 = (TextView) findViewById(R.id.tvTipo3);
        tvTipo4 = (TextView) findViewById(R.id.tvTipo4);
        tvTipo5 = (TextView) findViewById(R.id.tvTipo5);

        int contador = 0;
        String nombres = "";
        String Dias = "";
        String Tarifa = "";
        String Subtotal = "";
        String Descuento = "";
        String Total = "";

        int contdias=0;
        int tardia;
        int tipo1=0, tipo2=0, tipo3=0, tipo4=0, tipo5=0;

        ct = new CrearTabla(this);

        Cursor c = ct.MostrarHuespedes();

        while (c.moveToNext()) {

            tardia=0;

            int columnaNombre = c.getColumnIndex(TablaHuespedes.NOMBRE_HUESPED);
            String nombre = c.getString(columnaNombre);
            nombres = nombres + nombre + "\n";

            int Diass = c.getColumnIndex(TablaHuespedes.DIAS);
            String dia = c.getString(Diass);
            tardia = Integer.parseInt(dia);
            Dias = Dias + dia + "\n";
            contdias = contdias +Integer.parseInt(dia);

            int Tarifass = c.getColumnIndex(TablaHuespedes.TARIFA);
            String U2 = c.getString(Tarifass);
            Tarifa = Tarifa + U2 + "\n";
            if (Integer.parseInt(U2) == 120){
                tipo1=tipo1 + tardia;
            }else if (Integer.parseInt(U2) == 155){
                tipo2 = tipo2 + tardia;
            }else if (Integer.parseInt(U2) == 210){
                tipo3 = tipo3 + tardia;
            }else if (Integer.parseInt(U2) == 285){
                tipo4 = tipo4 + tardia;
            }else if (Integer.parseInt(U2) == 400){
                tipo5 = tipo5 + tardia;
            }

            int Subtotall = c.getColumnIndex(TablaHuespedes.SUBTOTAL);
            String U3 = c.getString(Subtotall);
            Subtotal = Subtotal + U3 + "\n";

            int Descuent = c.getColumnIndex(TablaHuespedes.DESCUENTO);
            String U4 = c.getString(Descuent);
            Descuento = Descuento + U4 + "\n";

            int Totall = c.getColumnIndex(TablaHuespedes.TOTAL);
            String U5 = c.getString(Totall);
            Total = Total + U5 + "\n";

            contador ++;

        }

        tvNombre.setText(nombres);
        tvDias.setText(Dias);
        tvTarifa.setText(Tarifa);
        tvSubTotal.setText(Subtotal);
        tvDescuento.setText(Descuento);
        tvTotal.setText(Total);
        tvTotalHuespedes.setText("Total: "+contador+" huespedes");
        tvTotalDias.setText("Total de dias de ocupacion: "+contdias);
        tvTipo1.setText("Tipo1: "+tipo1+" dias.   ");
        tvTipo2.setText("Tipo2: "+tipo2+" dias.   ");
        tvTipo3.setText("Tipo3: "+tipo3+" dias.   ");
        tvTipo4.setText("Tipo4: "+tipo4+" dias.   ");
        tvTipo5.setText("Tipo5: "+tipo5+" dias.   ");

  }
}
