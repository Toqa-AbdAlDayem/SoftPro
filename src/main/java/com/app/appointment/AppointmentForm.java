package com.app.appointment;

public class AppointmentForm {


        private int app_id;
        private int cust_id;
        private String day;

        public String getIsreceive() {
            return isreceive;
        }

        public void setIsreceive(String isreceive) {
            this.isreceive = isreceive;
        }

        public String getHour() {
            return hour;
        }

        public String getService() {
            return service;
        }

        public void setService(String service) {
            this.service = service;
        }

        public void setHour(String hour) {
            this.hour = hour;
        }

        public int getApp_id() {
            return app_id;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public void setApp_id(int app_id) {
            this.app_id = app_id;
        }

        private String hour;

        public int getCust_id() {
            return cust_id;
        }

        public void setCust_id(int cust_id) {
            this.cust_id = cust_id;
        }

        private String service;
        private String isreceive;




}
