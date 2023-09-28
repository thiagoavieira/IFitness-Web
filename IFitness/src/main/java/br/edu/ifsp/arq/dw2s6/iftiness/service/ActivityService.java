package br.edu.ifsp.arq.dw2s6.iftiness.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsp.arq.dw2s6.iftiness.domain.model.Activity;
import br.edu.ifsp.arq.dw2s6.iftiness.domain.model.User;
import br.edu.ifsp.arq.dw2s6.iftiness.repository.ActivityRepository;
import br.edu.ifsp.arq.dw2s6.iftiness.repository.UserRepository;
import br.edu.ifsp.arq.dw2s6.iftiness.service.exception.NonExistentOrInactiveUserException;

@Service
public class ActivityService {
	
	@Autowired
	private ActivityRepository activityRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Activity save(Activity activity) {
		Optional<User> user = userRepository.findById(
				activity.getUser().getId());
		if(!user.isPresent() || !user.get().isActive()) {
			throw new NonExistentOrInactiveUserException();
		}
		return activityRepository.save(activity);
	}

}
