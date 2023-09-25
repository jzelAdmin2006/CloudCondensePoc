package tech.bison.trainee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cloud-storage")
public class CloudStorageController {
  @Autowired
  private CloudStorageService service;

  @GetMapping
  public List<CloudStorage> getAllEntries() {
    return service.getAllCloudStorageEntries();
  }
}
