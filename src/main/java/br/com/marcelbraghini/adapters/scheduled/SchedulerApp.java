package br.com.marcelbraghini.adapters.scheduled;

import io.quarkus.scheduler.Scheduled;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@ApplicationScoped
public class SchedulerApp {

    @Scheduled(every="10s")
    public void increment() throws IOException {
        URL url = new URL("http://localhost:8080/health/live");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
    }

}
