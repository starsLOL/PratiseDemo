package com.stars.pratise.demo.crud;

import java.io.Serializable;

public  interface BaseModel<ID extends Serializable> extends Serializable {


    ID getId();

}
