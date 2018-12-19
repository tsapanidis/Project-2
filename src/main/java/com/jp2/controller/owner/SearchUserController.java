package com.jp2.controller.owner;

import com.jp2.forms.SearchForm;
import com.jp2.model.OwnerModel;

import com.jp2.domain.enumerations.UserSearchType;
import com.jp2.mappers.OwnerServiceToModel;
import com.jp2.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

       @Controller
       public class SearchUserController {

           @Autowired
           private OwnerServiceToModel mapper;

        @Autowired
        private OwnerService service;

        @GetMapping(value = "/Owners/search")
        public ResponseEntity<List<OwnerModel>> searchForUsers(Model model, SearchForm searchForm) {
            List<OwnerModel> owners = findUsers(searchForm);
            return ResponseEntity.ok(owners);
        }

        private List<OwnerModel> findUsers(SearchForm searchForm) {

            UserSearchType type = UserSearchType.valueOf(searchForm.getType());

            List<OwnerModel> owners = new ArrayList<>() ;
            switch (type) {

                case VAT:
                    int vat = Integer.parseInt(searchForm.getTerm());
                    owners.add(mapper.mapToOwnerModel(service.findByVat(vat).get()));
                    break;

                case EMAIL:
                    owners.add(mapper.mapToOwnerModel(service.findByMail(searchForm.getTerm()).get()));
                    break;
            }

            return owners;
        }
    }

