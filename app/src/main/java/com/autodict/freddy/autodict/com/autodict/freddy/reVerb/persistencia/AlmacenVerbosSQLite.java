package com.autodict.freddy.autodict.com.autodict.freddy.reVerb.persistencia;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.autodict.freddy.autodict.com.autodict.freddy.reVerb.DTO.VerboDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freddy on 15/01/2017.
 */

public class AlmacenVerbosSQLite extends SQLiteOpenHelper implements AlmacenVerbos {


    public AlmacenVerbosSQLite(Context context) {
        super(context, "verbos", null, 1);

    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String query = "CREATE TABLE verbos ("+"_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "infinito TEXT, simple TEXT, participio TEXT, significado TEXT)";
        db.execSQL(query);
    }

    @Override
    public String guardarVerbo(VerboDTO verbo) {
        String resultado =  "Verbo guardado correctamente";
        SQLiteDatabase db2 = getReadableDatabase();
        String consulta = "SELECT _id, infinito, simple, participio FROM verbos " +
                "WHERE infinito = '"+verbo.getInfinitivo()+"'";
        System.out.println(consulta);
        Cursor cursor = db2.rawQuery(consulta,null);

        if (cursor.getCount() == 0) {
            SQLiteDatabase db = getWritableDatabase();
            String query = "INSERT INTO verbos VALUES ( null,'"
                    + verbo.getInfinitivo() + "', '" + verbo.getPasadoSimple()
                    + "', '" + verbo.getPasadoParticipio() +
                    "', '" + verbo.getSignificado() + "')";
            db.execSQL(query);
            db.close();
        }else {
            resultado = "Verbo ya existe!!!";
        }
        db2.close();
        return resultado;
    }

    public List<VerboDTO> consultarListaVerbos(){
        SQLiteDatabase db2 = getReadableDatabase();
        String consulta = "SELECT infinito, simple, participio, significado FROM verbos ";
        System.out.println(consulta);
        Cursor cursor = db2.rawQuery(consulta,null);
        List <VerboDTO> lista = new ArrayList<VerboDTO>();
        while (cursor.moveToNext()) {
            VerboDTO verbo = new VerboDTO();
            verbo.setInfinitivo(cursor.getString(0));
            verbo.setPasadoSimple(cursor.getString(1));
            verbo.setPasadoParticipio(cursor.getString(2));
            verbo.setSignificado(cursor.getString(3));
            lista.add(verbo);
        }
        db2.close();
        return lista;
    }

    @Override
    public List<VerboDTO> listaVerbos(int cantidad) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub

    }


}
