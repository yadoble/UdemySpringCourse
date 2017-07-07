package com.udemy.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;

import com.udemy.entity.Course;
import com.udemy.entity.QCourse;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository("queryDSLExampleRepo")
public class QueryDslExampleRepo {

	private QCourse qCourse = QCourse.course;
	
	@PersistenceContext
	private EntityManager em;
	
	public Course find(boolean exist){
		
		JPAQuery<Course> query = new JPAQuery<>(em);
		
		BooleanBuilder predicateBuilder = new BooleanBuilder(qCourse.description.endsWith("OP"));
		
		if(exist){
			Predicate predicate2 = qCourse.id.eq(23);
			predicateBuilder.and(predicate2);
		}else{
			Predicate predicate3 = qCourse.name.endsWith("OP");
			predicateBuilder.or(predicate3);
		}
		
		Course course1 = query.select(qCourse).from(qCourse).where(predicateBuilder).fetchOne();
		
		return course1;	
	}

}
