package com.example.baitap2.service;

import com.example.baitap2.repo.DictionaryRepo;
import com.example.baitap2.repo.IDictionaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements  IDictionaryService {
    @Autowired
    private IDictionaryRepo iDictionaryRepo = new DictionaryRepo();

    @Override
    public String display(String englishDictionary) {
        return iDictionaryRepo.display(englishDictionary);
    }
}
