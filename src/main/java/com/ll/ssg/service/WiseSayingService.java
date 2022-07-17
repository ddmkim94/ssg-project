package com.ll.ssg.service;

import com.ll.ssg.App;
import com.ll.ssg.Util;
import com.ll.ssg.WiseSaying;
import com.ll.ssg.repository.WiseSayingRepository;

import java.util.List;
import java.util.stream.Collectors;

public class WiseSayingService {

    private final WiseSayingRepository wiseSayingRepository;

    public WiseSayingService() {
        wiseSayingRepository = new WiseSayingRepository();
    }

    public List<WiseSaying> findAll() {
        return wiseSayingRepository.findAll();
    }

    public WiseSaying add(String content, String author) {
        return wiseSayingRepository.add(content, author);
    }

    public void update(int id, String content, String author) {
        wiseSayingRepository.update(id, content, author);
    }

    public void delete(int id) {
        wiseSayingRepository.delete(id);
    }

    public WiseSaying findById(int id) {
        return wiseSayingRepository.findById(id);
    }

    public void dumpToJson() {
        List<WiseSaying> wiseSayingList = wiseSayingRepository.findAll();

        StringBuilder json = new StringBuilder();
        json.append("[\n");
        for (int i = 0; i < wiseSayingList.size(); i++) {
            WiseSaying wiseSaying = wiseSayingList.get(i);
            json.append("\t").append(wiseSaying.toJson()).append(i == wiseSayingList.size() - 1 ? "" : ",\n");
        }
        json.append("\n]");

        Util.file.saveToFile("%s/data.json".formatted(App.getBaseDir()), json.toString());
    }
}
