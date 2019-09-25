package br.com.marcus.gas;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView web = findViewById(R.id.webview);
        web.getSettings().setJavaScriptEnabled(true);
        web.setWebChromeClient(new WebChromeClient());
        web.setWebViewClient(new WebViewClient());
        web.loadUrl("file:///android_asset/index.html");

        web.addJavascriptInterface(new Ponte(this), "Marcus");

    }

    class Ponte {
        Context contexto;
        public Ponte(Context contexto) {
            this.contexto = contexto;
        }

        @JavascriptInterface
        public void grava(String sPosto, String sLitros, String sQuilometragem, String sPreco, String sAtendimento) {
            String posto         = sPosto;
            long   litros        = Long.parseLong(sLitros);
            long   quilometragem = Long.parseLong(sQuilometragem);
            double preco         = Double.parseDouble(sPreco);
            String atendimento   = sAtendimento;
            Log.d("GRAVA", posto + "-" + litros  + "-" +  quilometragem  + "-" +  preco  + "-" +  atendimento);

            Banco bd = new Banco(contexto, 1);
            long resultado = bd.insere(posto, litros, quilometragem, preco, atendimento);
            if (resultado > 0) {
                Toast.makeText(contexto, "Dados Inseridos", Toast.LENGTH_LONG). show();
            } else {
                Toast.makeText(contexto, "Problema na Inserção", Toast.LENGTH_LONG). show();
            }
        }

        @JavascriptInterface
        public void consultaTodos() {
            Banco bd = new Banco(contexto, 1);
            ArrayList<Abastecimento> a = bd.consultaTodos();
            String texto="";
            if (a != null) {
                for (int i=0; i < a.size(); i++) {
                    System.out.println ("Posto: " + a.get(i).getPosto());
                    System.out.println ("Litros: "+ a.get(i).getLitros());
                    System.out.println ("Quilometragem: "+ a.get(i).getQuilometragem());
                    System.out.println ("Preco: "+ a.get(i).getPreco());
                    System.out.println ("Atendimento: "+ a.get(i).getAtendimento());
                }
            } else {
                System.out.println ("Não há dados");

            }
        }

    }
}
