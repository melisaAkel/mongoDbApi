package com.mongoDBApi.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data//getter setter koyuyor
@NoArgsConstructor// no argument constructor yapıyır
@AllArgsConstructor// all argument constructor yapıyor
public class IL {
    @Id
    private String id;
    private String name;


}
