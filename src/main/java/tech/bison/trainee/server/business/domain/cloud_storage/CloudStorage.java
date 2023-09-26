package tech.bison.trainee.server.business.domain.cloud_storage;

import tech.bison.trainee.server.persistence.domain.cloud_storage.CloudStorageType;

public record CloudStorage(int id, String name, CloudStorageType type, String username, String password) {
}
