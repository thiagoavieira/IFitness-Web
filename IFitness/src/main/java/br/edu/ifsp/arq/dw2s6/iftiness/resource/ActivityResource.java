package br.edu.ifsp.arq.dw2s6.iftiness.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.arq.dw2s6.iftiness.domain.model.Activity;
import br.edu.ifsp.arq.dw2s6.iftiness.repository.ActivityRepository;
import br.edu.ifsp.arq.dw2s6.iftiness.service.ActivityService;

@RestController
@RequestMapping("/activities")
public class ActivityResource {

	@Autowired
	private ActivityRepository activityRepository;
	
	@Autowired
	private ActivityService activityService;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_SEARCH_ACTIVITY') and #oauth2.hasScope('read')")
	public List<Activity> list(){
		return activityRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_SEARCH_ACTIVITY') and #oauth2.hasScope('read')")
	public ResponseEntity<Activity> findById(@PathVariable Long id){
		Optional<Activity> activity = 
				activityRepository.findById(id);
		if(activity.isPresent()) {
			return ResponseEntity.ok(activity.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('ROLE_REGISTER_ACTIVITY') and #oauth2.hasScope('write')")
	public Activity create(@Valid @RequestBody Activity activity) {
		return activityService.save(activity);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVE_ACTIVITY') and #oauth2.hasScope('write')")
	public void remover(@PathVariable Long id) {
		activityRepository.deleteById(id);
	}
}
