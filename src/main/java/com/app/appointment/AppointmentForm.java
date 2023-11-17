package com.app.appointment;

public class AppointmentForm {
        private int appId;
        private int custId;
        private String day;
       private String service;
        private String isreceive;
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
        public int getAppId() {
            return appId;
        }
        public String getDay() {
            return day;
        }
        public void setDay(String day) {
            this.day = day;
        }
        public void setAppId(int appId) {
            this.appId = appId;
        }
        private String hour;
        public int getCustId() {
            return custId;
        }
        public void setCustId(int custId) {
            this.custId = custId;
        }
}
