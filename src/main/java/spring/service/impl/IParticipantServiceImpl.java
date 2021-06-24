package spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.dao.IParticipantRepository;
import spring.service.IParticipantService;
import spring.domain.Participant;

@Service
public class IParticipantServiceImpl implements IParticipantService {

	@Autowired
	private IParticipantRepository IParticipantRepository;

	@Override
	public Participant create(Participant university) {
		return IParticipantRepository.save(university);
	}

	@Override
	public List<Participant> findAll() {
		return IParticipantRepository.findAll();
	}

	@Override
	public Participant findById(Integer id) {
		return IParticipantRepository.getOne(id);
	}

	@Override
	public Participant update(Participant university) {
		return IParticipantRepository.save(university);
	}

	@Override
	public void deleteById(Integer id) {
		IParticipantRepository.deleteById(id);
	}

}