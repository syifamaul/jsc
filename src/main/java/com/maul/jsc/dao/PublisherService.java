package com.maul.jsc.dao;

import java.util.List;

import com.maul.jsc.models.Publisher;

public interface PublisherService {
	List < Publisher > getAll();
    void savePublisher(Publisher Publisher);
    Publisher getPublisherById(long id);
    void deletePublisherById(long id);
}
