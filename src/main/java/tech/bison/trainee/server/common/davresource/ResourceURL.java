package tech.bison.trainee.server.common.davresource;

import static java.util.Objects.requireNonNull;

import com.github.sardine.DavResource;

import lombok.AllArgsConstructor;
import okhttp3.HttpUrl;

@AllArgsConstructor
public class ResourceURL {
  private final String baseUrl;
  private final DavResource resource;

  public String toStringNoTrailingSlash() {
    final HttpUrl baseHttpUrl = requireNonNull(HttpUrl.parse(baseUrl), "URL is invalid");
    final String fullPath = resource.getHref().getPath();
    final String resolvedUrl = baseHttpUrl.resolve(fullPath).toString();
    return resolvedUrl.endsWith("/") ? resolvedUrl.substring(0, resolvedUrl.length() - 1) : resolvedUrl;
  }

  public String toStringTrailingSlash() {
    return toStringNoTrailingSlash() + "/";
  }
}
