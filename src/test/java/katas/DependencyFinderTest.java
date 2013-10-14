package katas;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.util.Collections.list;

import java.util.List;

import org.junit.Test;

/**
 *
 */
public class DependencyFinderTest {
  @Test
  public void shouldBeTrue() {
    assertThat(true).isTrue();
  }

  @Test
  public void shouldResolveDependenciesIfOnlyOneDirectDependencySpecified() {
    DependencyFinder dependencyFinder = new DependencyFinder();
    String baseItem = "a";
    List<String> dependencies = list("b", "c");
    dependencyFinder.addDirectDependency(baseItem, dependencies);
    assertThat(dependencyFinder.getDependencies(baseItem)).isEqualTo(dependencies);
  }

  @Test
  public void shouldGetDependenciesIfMultipleNonoverlappingDependenciesSpecified() {
    DependencyFinder dependencyFinder = new DependencyFinder();
    String baseItem1 = "a";
    List<String> dependencies1 = list("b", "c");
    String baseItem2 = "d";
    List<String> dependencies2 = list("e", "f");
    dependencyFinder.addDirectDependency(baseItem1, dependencies1);
    dependencyFinder.addDirectDependency(baseItem2, dependencies2);
    assertThat(dependencyFinder.getDependencies(baseItem1)).isEqualTo(dependencies1);
    assertThat(dependencyFinder.getDependencies(baseItem2)).isEqualTo(dependencies2);
  }
}
