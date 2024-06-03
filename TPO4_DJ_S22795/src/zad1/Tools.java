/**
 *
 *  @author Depka Jakub S22795
 *
 */

package zad1;


import org.yaml.snakeyaml.Yaml;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Tools {

    static Options createOptionsFromYaml(String fileName) throws Exception{

        Options options;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String collect = bufferedReader.lines().collect(Collectors.joining(System.lineSeparator()));
        Yaml yaml = new Yaml();
        Map<String, Object> load = yaml.load(collect);
        options = new Options(String.valueOf(load.get("host")), Integer.parseInt(String.valueOf(load.get("port"))),
                (Boolean) load.get("concurMode"), (Boolean) load.get("showSendRes"),
                (Map<String, List<String>>) load.get("clientsMap"));

        return options;
    }
}