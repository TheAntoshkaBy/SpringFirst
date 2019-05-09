package com.thirdTask.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity /** Подсказывает, что этот класс не просто кусок программного кода,
 а сущность которую нам необходимо сейвить в базе данных.*/

public class Message {
    /**Две аннтоации, что бы различать две записи в одной табличке*/
    @Id /**поясняем, что это ID*/
    @GeneratedValue(strategy= GenerationType.AUTO)/**Spring  сам разберется
     в каком виде будут генерится значения*/
    private Integer id;

    private String text;
    private String tag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
