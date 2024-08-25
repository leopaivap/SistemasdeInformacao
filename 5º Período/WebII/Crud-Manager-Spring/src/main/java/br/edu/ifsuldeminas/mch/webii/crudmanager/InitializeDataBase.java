package br.edu.ifsuldeminas.mch.webii.crudmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Address;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.User;
import br.edu.ifsuldeminas.mch.webii.crudmanager.repo.AddressRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.repo.UserRepository;
import jakarta.transaction.Transactional;

@Component
@Transactional
public class InitializeDataBase implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public void run(String... args) throws Exception {
		User salomao = new User();
		salomao.setName("Salomão Ferreira");
		salomao.setGender("M");
		salomao.setEmail("salomao@gmail.com");

		Address addressS = new Address();
		addressS.setPlace("Rua 25 de Março");
		addressS.setNumber(11);
		addressS.setZipCode("37750-000");

		User leonardo = new User();
		leonardo.setName("Leonardo Paiva");
		leonardo.setGender("M");
		leonardo.setEmail("leonardo@gmail.com");

		Address addressL = new Address();
		addressL.setPlace("Rua dos macacos");
		addressL.setNumber(250);
		addressL.setZipCode("37005-021");

		addressRepository.save(addressS);
		addressRepository.save(addressL);
		addressRepository.flush();

		salomao.setAddress(addressS);
		leonardo.setAddress(addressL);

		userRepository.save(salomao);
		userRepository.save(leonardo);

	}

}
