package com.webproject.entity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockEntityA {
    private String str;
    private String[] array;
    private List<Integer> list;
    private Map<String,String> map;
    private MockEntityB mockEntityB;

    public String getStr() {
        return str;
    }

    public String[] getArray() {
        return array;
    }

    public List<Integer> getList() {
        return list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public MockEntityB getMockEntityB() {
        return mockEntityB;
    }

    public MockEntityA() {
        this.str = "str";
        this.array = new String[] {"AAA", "BBB", "CCC"};
        this.list = Arrays.asList(123, 456, 789);
        this.map = new HashMap<String,String>() {{put("key-0", "values-0");}};
        this.mockEntityB = new MockEntityB();
    }
}
