package pp.json;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JacksonTest {
    public static class Person {
        private String fullname = null;
        private String org = null;
        private List<Address> emailaddrs = new ArrayList<>();
        private List<Address> telephones = new ArrayList<>();
        private List<Address> addresses = new ArrayList<>();
        private List<Address> urls = new ArrayList<>();

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getOrg() {
            return org;
        }

        public void setOrg(String org) {
            this.org = org;
        }

        public List<Address> getEmailaddrs() {
            return emailaddrs;
        }

        public void setEmailaddrs(List<Address> emailaddrs) {
            this.emailaddrs = emailaddrs;
        }

        public List<Address> getTelephones() {
            return telephones;
        }

        public void setTelephones(List<Address> telephones) {
            this.telephones = telephones;
        }

        public List<Address> getAddresses() {
            return addresses;
        }

        public void setAddresses(List<Address> addresses) {
            this.addresses = addresses;
        }

        public List<Address> getUrls() {
            return urls;
        }

        public void setUrls(List<Address> urls) {
            this.urls = urls;
        }
    }

    public static class Address {
        private String type = null;
        private String value = null;
        private String format = null;
        private int pref = 0;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }

        public int getPref() {
            return pref;
        }

        public void setPref(int pref) {
            this.pref = pref;
        }
    }

    public static String read(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null) {
            sb.append(s + "\n");
        }
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        String results = read("json.txt");
        System.out.println(results);
        ObjectMapper om = new ObjectMapper();/* 对象就在这里读取*/
        Person person = om.readValue(results, Person.class);
        System.out.println("fullname:" + person.getFullname());
        System.out.println("org:" + person.getOrg());
        System.out.println(person.getEmailaddrs().get(0).getValue());
        System.out.println(person.getEmailaddrs().get(0).getType());
        System.out.println(person.getEmailaddrs().get(1).getType());
        System.out.println(person.getEmailaddrs().get(0).getValue());
        System.out.println(person.getEmailaddrs().get(1).getFormat());
        System.out.println(person.getUrls().get(0).getValue());/*        om.writeValue(new File("json.txt"), person);*/
    }
}