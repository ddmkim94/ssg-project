package com.ll.ssg;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class WiseSaying {

    private int id;
    private String content;
    private String author;

    public WiseSaying(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public String toJson() {
        return """
                {
                    "id" : %d,
                    "content" : "%s",
                    "author" : "%s"
                }
                """
                .stripIndent()
                .formatted(id, content, author)
                .trim();
    }
}