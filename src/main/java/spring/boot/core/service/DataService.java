package spring.boot.core.service;


import spring.boot.core.domain.BankData;
import spring.boot.core.domain.User;

import java.io.IOException;
import java.util.List;

/**
 * User 业务层接口
 *
 * Created by bysocket on 24/07/2017.
 */
public interface DataService {

    List<BankData> search(String sQuery) throws IOException;

}
