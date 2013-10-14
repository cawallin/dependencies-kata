package katas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is a class that determines all of the dependencies in a system.
 */
public class DependencyFinder {
  private Map<String, List<String>> dependencies;

  public DependencyFinder() {
    dependencies = new HashMap<String, List<String>>();
  }

  public void addDirectDependency(String file, List<String> dependencies) {
    this.dependencies.put(file, dependencies);
  }

  public List<String> getDependencies(String file) {
    return dependencies.get(file);
  }
}
