class Solution {
     public int daysBetweenDates(String date1, String date2) {
        int days1 = days(date1);
        int days2 = days(date2);
        return Math.abs(days1 - days2);
    }

    int[] mdays = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};

 
    private int days(String d) {
        String[] ss = d.split("-");
        int year = Integer.valueOf(ss[0]);
        int month = Integer.valueOf(ss[1]);
        int day = Integer.valueOf(ss[2]);
        int ydelta = year - 1 - 1900;
        int dy = ydelta * 365 + ydelta / 4;
        int dm = mdays[month - 1];
        if (isleap(year) && month - 1 >= 2) {
            dm++;
        }
        return dy + dm + day;
    }

    private boolean isleap(int year) {
        return (year % 100 != 0 && year % 4 == 0) || (year % 100 == 0 && year % 400 == 0);
    }

}
