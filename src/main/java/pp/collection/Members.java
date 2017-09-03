package pp.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Members {
    private List<Map> data = new ArrayList<>();

    public static void main(String[] args) {
        Members members = new Members();

        Map<String, String> member = new HashMap<>();
        member.put("name", "jo");
        member.put("sex", "male");
        members.data.add(member);

//        member.clear();
//        member.put("name", "joke");
//        member.put("sex", "female");
//        members.data.add(member);
//        member.clear();
        for(Map<String, String> m : members.data) {
            System.out.println(m);
        }
    }
}
