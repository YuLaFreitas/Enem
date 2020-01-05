package com.appENEM.menugrupal;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AlertDialogLayout;
import androidx.fragment.app.DialogFragment;

public class Resposta {
    private Context context;
    Resposta(Context x){
        context = x;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @JavascriptInterface
    public void comentario(String texto){
        final AlertDialogLayout adl = new AlertDialogLayout(context);
        TextView tx = new TextView(context);

        tx.setTextColor(Color.BLUE);
        tx.setText(texto);
        tx.setVerticalScrollBarEnabled(true);
        tx.onScreenStateChanged(ScrollView.SCROLLBAR_POSITION_LEFT);
        tx.setGravity(View.TEXT_ALIGNMENT_CENTER);
        tx.setFreezesText(true);

        DialogFragment df = new DialogFragment();

        final AlertDialog.Builder tela = new AlertDialog.Builder(context);

        adl.setMeasureWithLargestChildEnabled(true);
        adl.setVerticalGravity(View.TEXT_ALIGNMENT_CENTER);
        adl.addView(tx);
        adl.setScrollY(View.SCROLL_AXIS_VERTICAL);
        adl.computeScroll();
        tela.setView(adl);
        tela.setNegativeButton("cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, int which) {

                        Runnable run = new Runnable() {
                            @Override
                            public void run() {
                               // adl.animate().cancel();
                                //dialog.dismiss();
                            }
                        };
                        adl
                                .animate()
                                .translationXBy(2000)
                                .setDuration(20000)
                                .withEndAction(run);
                        tela.setView(adl);
                    }
                }
        );
        tela.create();
        df.onDismiss(tela.show());
        df.getDialog();
    }
}
