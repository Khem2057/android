package com.example.easyassist.model;

public class SignupRequest {
        private String fullname;
        private String address;
        private String contact;
        private String email;
        private String password;

        public SignupRequest(String fullname, String address, String contact, String email, String password) {
            this.fullname = fullname;
            this.address = address;
            this.contact = contact;
            this.email = email;
            this.password = password;
        }
}

