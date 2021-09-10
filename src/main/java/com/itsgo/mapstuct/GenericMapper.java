package com.itsgo.mapstuct;

public interface GenericMapper<D, E> {
    D toDto(E entity);
    E toEntity(D dto);
}
