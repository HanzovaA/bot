package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import io.github.sceneview.ar.ArSceneView;
import io.github.sceneview.node.Node;

public class MainActivity extends AppCompatActivity {
    private ArSceneView arSceneView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        arSceneView = findViewById(R.id.arSceneView);
        loadModel();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void loadModel() {
        ModelLoader.loadModel(this, "souhvezdi.glb", modelRenderable -> {
            Node node = new Node();
            node.setRenderable(modelRenderable);
            node.setParent(arSceneView.getScene());
        });
    }
}