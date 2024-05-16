package com.aston.frontendpracticeservice.repository;

import com.aston.frontendpracticeservice.domain.entity.Requisites;
import com.aston.frontendpracticeservice.domain.entity.User;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;


public class UserSpecifications {


    private static final String NAME_FIELD_LOGIN = "login";

    private static final String NAME_FIELD_SNILS = "snils";

    private static final String NAME_FIELD_PASSPORT_NUMBER = "passportNumber";

    private static final String NAME_FIELD_INN = "inn";
    private static final String NAME_FIELD_REQUISITES = "requisites";


    public static Specification<User> filterByLogin(String login) {
        return (root, query, criteriaBuilder) ->
                login == null ? criteriaBuilder.conjunction() :
                        criteriaBuilder.equal(root.get(NAME_FIELD_LOGIN), login);
    }

    public static Specification<User> filterByPassportNumber(String passportNumber) {
        return (root, query, criteriaBuilder) ->
                passportNumber == null ? criteriaBuilder.conjunction() :
                        criteriaBuilder.equal(root.get(NAME_FIELD_PASSPORT_NUMBER), passportNumber);
    }

    public static Specification<User> filterBySnils(String snils) {
        return (root, query, criteriaBuilder) ->
                snils == null ? criteriaBuilder.conjunction() :
                        criteriaBuilder.equal(root.get(NAME_FIELD_SNILS), snils);
    }

    public static Specification<User> filterByInn(Requisites requisites) {
        return (root, query, cb) -> {
            Join<Requisites, User> requisitesJoin = root.join(NAME_FIELD_REQUISITES, JoinType.LEFT);
            return requisites == null ? cb.conjunction() :
                    cb.equal(requisitesJoin.get(NAME_FIELD_INN), requisites.getInn());
        };
    }
}
