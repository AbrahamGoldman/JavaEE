package ssm.spring5.arrrylistcollectionmap;

import java.util.Map;

/**
 * @author Abraham
 * @create 11:27/周六/10/07/2021
 */
public class TestUtil {
    private Map<Integer,String> map;

    public Map<Integer, String> getMap() {
        return map;
    }

    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "TestUtil{" +
                "map=" + map +
                '}';
    }
}
