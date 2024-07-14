package com.example.foregroundservice;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageButton btnReproducir;
    ImageButton btnDetener;
    ImageButton btnPausar;
    ImageButton btnReiniciar;
    String tituloCuadro = "La Otra Ciudad";
    String descripcion = "“La Otra Ciudad” se perfila como una invitación a lo inadvertido. " +
            "La urbe convencional que es desafiada por la mirada atenta del artista, " +
            "revela una belleza latente sumergida entre la velocidad de la cotidianeidad. " +
            "Los márgenes de la metrópolis aciaga y ciega son palpables mediante " +
            "un conjunto de luces, sombras y texturas que aplican para devenir en " +
            "abstracción.";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtDetObraTitulo = findViewById(R.id.txtDetObraTitulo);
        txtDetObraTitulo.setText(tituloCuadro);
        TextView txtDetObraDescripcion = findViewById(R.id.txtDetObraDescripcion);
        txtDetObraDescripcion.setText(descripcion);
        btnReproducir = findViewById(R.id.btnReproducir);
        btnDetener = findViewById(R.id.btnDetener);
        btnPausar = findViewById(R.id.btnPausar);
        btnReiniciar = findViewById(R.id.btnReiniciar);

        btnReproducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAudioService();
            }
        });
        btnDetener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pararReproduccion();
            }
        });
        btnPausar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pausarReproduccion();
            }
        });
        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reiniciarReproduccion();
            }
        });

    }

    private void startAudioService() {
        Intent serviceIntent = new Intent(this, ServicioAudio.class);
        serviceIntent.putExtra("nombreCuadro",tituloCuadro);
        serviceIntent.putExtra("nombreArchivo","audio_cuadro.mp3");
        serviceIntent.putExtra("control","reproducir");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(serviceIntent);
        } else {
            startService(serviceIntent);
        }
    }
    private void pararReproduccion(){
        Intent serviceIntent = new Intent(this, ServicioAudio.class);
        serviceIntent.putExtra("nombreCuadro",tituloCuadro);
        serviceIntent.putExtra("control","parar");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(serviceIntent);
        } else {
            startService(serviceIntent);
        }
    }
    private void pausarReproduccion(){
        Intent serviceIntent = new Intent(this, ServicioAudio.class);
        serviceIntent.putExtra("nombreCuadro",tituloCuadro);
        serviceIntent.putExtra("control","pausar");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(serviceIntent);
        } else {
            startService(serviceIntent);
        }
    }
    private void reiniciarReproduccion(){
        Intent serviceIntent = new Intent(this, ServicioAudio.class);
        serviceIntent.putExtra("nombreCuadro",tituloCuadro);
        serviceIntent.putExtra("control","reiniciar");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(serviceIntent);
        } else {
            startService(serviceIntent);
        }
    }
}
