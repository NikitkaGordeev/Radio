package ru.netology.stats;

public class Radio {
    private int currentVolume;
    private int allStation = 9;
    private int maxRadioStation = 9;
    private int minRadioStation = 0;
    private int maxVolume = 100;
    private int minVolume = 0;
    private int currentStation = maxRadioStation;

    public Radio() {
        this.currentStation = minRadioStation;
    }

    public Radio(int allStation) {
        this.allStation = allStation;
    }

    public int getMaxRadioStation() {
        return maxRadioStation;
    }

    public int getMinRadioStation() {
        return minRadioStation;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public int getMinVolume() {
        return minVolume;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public int getAllStation() {
        return allStation;
    }

    public void setCurrentStation(int newCurrentStation) { // минимум и максимум радиостанций
        if (newCurrentStation < minRadioStation) {
            return;
        }
        if (newCurrentStation > maxRadioStation) {
            return;
        }
        currentStation = newCurrentStation;
    }

    public void setCurrentVolume(int newCurrentVolume) { // минимум и максимум громкости
        if (newCurrentVolume < minVolume) {
            newCurrentVolume = minVolume;
        }
        if (newCurrentVolume > maxVolume) {
            newCurrentVolume = maxVolume;
        }
        currentVolume = newCurrentVolume;
    }

    public int nextStation() { // следующая радиостанция
        if (currentStation < maxRadioStation) {
            return currentStation++;
        } else {
            return currentStation = minRadioStation;
        }
    }

    public int previousStation() { // предыдущая радиостанция
        if (currentStation > minRadioStation) {
            return currentStation--;
        } else {
            return currentStation = maxRadioStation;
        }
    }

    public int moreVolume() { // увеличение громкости
        if (currentVolume >= maxVolume) {
            return currentVolume = maxVolume;
        } else {
            return currentVolume++;
        }
    }

    public int lessVolume() { // уменьшение громкости
        if (currentVolume <= minVolume) {
            return currentVolume = minVolume;
        } else {
            return currentVolume--;
        }
    }
}

