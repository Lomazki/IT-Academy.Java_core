package by.it.doNotTouch.gerasimov.calc;

interface Settings {

    String pathToFiles = System.getProperty("user.dir") + "/src/by/it/gerasimov/calc/";
    String pathToVars = pathToFiles + "vars.txt";
    String pathToLog = pathToFiles + "log.txt";
}
