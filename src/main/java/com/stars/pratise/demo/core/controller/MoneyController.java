package com.stars.pratise.demo.core.controller;

import com.stars.pratise.demo.crud.BaseController;
import com.stars.pratise.demo.domain.Money;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/money")
public class MoneyController extends BaseController<Money, Integer> {
}
