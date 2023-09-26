package tech.bison.trainee;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CloudStorageRepository {
  private final CloudStoragePersistence cloudStoragePersistence;
  private final PersistenceMapperService mapperService;

  public CloudStorageRepository(CloudStoragePersistence cloudStoragePersistence,
      PersistenceMapperService persistenceMapperService) {
    this.cloudStoragePersistence = cloudStoragePersistence;
    this.mapperService = persistenceMapperService;
  }

  public List<CloudStorage> findAll() {
    return mapperService.fromCloudStorageEntities(cloudStoragePersistence.findAll());
  }

  public CloudStorage save(CloudStorage entry) {
    return mapperService.fromEntity(cloudStoragePersistence.save(mapperService.toEntity(entry)));
  }
}
