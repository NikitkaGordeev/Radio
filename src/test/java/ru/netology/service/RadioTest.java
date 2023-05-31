package ru.netology.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.stats.Radio;


class RadioTest {
    // Радиостанции
    @Test
    public void shouldSetRadioStation() { // выбор радиостанции в диапазоне
        Radio radio = new Radio();
        radio.setCurrentStation(4);
        int expected = 4;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNextExceedingMaxValueRadioStation() { // Значение превышающее колличество радиостанций
        Radio radio = new Radio();
        radio.setCurrentStation(10);
        int expected = 0;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldNextLessMaxValueRadioStation() { // Верхнее граничное значение радиостанции -1
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.previousStation();
        int expected = 8;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPreviousExceedingMixValueRadioStation() { // Нижнее граничное значение радиостанции +1
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.nextStation();
        int expected = 1;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldPreviousLessMinValueRadioStation() { // отрицательное значение радиостанции
        Radio radio = new Radio();
        radio.setCurrentStation(-1);
        int expected = 0;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNextNullRadioStation() { // Следующая радиостанция возврат на 0 радиостанцию
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.nextStation();
        int expected = 0;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPreviousNullRadioStation() { // Предыдущая радиостанция возврат на 9 радиостанцию
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.previousStation();
        int expected = 9;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNextRadioStation() { // Следующая радиостанция
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.nextStation();
        int expected = 6;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPreviousRadioStation() { // Предыдущая радиостанция
        Radio radio = new Radio();
        radio.setCurrentStation(7);
        radio.previousStation();
        int expected = 6;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    //Громкость
    @Test
    public void shouldSetVolume() { // выбор громкости в диапазоне
        Radio radio = new Radio();
        radio.setCurrentVolume(51);
        int expected = 51;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldUpperVolumeLimitMore() { // Верхнее граничное значение громкости +1
        Radio radio = new Radio();
        radio.setCurrentVolume(101);
        radio.moreVolume();
        int expected = 100;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldUpperVolumeLimitLesser() { // Верхнее граничное значение громкости -1
        Radio radio = new Radio();
        radio.setCurrentVolume(100);
        radio.lessVolume();
        int expected = 99;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldLowerVolumeLimitLesser() { // Нижнее граничное значение громкости -1
        Radio radio = new Radio();
        radio.setCurrentVolume(-1);
        radio.lessVolume();
        int expected = 0;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldLowerVolumeLimitMore() { // Нижнее граничное значение громкости +1
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        radio.moreVolume();
        int expected = 1;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }


}