package uz.app.authapp.entity.enums;


import lombok.Getter;

@Getter
public enum Times {
    time_00_00("00:00-01:00"),
    time_01_00("01:00-02:00"),
    time_02_00("02:00-03:00"),
    time_03_00("03:00-04:00"),
    time_04_00("04:00-05:00"),
    time_05_00("05:00-06:00"),
    time_06_00("06:00-07:00"),
    time_07_00("07:00-08:00"),
    time_08_00("08:00-09:00"),
    time_09_00("09:00-10:00"),
    time_10_00("10:00-11:00"),
    time_11_00("11:00-12:00"),
    time_12_00("12:00-13:00"),
    time_13_00("13:00-14:00"),
    time_14_00("14:00-15:00"),
    time_15_00("15:00-16:00"),
    time_16_00("16:00-17:00"),
    time_17_00("17:00-18:00"),
    time_18_00("18:00-19:00"),
    time_19_00("19:00-20:00"),
    time_20_00("20:00-21:00"),
    time_21_00("21:00-22:00"),
    time_22_00("22:00-23:00"),
    time_23_00("23:00-24:00");
    private String time;

    Times(String time) {
        this.time = time;
    }
}
