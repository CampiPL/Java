package zad1;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Currency;
import java.util.Locale;
import java.util.stream.Collectors;

public class Service {

    String panstwo;

    Service(String panstwo){

        this.panstwo=panstwo;
    }

    String getWeather(String miasto){

        String weatherJson = "";

        String web = "https://api.openweathermap.org/data/2.5/weather?q=" + miasto + "&appid=d25d1fc91da69a1211c1044143d394ad";

        try(BufferedReader bf = new BufferedReader(new InputStreamReader(new URL(web).openConnection().getInputStream()));) {
            weatherJson = bf.lines().collect(Collectors.joining(System.lineSeparator()));

            /*

            JSONParser parser = new JSONParser();
            JSONObject parse = (JSONObject) parser.parse(weatherJson);
            System.out.println(parse.get("main"));
            JSONObject parseMain = (JSONObject) parse.get("main");
            System.out.println(parseMain.get("temp"));

            Gson gson = new Gson();
            WeatherDTO weatherDTO = gson.fromJson(weatherJson, WeatherDTO.class);

            System.out.println(weatherDTO.sys.country);
            System.out.println(weatherDTO.sys.sunset);
            System.out.println(weatherDTO.wind.speed);
            System.out.println(weatherDTO.weather.get(0).description);

             */

        } catch (IOException e) {
            e.printStackTrace();
        }

        return weatherJson;
    }

    Double getRateFor(String waluta){

        double rate = 0, cRate, eRate;
        DecimalFormat df = new DecimalFormat("0.00");

        String val = Arrays.stream(Locale.getAvailableLocales()).filter(x->x.getDisplayCountry(Locale.ENGLISH)
                .equals(panstwo)).map(x-> Currency.getInstance(x) + "").limit(1).collect(Collectors.joining());

        String web = "http://api.exchangeratesapi.io/v1/latest?access_key=e715026bded077fee3869c60a1e029da&format=1&symbols=" + waluta + "," + val;

        try(BufferedReader bf = new BufferedReader(new InputStreamReader(new URL(web).openConnection().getInputStream()))) {
            web = bf.lines().collect(Collectors.joining(System.lineSeparator()));

            JSONParser parser = new JSONParser();
            JSONObject parse = (JSONObject) parser.parse(web);
            JSONObject parseRate = (JSONObject) parse.get("rates");
            cRate = Double.parseDouble(parseRate.get(val) + "");
            eRate = Double.parseDouble(parseRate.get(waluta) + "");
            rate = Double.parseDouble(df.format(eRate/cRate).replace(',','.'));

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return rate;
    }

    Double getNBPRate(){

        double rate = 1;
        DecimalFormat df = new DecimalFormat("0.00");

        String val = Arrays.stream(Locale.getAvailableLocales()).filter(x->x.getDisplayCountry(Locale.ENGLISH)
                .equals(panstwo)).map(x-> Currency.getInstance(x) + "").limit(1).collect(Collectors.joining());

        if(val.equals("PLN"))
            return rate;

        String web = "http://api.nbp.pl/api/exchangerates/rates/a/" + val + "/";

        try(BufferedReader bf = new BufferedReader(new InputStreamReader(new URL(web).openConnection().getInputStream()))) {
            web = bf.lines().collect(Collectors.joining(System.lineSeparator()));

            JSONParser parser = new JSONParser();
            JSONObject parse = (JSONObject) parser.parse(web);
            JSONArray array = (JSONArray) parse.get("rates");
            JSONObject parseRate = (JSONObject) array.get(0);
            rate = Double.parseDouble(df.format(1/Double.parseDouble(parseRate.get("mid") + ""))
                    .replace(',','.'));

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return rate;
    }

}

/*

class WeatherDTO{
    Wind wind;
    Sys sys;
    List<Weather> weather;
}
class Wind{
    double speed;
}
class Sys{
    int sunset;
    String country;
}
class Weather{
    String description;
}

 */