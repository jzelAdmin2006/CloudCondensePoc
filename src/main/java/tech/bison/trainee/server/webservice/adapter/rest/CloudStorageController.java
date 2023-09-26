package tech.bison.trainee.server.webservice.adapter.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.bison.trainee.server.business.service.CloudStorageService;
import tech.bison.trainee.server.webservice.adapter.model.cloud_storage.CloudStorageRequestDto;
import tech.bison.trainee.server.webservice.adapter.model.cloud_storage.CloudStorageResourceDto;
import tech.bison.trainee.server.webservice.service.WebMapperService;

@RestController
@RequestMapping("/cloud-storage")
public class CloudStorageController {
  @Autowired
  private CloudStorageService service;

  @Autowired
  private WebMapperService webMapperService;

  @GetMapping
  public ResponseEntity<List<CloudStorageResourceDto>> getAllEntries() {
    return ResponseEntity.ok(webMapperService.toDtos(service.getAllCloudStorageEntries()));
  }

  @PostMapping
  public ResponseEntity<CloudStorageResourceDto> addEntry(@RequestBody CloudStorageRequestDto entry) {
    return ResponseEntity.ok(webMapperService.toDto(service.addCloudStorageEntry(webMapperService.fromDto(entry))));
  }
}
