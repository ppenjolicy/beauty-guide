package com.example.beautyguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.ar.core.AugmentedFace;
import com.google.ar.core.Frame;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.Renderable;
import com.google.ar.sceneform.rendering.Texture;
import com.google.ar.sceneform.ux.AugmentedFaceNode;

import java.util.Collection;

import de.hdodenhof.circleimageview.CircleImageView;

public class Brown5 extends AppCompatActivity {

    private ModelRenderable modelRenderable;
    private Texture texture;
    private boolean isAdded = false;

    private CircleImageView cir1,cir2,cir3,cir4,cir5;
    private Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brow1);

        /**menu**/
        home = (Button) findViewById(R.id.b_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Brown5.this,MainActivity.class));
            }
        });

        cir1 = (CircleImageView) findViewById(R.id.color1);
        cir2 = (CircleImageView) findViewById(R.id.color2);
        cir3 = (CircleImageView) findViewById(R.id.color3);
        cir4 = (CircleImageView) findViewById(R.id.color4);
        cir5 = (CircleImageView) findViewById(R.id.color5);

        cir2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Brown5.this,Brown2.class));
            }
        });
        cir3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Brown5.this,Brown3.class));
            }
        });
        cir4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Brown5.this,Brown4.class));
            }
        });
        cir1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Brown5.this,Brow1.class));
            }
        });/**End Menu**/

        /**ArCamera**/
        CustomArFragment customARFragment = (CustomArFragment) getSupportFragmentManager().findFragmentById(R.id.ux_fragment);

        ModelRenderable.builder()
                .setSource(this,R.raw.fox_face)
                .build()
                .thenAccept(renderable1 -> {
                    modelRenderable = renderable1;

                    modelRenderable.setShadowCaster(false);
                    modelRenderable.setShadowReceiver(false);
                });

        Texture.builder()
                .setSource(this,R.drawable.brow5)
                .build()
                .thenAccept(texture -> this.texture = texture);

        customARFragment.getArSceneView().setCameraStreamRenderPriority(Renderable.RENDER_PRIORITY_FIRST);

        customARFragment.getArSceneView().getScene().addOnUpdateListener(frameTime -> {

            if(modelRenderable == null || texture == null)
                return;

            Frame frame = customARFragment.getArSceneView().getArFrame();

            Collection<AugmentedFace> augmentedFaces = frame.getUpdatedTrackables(AugmentedFace.class);

            for(AugmentedFace augmentedFace : augmentedFaces){
                if(isAdded)
                    return;

                AugmentedFaceNode augmentedFaceNode = new AugmentedFaceNode(augmentedFace);
                augmentedFaceNode.setParent(customARFragment.getArSceneView().getScene());
                //augmentedFaceNode.setFaceRegionsRenderable(modelRenderable);
                augmentedFaceNode.setFaceMeshTexture(texture);

                isAdded = true;

            }

        });/**End ArCamera**/
    }
}
