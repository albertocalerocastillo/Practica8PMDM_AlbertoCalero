package es.studium.practica8pmdmalbertocalero;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class PasitosController {
    private AyudanteBaseDeDatos BaseDatos;
    private String NOMBRE_TABLA = "pasitosApp";

    public PasitosController(Context contexto) {
        BaseDatos = new AyudanteBaseDeDatos(contexto);
    }

    public long nuevoRegistro(Pasitos pasitos) {
        SQLiteDatabase baseDeDatos = BaseDatos.getWritableDatabase();
        ContentValues valoresParaInsertar = new ContentValues();
        valoresParaInsertar.put("latitud", pasitos.getLatitud());
        valoresParaInsertar.put("longitud", pasitos.getLongitud());
        valoresParaInsertar.put("bateria", pasitos.getBateria());
        valoresParaInsertar.put("titulo", pasitos.getTitulo());
        return baseDeDatos.insert(NOMBRE_TABLA, null, valoresParaInsertar);
    }

    public ArrayList<Pasitos> obtenerUbicaciones() {
        ArrayList<Pasitos> pasos = new ArrayList<>();
        SQLiteDatabase baseDeDatos = BaseDatos.getReadableDatabase();
        String[] columnasAConsultar = {"latitud", "longitud", "bateria", "titulo"};
        Cursor cursor = baseDeDatos.query(
                NOMBRE_TABLA,
                columnasAConsultar,
                null,
                null,
                null,
                null,
                ""
        );
        if (cursor == null) {
            return pasos;
        }
        if (!cursor.moveToFirst()) {
            return pasos;
        }
        do {
            Double latitud = cursor.getDouble(0);
            Double longitud = cursor.getDouble(1);
            Double bateria = cursor.getDouble(2);
            String titulo = cursor.getString(3);
            Pasitos pasosObtenidos = new Pasitos(latitud, longitud, bateria, titulo);
            pasos.add(pasosObtenidos);
        } while (cursor.moveToNext());
        cursor.close();
        return pasos;
    }
}