package tech.bison.trainee.server.persistence.domain.cloud_storage;

import java.util.List;

import org.springframework.stereotype.Service;

import tech.bison.trainee.server.business.domain.cloud_storage.CloudStorage;
import tech.bison.trainee.server.persistence.service.PersistenceMapperService;

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
