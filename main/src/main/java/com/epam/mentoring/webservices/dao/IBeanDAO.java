package com.epam.mentoring.webservices.dao;

import com.epam.mentoring.webservices.bean.AbstractBean;

public interface IBeanDAO <T extends AbstractBean> {

    public Class<?> getBeanClass();
    
    public T get(long beanID);
    public void save(T bean);
    public void delete(long beanID);
}
