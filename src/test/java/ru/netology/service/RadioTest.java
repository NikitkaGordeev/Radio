package ru.netology.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.stats.Radio;


class RadioTest {
    Radio radio = new Radio();

    // Радиостанции
    @Test
    public void defaultRadioStation() {
        Radio radio = new Radio(20);
        radio.setCurrentStation(15);
        Assertions.assertEquals(15, radio.getCurrentStation());
        Assertions.assertEquals(20, radio.getMaxRadioStation());
        Assertions.assertEquals(0, radio.getMinRadioStation());
        Assertions.assertEquals(100, radio.getMaxVolume());
        Assertions.assertEquals(0, radio.getMinVolume());
    }

    @Test
    public void shouldSetRadioStation() { // выбор радиостанции в диапазоне
        radio.setCurrentStation(4);
        int expected = 4;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNextExceedingMaxValueRadioStation() { // Значение превышающее колличество радиостанций
        radio.setCurrentStation(10);
        int expected = 0;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldNextLessMaxValueRadioStation() { // Верхнее граничное значение радиостанции -1
        radio.setCurrentStation(9);
        radio.previousStation();
        int expected = 8;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPreviousExceedingMixValueRadioStation() { // Нижнее граничное значение радиостанции +1
        radio.setCurrentStation(0);
        radio.nextStation();
        int expected = 1;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldPreviousLessMinValueRadioStation() { // отрицательное значение радиостанции

        radio.setCurrentStation(-1);
        int expected = 0;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNextNullRadioStation() { // Следующая радиостанция возврат на 0 радиостанцию
        radio.setCurrentStation(9);
        radio.nextStation();
        int expected = 0;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPreviousNullRadioStation() { // Предыдущая радиостанция возврат на 9 радиостанцию
        radio.setCurrentStation(0);
        radio.previousStation();
        int expected = 9;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNextRadioStation() { // Следующая радиостанция
        radio.setCurrentStation(5);
        radio.nextStation();
        int expected = 6;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPreviousRadioStation() { // Предыдущая радиостанция
        radio.setCurrentStation(7);
        radio.previousStation();
        int expected = 6;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    //Громкость
    @Test
    public void shouldSetVolume() { // выбор громкости в диапазоне
        radio.setCurrentVolume(51);
        int expected = 51;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldUpperVolumeLimitMore() { // Верхнее граничное значение громкости +1
        radio.setCurrentVolume(101);
        radio.moreVolume();
        int expected = 100;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldUpperVolumeLimitLesser() { // Верхнее граничное значение громкости -1
        radio.setCurrentVolume(100);
        radio.lessVolume();
        int expected = 99;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldLowerVolumeLimitLesser() { // Нижнее граничное значение громкости -1
        radio.setCurrentVolume(-1);
        radio.lessVolume();
        int expected = 0;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldLowerVolumeLimitMore() { // Нижнее граничное значение громкости +1
        radio.setCurrentVolume(0);
        radio.moreVolume();
        int expected = 1;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }
}