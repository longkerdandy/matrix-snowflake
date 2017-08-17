package com.github.longkerdandy.matrix.snowflake;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class IdGeneratorTest {

  @Test
  public void print() {
    IdGenerator generator = new IdGenerator(233);
    for (int i = 0; i < 100; i++) {
      long id = generator.nextId();
      System.out.println(Long.toBinaryString(id));
    }
  }

  @Test
  public void singleGeneratorTest() {
    IdGenerator generator = new IdGenerator(255);
    Set<Long> results = new HashSet<>();
    for (int i = 0; i < 10000; i++) {
      long id = generator.nextId();
      results.add(id);
    }
    assert results.size() == 10000;
  }

  @Test
  public void twoGeneratorsTest() {
    IdGenerator generator1 = new IdGenerator(255);
    IdGenerator generator2 = new IdGenerator(516);  // yeah, it's my birthday
    Set<Long> results = new HashSet<>();
    for (int i = 0; i < 10000; i++) {
      long id1 = generator1.nextId();
      long id2 = generator2.nextId();
      results.add(id1);
      results.add(id2);
    }
    assert results.size() == 20000;
  }
}
