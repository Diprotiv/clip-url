package com.diprots.clipurl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Url {
    @Id
    private String shortUrl;
    private String longUrl;
    private String customizedUrl;
    private Long creationDate;
}
