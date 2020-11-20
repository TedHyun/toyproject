package com.example.main.springboot.domain.user;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public class UserRepoImpl extends QuerydslRepositorySupport implements UserRepoCustom {

    private static final QUser table = QUser.user;

    public UserRepoImpl(){
        super(User.class);
    }

    @Override
    public User getByid(String id){

        return from(table)
                .where(table.id.eq(table.id))
                .fetchOne();
    }
}
