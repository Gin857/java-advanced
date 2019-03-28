package com.soft1841.set;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMaoTest {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("南京","仙林大学城");
        map.put("合肥","合肥工大");
        map.put("广州","深圳");
        Iterator<Map.Entry<String,String>> iterator =map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String> entry = iterator.next();
            System.out.println(entry.getKey()+ "有"+entry.getValue());
        }
    }
}
