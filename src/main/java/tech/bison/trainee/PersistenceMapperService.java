package tech.bison.trainee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersistenceMapperService {
  @Autowired
  private EncryptionService encryptionService;

  public List<CloudStorage> fromCloudStorageEntities(List<CloudStorageEntity> entities) {
    return entities.stream().map(this::fromEntity).toList();
  }

  public CloudStorage fromEntity(CloudStorageEntity entity) {
    return new CloudStorage(entity.getId(), entity.getName(), entity.getUsername(),
        encryptionService.decrypt(entity.getPassword()));
  }

  public CloudStorageEntity toEntity(CloudStorage entry) {
    final CloudStorageEntity entity = new CloudStorageEntity();
    entity.setId(entry.id());
    entity.setName(entry.name());
    entity.setUsername(entry.username());
    entity.setPassword(encryptionService.encrypt(entry.password()));
    return entity;
  }

}
