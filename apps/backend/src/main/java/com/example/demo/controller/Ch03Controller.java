package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CommonHeaderResponse;
import com.example.demo.dto.CustomerRequest;
import com.example.demo.dto.CustomerResponse;
import com.example.demo.dto.CustomerResponseBody;

@CrossOrigin
@RestController
public class Ch03Controller {

  @PostMapping("/ch03")
  public CustomerResponse ch03(@RequestBody CustomerRequest request) {
    CustomerResponse response = new CustomerResponse();
    CustomerResponseBody responseBody = new CustomerResponseBody();

    CommonHeaderResponse header = new CommonHeaderResponse();
    BeanUtils.copyProperties(request.getHeader(), header);
    header.setCode("0000");
    header.setMsg("成功");

    responseBody.setCustomerId(request.getBody().getCustomerId());
    responseBody.setName("Alan");
    responseBody.setTel("0912345678");
    responseBody.setAddr("地址");
    responseBody.setAge(BigDecimal.valueOf(20));

    response.setHeader(header);
    response.setBody(Arrays.asList(responseBody));

    return response;
  }
}
