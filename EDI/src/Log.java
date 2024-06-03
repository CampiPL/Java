import java.io.File;

import java.io.IOException;

import java.util.logging.FileHandler;

import java.util.logging.Level;

import java.util.logging.Logger;

import java.util.logging.SimpleFormatter;


public class Log {


    Logger logger;

    FileHandler fh;

    File f;


    Log(String fileName) throws SecurityException, IOException {


        this.f = new File(fileName);


        if (!this.f.exists())

            this.f.createNewFile();


        fh = new FileHandler(fileName, true);


        logger = Logger.getLogger("test");


        logger.addHandler(fh);

        logger.setLevel(Level.ALL);


        SimpleFormatter formatter = new SimpleFormatter();


        fh.setFormatter(formatter);

    }


}