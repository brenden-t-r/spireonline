package com.spireonline.app.repository;

import com.spireonline.app.domain.BaseEntity;
import com.spireonline.app.utils.DefaultEntityFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public abstract class AbstractRepositoryTest<T extends BaseEntity> extends BasePersistenceTest
{
    @Autowired
    private DefaultEntityFactory entityFactory;
    private Collection<T> entities;

    protected abstract Collection<T> getPersistedEntities();

    protected abstract JpaRepository<T, Long> getRepository();

    @Before
    public void setup()
    {
        entities = getPersistedEntities();
        assertThat(getEntity(), notNullValue());
    }

    private T getEntity()
    {
        return entities.stream().findFirst().orElse(null);
    }

    @After
    public void teardown()
    {
        entityFactory.reset();
    }

    @Test
    public void testFindAll() throws Exception
    {
        final Collection<T> entities = getRepository().findAll();
        assertThat(entities.size(), equalTo(this.entities.size()));
        for (T entity : entities)
        {
            assertThat(this.entities, hasItem(entity));
        }
    }

    @Test
    public void testFindById()
    {
        final T expectedEntity = getEntity();
        final Optional<T> entity = getRepository().findById(expectedEntity.getId());

        assertThat(entity.isPresent(), equalTo(true));
        assertThat(entity.orElse(null), equalTo(expectedEntity));
    }

    @Test
    @Transactional
    public void testDeleteById() throws Exception
    {
        T entity;
        final Long id = getEntity().getId();

        entity = getRepository().findById(id).orElse(null);
        assertThat(entity, notNullValue());

        getRepository().deleteById(id);
        entity = getRepository().findById(id).orElse(null);

        assertThat(entity, nullValue());
    }
}