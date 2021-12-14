package com.rest.jwt.service;



import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBaseService<T, V> {	
	public Flux<T> getListe();
	public Mono<T> getElement(V v);
	public Mono<T> ajouter(T t);
	public Mono<T> modifier(V v, Mono<T> t);
	public Mono<Void> supprimer(V v);
}