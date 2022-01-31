package com.jorsilva.repTesteMockito.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jorsilva.repTesteMockito.dto.CityDTO;
import com.jorsilva.repTesteMockito.dto.EventDTO;
import com.jorsilva.repTesteMockito.entities.City;
import com.jorsilva.repTesteMockito.entities.Event;
import com.jorsilva.repTesteMockito.repositories.EventRepository;
import com.jorsilva.repTesteMockito.services.exceptions.ResourceNotFoundException;

@Service
public class EventService {

	@Autowired
	private EventRepository repository;

	@Transactional(readOnly = true)
	public EventDTO update(Long id, EventDTO dto) {
		try {
			Event entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new EventDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found = " + id);
		}
	}

	private void copyDtoToEntity(EventDTO dto, Event entity) {
		entity.setName(dto.getName());
		entity.setDate(dto.getDate());
		entity.setUrl(dto.getUrl());
		entity.setCity(new City(dto.getCityId(), null));
	}

	@Transactional(readOnly = true)
	public List<EventDTO> findAll() {
		List<Event> list = repository.findAll();
		return list.stream().map(x -> new EventDTO(x)).collect(Collectors.toList());
	}

	@Transactional
	public EventDTO insert(EventDTO dto) {
		Event entity = new Event();
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new EventDTO(entity);
	}
}
