package br.com.marcus.gas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class Banco extends SQLiteOpenHelper{
    public Banco(Context context, int version) {
        super(context, "gas", null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase banco) {
        String sql = " CREATE TABLE abastece ( " +
                     " id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     " posto TEXT, " +
                     " litros INTEGER, " +
                     " quilometragem INTEGER, " +
                     " preco REAL, " +
                     " atendimento TEXT )";
        banco.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public ArrayList<Abastecimento> consultaTodos() {
        ArrayList<Abastecimento> resultado=null;
        SQLiteDatabase banco = this.getReadableDatabase();
        String sql = " SELECT * FROM abastece";
        Cursor c = banco.rawQuery(sql, null);
        if (c.moveToFirst()) {
            resultado = new ArrayList<Abastecimento>();
            do {
                Abastecimento a = new Abastecimento();
                a.setPosto(c.getString(1));
                a.setLitros(c.getLong(2));
                a.setQuilometragem(c.getLong(3));
                a.setPreco(c.getDouble(4));
                a.setAtendimento(c.getString(5));
                resultado.add(a);
            } while (c.moveToNext());
        }
        return resultado;
    }

    public long insere(String posto, long litros, long quilometragem, double preco, String atendimento) {
        Log.d("BANCO", posto + "-" + litros  + "-" +  quilometragem  + "-" +  preco  + "-" +  atendimento);
        SQLiteDatabase banco = this.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put ("posto", posto);
        registro.put ("litros", litros);
        registro.put ("preco", preco);
        registro.put ("atendimento", atendimento);
        long retorno = banco.insert("abastece", null, registro);
        return retorno;
    }
}
