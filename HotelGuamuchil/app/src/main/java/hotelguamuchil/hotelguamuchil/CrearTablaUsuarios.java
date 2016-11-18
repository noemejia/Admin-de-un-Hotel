package hotelguamuchil.hotelguamuchil;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Noé on 18/10/2016.
 */
public class CrearTablaUsuarios extends SQLiteOpenHelper{

    private static final String NOMBRE_BD="bdhuespedes";
    private static final int  VERSION_BASE_DATOS=1;

    public CrearTablaUsuarios(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    CrearTablaUsuarios(Context contex){
        super(contex,NOMBRE_BD,null,VERSION_BASE_DATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL("create table "+ TablaUsuarios.NOMBRE_TABLA +"("+TablaUsuarios.ID_USUARIO+" integer primary key autoincrement, "+
                TablaUsuarios.NOMBRE_USUARIO+" varchar(45), "+TablaUsuarios.CONTRASEÑA+" varchar(20)); ");
    }

    public long agregarUsuario(String nombre, String contraseña){

        //crear un objeto contenedor del valor

        ContentValues cv = new ContentValues();

        cv.put(TablaUsuarios.NOMBRE_USUARIO, nombre);
        cv.put(TablaUsuarios.CONTRASEÑA, contraseña);

        SQLiteDatabase sd=getWritableDatabase();
        long result = sd.insert(TablaUsuarios.NOMBRE_TABLA, null,cv);

        return result;
    }

    public Cursor ConsultarUsuarios() {
        SQLiteDatabase sd = getWritableDatabase();
        String[] cols = new String[]{TablaUsuarios.ID_USUARIO,
                TablaUsuarios.NOMBRE_USUARIO,
                TablaUsuarios.CONTRASEÑA,};
        Cursor c = sd.query(TablaUsuarios.NOMBRE_TABLA, cols, null, null, null, null, null, null);
        return c;
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int i, int i1) {
        onCreate(bd);
    }
}
