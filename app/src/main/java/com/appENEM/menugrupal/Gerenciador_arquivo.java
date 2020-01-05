package com.appENEM.menugrupal;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class Gerenciador_arquivo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questoes);
        Intent in = getIntent();
        String valor = in.getStringExtra("escolha");
        ativarWebView(valor);
    }

    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface", "SetJavaScriptEnabled"})
    public void ativarWebView(String url){
        WebView web = findViewById(R.id.web);
        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setDomStorageEnabled(true);
        web.getSettings().setSupportMultipleWindows(true);
        web.getSettings().getBlockNetworkLoads();
        web.addJavascriptInterface(new Resposta(this), "Resposta");
        web.showContextMenu();
        web.loadUrl(
                "file:///android_asset/perguntas/" + url);
    }

}
