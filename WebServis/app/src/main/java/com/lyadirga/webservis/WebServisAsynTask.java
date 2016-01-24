package com.lyadirga.webservis;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class WebServisAsynTask extends AsyncTask < String, String , List<String> > {

    private Context context;
    private ListView liste;
    private ProgressDialog progressDialog;


    public  WebServisAsynTask(Context context) {
        this.context = context;

        liste=(ListView)((AppCompatActivity)context).findViewById(R.id.listView);


    }

    @Override
    protected void onPreExecute() {
        //UI Thread içerisinde yürütülür...
        // ilk çalışacak metoddur..
        //Task çalışmadan önce yapılacak hazırlıklar burada yapılır...
        progressDialog= ProgressDialog.show(context, "Lütfen bekleyiniz...", "İşlem yürütülüyor...", true);
    }

    @Override
    protected List<String> doInBackground(String... params) {
        //Override edilmesi zorunlu...
        //1. Parametre buraya geliyor
        //execute metoduna verilen arguman ile çağrılır. Arkaplan işlemleri burada yapılır.
        // geriye dönen değer 3. parametre tipinde ve onPostExecute metoduna arguman olarak veriliyor.
        // UI Thread içinde değil yardımcı Thread içerisinde çalışır...
        //Burada arayüz güncellenemez...
        //publishProgress metodu ile onProgressUpdate metoduna bilgi gönderiliyor

        List<String> doviz_list=new ArrayList<String>();
        HttpURLConnection baglanti=null;

        try {
            URL url=new URL(params[0]);

            baglanti= (HttpURLConnection) url.openConnection();

            int baglanti_durumu=baglanti.getResponseCode();

            if(baglanti_durumu==HttpURLConnection.HTTP_OK){

                BufferedInputStream stream= new BufferedInputStream(baglanti.getInputStream());

                publishProgress("Döviz kurları okunuyor...");  //ProgressDialog güncellemesi için bilgi gönderiliyor

                DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();

                Document document=documentBuilder.parse(stream); //iki farklı paket var


                NodeList dovizNodeList=document.getElementsByTagName("Currency");

                for (int i=0 ; i<dovizNodeList.getLength() ; i++){

                    Element element= (Element) dovizNodeList.item(i); //üç farklı paket var

                    NodeList nodeListBirim=element.getElementsByTagName("Unit");
                    NodeList nodeListParaBirimi=element.getElementsByTagName("Isim");
                    NodeList nodeListAlis=element.getElementsByTagName("ForexBuying");
                    NodeList nodeListSatis=element.getElementsByTagName("ForexSelling");

                    String birim=nodeListBirim.item(0).getFirstChild().getNodeValue();
                    String parabirimi=nodeListParaBirimi.item(0).getFirstChild().getNodeValue();
                    String alis=nodeListAlis.item(0).getFirstChild().getNodeValue();
                    String satis=nodeListSatis.item(0).getFirstChild().getNodeValue();



                    doviz_list.add( birim+" "+parabirimi+"  Alış: "+alis+" Satış: "+satis );

                }

                publishProgress("Liste güncelleniyor..."); //ProgressDialog güncellemesi için bilgi gönderiliyor


            }

        }catch (Exception e){

            Log.e("Xml parse hatası", e.getMessage().toString());

        }finally {

            if(baglanti != null)
                baglanti.disconnect();
        }


        return doviz_list;
    }



    @Override
    protected void onProgressUpdate(String... values) {
        //UI Thread içerisinde yürütülür...
        // 2. parametre tipinde değer buraya arguman olarak geliyor...
        //ProgressDialog güncelleniyor...
        // doInBackground içerisinden publishProgress metodu ile arguman gönderiliyor.
        progressDialog.setMessage(values[0]);
    }


    @Override
    protected void onPostExecute(List<String> result) {
        //UI Thread içerisinde yürütülür...
        //Parametre olarak doInBackground metodunun sonucunu alır
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(context,android.R.layout.simple_expandable_list_item_1,result);
        liste.setAdapter(adapter);
        progressDialog.cancel();
    }

    @Override
    protected void onCancelled(List<String> strings) {
        super.onCancelled(strings);
        //UI Thread içerisinde yürütülür...
        //Herhangi bir sebepten dolayı AsyncTask iptal edilirse bu metod uyarılır.
        //Burada kullanıdığınız kaynakları temizleyebilirsiniz.
    }
}
