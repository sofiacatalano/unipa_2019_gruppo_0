package it.eng.unipa.filesharing.container;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.eng.unipa.filesharing.dto.MembershipDTO;
import it.eng.unipa.filesharing.service.TeamService;

@RestController
@RequestMapping("/member")
public class MemberController {
	
	private TeamService teamService;
	
	public MemberController(@Autowired TeamService teamService) {
		this.teamService = teamService;
	}
	
	@GetMapping("invite/{uuid}/{email}/{admin}")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void inviteMember(@PathVariable("uuid")UUID uuid,@PathVariable("email")String email,@PathVariable("admin") boolean admin) {
		teamService.inviteMember(uuid, email, admin);
	}
	
	
	@GetMapping("accept/{uuid}")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void acceptMember(@PathVariable("uuid")UUID uuid) {
		teamService.acceptInvite(uuid);
	}

	@GetMapping("reject/{uuid}")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void rejectInvite(@PathVariable("uuid")UUID uuid) {
		teamService.rejectInvite(uuid);
	}
	
	@DeleteMapping("/{uuid}/{email}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void remove(@PathVariable("uuid")UUID uuid,@PathVariable("email")String email) {
		teamService.removeMember(uuid, email);
	}
	
	
	@PostMapping("membership/{uuid}/{bucketName}")
	@ResponseStatus(value = HttpStatus.OK)
	public void add(@PathVariable("uuid") UUID uuid,@PathVariable("bucketName") String bucketName,@RequestBody MembershipDTO membershipDTO) {
		teamService.addMembership(uuid, bucketName, membershipDTO);
	}
	
}
