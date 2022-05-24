package com.example.demo.src.store;

import com.example.demo.config.BaseException;
import com.example.demo.src.store.model.GetStoreHomeRes;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.demo.config.BaseResponseStatus.DATABASE_ERROR;

@Service
public class StoreService {
    private final StoreDao storeDao;

    public StoreService(StoreDao storeDao) {
        this.storeDao = storeDao;
    }

    @Transactional(readOnly = true)
    public List<GetStoreHomeRes> getStoreResList() throws BaseException {
        try {
            List<GetStoreHomeRes> getStoreResList = storeDao.getHome();
            System.out.println("getStoreResList = " + getStoreResList);
            return getStoreResList;
        } catch (Exception exception) {
            System.out.println("exception.get = " + exception.getMessage());
            throw new BaseException(DATABASE_ERROR);
        }
    }
}