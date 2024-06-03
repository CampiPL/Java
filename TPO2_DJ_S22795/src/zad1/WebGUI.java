package zad1;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class WebGUI extends JFrame{
    private JPanel webPanel;
    private JPanel mainPanel;
    private JPanel infoPanel;
    private JPanel weatherPanel;
    private JPanel currencyPanel;
    private JPanel NBPPanel;
    private JLabel tempLabel;
    private JLabel currencyLabel;
    private JLabel NBPLabel;
    private JLabel pressure;
    private JLabel humidityLabel;
    private JFXPanel jfxPanel;
    private WebView webView;

    Service s;
    String weatherJson;
    Double rate1;
    Double rate2;

    public WebGUI(Service s,String weatherJson, Double rate1, Double rate2) throws HeadlessException {

        this.s = s;
        this.weatherJson = weatherJson;
        this.rate1 = rate1;
        this.rate2 = rate2;

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.jfxPanel = new JFXPanel();
        Platform.runLater(this::createJFXContent);

        JSONParser parser = new JSONParser();
        JSONObject parse = null;
        try {
            parse = (JSONObject) parser.parse(this.weatherJson);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert parse != null;

        JSONObject parseMain = (JSONObject) parse.get("main");

        DecimalFormat df = new DecimalFormat("0.00");

        this.tempLabel.setText("Temp: " + df.format(Double.parseDouble(parseMain.get("temp") + "")-272.15)
                .replace(',','.'));
        this.pressure.setText("Pressure: " + parseMain.get("pressure"));
        this.humidityLabel.setText("Humidity: " + parseMain.get("humidity"));

        this.currencyLabel.setText("Exchange rate: " + rate1);

        this.NBPLabel.setText("NBP rate: " + rate2);

        this.webPanel.add(this.jfxPanel);
        this.add(this.mainPanel);

        this.pack();
    }

    private void createJFXContent(){

        JSONParser parser = new JSONParser();
        JSONObject parse = null;
        try {
            parse = (JSONObject) parser.parse(weatherJson);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert parse != null;

        this.webView = new WebView();
        this.webView.getEngine().load("https://en.wikipedia.org/wiki/" + parse.get("name"));
        Scene scene = new Scene(this.webView);
        this.jfxPanel.setScene(scene);
        this.pack();
    }

}
