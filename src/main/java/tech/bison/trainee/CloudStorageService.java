package tech.bison.trainee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CloudStorageService {

  @Autowired
  private CloudStorageRepository repository;

  public List<CloudStorage> getAllCloudStorageEntries() {
    return repository.findAll();
  }

  public CloudStorage addCloudStorageEntry(CloudStorage entry) {
    return repository.save(entry);
  }
}
