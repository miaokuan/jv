package pp.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LogPOJO {

    @JsonProperty(value = "classId")
    private int id;


    @JsonProperty(value = "className")
    private String name;

    @JsonProperty("member")
    private Attr attr;

    public Attr getAttr() {
        return attr;
    }

    public void setAttr(Attr attr) {
        this.attr = attr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "class{id:"+id+", name:"+name+","+ this.attr.toString();
    }

    public class Attr {

        private String name;

        private String sex;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String toString() {
            return "person{name:" + this.name + ", sex:" + this.sex+"}";
        }
    }
}
