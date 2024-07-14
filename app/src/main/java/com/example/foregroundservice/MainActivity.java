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
        TextView txtDetObraDescripcion = findViewById(R.id.txtDetObraDescripcion);
        txtDetObraDescripcion.setText(descripcion);
        btnReproducir = findViewById(R.id.btnReproducir);
        btnReproducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAudioService();
            }
        });
    }

    private void startAudioService() {
        Intent serviceIntent = new Intent(this, ServicioAudio.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(serviceIntent);
        } else {
            startService(serviceIntent);
        }
    }
}
