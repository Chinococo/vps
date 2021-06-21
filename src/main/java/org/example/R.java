package org.example;

public class R {
    public static class account
    {
        public static String apikey="42ZTCxkOl9XrABHtOWCSYeBtmdKBTUqX0P6ixCKkM0zXUl2hGnLjfzuzcPGEou0E";
        public static String secretkey="N4lAGy6ERR3MAWjeyTG964pS4mM8N6Jb5xOo2tFyKp4jOpe89A6jexQQqm68iM03";

    }
    public static class Interval
    {
        public static String MINUTE_1 = "1m";
        public static String MINUTE_3 = "3m";
        public static String MINUTE_5 = "5m";
        public static String MINUTE_15 = "15m";
        public static String MINUTE_30 = "30m";
        public static String HOUR_1 = "1h";
        public static String HOUR_2 = "2h";
        public static String HOUR_4 = "4h";
        public static String HOUR_6 = "6h";
    }
    public static class OrderType
    {
        public String LIMIT="LIMIT";
        public String MARKET = "MARKET";
        public String STOP = "STOP";
        public String STOP_LIMIT="STOP_LIMIT";
    }
    public static class side
    {
        public String BUY="BUY";
        public String SELL = "SELL";
    }
    public static class TimeInForce
    {
        public String GTC="GTC";
        public String IOC = "IOC";
        public String FOK="FOK";
        public String GTX = "GTX";
    }
    public  static enum HTTP
    {
        GET,POST,DELETE,PUT;
    }

}
