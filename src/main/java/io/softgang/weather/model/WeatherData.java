package io.softgang.weather.model;

public class WeatherData {
    private WeatherDescriptionData [] weather;
    private WeatherMainData main;
    private WeatherSysData sys;
    private WeatherWindData wind;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public WeatherSysData getSys() {
        return sys;
    }

    public void setSys(WeatherSysData sys) {
        this.sys = sys;
    }

    public WeatherWindData getWind() {
        return wind;
    }

    public void setWind(WeatherWindData wind) {
        this.wind = wind;
    }

    public WeatherDescriptionData[] getWeather() {
        return weather;
    }

    public void setWeather(WeatherDescriptionData[] weather) {
        this.weather = weather;
    }

    public WeatherMainData getMain() {
        return main;
    }

    public void setMain(WeatherMainData main) {
        this.main = main;
    }


}