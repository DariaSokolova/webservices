package com.epam.mentoring.webservices.dao;

import java.util.List;

import com.epam.mentoring.webservices.bean.BaseBean;

public interface IBeanDAO <T extends BaseBean> {

    public Class<?> getBeanClass();
    
    public T get(long beanID);
    public List<T> getAll();
    public void save(T bean);
    public void delete(long beanID);
}
