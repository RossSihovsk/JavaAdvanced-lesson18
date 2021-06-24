package spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.domain.Participant;

public interface IParticipantRepository extends JpaRepository<Participant, Integer> {

}