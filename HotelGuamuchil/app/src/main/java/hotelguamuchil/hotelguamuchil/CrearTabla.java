package hotelguamuchil.hotelguamuchil;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Noé on 18/10/2016.
 */
public class CrearTabla extends SQLiteOpenHelper {

    private static final String NOMBRE_BD="bdhuespedes";
    private static final int  VERSION_BASE_DATOS=1;

    public CrearTabla(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    CrearTabla(Context contex){
        super(contex,NOMBRE_BD,null,VERSION_BASE_DATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TablaHuespedes.NOMBRE_TABLA +"( "+TablaHuespedes.ID_HUESPED+" integer primary key autoincrement, "+
                TablaHuespedes.NOMBRE_HUESPED+" varchar(45), "+ TablaHuespedes.DIAS+" integer, "+TablaHuespedes.TARIFA+" float, "+
                TablaHuespedes.SUBTOTAL+ " float, "+ TablaHuespedes.DESCUENTO + " float, " +
                TablaHuespedes.TOTAL+ " float);");
    }

    public long agregarHuesped(String nombre, int dias, float tarifa, float subtotal, float descuento, float total){

        ContentValues cv = new ContentValues();

        cv.put(TablaHuespedes.NOMBRE_HUESPED, nombre);
        cv.put(TablaHuespedes.DIAS, dias);
        cv.put(TablaHuespedes.TARIFA, tarifa);
        cv.put(TablaHuespedes.SUBTOTAL, subtotal);
        cv.put(TablaHuespedes.DESCUENTO, descuento);
        cv.put(TablaHuespedes.TOTAL, total);

        SQLiteDatabase sd=getWritableDatabase();
        long result = sd.insert(TablaHuespedes.NOMBRE_TABLA, null,cv);

        return result;
    }

    public Cursor MostrarHuespedes() {
        SQLiteDatabase sd = getWritableDatabase();
        String[] cols = new String[]{TablaHuespedes.ID_HUESPED,
                TablaHuespedes.NOMBRE_HUESPED,
                TablaHuespedes.DIAS,
                TablaHuespedes.TARIFA,
                TablaHuespedes.SUBTOTAL,
                TablaHuespedes.DESCUENTO,
                TablaHuespedes.TOTAL,};
        Cursor c = sd.query(TablaHuespedes.NOMBRE_TABLA, cols, null, null, null, null, null, null);
        return c;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        onCreate(db);
    }
}
