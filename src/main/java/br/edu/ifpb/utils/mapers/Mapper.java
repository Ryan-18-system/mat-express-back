package br.edu.ifpb.utils.mapers;

import java.util.Collection;

public interface Mapper <T,U>{
    U map (T object);

    Collection<U> mapCollection(Collection<T> objects);
}
