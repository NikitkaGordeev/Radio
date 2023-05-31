package ru.netology.stats;

public class Radio {
    private int currentStation;
    private int currentVolume;

    public int getCurrentStation() {
        return currentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentStation(int newCurrentStation) { // минимум и максимум радиостанций
        if (newCurrentStation < 0) {
            return;
        }
        if (newCurrentStation > 9) {
            return;
        }
        currentStation = newCurrentStation;
    }

    public void setCurrentVolume(int newCurrentVolume) { // минимум и максимум громкости
        if (newCurrentVolume < 0) {
            newCurrentVolume = 0;
        }
        if (newCurrentVolume > 100) {
            newCurrentVolume = 100;
        }
        currentVolume = newCurrentVolume;
    }

    public int nextStation() { // следующая радиостанция
        if (currentStation < 9) {
            return currentStation++;
        } else {
            return currentStation = 0;
        }
    }

    public int previousStation() { // предыдущая радиостанция
        if (currentStation > 0) {
            return currentStation--;
        } else {
            return currentStation = 9;
        }
    }

    public int moreVolume() { // увеличение громкости
        if (currentVolume >= 100) {
            return currentVolume = 100;
        } else {
            return currentVolume++;
        }
    }

    public int lessVolume() { // уменьшение громкости
        if (currentVolume <= 0) {
            return currentVolume = 0;
        } else {
            return currentVolume--;
        }
    }
}

