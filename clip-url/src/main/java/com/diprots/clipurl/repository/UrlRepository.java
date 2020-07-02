package com.diprots.clipurl.repository;

import com.diprots.clipurl.model.Url;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface UrlRepository extends CrudRepository<Url, String> {
}
