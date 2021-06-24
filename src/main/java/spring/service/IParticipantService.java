package spring.service;

import java.util.List;

import spring.domain.Participant;

public interface IParticipantService {

	Participant create(Participant participant);

	List<Participant> findAll();
	
	Participant findById(Integer id);

	Participant update(Participant participant);

	void deleteById(Integer id);
	
}