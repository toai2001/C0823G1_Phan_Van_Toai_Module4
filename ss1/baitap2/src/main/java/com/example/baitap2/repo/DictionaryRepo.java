package com.example.baitap2.repo;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Repository
public class DictionaryRepo implements IDictionaryRepo {
    private static final Map<String, String> mapDictionary;

    static {
        mapDictionary = new HashMap<>();
        mapDictionary.put("Blackberry", "Dâu đen");
        mapDictionary.put("Cherry", "Trái anh đào");
        mapDictionary.put("Lemon", "Chanh vàng");
        mapDictionary.put("Orange", "Cam");
        mapDictionary.put("Apple", "Táo");
        mapDictionary.put("Banana", "Trái chuối");
        mapDictionary.put("Grape", "Nho");
        mapDictionary.put("Mango", "Xoài");
        mapDictionary.put("Melon", "Dưa");
        mapDictionary.put("Watermelon", "Dưa hấu");
    }

    @Override
    public String display(String englishDictionary) {
        return mapDictionary.getOrDefault(englishDictionary, "Không có trong danh sách từ điển");
    }
}
