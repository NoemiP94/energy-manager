package controllers;

import entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;
import payloads.user.UserDTO;
import services.UserService;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    //me endpoint
    @GetMapping("/me")
    public User getProfile(@AuthenticationPrincipal User currentUser){
        return currentUser;
    }

    @PutMapping("/me")
    public User getMeAndUpdate(@AuthenticationPrincipal User currentUser, @RequestBody UserDTO body) {
        return userService.findByIdAndUpdate(currentUser.getUuid(), body);
    }

    @PutMapping("/me/pw")
    public User getMeByIdAndUpdatePassword(@AuthenticationPrincipal User currentUser, @RequestBody UserDTO body) {
        return userService.findByIdAndUpdatePassword(currentUser.getUuid(), body);
    }

    @DeleteMapping("/me")
    public void getMeAnDelete(@AuthenticationPrincipal User currentUser) {
        userService.deleteById(currentUser.getUuid());
    }

    //other
    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public Page<User> getUsers(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "10") int size,
                               @RequestParam(defaultValue = "uuid") String orderBy) {
        return userService.getUsers(page, size, orderBy);
    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public User getUserById(@PathVariable UUID userId) {
        return userService.findById(userId);
    }


    @PutMapping("/{userId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public User getUserByIdAndUpdate(@PathVariable UUID userId, @RequestBody UserDTO modifiedUserPayload) {
        return userService.findByIdAndUpdate(userId, modifiedUserPayload);
    }

    @DeleteMapping("/{userId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getUserByIdAndDelete(@PathVariable UUID userId) {
        userService.deleteById(userId);
    }

    @GetMapping("/{uuid}/set-admin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public User setAdmin(@PathVariable UUID uuid) {
        return userService.setAdmin(uuid);
    }

    @GetMapping("/{uuid}/set-user")
    @PreAuthorize("hasAuthority('ADMIN')")
    public User setUser(@PathVariable UUID uuid) {
        return userService.setUser(uuid);
    }

    @PostMapping("/{id}/avatar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String uploadAvatar(@PathVariable UUID uuid, @RequestParam("avatar") MultipartFile body) throws IOException {
        return userService.uploadAvatar(uuid, body);
    }
}
