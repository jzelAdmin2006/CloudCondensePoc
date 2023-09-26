package tech.bison.trainee.server.persistence.domain.cloud_storage;

public enum CloudStorageType {
  GOOGLE_DRIVE("Google Drive"),
  WEBDAV("WebDAV"),
  UNKNOWN("Unknown");

  private final String displayName;

  CloudStorageType(String displayName) {
    this.displayName = displayName;
  }

  public String getDisplayName() {
    return displayName;
  }
}
