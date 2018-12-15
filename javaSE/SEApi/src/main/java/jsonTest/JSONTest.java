package jsonTest;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

class JSONTest {

    public static void main(String[] args) {
        City c1 = new City(1005, "石家庄");
        City c2 = new City(1006, "唐山");
        City c3 = new City(1007, "保定");

        List<City> cities = new ArrayList<>();
        cities.add(c1);
        cities.add(c2);
        cities.add(c3);

        Province hebei = new Province("hebei", cities);

        String json = JSON.toJSONString(hebei);
        System.out.println(json);

        Province province = JSON.parseObject(json, Province.class);
        System.out.println(province);

    }
}
