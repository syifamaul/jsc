package com.maul.jsc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maul.jsc.models.Publisher;
@Service
public class PublisherImpl implements PublisherService {
	@Autowired
	private PublisherRepository publisherRepository;

	@Override
	public List<Publisher> getAll() {
		return publisherRepository.findAll();
	}

	@Override
	public void savePublisher(Publisher Publisher) {
		this.publisherRepository.save(Publisher);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Publisher getPublisherById(long id) {
		return publisherRepository.getById(id);
	}

	@Override
	public void deletePublisherById(long id) {
		this.publisherRepository.deleteById(id);
	}
 
	 
	  
}
