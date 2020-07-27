package com.testingspring.springtest.repos.inmemory;

import com.testingspring.springtest.model.AbstractBaseEntity;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryBaseRepository<T extends AbstractBaseEntity> {

    private static final AtomicInteger counter = new AtomicInteger(0);

    final Map<Integer, T> map = new ConcurrentHashMap<>();

    public T save(T entry) {
        if(entry.isNew()) {
            entry.setId(counter.incrementAndGet());
            return entry;
        }
        return map.computeIfPresent(entry.getId(),(id,oldT) -> entry);
    }

    public boolean delete(int id){return map.remove(id) != null;}

    Collection<T> getCollection() {
        return map.values();
    }
}
