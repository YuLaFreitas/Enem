package com.appENEM.menugrupal;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

public class Resposta {
    private Context context;
    Resposta(Context x){
        context = x;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @JavascriptInterface
    public void comentario(String texto){
        AlertDialog.Builder adl = new AlertDialog.Builder(context);
        final TextView tx = new TextView(context);

        tx.setTextColor(Color.BLUE);
        tx.setText(texto);
        tx.setVerticalScrollBarEnabled(true);
        tx.onScreenStateChanged(ScrollView.SCROLLBAR_POSITION_LEFT);
        tx.setGravity(View.TEXT_ALIGNMENT_CENTER);
        tx.setFreezesText(true);
        tx.setMovementMethod(new ScrollingMovementMethod());

        adl.setView(tx);
        adl.setNegativeButton("ENTENDEU???",null);
    adl.create().show();
    }
}
