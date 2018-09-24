package nl.grolman.rtchcathome;

import android.net.http.SslError;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.PermissionRequest;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebViewClient;
import android.webkit.WebView;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    View view;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_main, container, false);

        WebView myWebView;
        myWebView = view.findViewById(R.id.rtcWebview);

        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed(); // Ignore SSL certificate errors
            }
        });

        myWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onPermissionRequest(PermissionRequest request) {
                request.grant(request.getResources());
            }
        });

        myWebView.getSettings().setJavaScriptEnabled(true);
//        myWebView.getSettings().setAllowContentAccess(true);


//        myWebView.loadUrl("https://192.168.1.18:8080");
       myWebView.loadUrl("https://192.168.1.126:8080");
//        myWebView.loadUrl("https://192.168.2.179:8080");

        return view;
    }

}
