package kayvan.soleimani.springbootapp.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
  @GetMapping(value = "/all",produces = "text/plain;charset=UTF-8")
  public String allAccess() {
    return "محتوای عمومی.";
  }

  @GetMapping(value = "/user",produces = "text/plain;charset=UTF-8")
  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
  public String userAccess() {
    return "محتوای کاربر.";
  }

  @GetMapping(value = "/mod",produces = "text/plain;charset=UTF-8")
  @PreAuthorize("hasRole('MODERATOR')")
  public String moderatorAccess() {
    return "صفحه ی مدیر.";
  }

  @GetMapping(value = "/admin",produces = "text/plain;charset=UTF-8")
  @PreAuthorize("hasRole('ADMIN')")
  public String adminAccess() {
    return "صفحه مدیر کل.";
  }
}
