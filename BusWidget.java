import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.cert.CertificateException;

public class BusWidget extends Widget {
    @Override
    Widget instance() {
        return null;
    }

    @Override
    void display() {

    }
    private static OkHttpClient getUnsafeOkHttpClient() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[] {
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager)trustAllCerts[0]);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

            OkHttpClient okHttpClient = builder.build();
            return okHttpClient;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    void showBusData(String url) {
        String data = requestBusData(url);
        JSONArray busLines = new JSONArray(data);

        for (int i = 0; i < busLines.length(); i++) {
            JSONObject line = busLines.getJSONObject(i);
            int lineNumber = line.getInt("Shilut");
            int minutes = line.getInt("MinutesToArrival");
            if (minutes == 0) {
                System.out.println("Bus line number " + Integer.toString(lineNumber) + " arrived to the station.\n");
            } else {
                System.out.println("Bus line number " + Integer.toString(lineNumber) + " will arrive in the station in "
                        + Integer.toString(minutes) + " minutes.\n");
            }
        }
    }

    String requestBusData(String url) {
        OkHttpClient client = getUnsafeOkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.body() == null) {
                System.out.println("No body in response");
                return null;
            }
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
